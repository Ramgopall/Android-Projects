package com.example.amit.sharedprefrencess;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2,ed3;
    Button b1,b2;
    SharedPreferences sp;
    SharedPreferences.Editor ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        ed3= (EditText) findViewById(R.id.ed3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


        sp = getSharedPreferences("abc",MODE_PRIVATE);

        ed = sp.edit();

        String user = sp.getString("user","defaultuser");
        String pass = sp.getString("pass","defaultpass");
        int id = sp.getInt("id",0);

        if(id==0)
        {
            Toast.makeText(this, "User Not Logged in", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "User Logged In", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onClick(View view)
    {
        if (view==b1) {
            ed.putString("user", ed1.getText().toString());
            ed.putString("pass", ed2.getText().toString());
            ed.putInt("id", Integer.parseInt(ed3.getText().toString()));
            ed.commit();
        }
        else if (view==b2)
        {
            ed.remove("id");
            ed.commit();
        }
        }

}
