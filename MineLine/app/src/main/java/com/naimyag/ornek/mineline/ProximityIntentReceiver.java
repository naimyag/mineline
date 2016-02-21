package com.naimyag.ornek.mineline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Naim on 31.01.2016.
 */
public class ProximityIntentReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String key = LocationManager.KEY_PROXIMITY_ENTERING;

        Boolean entering = intent.getBooleanExtra(key, false);

        if (entering) {


            Toast.makeText(context, "HOŞGELDİN!", Toast.LENGTH_SHORT).show();
            Log.d(getClass().getSimpleName(), "entering");


            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,new Intent(context,MainActivity.class), 0);


            NotificationManager mng =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            Notification.Builder nb = new Notification.Builder(context);

            // API 21+ olması lazım
            // nb.setColor(Color.GREEN);

            nb.setContentText("Bölgeye Girdin Hafız");
            nb.setContentTitle("MAYIN");
            nb.setContentIntent(pendingIntent);
            nb.setSmallIcon(R.drawable.notifibomb);
            nb.setVibrate(new long[]{500L, 500L, 500L, 500L});


            // API 16+ build altında getNotification()
            // Notification not = nb.build();
            Notification not = nb.getNotification();

            mng.notify(1, not);




            //    NotificationManager notificationManager =
       //            (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

       //    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

       //    //  Notification notification = createNotification();


       //    Notification notification = new Notification();

       //    notification.icon = R.drawable.ic_menu_notifications;
       //    notification.when = System.currentTimeMillis();

       //    notification.flags |= Notification.FLAG_AUTO_CANCEL;
       //    notification.flags |= Notification.FLAG_SHOW_LIGHTS;

       //    notification.defaults |= Notification.DEFAULT_VIBRATE;
       //    notification.defaults |= Notification.DEFAULT_LIGHTS;

       //    notification.ledARGB = Color.WHITE;
       //    notification.ledOnMS = 1500;
       //    notification.ledOffMS = 1500;






       //    //  notification.setLatestEventInfo(context, "Proximity Alert!", "You are near your point of interest.", pendingIntent);

       //    Notification.Builder builder = new Notification.Builder(context);


       //    //builder.setAutoCancel(false);
       //    //builder.setTicker("this is ticker text");
       //    builder.setContentTitle("Proximity Alert!");
       //    builder.setContentText("You are near your point of interest.");
       //    //builder.setSmallIcon(R.drawable.ic_launcher);
       //    builder.setContentIntent(pendingIntent);
       //    //builder.setOngoing(true);
       //    //builder.setSubText("This is subtext...");   //API level 16
       //    //builder.setNumber(100);
       //    builder.build();

       //    notification = builder.getNotification();


       //    notificationManager.notify(NOTIFICATION_ID, notification);

        }
        else {
            Log.d(getClass().getSimpleName(), "exiting");

            Toast.makeText(context, "GÜLE GÜLE!", Toast.LENGTH_LONG).show();
        }



    }





 // private Notification createNotification() {




 //     return notification;
 //
 // }

}