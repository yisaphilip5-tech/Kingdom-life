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
import android.os.IBinder;

public class KingdomMusicService extends Service {

    public static final String ACTION_PLAY = "com.kingdomlife.app.MUSIC_PLAY";
    public static final String ACTION_PAUSE = "com.kingdomlife.app.MUSIC_PAUSE";
    public static final String ACTION_STOP = "com.kingdomlife.app.MUSIC_STOP";

    public static final String EXTRA_URI = "music_uri";
    public static final String EXTRA_TITLE = "music_title";

    private static final String CHANNEL_ID = "kingdom_music_channel";
    private static final int NOTIFICATION_ID = 7301;

    private MediaPlayer player;
    private String currentTitle = "Kingdom Music";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return START_NOT_STICKY;
        }

        String action = intent.getAction();

        if (ACTION_PLAY.equals(action)) {
            String uriText = intent.getStringExtra(EXTRA_URI);
            currentTitle = intent.getStringExtra(EXTRA_TITLE);

            if (currentTitle == null || currentTitle.trim().isEmpty()) {
                currentTitle = "Kingdom Music";
            }

            if (uriText != null) {
                playAudio(Uri.parse(uriText));
            }

        } else if (ACTION_PAUSE.equals(action)) {
            if (player != null && player.isPlaying()) {
                player.pause();
                showNotification("Paused");
            }

        } else if (ACTION_STOP.equals(action)) {
            stopPlayback();
            stopForeground(true);
            stopSelf();
        }

        return START_NOT_STICKY;
    }

    private void playAudio(Uri uri) {
        try {
            startForeground(NOTIFICATION_ID, buildNotification("Playing"));

            releasePlayer();

            player = new MediaPlayer();

            player.setAudioAttributes(
                    new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
            );

            player.setDataSource(this, uri);

            player.setOnPreparedListener(mp -> {
                mp.start();
                showNotification("Playing");
            });

            player.setOnCompletionListener(mp -> {
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

    private Notification buildNotification(String status) {
        Intent openIntent = new Intent(this, KingdomMusicActivity.class);

        int pendingFlags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pendingFlags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                7302,
                openIntent,
                pendingFlags
        );

        Notification.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(this, CHANNEL_ID);
        } else {
            builder = new Notification.Builder(this);
        }

        return builder
                .setContentTitle(currentTitle)
                .setContentText("Kingdom Life • " + status)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentIntent(pendingIntent)
                .setOngoing("Playing".equals(status))
                .build();
    }

    private void showNotification(String status) {
        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (manager != null) {
            manager.notify(NOTIFICATION_ID, buildNotification(status));
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Kingdom Music",
                    NotificationManager.IMPORTANCE_LOW
            );

            channel.setDescription("Music playback controls and status");

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
