package com.example.amit.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3;
    Button b1,b2;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        et3= (EditText) findViewById(R.id.et3);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onClick(View view) {

        if (view==b1)
        {
            Intent ii = new Intent(MainActivity.this,Main2Activity.class);
            PendingIntent pi = PendingIntent.getActivity(MainActivity.this,2,ii,0);
            Notification.Builder nb = new Notification.Builder(MainActivity.this);

            nb.setContentTitle(et1.getText().toString());
            nb.setContentText(et2.getText().toString());
            nb.setSubText(et3.getText().toString());

            nb.setContentIntent(pi);
            nb.setSmallIcon(R.mipmap.ic_launcher);

            /* Increase notification number every time a new notification arrives */
           // nb.setNumber(++numMessages);

   /* Add Big View Specific Configuration */
            Notification.InboxStyle inboxStyle = new Notification.InboxStyle();

            String[] events = new String[6];
            events[0] = new String("This is first line....");
            events[1] = new String("This is second line...");
            events[2] = new String("This is third line...");
            events[3] = new String("This is 4th line...");
            events[4] = new String("This is 5th line...");
            events[5] = new String("This is 6th line...");

            // Sets a title for the Inbox style big view
            inboxStyle.setBigContentTitle("Big Title Details:");

            // Moves events into the big view
            for (int i=0; i < events.length; i++) {
                inboxStyle.addLine(events[i]);
            }

            nb.setStyle(inboxStyle);

            nm.notify(54,nb.build());





        }
        else
        {
nm.cancel(54);
        }



    }
}
