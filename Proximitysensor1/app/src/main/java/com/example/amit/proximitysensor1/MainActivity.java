package com.example.amit.proximitysensor1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor s;
    ImageView iv;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= (ImageView) findViewById(R.id.iv);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(MainActivity.this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(MainActivity.this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.values[0]==0)
        {
            switch (a)
            {
                case 0: iv.setImageResource(R.drawable.a); a++; break;
                case 1: iv.setImageResource(R.drawable.b); a++; break;
                case 2:iv.setImageResource(R.drawable.c); a++; break;
                case 3:iv.setImageResource(R.drawable.d); a++; break;
                case 4:iv.setImageResource(R.drawable.e); a++; break;
                case 5:iv.setImageResource(R.drawable.f); a++; break;
                case 6:iv.setImageResource(R.drawable.g); a++; break;
                case 7:iv.setImageResource(R.drawable.h); a++; break;
                case 8:iv.setImageResource(R.drawable.i); a++; break;
                case 9:iv.setImageResource(R.drawable.j); a++; break;
                default: a=0;
            }



            //   Toast.makeText(this, "Youu Are So near", Toast.LENGTH_SHORT).show();
            //DisplayManager dm = (DisplayManager) getSystemService(DISPLAY_SERVICE);

        }

        else
        {
            //iv.setImageResource(R.drawable.b);
            //Toast.makeText(this, "You Are So Far", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
