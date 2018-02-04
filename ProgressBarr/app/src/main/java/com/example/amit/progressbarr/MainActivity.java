package com.example.amit.progressbarr;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText et1;
    ProgressBar pb1;
    CountDownTimer cd;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.b1);
        et1= (EditText) findViewById(R.id.et1);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        pb1= (ProgressBar) findViewById(R.id.pb1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final int a = Integer.parseInt(et1.getText().toString());

        cd = new CountDownTimer(a*1000,1) {
            @Override
            public void onTick(long l) {
                l/=1000;
                tv2.setText(l+"");
                long i = (a)-l;
                tv1.setText(i+"");
                pb1.setMax(a);
                pb1.setProgress((int) i);
            }

            @Override
            public void onFinish() {
                cd.cancel();
            }
        };
        cd.start();

    }
}
