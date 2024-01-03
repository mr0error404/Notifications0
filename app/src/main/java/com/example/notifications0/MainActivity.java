package com.example.notifications0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingInflatedId") 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    // step 1 createChannel
                    NotificationChannel channel1=new NotificationChannel("1","MSG", NotificationManager.IMPORTANCE_HIGH);
                    channel1.setDescription("masmasmasmas");
                    channel1.setName("MsG");
                    channel1.enableVibration(true);
                    channel1.enableLights(true);


                    //step 2 createNotification
                    Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_IMMUTABLE);
                    Notification notification1 = new Notification.Builder(MainActivity.this,"1")
                            .setSmallIcon(R.drawable.what)
                            .setContentText("////your MSG///// ")
                            .setContentTitle("Title")
                            .setAutoCancel(true)//
                            .setContentIntent(pendingIntent)
                            .build(); 

                    //setp 3 create Manager Notification
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel1);

                    //step 4 startNotification
                    notificationManager.notify(1,notification1);
                }
            }
        });


    }
}