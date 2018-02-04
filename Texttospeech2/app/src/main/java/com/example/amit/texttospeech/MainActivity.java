package com.example.amit.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed;
    Button b;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= (Button) findViewById(R.id.b);
        ed= (EditText) findViewById(R.id.ed);

        b.setOnClickListener(this);

        tts= new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                tts.setLanguage(Locale.JAPANESE);

                tts.setSpeechRate(0.5f);  //   1.0 is default and in + get faster.

                tts.setPitch(1.5f);     //  1.0 is default and in + get thinner.


            }
        });
    }

    @Override
    public void onClick(View view) {

        tts.speak(ed.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);


    }
}
