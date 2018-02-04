package com.example.amit.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    RelativeLayout r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        r1= (RelativeLayout) findViewById(R.id.activity_main);

        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Snackbar.make(r1,"hello",10000).setAction("Go Online", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Connecting", Toast.LENGTH_SHORT).show();
            }
        }).show();


    }
}
