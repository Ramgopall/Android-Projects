package com.example.amit.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getSupportActionBar().show();
        getSupportActionBar().setTitle("My Android App");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Hello");
        menu.add("Java");
        menu.add("Android");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }

        if(item.getTitle()=="Hello")
        {
            Toast.makeText(this, "hello selected", Toast.LENGTH_SHORT).show();
        }

        else if(item.getTitle()=="Android")
        {
            Toast.makeText(this, "Android selected", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Java selected", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
