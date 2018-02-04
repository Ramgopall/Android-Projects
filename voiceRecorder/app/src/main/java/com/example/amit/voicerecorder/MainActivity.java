package com.example.amit.voicerecorder;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4;
    MediaRecorder mr;
    String pathh ;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view==b1){

            b1.setEnabled(false);
            b2.setEnabled(true);

            pathh = Environment.getExternalStorageDirectory().getAbsolutePath()+"/abc"+ System.currentTimeMillis()+".3gp";

            mr = new MediaRecorder();
            mr.setAudioSource(MediaRecorder.AudioSource.MIC);
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mr.setOutputFile(pathh);
            try {
                mr.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mr.start();

        }

        else if (view==b2)
        {
            b2.setEnabled(false);
            b1.setEnabled(true);

            mr.stop();
            mr.release();
            mr=null;


        }

        else if(view==b3)
        {
             mp = new MediaPlayer();
            try
            {
                mp.setDataSource(pathh);
                mp.prepare();
                mp.start();
            }
            catch(Exception e)
            {
                Toast.makeText(this, "Media Player Not Started", Toast.LENGTH_SHORT).show();
            }

        }
        else if (view==b4)
        {
            mp.stop();
        }
    }
}
