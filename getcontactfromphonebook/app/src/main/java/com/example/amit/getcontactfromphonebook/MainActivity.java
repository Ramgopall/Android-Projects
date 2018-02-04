package com.example.amit.getcontactfromphonebook;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1,tv2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(i,89);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==89&&resultCode==RESULT_OK&&data!=null)
        {


            Uri uu = data.getData();

            Cursor cr = managedQuery(uu,null,null,null,null);

            cr.moveToFirst();

            String NameColum = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
            String NumColum = ContactsContract.CommonDataKinds.Phone.NUMBER;


           String name =  cr.getString(cr.getColumnIndex(NameColum));
            String number = cr.getString(cr.getColumnIndex(NumColum));

            tv1.setText(name);
            tv2.setText(number);

        }

    }
}
