package com.example.amit.jsonparsing1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv1;
    ArrayList al_iid,al_name,al_email,al_address,al_gender,al_mobile,al_home,al_office;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lv1= (ListView) findViewById(R.id.lv1);
         al_iid = getIntent().getStringArrayListExtra("idd");
         al_name = getIntent().getStringArrayListExtra("namee");
         al_email = getIntent().getStringArrayListExtra("emaill");
         al_address = getIntent().getStringArrayListExtra("addresss");
         al_gender = getIntent().getStringArrayListExtra("genderr");
         al_mobile = getIntent().getStringArrayListExtra("mobilee");
         al_home = getIntent().getStringArrayListExtra("homee");
         al_office = getIntent().getStringArrayListExtra("officee");

        ArrayAdapter ad = new ArrayAdapter(Main3Activity.this,android.R.layout.simple_list_item_1,al_iid);
        lv1.setAdapter(ad);
        lv1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent ai = new Intent(Main3Activity.this,Main2Activity.class);
        ai.putExtra("idd", String.valueOf(al_iid.get(i)));
        ai.putExtra("namee", String.valueOf(al_name.get(i)));
        ai.putExtra("emaill", String.valueOf(al_email.get(i)));
        ai.putExtra("addresss", String.valueOf(al_address.get(i)));
        ai.putExtra("genderr", String.valueOf(al_gender.get(i)));
        ai.putExtra("mobilee", String.valueOf(al_mobile.get(i)));
        ai.putExtra("homee", String.valueOf(al_home.get(i)));
        ai.putExtra("officee", String.valueOf(al_office.get(i)));
        startActivity(ai);

    }
}
