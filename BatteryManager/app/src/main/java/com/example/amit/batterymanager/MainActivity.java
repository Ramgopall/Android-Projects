package com.example.amit.batterymanager;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    Intent i;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);
        b9= (Button) findViewById(R.id.b9);
        b10= (Button) findViewById(R.id.b10);
        iv= (ImageView) findViewById(R.id.iv);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        IntentFilter ifl = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        i = registerReceiver(null,ifl);

        if (view==b1)
        {
           int y =  i.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,-1);

            Toast.makeText(this, y+"", Toast.LENGTH_SHORT).show();
            iv.setImageResource(y);


        }
        else if (view==b2)
        {
            int y= i.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,-1);
            y /=10;
            Toast.makeText(this, y+"C", Toast.LENGTH_SHORT).show();




        }
        else if (view==b3)
        {
            int y=  i.getIntExtra(BatteryManager.EXTRA_VOLTAGE,-1);
            double m =y/1000;
            Toast.makeText(this, m+"V", Toast.LENGTH_SHORT).show();


        }
        else if (view==b4)
        {
            int y = i.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            Toast.makeText(this, y+"%", Toast.LENGTH_SHORT).show();


        }
        else if (view==b5)
        {
            int y = i.getIntExtra(BatteryManager.EXTRA_HEALTH,-1);

            if (y==BatteryManager.BATTERY_HEALTH_COLD)
            {
                Toast.makeText(this, "cold", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_HEALTH_DEAD)
            {
                Toast.makeText(this, "dead", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_HEALTH_GOOD)
            {
                Toast.makeText(this, "good", Toast.LENGTH_SHORT).show();

            }
            else if (y==BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE)
            {
                Toast.makeText(this, "over voltage", Toast.LENGTH_SHORT).show();

            }
            else if (y==BatteryManager.BATTERY_HEALTH_OVERHEAT)
            {
                Toast.makeText(this, "over heated", Toast.LENGTH_SHORT).show();

            }
            else if (y==BatteryManager.BATTERY_HEALTH_UNKNOWN)
            {
                Toast.makeText(this, "unknown", Toast.LENGTH_SHORT).show();

            }
            else if (y==BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE)
            {
                Toast.makeText(this, "Unspecified failure", Toast.LENGTH_SHORT).show();

            }




        }
        else if (view==b6)
        {
            int y = i.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
           // Toast.makeText(this, ""+y, Toast.LENGTH_SHORT).show();

            if (y==BatteryManager.BATTERY_STATUS_CHARGING)
            {
                Toast.makeText(this, "Charging", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_STATUS_DISCHARGING)
            {
                Toast.makeText(this, "Discharging", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_STATUS_FULL)
            {
                Toast.makeText(this, "Full", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_STATUS_NOT_CHARGING)
            {
                Toast.makeText(this, "Not Charging", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_STATUS_UNKNOWN)
            {
                Toast.makeText(this, "Unkown", Toast.LENGTH_SHORT).show();
            }



        }
        else if (view==b7)
        {
            int y = i.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);


            if (y==BatteryManager.BATTERY_PLUGGED_AC)
            {
                Toast.makeText(this, "AC", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_PLUGGED_USB)
            {
                Toast.makeText(this, "USB", Toast.LENGTH_SHORT).show();
            }
            else if (y==BatteryManager.BATTERY_PLUGGED_WIRELESS)
            {
                Toast.makeText(this, "WIRELESS", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "not Plugged", Toast.LENGTH_SHORT).show();




        }
        else if (view==b8)
        {

            getBatteryCapacity();
        }
        else if (view==b9)
        {
            String s = i.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();


        }
        else if (view==b10)
        {
            boolean b= i.getBooleanExtra(BatteryManager.EXTRA_PRESENT,false);

            if (b==true)
            {
                Toast.makeText(this, "Battery is present", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Battery isnot present", Toast.LENGTH_SHORT).show();

        }

    }

        public void getBatteryCapacity() {
            Object mPowerProfile_ = null;

            final String POWER_PROFILE_CLASS = "com.android.internal.os.power_profile.xml";

            try {
                mPowerProfile_ = Class.forName(POWER_PROFILE_CLASS).getConstructor(Context.class).newInstance(this);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                double batteryCapacity = (Double) Class.forName(POWER_PROFILE_CLASS).getMethod("getAveragePower", java.lang.String.class).invoke(mPowerProfile_, "battery.capacity");
                Toast.makeText(MainActivity.this, batteryCapacity + " mah", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }



