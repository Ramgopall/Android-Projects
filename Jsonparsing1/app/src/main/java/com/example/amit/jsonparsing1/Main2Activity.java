package com.example.amit.jsonparsing1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {
    EditText id,name,email,address,gender,mobile,home,office;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       id= (EditText) findViewById(R.id.id);
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        address= (EditText) findViewById(R.id.address);
        gender= (EditText) findViewById(R.id.gender);
        mobile= (EditText) findViewById(R.id.mobile);
        home= (EditText) findViewById(R.id.home);
        office= (EditText) findViewById(R.id.office);

        String f = getIntent().getStringExtra("idd");
        String g = getIntent().getStringExtra("namee");
        String h = getIntent().getStringExtra("emaill");
        String i = getIntent().getStringExtra("addresss");
        String j = getIntent().getStringExtra("genderr");
        String k = getIntent().getStringExtra("mobilee");
        String l= getIntent().getStringExtra("homee");
        String m = getIntent().getStringExtra("officee");
        id.setText(f);
        name.setText(g);
        email.setText(h);
        address.setText(i);
        gender.setText(j);
        mobile.setText(k);
        home.setText(l);
        office.setText(m);

    }
}
