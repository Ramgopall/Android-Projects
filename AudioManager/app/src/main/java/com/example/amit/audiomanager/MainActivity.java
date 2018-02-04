package com.example.amit.audiomanager;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;
    Button b1;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= (RadioGroup) findViewById(R.id.rg);
        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);

        am= (AudioManager) getSystemService(AUDIO_SERVICE);

        int ringer = am.getRingerMode();

        if (ringer==am.RINGER_MODE_NORMAL)
        {
            rg.check(R.id.rb3);
        }
        else if (ringer==am.RINGER_MODE_SILENT)
        {
            rg.check(R.id.rb1);
        }
        else if (ringer==am.RINGER_MODE_VIBRATE)
        {
            rg.check(R.id.rb2);
        }


        rg.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {

        int i = rg.getCheckedRadioButtonId();

        if(i==R.id.rb1)
        {
            am.setRingerMode(am.RINGER_MODE_SILENT);
        }
        else if (i==R.id.rb2)
        {
            am.setRingerMode(am.RINGER_MODE_VIBRATE);
        }
        else if (i==R.id.rb3)
        {
            am.setRingerMode(am.RINGER_MODE_NORMAL);

        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {


        if(i==R.id.rb1)
        {
            am.setRingerMode(am.RINGER_MODE_SILENT);
        }
        else if (i==R.id.rb2)
        {
            am.setRingerMode(am.RINGER_MODE_VIBRATE);
        }
        else if (i==R.id.rb3)
        {
            am.setRingerMode(am.RINGER_MODE_NORMAL);
        }

    }
}
