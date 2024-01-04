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
import android.os.Handler;
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

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNotification();
            }
        },15000);
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


                    String txt="All right everyone, line up alphabetically according to your height.\n" +
                            "They say marriages are made in Heaven. But so is thunder and lightning.\n" +
                            "I have six locks on my door all in a row. When I go out, I lock every other one. I figure no matter how long somebody stands there picking the locks, they are always locking three\n ";
                    //step 2 createNotification
                    Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_IMMUTABLE);
                    Notification notification1 = new Notification.Builder(MainActivity.this,"1")
                            .setSmallIcon(R.drawable.virus)
                            .setContentText("////your MSG///// ")
                            .setContentTitle("Title")
                            .setAutoCancel(true)//
                            .setContentIntent(pendingIntent)
                            .addAction(R.drawable.openn ,"Open MSG",pendingIntent)
                            .addAction(R.drawable.close, "Cloase MSG",pendingIntent)
                            .setStyle(new Notification.BigTextStyle().bigText(txt))
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
    private void showNotification(){
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // step 1 createChannel
            NotificationChannel channel1=new NotificationChannel("1","MSG", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("masmasmasmas");
            channel1.setName("MsG");
            channel1.enableVibration(true);
            channel1.enableLights(true);

            //MESG
            String txt="All right everyone, line up alphabetically according to your height.\n" +
                    "They say marriages are made in Heaven. But so is thunder and lightning.\n" +
                    "I have six locks on my door all in a row. When I go out, I lock every other one. I figure no matter how long somebody stands there picking the locks, they are always locking three\n ";
            //step 2 createNotification
            Intent intent = new Intent(MainActivity.this , MainActivity2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_IMMUTABLE);
            Notification notification1 = new Notification.Builder(MainActivity.this,"1")
                    .setSmallIcon(R.drawable.virus)
                    .setContentText("////your MSG///// ")
                    .setContentTitle("Title")
                    .setAutoCancel(true)//
                    .setContentIntent(pendingIntent)
                    .addAction(R.drawable.openn ,"Open MSG",pendingIntent)
                    .addAction(R.drawable.close, "Cloase MSG",pendingIntent)
                    .setStyle(new Notification.BigTextStyle().bigText(txt))
                    .build();
            //setp 3 create Manager Notification
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
            //step 4 startNotification
            notificationManager.notify(1,notification1);
        }
    }
}