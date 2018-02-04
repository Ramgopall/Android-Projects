package com.example.amit.trydb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1,ed2,ed3;
    Button b1,b2,b3,b4,b5,b6;
    SQLiteDatabase sb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        ed3= (EditText) findViewById(R.id.ed3);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view == b1) {
// thats why always write this command i  oncreate time bcs we dont want always open the database again and again.
            sb = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory().getAbsolutePath() + "/abc.sqlite", null);

            sb.execSQL("Create table if not exists tbname (Name varchar, Roll_No varchar, Marks varchar);");

        } else if (view == b2) {
            sb.execSQL("insert into tbname values('" + ed1.getText().toString() + "', '" + ed2.getText().toString() + "', '" + ed3.getText().toString() + "');");
        } else if (view == b3) {
            sb.execSQL("delete from tbname where Roll_No = '" + ed2.getText().toString() + "'");
        } else if (view == b4) {
            Cursor cr = sb.rawQuery("Select * from tbname where Roll_No= '" + ed2.getText().toString() + "'", null);

            cr.moveToFirst();

            ed1.setText(cr.getString(0));
            ed3.setText(cr.getString(2));
        } else if (view == b5) {
            sb.execSQL("Update tbname set Name = '" + ed1.getText().toString() + "', Marks = '" + ed3.getText().toString() + "' where Roll_no = '" + ed2.getText().toString() + "'");
        } else if (view == b6)
        {

            Cursor cs = sb.rawQuery("select Roll_No  from tbname",null);

            int m = cs.getCount();
            Toast.makeText(this, m +"", Toast.LENGTH_SHORT).show();



          /* while(cs.moveToNext())
           {
               Toast.makeText(this, cs.getString(0), Toast.LENGTH_SHORT).show();
           }
*/

                   }





    }
}
