package com.example.amit.textwatcher;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnFocusChangeListener, View.OnLongClickListener, View.OnClickListener {
    EditText ed1,ed2;
    Button b1,b2;
    Vibrator vb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= (EditText) findViewById(R.id.et1);
        ed2= (EditText) findViewById(R.id.et2);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);

        ed1.addTextChangedListener(this);
        ed2.setOnFocusChangeListener(this);
        b1.setOnLongClickListener(this);
        b2.setOnClickListener(this);
        vb = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int oldlength, int newlength) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        Toast.makeText(this, b+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {

        Toast.makeText(this, "button long clicked", Toast.LENGTH_SHORT).show();
        ed2.setVisibility(View.VISIBLE);
        return false;

    }

    @Override
    public void onClick(View view) {
        ed2.setVisibility(View.INVISIBLE);
        vb.vibrate(200);
    }
}
