package com.example.amit.sms_sending;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1,ed2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String num = ed1.getText().toString();
        String msg = ed2.getText().toString();

        if (view==b1)
        {
            SmsManager sm =  SmsManager.getDefault();
            sm.sendTextMessage(num,null,msg,null,null);
            Toast.makeText(this, "Message snt succesfully", Toast.LENGTH_SHORT).show();


        }
        else  if (view==b2)
        {
            Intent i= new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+num));
            i.putExtra("sms_body",msg);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "No Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(i);
            }

        }

    }
}
