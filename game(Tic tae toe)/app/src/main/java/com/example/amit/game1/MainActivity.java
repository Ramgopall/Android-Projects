package com.example.amit.game1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //public static boolean playerturn = true;
   // public static boolean player1won= false;
   // public static boolean player2won= false;

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView tv1;
    boolean playerturn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Tic Tac Toe");

        b0= (Button) findViewById(R.id.b0);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);
        b9= (Button) findViewById(R.id.b9);
        tv1= (TextView) findViewById(R.id.tv1);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {

        if(view==b0)
        {
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            tv1.setText("");


            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);

        }







             if (view == b1) {

                 if (playerturn==true)
                 {

                     b1.setText("x");
                     b1.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b1.setText("o");
                     b1.setEnabled(false);
                     playerturn = true;
                 }

              } else if (view == b2) {
                 if (playerturn==true)
                 {

                     b2.setText("x");
                     b2.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b2.setText("o");
                     b2.setEnabled(false);
                     playerturn = true;
                 }
              } else if (view == b3) {
                 if (playerturn==true)
                 {

                     b3.setText("x");
                     b3.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b3.setText("o");
                     b3.setEnabled(false);
                     playerturn = true;
                 }

              } else if (view == b4) {
                 if (playerturn==true)
                 {

                     b4.setText("x");
                     b4.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b4.setText("o");
                     b4.setEnabled(false);
                     playerturn = true;
                 }

              } else if (view == b5) {
                 if (playerturn==true)
                 {

                     b5.setText("x");
                     b5.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b5.setText("o");
                     b5.setEnabled(false);
              playerturn = true;
                 }

              } else if (view == b6) {
                 if (playerturn==true)
                 {

                     b6.setText("x");
                     b6.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b6.setText("o");
                     b6.setEnabled(false);
                     playerturn = true;
                 }

              } else if (view == b7) {
                 if (playerturn==true)
                 {

                     b7.setText("x");
                     b7.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b7.setText("o");
                     b7.setEnabled(false);
                   playerturn = true;
                 }

              } else if (view == b8) {
                 if (playerturn==true)
                 {

                     b8.setText("x");
                     b8.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b8.setText("o");
                     b8.setEnabled(false);
                     playerturn = true;
                 }

              } else if (view == b9) {
                 if (playerturn==true)
                 {

                     b9.setText("x");
                     b9.setEnabled(false);
                     playerturn = false;
                 }
                 else {
                     b9.setText("o");
                     b9.setEnabled(false);
                     playerturn = true;
                 }

              }




        // ______________________________________________________________________________________________________________



        if (b1.getText().equals("x")){
            if (b5.getText().equals("x")){
                if (b9.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b1.getText().equals("x")){
            if (b4.getText().equals("x")){
                if (b7.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b1.getText().equals("x")){
            if (b2.getText().equals("x")){
                if (b3.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");
                }
            }
        }
        if (b2.getText().equals("x")){
            if (b5.getText().equals("x")){
                if (b8.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b4.getText().equals("x")){
            if (b5.getText().equals("x")){
                if (b6.getText().equals("x")){

                  //  player1won= true;
                  //  player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b3.getText().equals("x")){
            if (b5.getText().equals("x")){
                if (b7.getText().equals("x")){

                  //  player1won= true;
                  //  player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b7.getText().equals("x")){
            if (b8.getText().equals("x")){
                if (b9.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b3.getText().equals("x")){
            if (b6.getText().equals("x")){
                if (b9.getText().equals("x")){

                   // player1won= true;
                   // player2won= false;
                    tv1.setText("player1won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }







        if (b1.getText().equals("o")){
            if (b5.getText().equals("o")){
                if (b9.getText().equals("o")){

                   // player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");

                }
            }
        }
        if (b1.getText().equals("o")){
            if (b4.getText().equals("o")){
                if (b7.getText().equals("o")){

                   // player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b1.getText().equals("o")){
            if (b2.getText().equals("o")){
                if (b3.getText().equals("o")){

                   // player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b2.getText().equals("o")){
            if (b5.getText().equals("o")){
                if (b8.getText().equals("o")){

                  //  player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b4.getText().equals("o")){
            if (b5.getText().equals("o")){
                if (b6.getText().equals("o")){

                  //  player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b3.getText().equals("o")){
            if (b5.getText().equals("o")){
                if (b7.getText().equals("o")){

                   // player1won= false;
                   // player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b7.getText().equals("o")){
            if (b8.getText().equals("o")){
                if (b9.getText().equals("o")){

                   // player1won= false;
                    //player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        if (b3.getText().equals("o")){
            if (b6.getText().equals("o")){
                if (b9.getText().equals("o")){

                   // player1won= false;
                    //player2won= true;
                    tv1.setText("player2won!");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }













    }





    }



