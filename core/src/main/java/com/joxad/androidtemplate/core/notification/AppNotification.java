package com.joxad.androidtemplate.core.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;


/**
 * Created by josh on 10/04/16.
 */
public enum AppNotification {

    INSTANCE;
    private Context context;
    private NotificationManager notificationManager;

    public void init(final Context context) {
        this.context = context;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /***
     */
    public void show(final int id, final int drawable, final String title) {

        Notification notification = new Notification.Builder(context)
                .setContentTitle(title)
                .setSmallIcon(drawable)
                .setOngoing(true).build();

        notificationManager.notify(id, notification);
    }

    public void cancel(final int id) {
        notificationManager.cancel(id);
    }
}
