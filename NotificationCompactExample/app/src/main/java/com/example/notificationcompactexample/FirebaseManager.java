package com.example.notificationcompactexample;

import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseManager extends FirebaseMessagingService {

    NotificationManagerCompat notificationManagerCompat;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        basicNotification(ChannelManager.HIGH_IMPORTANCE_CHANNEL, remoteMessage.getNotification().getTitle(),
                remoteMessage.getNotification().getBody());

    }

    public void basicNotification(String channelID, String contentTitle, String contentText){

        //Crear notificacion basica
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_cake)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setColor(Color.GREEN)
                .setAutoCancel(true);

        notificationManagerCompat.notify(01, notification.build());

    }

}
