package com.example.amit.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3;
    String a[]={"1st","2nd","3rd"};
    boolean bb[]={false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view==b1)
        {
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

            ad.setIcon(R.mipmap.ic_launcher);
            ad.setTitle("hello");
            ad.setMessage("its a message");
            ad.setCancelable(false);
            ad.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            ad.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            ad.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            ad.create().show();

        }

        else if(view==b2)
        {

            AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);

            ab.setIcon(R.mipmap.ic_launcher);

            ab.setTitle("list dailog");

            ab.setItems(a, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if(i==0)
                    {
                        Toast.makeText(MainActivity.this, "u have selected first ittem's "+a[i], Toast.LENGTH_SHORT).show();
                    }
                    else if (i==1)
                    {
                        Toast.makeText(MainActivity.this, "u have selected Second ittem's "+a[i], Toast.LENGTH_SHORT).show();

                    }
                    else if (i==2)
                    {
                        Toast.makeText(MainActivity.this, "u have selected third ittem's "+a[i], Toast.LENGTH_SHORT).show();

                    }

                }
            });

            ab.create().show();



        }

        else if (view==b3)
        {

            AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);

            ab.setIcon(R.mipmap.ic_launcher);

            ab.setTitle("list dailog");

            ab.setMultiChoiceItems(a, bb, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    Toast.makeText(MainActivity.this, i+" "+b, Toast.LENGTH_SHORT).show();

                }
            });

            ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String s="";

                   if(bb[0]==true)
                   {
                       s=s+"1st,";
                   }
                    else
                   {}
                    if (bb[1]== true)
                    {
                        s=s+"2nd,";
                    }
                    else
                    {}
                    if (bb[2]==true)
                    {
                        s=s+"3rd,";
                    }

                    Toast.makeText(MainActivity.this, s.substring(0,s.length()-1)+" is selected", Toast.LENGTH_SHORT).show();




                }
            });

            ab.setNeutralButton("cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            ab.create().show();


        }











    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

        ad.setIcon(R.mipmap.ic_launcher);
        ad.setTitle("hello");
        ad.setMessage("its a message");
        ad.setCancelable(false);
        ad.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();

            }
        });

        ad.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {



            }
        });

        ad.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ad.create().show();


       // super.onBackPressed();
    }
}
