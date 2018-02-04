package com.example.amit.counontimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4;
    TextView tv,tv1;
    EditText et;
    CountDownTimer cd;
    int i;
    String time,t2;
    SeekBar sb1,sb2;
    boolean check=false;
    boolean check2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        et= (EditText) findViewById(R.id.et);
        tv= (TextView) findViewById(R.id.tv);
        tv1= (TextView) findViewById(R.id.tv1);
        sb1= (SeekBar) findViewById(R.id.sb1);
        sb2= (SeekBar) findViewById(R.id.sb2);



        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view==b1)
        {
           if (et.getText().toString().equals(""))
           {
               et.setError("Enter value");
               Toast.makeText(this, "Enter timer value", Toast.LENGTH_SHORT).show();
           }
            else {


               String a = et.getText().toString();
               i = Integer.parseInt(a);

               cd = new CountDownTimer(i * 1000, 1) {
                   @Override
                   public void onTick(long l) {

                       long uptime = (i*1000)-l;
                       l /= 1000;
                       tv.setText(l + "");
                       uptime /=1000 ;
                       uptime +=1;
                       tv1.setText(uptime+"");

                       sb1.setMax(i);
                       sb1.setProgress((int) uptime);
                       sb2.setMax(i);
                       sb2.setProgress((int) l);


                   }

                   @Override
                   public void onFinish() {
                       tv.setText("timer ended");

                   }
               };


               cd.start();
                check = true;
           }
        }
        else if (view==b2)
        {

            if (check==true)
            {
                cd.cancel();

                time = tv.getText().toString();
                t2 = tv1.getText().toString();
                check2 = true;

            }

            else {

                Toast.makeText(this, "timer has't started yet", Toast.LENGTH_SHORT).show();



            }


        }
        else if (view==b3)
        {

            if (check==true && check2==true) {
                final int t1 = Integer.parseInt(time);
                final int t3 = Integer.parseInt(t2);
                cd = new CountDownTimer(t1 * 1000, 1) {
                    @Override
                    public void onTick(long l) {

                        long up = (t1 * 1000) - l;
                        l /= 1000;
                        tv.setText(l + "");
                        up /= 1000;
                        up += t3 + 1;
                        tv1.setText(up + "");


                        sb1.setProgress((int) up);
                        sb2.setProgress((int) l);


                    }

                    @Override
                    public void onFinish() {

                        tv.setText("timer ended");

                    }
                };

                cd.start();
                check2=false;
            }
            else
                Toast.makeText(this, "first pause the timer", Toast.LENGTH_SHORT).show();
        }
        else if (view==b4)
        {
            if (check==true) {
                cd.cancel();
                tv.setText("Timer has been stoped");
                tv1.setText("Timer has been stoped");
                et.setText("");
                check2=false;
                check=false;
                sb1.setProgress(0);
                sb2.setProgress(0);
            }
            else
                Toast.makeText(this, "First Start Timer", Toast.LENGTH_SHORT).show();
        }
    }
}
