package com.kingdomlife.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

public class AudioSermonsService extends Service {

    public static final String ACTION_PLAY =
            "com.kingdomlife.app.SERMON_PLAY";

    public static final String ACTION_PAUSE =
            "com.kingdomlife.app.SERMON_PAUSE";

    public static final String ACTION_STOP =
            "com.kingdomlife.app.SERMON_STOP";

    public static final String ACTION_SEEK =
            "com.kingdomlife.app.SERMON_SEEK";

    public static final String ACTION_PROGRESS =
            "com.kingdomlife.app.SERMON_PROGRESS";

    public static final String EXTRA_URI = "sermon_uri";
    public static final String EXTRA_TITLE = "sermon_title";
    public static final String EXTRA_POSITION = "sermon_position";
    public static final String EXTRA_DURATION = "sermon_duration";

    private static final String CHANNEL_ID =
            "kingdom_sermons_channel";

    private static final int NOTIFICATION_ID = 7401;

    private MediaPlayer player;

    private String currentTitle = "Audio Sermons";
    private String currentUri;

    private boolean isPrepared = false;

    private final Handler handler =
            new Handler(Looper.getMainLooper());

    private final Runnable progressRunnable = new Runnable() {
        @Override
        public void run() {

            sendProgress();

            if (player != null && isPrepared) {
                handler.postDelayed(this, 500);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(
            Intent intent,
            int flags,
            int startId
    ) {

        if (intent == null) {
            return START_NOT_STICKY;
        }

        String action = intent.getAction();

        if (ACTION_PLAY.equals(action)) {

            String uriText =
                    intent.getStringExtra(EXTRA_URI);

            String title =
                    intent.getStringExtra(EXTRA_TITLE);

            if (uriText == null || uriText.trim().isEmpty()) {
                return START_NOT_STICKY;
            }

            if (title != null && !title.trim().isEmpty()) {
                currentTitle = title;
            }

            if (player != null
                    && isPrepared
                    && uriText.equals(currentUri)) {

                resumePlayback();

            } else {

                playAudio(Uri.parse(uriText));
            }

        } else if (ACTION_PAUSE.equals(action)) {

            pausePlayback();

        } else if (ACTION_SEEK.equals(action)) {

            seekTo(
                    intent.getIntExtra(EXTRA_POSITION, 0)
            );

        } else if (ACTION_STOP.equals(action)) {

            stopPlayback();
            stopForeground(true);
            stopSelf();
        }

        return START_NOT_STICKY;
    }

    private void playAudio(Uri uri) {

        releasePlayer();

        currentUri = uri.toString();

        isPrepared = false;

        try {

            player = new MediaPlayer();

            player.setAudioAttributes(
                    new AudioAttributes.Builder()
                            .setUsage(
                                    AudioAttributes.USAGE_MEDIA
                            )
                            .setContentType(
                                    AudioAttributes.CONTENT_TYPE_SPEECH
                            )
                            .build()
            );

            player.setDataSource(this, uri);

            player.setOnPreparedListener(mp -> {

                isPrepared = true;

                mp.start();

                startForeground(
                        NOTIFICATION_ID,
                        buildNotification("Playing")
                );

                sendProgress();

                handler.removeCallbacks(progressRunnable);
                handler.post(progressRunnable);
            });

            player.setOnCompletionListener(mp -> {

                sendProgress();

                stopPlayback();

                stopForeground(true);
                stopSelf();
            });

            player.setOnErrorListener((mp, what, extra) -> {

                stopPlayback();

                stopForeground(true);
                stopSelf();

                return true;
            });

            player.prepareAsync();

        } catch (Exception e) {

            stopPlayback();

            stopForeground(true);
            stopSelf();
        }
    }

    private void resumePlayback() {

        if (player == null || !isPrepared) {
            return;
        }

        try {

            if (!player.isPlaying()) {
                player.start();
            }

            startForeground(
                    NOTIFICATION_ID,
                    buildNotification("Playing")
            );

            sendProgress();

            handler.removeCallbacks(progressRunnable);
            handler.post(progressRunnable);

        } catch (IllegalStateException ignored) {
        }
    }

    private void pausePlayback() {

        if (player == null || !isPrepared) {
            return;
        }

        try {

            if (player.isPlaying()) {
                player.pause();
            }

            showNotification("Paused");

            sendProgress();

            handler.removeCallbacks(progressRunnable);

        } catch (IllegalStateException ignored) {
        }
    }

    private void seekTo(int position) {

        if (player == null || !isPrepared) {
            return;
        }

        try {

            int safePosition = Math.max(
                    0,
                    Math.min(position, player.getDuration())
            );

            player.seekTo(safePosition);

            sendProgress();

        } catch (IllegalStateException ignored) {
        }
    }

    private void sendProgress() {

        if (player == null || !isPrepared) {
            return;
        }

        try {

            Intent progress =
                    new Intent(ACTION_PROGRESS);

            progress.setPackage(getPackageName());

            progress.putExtra(
                    EXTRA_POSITION,
                    player.getCurrentPosition()
            );

            progress.putExtra(
                    EXTRA_DURATION,
                    player.getDuration()
            );

            sendBroadcast(progress);

        } catch (IllegalStateException ignored) {
        }
    }

    private Notification buildNotification(String status) {

        Intent openIntent = new Intent(
                this,
                AudioSermonsActivity.class
        );

        int pendingFlags =
                PendingIntent.FLAG_UPDATE_CURRENT;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pendingFlags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        7402,
                        openIntent,
                        pendingFlags
                );

        Notification.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            builder = new Notification.Builder(
                    this,
                    CHANNEL_ID
            );

        } else {

            builder = new Notification.Builder(this);
        }

        return builder
                .setContentTitle(currentTitle)
                .setContentText(
                        "Kingdom Life • Audio Sermons • " + status
                )
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentIntent(pendingIntent)
                .setOngoing("Playing".equals(status))
                .build();
    }

    private void showNotification(String status) {

        NotificationManager manager =
                (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE
                );

        if (manager != null) {

            manager.notify(
                    NOTIFICATION_ID,
                    buildNotification(status)
            );
        }
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            "Kingdom Life Audio Sermons",
                            NotificationManager.IMPORTANCE_LOW
                    );

            channel.setDescription(
                    "Audio sermon playback status"
            );

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void stopPlayback() {
        releasePlayer();
    }

    private void releasePlayer() {

        handler.removeCallbacks(progressRunnable);

        isPrepared = false;
        currentUri = null;

        if (player != null) {

            try {
                player.release();
            } catch (Exception ignored) {
            }

            player = null;
        }
    }

    @Override
    public void onDestroy() {

        releasePlayer();

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
              }
