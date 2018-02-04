package com.example.amit.getlocationchanges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(i);

    }


}
