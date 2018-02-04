package com.example.amit.backpresss;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CountDownTimer cd;
    boolean m =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cd = new CountDownTimer(5*1000,1) {

            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {


                m= false;

            }
        };
    }

    @Override
    public void onBackPressed() {

        if (m==false)
        {
            m=true;
            Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();

            cd.start();


        }
        else
        {
            finish();
        }






    }
}
