package com.example.amit.networkconnection;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if(ni==null)
        {
            Toast.makeText(this, "No Active Network Available", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, ni.isRoaming()+"", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ni.isAvailable()+"", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ni.isConnected()+"", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ni.isConnectedOrConnecting()+"", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ni.getState()+"", Toast.LENGTH_SHORT).show();
            if(ni.getType()==ConnectivityManager.TYPE_WIFI)
            {
                Toast.makeText(this, "Wifi is Connected", Toast.LENGTH_SHORT).show();
            }

            else if(ni.getType()==ConnectivityManager.TYPE_MOBILE)
            {
                Toast.makeText(this, "Mobile Data Connected", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, ni.getTypeName(), Toast.LENGTH_SHORT).show(); //Mobile
            Toast.makeText(this, ni.getSubtypeName(), Toast.LENGTH_SHORT).show();  //lte or 3g or 2g


        }



    }
}
