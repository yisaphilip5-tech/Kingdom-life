package com.kingdomlife.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.session.MediaController;
import androidx.media3.session.SessionToken;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.CancellationException;
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

    private String pendingAudioUrl;

    private boolean connecting = false;

    private boolean released = false;

    private final float[] playbackSpeeds = {
            0.75f, 1.0f, 1.25f, 1.5f, 1.75f, 2.0f
    };

    private int speedIndex = 1;

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

            if (released) {
                return;
            }

            if (controller != null && listener != null) {
                notifyPlaybackChanged();
            }

            handler.postDelayed(this, 500);
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

        if (released || connecting || controller != null) {
            return;
        }

        connecting = true;

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

        ListenableFuture<MediaController> future =
                controllerFuture;

        future.addListener(() -> {

            try {

                MediaController connectedController =
                        future.get();

                connecting = false;

                if (released) {
                    connectedController.release();
                    return;
                }

                controller = connectedController;

                controller.addListener(playerListener);

                handler.removeCallbacks(progressUpdater);

                handler.post(progressUpdater);

                notifyPlaybackChanged();

                // Play a chapter requested while connecting.
                if (pendingAudioUrl != null) {

                    String audioUrl = pendingAudioUrl;

                    pendingAudioUrl = null;

                    loadAndPlay(audioUrl);
                }

            } catch (
                    ExecutionException |
                    InterruptedException |
                    CancellationException e
            ) {

                connecting = false;

                controllerFuture = null;

                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }

                if (!released) {
                    reportError(
                            "Unable to connect to Audio Bible. Please try again."
                    );
                }
            }

        }, command -> handler.post(command));
    }

    private void connectIfNeeded() {

        if (controller == null && !connecting && !released) {
            connectToService();
        }
    }

    public boolean isConnected() {
        return controller != null;
    }

    public void playChapter(
            String translation,
            String book,
            int chapter
    ) {

        if (released) {
            return;
        }

        if (translation == null || book == null) {
            reportError("Invalid Bible selection.");
            return;
        }

        if (!AudioBibleData.isValidChapter(book, chapter)) {
            reportError("Invalid Bible chapter.");
            return;
        }

        currentTranslation = translation;
        currentBook = book;
        currentChapter = chapter;

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

        if (controller != null) {
            loadAndPlay(audioUrl);
        } else {

            // Keep the latest requested chapter until connected.
            pendingAudioUrl = audioUrl;

            connectIfNeeded();
        }
    }

    private void loadAndPlay(String audioUrl) {

        if (controller == null || released) {
            return;
        }

        MediaItem mediaItem = new MediaItem.Builder()
                .setUri(audioUrl)
                .setMediaId(
                        currentBook + "_" + currentChapter
                )
                .setMediaMetadata(
                        new MediaMetadata.Builder()
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

        pendingAudioUrl = null;

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

        pendingAudioUrl = null;

        handler.removeCallbacks(progressUpdater);

        if (controller != null) {

            controller.removeListener(playerListener);

            controller.release();

            controller = null;

        } else if (controllerFuture != null) {

            MediaController.releaseFuture(controllerFuture);
        }

        controllerFuture = null;

        connecting = false;

        listener = null;
    }
}
