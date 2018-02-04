package com.example.amit.radiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup rg1,rg2,rg3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1= (RadioGroup) findViewById(R.id.rg1);
        rg2= (RadioGroup) findViewById(R.id.rg2);
        rg3= (RadioGroup) findViewById(R.id.rg3);
        b1= (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                int i1 = rg1.getCheckedRadioButtonId();

                int i2 = rg2.getCheckedRadioButtonId();

                int i3 = rg3.getCheckedRadioButtonId();

                if(i1==R.id.r1)
                {
                    Toast.makeText(MainActivity.this, "rg1's First radio is selected", Toast.LENGTH_SHORT).show();
                }

                else if(i1==R.id.r2)
                {
                    Toast.makeText(MainActivity.this, "rg1's Second radio is selected", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "rg1's third radio is selected", Toast.LENGTH_SHORT).show();


                if(i2==R.id.r4)
                {
                    Toast.makeText(MainActivity.this, "rg2's First radio is selected", Toast.LENGTH_SHORT).show();
                }

                else if(i2==R.id.r5)
                {
                    Toast.makeText(MainActivity.this, "rg2's Second radio is selected", Toast.LENGTH_SHORT).show();

                }

                else
                    Toast.makeText(MainActivity.this, "rg2's Third radio is selected", Toast.LENGTH_SHORT).show();


                if(i3==R.id.r7)
                {
                    Toast.makeText(MainActivity.this, "rg3's First radio is selected", Toast.LENGTH_SHORT).show();

                }

                else if(i3==R.id.r8)
                {
                    Toast.makeText(MainActivity.this, "rg3's Second radio is selected", Toast.LENGTH_SHORT).show();

                }

                else
                    Toast.makeText(MainActivity.this, "rg3's Third radio is selected", Toast.LENGTH_SHORT).show();

            }

        });

        rg1.setOnCheckedChangeListener(this);
        rg2.setOnCheckedChangeListener(this);
        rg3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (rg1==radioGroup)
        {
            if(i==R.id.r1)
            {
                Toast.makeText(MainActivity.this, "rg1's First radio is selected", Toast.LENGTH_SHORT).show();
            }

            else if(i==R.id.r2)
            {
                Toast.makeText(MainActivity.this, "rg1's Second radio is selected", Toast.LENGTH_SHORT).show();
            }

            else
                Toast.makeText(MainActivity.this, "rg1's third radio is selected", Toast.LENGTH_SHORT).show();




        }
        else if (rg2==radioGroup)
        {
            if(i==R.id.r4)
            {
                Toast.makeText(MainActivity.this, "rg2's First radio is selected", Toast.LENGTH_SHORT).show();
            }

            else if(i==R.id.r5)
            {
                Toast.makeText(MainActivity.this, "rg2's Second radio is selected", Toast.LENGTH_SHORT).show();

            }

            else
                Toast.makeText(MainActivity.this, "rg2's Third radio is selected", Toast.LENGTH_SHORT).show();


        }
        else
        {
            if(i==R.id.r7)
            {
                Toast.makeText(MainActivity.this, "rg3's First radio is selected", Toast.LENGTH_SHORT).show();

            }

            else if(i==R.id.r8)
            {
                Toast.makeText(MainActivity.this, "rg3's Second radio is selected", Toast.LENGTH_SHORT).show();

            }

            else
                Toast.makeText(MainActivity.this, "rg3's Third radio is selected", Toast.LENGTH_SHORT).show();

        }

    }
}
