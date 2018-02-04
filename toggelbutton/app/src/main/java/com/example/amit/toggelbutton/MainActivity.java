package com.example.amit.toggelbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ToggleButton t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    t1= (ToggleButton) findViewById(R.id.t1);
        t2= (ToggleButton) findViewById(R.id.t2);


        t2.setChecked(true);

        b1= (Button) findViewById(R.id.b1);

        t1.setOnCheckedChangeListener(this);
        t2.setOnCheckedChangeListener(this);


        b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(t1.isChecked())
            {
                Toast.makeText(MainActivity.this, "Toggle 1 is On", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(MainActivity.this, "Toggle 1 is off", Toast.LENGTH_SHORT).show();
            }


            if(t2.isChecked())
            {
                Toast.makeText(MainActivity.this, "t2 is on", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(MainActivity.this, "t2 is off", Toast.LENGTH_SHORT).show();
            }





        }
    });






    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {


        if(compoundButton==t1)
        {
            if(b==true)
            {
               t2.setChecked(true);
                 Toast.makeText(this, "t1 is on", Toast.LENGTH_SHORT).show();
            }

            else
            {
                t2.setChecked(false);
                Toast.makeText(this, "T1 is off", Toast.LENGTH_SHORT).show();
            }
        }

        else
        {
            if (b==true)
            {
                Toast.makeText(this, "t2 is on", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "t2 is off", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
