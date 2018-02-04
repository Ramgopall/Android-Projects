package com.example.amit.swipegesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ScaleGestureDetector.OnScaleGestureListener {
    GestureDetector gd;
    ScaleGestureDetector sgd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gd = new GestureDetector(MainActivity.this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
               // Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_SHORT).show();
                // every time when finger touch's screen
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
        // when we just press the screen
                Toast.makeText(MainActivity.this, "On ShowPress ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                // on clicking single time
                Toast.makeText(MainActivity.this, "OnSingleTapUp ", Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
               // Toast.makeText(MainActivity.this, "OnScroll ", Toast.LENGTH_SHORT).show();
                // work on every pixel thats why not using it

                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this, "OnLongPress ", Toast.LENGTH_SHORT).show();


            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                //Toast.makeText(MainActivity.this, ""+v1, Toast.LENGTH_SHORT).show();
                if (motionEvent.getY()- motionEvent1.getY()>50)
                {
                    Toast.makeText(MainActivity.this, "Swipe top", Toast.LENGTH_SHORT).show();
                }
                else if (motionEvent1.getY()- motionEvent.getY()>50)
                {
                    Toast.makeText(MainActivity.this, "Scroll down", Toast.LENGTH_SHORT).show();
                }
                else if (motionEvent.getX()-motionEvent1.getX() >50)
                {
                    Toast.makeText(MainActivity.this, "Swipe Rigth", Toast.LENGTH_SHORT).show();
                }
                else if (motionEvent1.getX()-motionEvent.getX()>50)
                {
                    Toast.makeText(MainActivity.this, "Swipe Left", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        sgd = new ScaleGestureDetector(MainActivity.this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
              //  gd.onTouchEvent(event);
        sgd.onTouchEvent(event);
        return true;   }

    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Toast.makeText(this, "OnScale", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Toast.makeText(this, "OnScaleBegin", Toast.LENGTH_SHORT).show();
        return false;

    }

    @Override
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Toast.makeText(this, "OnScaleEnd", Toast.LENGTH_SHORT).show();
    }
}
