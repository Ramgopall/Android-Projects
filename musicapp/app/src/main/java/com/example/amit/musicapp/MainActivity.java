package com.example.amit.musicapp;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemClickListener {

    TextView tv1,tv2;
    Button b1,b2,b3,b4,b5,b6,b7,b0;
    SeekBar sb1;
    MediaPlayer mp =new MediaPlayer();
    int nm, sec;
    CountDownTimer cd;
    Uri music;
    long dur;
    int pasong;
    ListView lv1;
    ArrayList al,alt;
   // String end = ".mp3";
   //String path = String.valueOf(Environment.getExternalStorageDirectory());


/*    private int getProgressPercentage(long currentDuration1, long totalDuration1) {
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration1 / 1000);
        long totalSeconds = (int) (totalDuration1 / 1000);

        // calculating percentage
        percentage = (((double) currentSeconds) / totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b0= (Button) findViewById(R.id.b0);
        sb1= (SeekBar) findViewById(R.id.sb1);
        lv1= (ListView) findViewById(R.id.lv1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b0.setOnClickListener(this);

        sb1.setOnSeekBarChangeListener(this);


        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);

        Cursor cr = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        al = new ArrayList();

        while(cr.moveToNext())
        {
            int namecolumnindex = cr.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME);
            al.add(cr.getString(namecolumnindex));
        }


        ArrayAdapter aa = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al);

        lv1.setAdapter(aa);

        Cursor c = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        alt = new ArrayList();

        while(c.moveToNext())
        {
            int nameecolumnindex = c.getColumnIndex(MediaStore.Audio.Media.DATA);
            alt.add(c.getString(nameecolumnindex));
        }

       // Toast.makeText(this, cr.getString(namecolumnindex), Toast.LENGTH_SHORT).show();

//        File myMp3Dir = new  File("/sdcard");
//        ArrayList songs=new ArrayList();
//        ArrayAdapter aa;
//        File filelist[] = myMp3Dir.listFiles();
//
//
//        if (filelist==null)
//        {
//            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
//        }
//
//        for (File f: filelist)
//
//        {
////           if (!f.isDirectory())
//          if (f.getName().endsWith(".mp3"))
//          {
//                songs.add(f.getName());
//          }
//
//        }
//
//
//
       lv1.setOnItemClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if (view==b0)
        {   if (mp.isPlaying()==true) {
            mp.stop();
            cd.cancel();
        }


            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 1);
            b1.setEnabled(true);

        }
        else if (view==b1)
        {
            if (mp.isPlaying()==true) {
                mp.pause();
                cd.cancel();
            }
            mp.seekTo(0);
                mp.start();
                dur = mp.getDuration();

                cd = new CountDownTimer(dur, 100) {
                    @Override
                    public void onTick(long l) {

                        long up = dur - l;
                        // dur /=1000;
                        sb1.setMax((int) dur);
                        //up /=1000;
                        sb1.setProgress((int) up);

                        up /= 1000;
                        int ff = (int) (up / 60);
                        int fg = (int) (up % 60);

                        tv1.setText(ff + ":" + fg);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                cd.start();

            int n = mp.getDuration();
            n=n/1000;
            nm =n/60;
            sec = n%60;
            tv2.setText(nm+":"+sec);




            b2.setEnabled(true);
            b3.setEnabled(false);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);


        }
        else if (view==b2)
        {
            mp.pause();
            cd.cancel();
            b3.setEnabled(true);
            b2.setEnabled(false);
           pasong =  sb1.getProgress();
        }
        else if (view==b3)
        {
            mp.start();


            int aa= (int) (dur-pasong);

            cd= new CountDownTimer(aa,100) {
                @Override
                public void onTick(long l) {

                    long up= dur-l;
                    // dur /=1000;
                    sb1.setMax((int) dur);
                    //up /=1000;
                    sb1.setProgress((int) up);

                    up /=1000;
                    int ff= (int) (up/60);
                    int fg = (int) (up%60);

                    tv1.setText(ff+":"+fg);
                }

                @Override
                public void onFinish() {

                }
            };
            cd.start();

            b3.setEnabled(false);
            b2.setEnabled(true);





        }
        else if (view==b4)
        {
            mp.stop();
            cd.cancel();
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b7.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b4.setEnabled(false);
            tv1.setText("");
            sb1.setProgress(0);
            tv2.setText("");
            mp = new MediaPlayer();
        }
        else if (view== b5)
        {
           double m = mp.getCurrentPosition();
            m=m/1000;
            m=m/60;
           tv1.setText(m+"");
        }
        else if (view== b6)
        {
            int n = mp.getDuration();
            n=n/1000;
            nm =n/60;
            sec = n%60;

            tv2.setText(nm+":"+sec);
        }
        else if (view== b7)
        {
            if (mp.isPlaying()==true)
            {
                Toast.makeText(this, "Media player is running", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Media player is not running", Toast.LENGTH_SHORT).show();

            }

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


     //   int n = mp.getDuration();
       // n=n/1000;

     /*  sb1.setMax((int) dur);
        mp.seekTo(i);
*/
     /*   int f=sb1.getProgress();
        f /=1000;
        f=f/60;
        int d = sb1.getProgress();
        d=d%60;
        tv1.setText(f+":"+d);

*/


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {



    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if (mp.isPlaying()==true) {
            cd.cancel();
            int ai = sb1.getProgress();
            mp.seekTo(ai);
            int aa = (int) (dur - ai);

            cd = new CountDownTimer(aa, 100) {
                @Override
                public void onTick(long l) {

                    long up = dur - l;
                    // dur /=1000;
                    sb1.setMax((int) dur);
                    //up /=1000;
                    sb1.setProgress((int) up);

                    up /= 1000;
                    int ff = (int) (up / 60);
                    int fg = (int) (up % 60);

                    tv1.setText(ff + ":" + fg);
                }

                @Override
                public void onFinish() {

                }
            };
            cd.start();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            music = data.getData();
            //Toast.makeText(this, "got the data", Toast.LENGTH_SHORT).show();

            try {
                mp = new MediaPlayer();
                mp.setDataSource(MainActivity.this,music);
                mp.prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

  /*  private void updatePosition() {

        handler.removeCallbacks(updatePosionRunable);
       sb1.setProgress(mp.getCurrentPosition());
        handler.postDelayed(updatePosionRunable,1000);
    }

  Runnable updatePosionRunable = new Runnable() {
      @Override
      public void run() {
          // updatePosition();
          if (mp.isPlaying()){
              //int totalDuration = mp.getDuration();
              starttime = mp.getCurrentPosition()/1000;
              //int progress = getProgressPercentage(currentDuration,totalDuration);
              sb1.setProgress((int) starttime);
              handler.postDelayed(this,1000);
          }}
  }; */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  mp.pause();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



        Toast.makeText(this, ""+alt.get(i), Toast.LENGTH_SHORT).show();


        mp = new MediaPlayer();
        try {
            mp.setDataSource(alt.get(i).toString());
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
