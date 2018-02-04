package com.example.amit.progressdialog;

import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= (Button) findViewById(R.id.b);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Please Wait..");
        pd.setMessage("Loading..");
        pd.setCancelable(false);
        pd.show();

        CountDownTimer cd = new CountDownTimer(5000,100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                pd.dismiss();


            }
        };

        cd.start();


    }
}
