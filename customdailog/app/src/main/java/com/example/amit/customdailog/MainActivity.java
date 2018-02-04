package com.example.amit.customdailog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);


        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {

        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);

        ab.setTitle("custom dailog");
        ab.setIcon(R.mipmap.ic_launcher);
        ab.setView(R.layout.login);
        ab.setCancelable(false);
        final AlertDialog a= ab.create();

        a.show();
       final EditText ed1,ed2;
        final ImageView iv1;
        final Button b2,b3;
        iv1= (ImageView) a.findViewById(R.id.iv1);
        ed1= (EditText) a.findViewById(R.id.ed1);
        ed2= (EditText) a.findViewById(R.id.ed2);
        b2= (Button) a.findViewById(R.id.b2);
        b3= (Button) a.findViewById(R.id.b3);
        //ed2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(b3.getText().equals("show"))
                {
                    ed2.setInputType(InputType.TYPE_CLASS_TEXT);
                    b3.setText("hide");
            }
                else  /*(b3.getText().equals("hide"))*/{

                    ed2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    b3.setText("show");
                }

            }
        });


        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.cancel();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(MainActivity.this, "Username :-"+ed1.getText().toString()+"\n"+"Password :-"+ed2.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}
