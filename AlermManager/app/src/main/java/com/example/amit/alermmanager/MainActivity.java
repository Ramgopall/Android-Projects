package com.example.amit.alermmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b,b2;
    EditText ed;
    PendingIntent pi;
    AlarmManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed= (EditText) findViewById(R.id.ed);
        b= (Button) findViewById(R.id.b);
        b2= (Button) findViewById(R.id.b2);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view==b) {
            int i = Integer.parseInt(ed.getText().toString());
            long l = i * 1000;
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent ii = new Intent(MainActivity.this, Alarm.class);
            pi = PendingIntent.getBroadcast(MainActivity.this, 1, ii, 0);
            am.set(am.RTC_WAKEUP, System.currentTimeMillis() + l, pi);
        }
        else if (view==b2) {

            //am.cancel(pi);

            if (Alarm.mp.isPlaying()==true) {
                Alarm.mp.stop();
            }
            else {

                Toast.makeText(this, "First set alarm", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
