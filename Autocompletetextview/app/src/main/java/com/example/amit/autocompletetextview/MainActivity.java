package com.example.amit.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView a1;
    MultiAutoCompleteTextView ma1;
    String a[] = {"red","yellow","green","blue"};
    String b[] = {"car","bike","cycle","bus"};

    ArrayAdapter ar,br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1= (AutoCompleteTextView) findViewById(R.id.a1);
        ma1= (MultiAutoCompleteTextView) findViewById(R.id.ma1);

        ar = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,a);
        br = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,b);

        a1.setAdapter(ar);
        a1.setThreshold(1);
        ma1.setAdapter(br);
        ma1.setThreshold(1);
        ma1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
