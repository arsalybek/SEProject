package com.example.sys.view.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.example.sys.R;
import com.example.sys.controller.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class SkillFMService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("TAGG",s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(!(remoteMessage.equals(""))){
            sendNotification(remoteMessage);
        }
    }

    private void sendNotification(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        String title = data.get("title");
        String content = data.get("content");
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


       NotificationManager notificationManager =  (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "channel";

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, "channel", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setSound(uri, null);
            notificationChannel.setLightColor(Color.RED);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setSmallIcon(R.drawable.ic_logo)
                        .setSound(uri)
                        .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                        .setContentTitle(title)
                        .setContentText(content)
                        .setCustomContentView(getCollapsedDesign(title, content))
                        .setAutoCancel(true)
                        .setOnlyAlertOnce(true)
                        .setContentIntent(pendingIntent);

        notificationManager.notify(1, builder.build());
    }


    private RemoteViews getCollapsedDesign(String title,String message) {

        RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.collapsed_notification);
        remoteViews.setTextViewText(R.id.content_title, title);
        remoteViews.setTextViewText(R.id.content_text, message);
        remoteViews.setImageViewResource(
                R.id.icon,
                R.drawable.user1
        );

        return remoteViews;
    }
}
