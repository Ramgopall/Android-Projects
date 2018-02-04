package com.example.amit.phonecalll;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String c = ed1.getText().toString();

        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + c));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "No Permission Granted", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(i);
        }
    }
}
