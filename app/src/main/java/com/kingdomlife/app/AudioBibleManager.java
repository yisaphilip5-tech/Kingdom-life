package com.kingdomlife.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.session.MediaController;
import androidx.media3.session.SessionToken;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class AudioBibleManager {

    public interface PlaybackListener {
        void onPlaybackChanged(
                boolean isPlaying,
                int playbackState,
                long position,
                long duration
        );

        void onChapterChanged(String book, int chapter);

        void onError(String message);
    }

    private final Context context;
    private final Handler handler =
            new Handler(Looper.getMainLooper());

    private MediaController controller;

    private ListenableFuture<MediaController> controllerFuture;

    private PlaybackListener listener;

    private String currentBook;
    private String currentTranslation = "KJV";
    private int currentChapter = 1;

    private final float[] playbackSpeeds = {
            0.75f, 1.0f, 1.25f, 1.5f, 1.75f, 2.0f
    };

    private int speedIndex = 1;

    private boolean released = false;

    private final Player.Listener playerListener =
            new Player.Listener() {

        @Override
        public void onIsPlayingChanged(boolean isPlaying) {
            notifyPlaybackChanged();
        }

        @Override
        public void onPlaybackStateChanged(int playbackState) {
            notifyPlaybackChanged();
        }

        @Override
        public void onMediaItemTransition(
                MediaItem mediaItem,
                int reason
        ) {
            notifyPlaybackChanged();
        }
    };

    private final Runnable progressUpdater = new Runnable() {
        @Override
        public void run() {

            if (controller != null && listener != null) {
                notifyPlaybackChanged();
            }

            if (!released) {
                handler.postDelayed(this, 500);
            }
        }
    };

    public AudioBibleManager(Context context) {

        this.context = context.getApplicationContext();

        connectToService();
    }

    public void setPlaybackListener(PlaybackListener listener) {
        this.listener = listener;
        notifyPlaybackChanged();
    }

    private void connectToService() {

        SessionToken sessionToken = new SessionToken(
                context,
                new ComponentName(
                        context,
                        AudioBibleService.class
                )
        );

        controllerFuture =
                new MediaController.Builder(context, sessionToken)
                        .buildAsync();

        controllerFuture.addListener(() -> {

            try {

                controller = controllerFuture.get();

                controller.addListener(playerListener);

                notifyPlaybackChanged();

                handler.removeCallbacks(progressUpdater);
                handler.post(progressUpdater);

            } catch (ExecutionException | InterruptedException e) {

                if (listener != null) {
                    listener.onError(
                            "Unable to connect to Audio Bible."
                    );
                }

                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }

        }, command -> handler.post(command));
    }

    public boolean isConnected() {
        return controller != null;
    }

    public void playChapter(
            String translation,
            String book,
            int chapter
    ) {

        currentTranslation = translation;
        currentBook = book;
        currentChapter = chapter;

        if (!AudioBibleData.isValidChapter(book, chapter)) {
            reportError("Invalid Bible chapter.");
            return;
        }

        String audioUrl = AudioBibleData.getAudioUrl(
                translation,
                book,
                chapter
        );

        if (audioUrl == null) {
            reportError(
                    "Audio is not available for this translation yet."
            );
            return;
        }

        if (controller == null) {
            connectIfNeeded();
            handler.postDelayed(() -> {
                if (controller != null) {
                    loadAndPlay(audioUrl);
                } else {
                    reportError("Audio service is not ready.");
                }
            }, 500);

            return;
        }

        loadAndPlay(audioUrl);
    }

    private void loadAndPlay(String audioUrl) {

        if (controller == null) {
            return;
        }

        MediaItem mediaItem = new MediaItem.Builder()
                .setUri(audioUrl)
                .setMediaId(
                        currentBook + "_" + currentChapter
                )
                .setMediaMetadata(
                        new androidx.media3.common.MediaMetadata.Builder()
                                .setTitle(
                                        currentBook + " " + currentChapter
                                )
                                .setArtist(
                                        "Kingdom Life Audio Bible"
                                )
                                .build()
                )
                .build();

        controller.setMediaItem(mediaItem);

        controller.prepare();

        controller.play();

        applyPlaybackSpeed();

        if (listener != null) {
            listener.onChapterChanged(
                    currentBook,
                    currentChapter
            );
        }
    }

    private void connectIfNeeded() {

        if (controller == null &&
                (controllerFuture == null ||
                        controllerFuture.isDone())) {

            connectToService();
        }
    }

    public void play() {

        if (controller != null) {
            controller.play();
        }
    }

    public void pause() {

        if (controller != null) {
            controller.pause();
        }
    }

    public void togglePlayPause() {

        if (controller == null) {
            return;
        }

        if (controller.isPlaying()) {
            pause();
        } else {
            play();
        }
    }

    public void stop() {

        if (controller != null) {
            controller.stop();
        }
    }

    public void nextChapter() {

        if (currentBook == null) {
            return;
        }

        int totalChapters =
                AudioBibleData.getChapterCount(currentBook);

        if (currentChapter < totalChapters) {
            currentChapter++;
            playChapter(
                    currentTranslation,
                    currentBook,
                    currentChapter
            );
        }
    }

    public void previousChapter() {

        if (currentBook == null) {
            return;
        }

        if (currentChapter > 1) {
            currentChapter--;
            playChapter(
                    currentTranslation,
                    currentBook,
                    currentChapter
            );
        }
    }

    public void seekTo(long position) {

        if (controller != null) {
            controller.seekTo(position);
        }
    }

    public void changePlaybackSpeed() {

        speedIndex++;

        if (speedIndex >= playbackSpeeds.length) {
            speedIndex = 0;
        }

        applyPlaybackSpeed();
    }

    private void applyPlaybackSpeed() {

        if (controller != null) {

            controller.setPlaybackParameters(
                    new PlaybackParameters(
                            playbackSpeeds[speedIndex]
                    )
            );
        }
    }

    public float getPlaybackSpeed() {
        return playbackSpeeds[speedIndex];
    }

    public boolean isPlaying() {

        return controller != null &&
                controller.isPlaying();
    }

    public long getCurrentPosition() {

        return controller == null
                ? 0
                : controller.getCurrentPosition();
    }

    public long getDuration() {

        return controller == null
                ? 0
                : controller.getDuration();
    }

    private void notifyPlaybackChanged() {

        if (listener == null || controller == null) {
            return;
        }

        listener.onPlaybackChanged(
                controller.isPlaying(),
                controller.getPlaybackState(),
                controller.getCurrentPosition(),
                controller.getDuration()
        );
    }

    private void reportError(String message) {

        if (listener != null) {
            listener.onError(message);
        }
    }

    public void release() {

        released = true;

        handler.removeCallbacks(progressUpdater);

        if (controller != null) {
            controller.removeListener(playerListener);
            controller.release();
            controller = null;
        } else if (controllerFuture != null) {
            MediaController.releaseFuture(controllerFuture);
        }

        controllerFuture = null;
        listener = null;
    }
  }
