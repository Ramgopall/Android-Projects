package com.example.amit.runtimeaddlayout;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.string.no;
import static android.R.string.yes;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ArrayList al ;
    TextView tv;
    Button save;
    RadioGroup rg;
    RadioButton rb,rbb;
    LinearLayout ll,ll1;
    String present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        al = getIntent().getStringArrayListExtra("araylist");
        int a = al.size();

        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        for (int i=0; i<a; i++)
        {
            tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setText(al.get(i).toString());
            tv.setId(R.id.tv+i);
            ll.addView(tv);

            ll1 = new LinearLayout(this);
            ll1.setOrientation(LinearLayout.HORIZONTAL);
            ll1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            rg= new RadioGroup(this);
            rg.setId(i);
            rb= new RadioButton(this);
            rb.setId(i);
            rb.setText("Present");
            rg.addView(rb);

            rbb=new RadioButton(this);
            rbb.setId(i);
            rbb.setText("Absent");
            rg.addView(rbb);
            ll1.addView(rg);
            ll.addView(ll1);
        }


        save = new Button(this);
        save.setText("Save");
        save.setOnClickListener(this);



        ll.addView(save);


        setContentView(ll);

    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase sb ;
        sb = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory().getAbsolutePath() + "/abc.sqlite", null);
        sb.execSQL("Create table if not exists tbname (Name varchar, Present varchar);");

        int a = al.size();

        //int i1 = rg.getCheckedRadioButtonId();
        for (int i=0; i<a;)
        {


                if (rg.getId()==i) {
                    if (rb.isChecked() == true) {
                        present = "yes";

                    } else if (rbb.isChecked() == true) {
                        present = "No";
                    }

                }
                sb.execSQL("insert into tbname values('" + al.get(i) + "', '" + present + "');");


            i++;

        }

    }
}
