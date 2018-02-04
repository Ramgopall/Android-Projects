package com.example.amit.clipboard;

import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2;
    Button b1,b2;
    ClipboardManager cbm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        cbm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


    }

    @Override
    public void onClick(View view) {

        if(view==b1)
        {
            cbm.setText(et1.getText().toString());
        }
        else if (view==b2)
        {
            et2.setText(cbm.getText().toString());

        }


    }
}
