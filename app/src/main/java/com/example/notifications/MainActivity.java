package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button btnShowNotification;
    private TextView textNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowNotification = findViewById(R.id.idBtn);

        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotificationFunction();
            }
        });
    }

    private void addNotificationFunction(){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notificationicon)
                .setContentTitle("Notifications")
                .setContentText("Mon premier notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        notificationIntent.putExtra("message" , "Mon Premier Notification :This means \" *My first notification* \" ");

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0
        , notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());

    }
}