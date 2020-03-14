package com.example.notificationcompactexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Button btnHigh;
    Button btnLow;
    Button btnBigHigh;
    Button btnBigLow;
    Button btnPicHigh;
    Button btnPicLow;
    Button btnInHigh;
    Button btnInLow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHigh = findViewById(R.id.btnHigh);
        btnLow = findViewById(R.id.btnLow);
        btnBigHigh = findViewById(R.id.btnBigHigh);
        btnBigLow = findViewById(R.id.btnBigLow);
        btnPicHigh = findViewById(R.id.btnPicHigh);
        btnPicLow = findViewById(R.id.btnPicLow);
        btnInHigh = findViewById(R.id.btnInHigh);
        btnInLow = findViewById(R.id.btnInLow);

        notificationManagerCompat = NotificationManagerCompat.from(this);



        btnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicNotification(ChannelManager.HIGH_IMPORTANCE_CHANNEL);
            }
        });

        btnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicNotification(ChannelManager.LOW_IMPORTANCE_CHANNEL);
            }
        });

        btnBigHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigTextStyleNotification(ChannelManager.HIGH_IMPORTANCE_CHANNEL);
            }
        });

        btnBigLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigTextStyleNotification(ChannelManager.LOW_IMPORTANCE_CHANNEL);
            }
        });

        btnPicHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigPictureStyleNotification(ChannelManager.HIGH_IMPORTANCE_CHANNEL);
            }
        });

        btnPicLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigPictureStyleNotification(ChannelManager.LOW_IMPORTANCE_CHANNEL);
            }
        });

        btnInHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxStyleNotification(ChannelManager.HIGH_IMPORTANCE_CHANNEL);
            }
        });

        btnInLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxStyleNotification(ChannelManager.LOW_IMPORTANCE_CHANNEL);
            }
        });

    }

    public void basicNotification(String channelID){

        //Crear notificacion basica
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_cake)
                .setContentTitle("Basic notification")
                .setContentText("Basic notification description")
                .setColor(Color.GREEN)
                .setAutoCancel(true);

        notificationManagerCompat.notify(01, notification.build());

    }

    public void bigTextStyleNotification(String channelID){

        //Crear notificacion amplia
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_cake)
                .setContentTitle("Big notification")
                .setContentText("Big notification description")
                .setColor(Color.GREEN)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setBigContentTitle("Titulo ya expandido")
                        .bigText(getString(R.string.big_text))
                        .setSummaryText("Bandeja de entrada")
                );

        notificationManagerCompat.notify(01, notification.build());

    }

    public void bigPictureStyleNotification(String channelID){

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.hd48);

        //Crear notificacion de imagen
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_cake)
                .setContentTitle("Basic notification")
                .setContentText("Basic notification description")
                .setColor(Color.GREEN)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(picture)
                );

        notificationManagerCompat.notify(01, notification.build());

    }

    public void inboxStyleNotification(String channelID){
        //Crear notificacion basica
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_cake)
                .setContentTitle("Basic notification")
                .setContentText("Basic notification description")
                .setColor(Color.GREEN)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("01")
                        .addLine("02")
                        .addLine("03")
                        .addLine("04")
                );

        notificationManagerCompat.notify(01, notification.build());
    }


}
