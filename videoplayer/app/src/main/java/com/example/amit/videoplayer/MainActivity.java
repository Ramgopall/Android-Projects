package com.example.amit.videoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    VideoView vv1;
    Uri video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv1= (VideoView) findViewById(R.id.vv1);
        b1= (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            video = data.getData();

            MediaController mediaController = new MediaController(MainActivity.this);

            mediaController.setPrevNextListeners(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "next", Toast.LENGTH_SHORT).show();
                }
            }, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "prev", Toast.LENGTH_SHORT).show();

                }
            });

            mediaController.setAnchorView(vv1);
            vv1.setMediaController(mediaController);
            vv1.setVideoURI(video);
            vv1.requestFocus();
            vv1.start();


        }

    }
}
