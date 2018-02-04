package com.example.amit.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;
    Button b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1= (CheckBox) findViewById(R.id.c1);
        c2= (CheckBox) findViewById(R.id.c2);
        c3= (CheckBox) findViewById(R.id.c3);
        b1= (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (c1.isChecked() && c2.isChecked() && c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c1,c2,c3 checkbox is checked", Toast.LENGTH_SHORT).show();

                }
                else if (!c1.isChecked() && !c2.isChecked() && !c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c1,c2,c3 checkbox is unchecked", Toast.LENGTH_SHORT).show();
                }
                else if(c1.isChecked() && c2.isChecked() && !c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c1,c2 checkbox is checked" +
                            "\nc3 checkbox is unchecked", Toast.LENGTH_SHORT).show();

                }
                else if (c1.isChecked() && !c2.isChecked() && c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c1,c3 checkbox is checked" +
                            "\nc2 is unchecked", Toast.LENGTH_SHORT).show();

                }

                else if (c1.isChecked() && !c2.isChecked() && !c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c1 checkbox is checked" +
                            "\nc2,c3 is unchecked", Toast.LENGTH_SHORT).show();

                }
                else if (!c1.isChecked() && c2.isChecked() && c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c2,c3 is checked" +
                            "\nc1  is unchecked", Toast.LENGTH_SHORT).show();
                   // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                else if (!c1.isChecked() && c2.isChecked() && !c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c2 is checked" +
                            "\nc1,c2 is unchecked", Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                else if (!c1.isChecked() && c2.isChecked() && c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c2,c3 is checked" +
                            "\nc1 is unchecked", Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                else if (!c1.isChecked() && !c2.isChecked() && c3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "c3 is checked" +
                            "\nc1,c2 is unchecked", Toast.LENGTH_SHORT).show();
                   // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                //if (c3.isChecked())
                //{
                //    Toast.makeText(MainActivity.this, "Third checkbox is checked", Toast.LENGTH_SHORT).show();
                //}
                //else
                //{
                 //   Toast.makeText(MainActivity.this, "Third checkbox is unchecked", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
}
