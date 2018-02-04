package com.example.amit.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    SeekBar sb1,sb2;
    Button b;
    TextView tv1,tv2;
    int i,k;
    double n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb1= (SeekBar) findViewById(R.id.sb1);
        sb2= (SeekBar) findViewById(R.id.sb2);
        b= (Button) findViewById(R.id.b);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
       // sb2.setProgress(50);
        sb2.setMax(100);




        b.setOnClickListener(this);
        sb1.setOnSeekBarChangeListener(this);
        sb2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        i= sb1.getProgress();
        n= sb2.getProgress();



            tv2.setText(n+"");


        tv1.setText(i+"");


        //Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, n+"", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        i=sb1.getProgress();
        n=sb2.getProgress();




        n= (n/10)+20;



        tv1.setText(i+"");
        tv2.setText(n+"");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {



    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
