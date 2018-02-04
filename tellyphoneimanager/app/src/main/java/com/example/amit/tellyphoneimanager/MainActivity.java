package com.example.amit.tellyphoneimanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    TelephonyManager tm;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tm= (TelephonyManager) getSystemService(TELEPHONY_SERVICE);



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
        b11= (Button) findViewById(R.id.b11);
        b12= (Button) findViewById(R.id.b12);
        b13= (Button) findViewById(R.id.b13);
        b14= (Button) findViewById(R.id.b14);
        b15= (Button) findViewById(R.id.b15);
        b16= (Button) findViewById(R.id.b16);
        b17= (Button) findViewById(R.id.b17);
        b18= (Button) findViewById(R.id.b18);
        b19= (Button) findViewById(R.id.b19);
        b20= (Button) findViewById(R.id.b20);

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
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        b17.setOnClickListener(this);
        b18.setOnClickListener(this);
        b19.setOnClickListener(this);
        b20.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        if (view==b1)
        {
           c=  tm.getDeviceId();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b2)
        {
           c = tm.getDeviceId(0);
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b3)
        {
          c =  tm.getDeviceId(1);
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b4)
        {
           c=  tm.getDeviceSoftwareVersion();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b5)
        {
            c = tm.getLine1Number();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b6)
        {
            c = tm.getNetworkCountryIso();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b7)
        {
            c = tm.getNetworkOperator();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b8)
        {
            c =tm.getNetworkOperatorName();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();

        }
        else if (view==b9)
        {
            int i =tm.getNetworkType();

            if(i==TelephonyManager.NETWORK_TYPE_CDMA)
            {
                Toast.makeText(this, "CDMA", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_EDGE)
            {
                Toast.makeText(this, "EDGE", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_GPRS)
            {
                Toast.makeText(this, "GPRS", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_HSPA)
            {
                Toast.makeText(this, "HSPA", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_LTE)
            {
                Toast.makeText(this, "LTE", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_UNKNOWN)
            {
                Toast.makeText(this, "unknown", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_1xRTT)
            {
                Toast.makeText(this, "1xRTT ", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_EHRPD)
            {
                Toast.makeText(this, "EHRPD", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_EVDO_0)
            {
                Toast.makeText(this, "EVDO_0", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_EVDO_A)
            {
                Toast.makeText(this, "EVDO_A", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_EVDO_B)
            {
                Toast.makeText(this, "EVDO_B", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_HSDPA)
            {
                Toast.makeText(this, "HSDPA", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_HSPAP)
            {
                Toast.makeText(this, "HSPAP", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_HSUPA)
            {
                Toast.makeText(this, "HSUPA", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_IDEN)
            {
                Toast.makeText(this, "IDEN", Toast.LENGTH_SHORT).show();
            }
            else if (i==TelephonyManager.NETWORK_TYPE_UMTS)
            {Toast.makeText(this, "UMTS", Toast.LENGTH_SHORT).show();}




        }
        else if (view==b10)
        {
            int b =tm.getPhoneCount();
            Toast.makeText(this, b+"", Toast.LENGTH_SHORT).show();
        }
        else if (view==b11)
        {
            int d =tm.getPhoneType();
            if (d==TelephonyManager.PHONE_TYPE_GSM)
            {
            Toast.makeText(this, "gsm", Toast.LENGTH_SHORT).show();
        }
        else if (d==TelephonyManager.PHONE_TYPE_CDMA)
            {}
            else if (d==TelephonyManager.PHONE_TYPE_NONE)
            {}



        }

        else if (view==b12)
        {
            c =tm.getSimCountryIso();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b13)
        {
            c =tm.getSimOperator();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b14)
        {
            c =tm.getSimOperatorName();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b15)
        {
            c =tm.getSimSerialNumber();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b16)
        {
            int f =tm.getSimState();

            if(f==TelephonyManager.SIM_STATE_ABSENT)
            {
                Toast.makeText(this, "Absent", Toast.LENGTH_SHORT).show();
            }
            else if (f==TelephonyManager.SIM_STATE_NETWORK_LOCKED)
            {
                Toast.makeText(this, "network locked", Toast.LENGTH_SHORT).show();
            }
            else if (f==TelephonyManager.SIM_STATE_PIN_REQUIRED)
            {
                Toast.makeText(this, "pin request", Toast.LENGTH_SHORT).show();
            }
            else if (f==TelephonyManager.SIM_STATE_PUK_REQUIRED)
            {
                Toast.makeText(this, "puk Required", Toast.LENGTH_SHORT).show();
            }
            else if (f==TelephonyManager.SIM_STATE_READY)
            {
                Toast.makeText(this, "ready", Toast.LENGTH_SHORT).show();
            }
            else if (f==TelephonyManager.SIM_STATE_UNKNOWN)
            {
                Toast.makeText(this, "unknown", Toast.LENGTH_SHORT).show();
            }

        }
        else if (view==b17)
        {
            c =tm.getSubscriberId();
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        }
        else if (view==b18)
        {
            int g =tm.getDataNetworkType();
            Toast.makeText(this, g+"", Toast.LENGTH_SHORT).show();
        }
        else if (view==b19)
        {
           boolean h =  tm.isNetworkRoaming();
if (h==true)
{
    Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
}
            else {
    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
}

        }
        else if (view==b20)
        {

        }

    }
}
