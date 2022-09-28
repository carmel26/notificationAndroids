package com.example.notifications;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class NotificationView extends AppCompatActivity {
    private TextView textDisplay, textTitle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        textDisplay = findViewById(R.id.textContentNotification);
        textTitle = findViewById(R.id.textIdNotification1);

        String messageSent = getIntent().getStringExtra("message");

        textDisplay.setText(messageSent);
        textTitle.setPaintFlags(textTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }
}
