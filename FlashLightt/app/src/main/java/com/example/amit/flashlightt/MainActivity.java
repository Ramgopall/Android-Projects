package com.example.amit.flashlightt;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.security.Policy;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Switch sw;
    Camera camera = Camera.open();
    Camera.Parameters para = camera.getParameters();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw= (Switch) findViewById(R.id.sw);

        sw.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (b==true)
        {
           // Camera camera = Camera.open();

            para.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(para);
            camera.startPreview();

        }
        else
        {

            para.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(para);
            camera.stopPreview();


        }


    }


}
