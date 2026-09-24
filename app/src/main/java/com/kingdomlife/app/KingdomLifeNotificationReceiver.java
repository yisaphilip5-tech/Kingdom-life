package com.kingdomlife.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Notification;
import android.os.Build;


public class KingdomLifeNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String type =
                intent.getStringExtra("notification_type");

        String title;
        String message;

        if ("daily".equals(type)) {

            title = "🎯 Daily Challenge";
            message =
                    "Take a moment to complete today's Kingdom Life challenge.";

        } else if ("bible".equals(type)) {

            title = "📖 Bible Reading";
            message =
                    "Take some time to read and reflect on God's Word today.";

        } else {

            title = "🧠 Memory Verse";
            message =
                    "Practice your Memory Verse and strengthen your Bible memory.";
        }

        Intent openApp =
                new Intent(context, MainActivity.class);

        openApp.setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TOP
        );

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        openApp,
                        PendingIntent.FLAG_UPDATE_CURRENT |
                        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                                ? PendingIntent.FLAG_IMMUTABLE
                                : 0)
                );

        Notification.Builder builder;

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    builder = new Notification.Builder(
            context,
            "kingdom_life_reminders"
    );
} else {
    builder = new Notification.Builder(context);
}

builder.setSmallIcon(R.drawable.kingdom_life_icon)
        .setContentTitle(title)
        .setContentText(message)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent);
        NotificationManager manager =
                (NotificationManager)
                        context.getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );

        if (manager != null) {

            int notificationId =
                    (int) System.currentTimeMillis();

            manager.notify(
                    notificationId,
                    builder.build()
            );
        }
    }
}
