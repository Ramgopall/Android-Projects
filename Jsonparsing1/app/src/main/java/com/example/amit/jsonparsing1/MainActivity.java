package com.example.amit.jsonparsing1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetContacts gc = new GetContacts(MainActivity.this);
        gc.execute("http://api.androidhive.info/contacts/");




    }
}
