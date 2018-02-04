package com.example.amit.fragments1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    LinearLayout ll3;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
       // b3= (Button) findViewById(R.id.b3);
        ll3= (LinearLayout) findViewById(R.id.ll3);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

     //   b3.setOnClickListener(this);

        fm = getFragmentManager();


    }

    @Override
    public void onClick(View view) {
        if (view==b1)
        {
            ft = fm.beginTransaction();
            ft.replace(R.id.ll3,new fragment1());
            ft.commit();

        }
        else if (view==b2)
        {
            ft = fm.beginTransaction();
            ft.replace(R.id.ll3,new fragment2());
            ft.commit();
        }


    }
}
