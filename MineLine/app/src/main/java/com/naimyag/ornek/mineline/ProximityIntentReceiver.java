package com.naimyag.ornek.mineline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.util.Log;

/**
 * Created by Naim on 31.01.2016.
 */
public class ProximityIntentReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {

        String key = LocationManager.KEY_PROXIMITY_ENTERING;

        Boolean entering = intent.getBooleanExtra(key, false);

        if (entering) {
            Log.d(getClass().getSimpleName(), "entering");
        }
        else {
            Log.d(getClass().getSimpleName(), "exiting");
        }

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, null, 0);

        Notification notification = createNotification();


      //  notification.setLatestEventInfo(context, "Proximity Alert!", "You are near your point of interest.", pendingIntent);

        Notification.Builder builder = new Notification.Builder(context);


        //builder.setAutoCancel(false);
        //builder.setTicker("this is ticker text");
        builder.setContentTitle("Proximity Alert!");
        builder.setContentText("You are near your point of interest.");
        //builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentIntent(pendingIntent);
        //builder.setOngoing(true);
        //builder.setSubText("This is subtext...");   //API level 16
        //builder.setNumber(100);
        builder.build();

        notification = builder.getNotification();


        notificationManager.notify(NOTIFICATION_ID, notification);

    }

    private Notification createNotification() {





        Notification notification = new Notification();

        notification.icon = R.drawable.ic_menu_notifications;
        notification.when = System.currentTimeMillis();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;

        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_LIGHTS;

        notification.ledARGB = Color.WHITE;
        notification.ledOnMS = 1500;
        notification.ledOffMS = 1500;


        return notification;
    }

}