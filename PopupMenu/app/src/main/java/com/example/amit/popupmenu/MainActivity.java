package com.example.amit.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= (Button) findViewById(R.id.b);

        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        PopupMenu pm = new PopupMenu(MainActivity.this,b);

        pm.inflate(R.menu.popupmenu);

        pm.show();


        pm.setOnMenuItemClickListener(this);



    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.m1) {

            Toast.makeText(this, "m1 selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.m2)
        {
            Toast.makeText(this, "m2 selected", Toast.LENGTH_SHORT).show();

        }
        else if (item.getItemId() == R.id.m3)
        {
            Toast.makeText(this, "m3 selected", Toast.LENGTH_SHORT).show();

        }
        else if (item.getItemId() == R.id.m4)
        {
            Toast.makeText(this, "m4 selected", Toast.LENGTH_SHORT).show();

        }


        return false;
    }
}
