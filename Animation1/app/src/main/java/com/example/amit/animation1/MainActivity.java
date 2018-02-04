package com.example.amit.animation1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
   Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1= (Button) findViewById(R.id.fadein);
        b2= (Button) findViewById(R.id.fadeout);
        b3= (Button) findViewById(R.id.rotate);
        b4= (Button) findViewById(R.id.move);
        b5= (Button) findViewById(R.id.slidedown);
        b6= (Button) findViewById(R.id.slideup);
        b7= (Button) findViewById(R.id.crossfade);
        b8= (Button) findViewById(R.id.blink);
        b9= (Button) findViewById(R.id.bounce);
        b10= (Button) findViewById(R.id.together);
        b11= (Button) findViewById(R.id.squential);
        b12= (Button) findViewById(R.id.zoomin);
        b13= (Button) findViewById(R.id.zoomout);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v==b1)
        {
           Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinn);
            b1.startAnimation(an);
        }
        else if (v==b2)
        {
           Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeoutt);
            b2.startAnimation(an);
        }
        else if (v==b3)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
            b3.startAnimation(an);
        }
        else if (v==b4)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
            b4.startAnimation(an);
        }
        else if (v==b5)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slidedown);
            b5.startAnimation(an);
        }
        else if (v==b6)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideup);
            b6.startAnimation(an);
        }
        else if (v==b7)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinn);
            Animation ann = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeoutt);

            an.setAnimationListener(this);

        }
        else if (v==b8)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
            b8.startAnimation(an);
        }
        else if (v==b9)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
            b9.startAnimation(an);
        }
        else if (v==b10)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);
            b10.startAnimation(an);
        }
        else if (v==b11)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.squentional);
            b11.startAnimation(an);
        }
        else if (v==b12)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
            b12.startAnimation(an);
        }
        else if (v==b13)
        {
            Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
            b13.startAnimation(an);
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
