package com.example.notificationcompactexample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ChannelManager extends Application {

    public static final String HIGH_IMPORTANCE_CHANNEL = "high_channel";
    public static final String LOW_IMPORTANCE_CHANNEL = "low_channel";

    @Override
    public void onCreate() {
        super.onCreate();

        channelSettings();

    }

    public void channelSettings(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //Crear nuestro canal de alta importancia
            NotificationChannel highChannel = new NotificationChannel(HIGH_IMPORTANCE_CHANNEL, "High Channel", NotificationManager.IMPORTANCE_HIGH);
            highChannel.setDescription("Channel with high level of importance");

            //Crear nuestro canal de baja importancia
            NotificationChannel lowChannel = new NotificationChannel(LOW_IMPORTANCE_CHANNEL, "Low Channel", NotificationManager.IMPORTANCE_LOW);
            lowChannel.setDescription("Channel with low level of importance");

            //Creamos el manejador de canales
            NotificationManager manager = getSystemService(NotificationManager.class);

            //Agregamos nuestros canales al manejador
            manager.createNotificationChannel(highChannel);
            manager.createNotificationChannel(lowChannel);

        }
    }

}
