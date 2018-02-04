package com.example.amit.runtimeaddlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
LinearLayout ll,ll1;
    TextView tv;
    EditText et;
    Button btn,btn2;
    ListView lv1;
    ArrayList al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        al = new ArrayList();

        ll = new LinearLayout(this);
        ll.setOrientation(android.widget.LinearLayout.VERTICAL);
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // ARGB: Opaque Red
        ///ll.setBackgroundColor(0x88ff0000);


        et = new EditText(this);
        et.setLayoutParams(new ViewGroup.LayoutParams(-1,-2));
        et.setText("edit me please");
        // ARGB: Solid Blue
        //et.setBackgroundColor(0xff0000ff);
        ll.addView(et);


        ll1 = new LinearLayout(this);
        ll1.setOrientation(LinearLayout.HORIZONTAL);
        ll1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        btn = new Button(this);
        btn.setText("Add");
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                al.add(et.getText().toString());

            }
        });

        ll1.addView(btn);

        btn2= new Button(this);
        btn2.setText("marks");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("araylist",al);
                startActivity(i);
            }
        });
        ll1.addView(btn2);
        ll.addView(ll1);

        lv1= new ListView(this);
        ll.addView(lv1);
        ArrayAdapter ad = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv1.setAdapter(ad);

        setContentView(ll);

    }
}
