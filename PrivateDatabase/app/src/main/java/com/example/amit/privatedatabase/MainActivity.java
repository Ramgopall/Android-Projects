package com.example.amit.privatedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1, ed2, ed3;
    Button b1, b2;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cr = sb.rawQuery("Select * from tbname where rollno ='"+ed3.getText().toString()+"' ;",null);
                cr.moveToFirst();

                ed1.setText(cr.getString(0));
                ed2.setText(cr.getString(1));

            }
        });
      }

    @Override
    public void onClick(View view) {

        //sb = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaa.sqlite", null);
        sb = openOrCreateDatabase("databasename",MODE_PRIVATE,null);
        sb.execSQL("Create table if not exists tbname (Name varchar,class varchar, rollno int);");
        sb.execSQL("insert into tbname values('" + ed1.getText().toString() + "','" + ed2.getText().toString() + "','" + ed3.getText().toString() + "');");
    }

}
