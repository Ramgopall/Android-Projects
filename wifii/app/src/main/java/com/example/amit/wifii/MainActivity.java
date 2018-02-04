package com.example.amit.wifii;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ToggleButton tg1;
    Button b1,b2,b3;
    WifiManager wm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wm= (WifiManager) getSystemService(WIFI_SERVICE);

        tg1= (ToggleButton) findViewById(R.id.tg1);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        tg1.setOnCheckedChangeListener(this);

        if(wm.isWifiEnabled()==true){
            tg1.setChecked(true);
        }
        else
        {
            tg1.setChecked(false);
        }



    }

    @Override
    public void onClick(View view) {

        if(view==b1)
        {

            if(wm.isWifiEnabled()==true)
            {
                Toast.makeText(this, "wifi is on", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "wifi is off", Toast.LENGTH_SHORT).show();
            }

        }

        else if (view==b2)
        {
            wm.setWifiEnabled(true);
            tg1.setChecked(true);
            Toast.makeText(this, "wifi is on", Toast.LENGTH_SHORT).show();


        }
        else if (view==b3)
        {
            wm.setWifiEnabled(false);
            tg1.setChecked(false);
            Toast.makeText(this, "wifi is off", Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

       if (compoundButton==tg1) {

           if (b == false) {
               wm.setWifiEnabled(false);
              // tg1.setChecked(false);
               Toast.makeText(this, "wifi off", Toast.LENGTH_SHORT).show();

           }
           else if (b == true) {
               wm.setWifiEnabled(true);
              // tg1.setChecked(true);
               Toast.makeText(this, "Wifi on", Toast.LENGTH_SHORT).show();

           }
       }


    }
}
