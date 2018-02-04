package com.example.amit.phoninfo;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);
        b9= (Button) findViewById(R.id.b9);
        b10= (Button) findViewById(R.id.b10);
        b11= (Button) findViewById(R.id.b11);
        b12= (Button) findViewById(R.id.b12);
        b13= (Button) findViewById(R.id.b13);
        b14= (Button) findViewById(R.id.b14);
        b15= (Button) findViewById(R.id.b15);
        b16= (Button) findViewById(R.id.b16);

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
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {


        if (view==b1)
        {
            String brand = Build.BRAND;
            String model = Build.MODEL;
            Toast.makeText(this, brand+" "+model, Toast.LENGTH_SHORT).show();

        }
        else if (view==b2)
        {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            double a = dm.widthPixels/dm.xdpi;
            double hight = dm.heightPixels/dm.ydpi;
            double inch = Math.sqrt(a*a+hight*hight);

            Toast.makeText(this, inch+"", Toast.LENGTH_SHORT).show();
        }
        else if (view==b3)
        {
            ActivityManager acmanager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo mf = new ActivityManager.MemoryInfo();
            acmanager.getMemoryInfo(mf);
            double totalmemory = mf.totalMem / 1048576L;
            double tm = Math.round(totalmemory/1024)*1;

            Toast.makeText(this, ""+tm, Toast.LENGTH_SHORT).show();

            //------------------------------------------------
            //its a another method

//            try {
//                FileReader fr = new FileReader("/proc/meminfo");
//
//                BufferedReader br = new BufferedReader(fr);
//                String text = br.readLine();
//                br.close();
//                Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }




        }
        else if (view==b4)
        {

            File path = Environment.getDataDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            long m= (totalBlocks * blockSize) / (1024*1024);
            // Toast.makeText(this, ""+totalBlocks, Toast.LENGTH_SHORT).show();

            File expath = Environment.getExternalStorageDirectory();
            StatFs exstat = new StatFs(expath.getPath());
            long exblocksize = exstat.getBlockSize();
            long extotalblock = exstat.getBlockCount();

            long ex = (extotalblock*exblocksize)/(1024*1024);

            Toast.makeText(this, "Internal Storage "+m+"MB"+"\n"+"External Storage "+ex+"MB", Toast.LENGTH_SHORT).show();

        }
        else if (view==b5)
        {
            Display display = getWindowManager().getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();

            Toast.makeText(this, width+"x"+height, Toast.LENGTH_SHORT).show();
        }
        else if (view==b6)
        {
            String ver = Build.VERSION.RELEASE ;
            Toast.makeText(this, ""+ver, Toast.LENGTH_SHORT).show();


        }
        else if (view==b7)
        {

            int i = Camera.CameraInfo.CAMERA_FACING_FRONT;
            Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();

        }
        else if (view==b8)
        {

          //  Camera ca = (Camera) getSystemService(CAMERA_SERVICE);
            Camera camera;
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
            //Camera camera = Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_FRONT, Camera.CameraInfo);
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size size = parameters.getPictureSize();


            int height = size.height;
            int width = size.width;

            double i = (height*width)/1024000;
            Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
        }
        else if (view==b9)
        {
            String s= Build.HARDWARE;
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();


        }
        else if (view==b10)
        {
            int i = Runtime.getRuntime().availableProcessors();
            Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
        }
        else if (view==b11)
        {
            try {
                FileReader fr = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
                FileReader frt = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                BufferedReader br = new BufferedReader(fr);
                String text = br.readLine();

                br = new BufferedReader(frt);
                String text2 = br.readLine();
                br.close();

                int i= Integer.parseInt(text);
                i /= 1000;

                int n = Integer.parseInt(text2);
                n /= 1000;

                Toast.makeText(this, i+"Mhz"+"-"+n+"Mhz", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (view==b12)
        {}
        else if (view==b13)
        {
            //int a = GL10.GL_RENDERER;
            String m = GLES10.glGetString(GL10.GL_VENDOR);
            //String m3 = GLES10.glGetString(GL10.GL_VERSION);
            //  String m4 = GLES10.glGetString(GL10.GL_EXTENSIONS);

            Toast.makeText(this, "Manufacturer:- "+m, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, ""+m3, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, ""+m4, Toast.LENGTH_SHORT).show();

        }
        else if (view==b14)
        {
            String m2 = GLES10.glGetString(GL10.GL_RENDERER);
            Toast.makeText(this, "Model:-"+m2, Toast.LENGTH_SHORT).show();


        }
        else if (view==b15)
        {
            boolean multi =
                    getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);

            if (multi==true)
            {
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();

            }
        }
        else if (view==b16)
        {}


    }
}
