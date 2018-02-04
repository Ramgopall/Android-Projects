package com.example.amit.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8;
    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ba=BluetoothAdapter.getDefaultAdapter();

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view==b1)
        {
            if (ba.isEnabled()==true)
            {
                Toast.makeText(this, "Bluetooth ON", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Bluetooth OFF", Toast.LENGTH_SHORT).show();
        }

        else if (view==b2)
        {
            ba.enable();
            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();

        }
        else if (view==b4)
        {
            ba.disable();
            Toast.makeText(this, "Bluetooth is OFF", Toast.LENGTH_SHORT).show();

        }
        else if (view==b3)
        {
            Toast.makeText(this, "Bluetooth Name is "+ba.getName(), Toast.LENGTH_SHORT).show();

        }
        else if (view==b5)
        {
            ba.setName("Ram");
            Toast.makeText(this, ba.getName()+"", Toast.LENGTH_SHORT).show();

        }
        else if (view==b6)
        {

            Toast.makeText(this, ba.getAddress(), Toast.LENGTH_SHORT).show();
        }
        else if (view==b7)
        {
            int m = ba.getState();

            if(m==BluetoothAdapter.STATE_CONNECTED)
            {
                Toast.makeText(this, "Bluetooth is Connected", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_DISCONNECTED)
            {
                Toast.makeText(this, "Bluetootth is Disconnected", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_OFF)
            {
                Toast.makeText(this, "Off", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_ON)
            {
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_CONNECTING)
            {
                Toast.makeText(this, "Connecting", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_DISCONNECTING)
            {
                Toast.makeText(this, "Disconnecting", Toast.LENGTH_SHORT).show();
            }
            if(m==BluetoothAdapter.STATE_TURNING_OFF)
            {
                Toast.makeText(this, "Turning Off", Toast.LENGTH_SHORT).show();
            }
            if (m==BluetoothAdapter.STATE_TURNING_ON)
            {
                Toast.makeText(this, "Turning On", Toast.LENGTH_SHORT).show();

            }

        }



    }
}
