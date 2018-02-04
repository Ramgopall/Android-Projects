package com.example.amit.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    RatingBar rb1,rb2;
    Button b;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    rb1= (RatingBar) findViewById(R.id.rb1);
        rb2= (RatingBar) findViewById(R.id.rb2);
        b= (Button) findViewById(R.id.b);
tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        rb2.setRating(2.5f);
        b.setOnClickListener(this);
        //rb2.setIsIndicator(true);
        rb1.setOnRatingBarChangeListener(this);
        rb2.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {

        float i= rb1.getRating();
        float f= rb2.getRating();

        Toast.makeText(this, i+","+f+"", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

        float q= rb1.getRating();
        float w= rb2.getRating();

        tv1.setText(q+"");
        tv2.setText(w+"");


    }
}
