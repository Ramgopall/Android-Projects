package com.example.amit.email;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2,ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        ed3= (EditText) findViewById(R.id.ed3);
        b1= (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+ed1.getText()));
        i.putExtra(Intent.EXTRA_SUBJECT,ed2.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT,ed3.getText().toString());
        startActivity(i);


    }
}
