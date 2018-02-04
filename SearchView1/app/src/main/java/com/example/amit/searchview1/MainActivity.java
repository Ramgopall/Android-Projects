package com.example.amit.searchview1;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter ad;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv = (ListView) findViewById(R.id.lv);
        ArrayList<String> arraycountry = new ArrayList<>();
        arraycountry.addAll(Arrays.asList(getResources().getStringArray(R.array.array_country)));
        ad= new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arraycountry);
        lv.setAdapter(ad);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (!searchView.isIconified())
//        {
//            searchView.onActionViewCollapsed();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menusearch);

        searchView = (SearchView) item.getActionView();
       // searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setQueryHint("searchee");
        searchView.setSubmitButtonEnabled(true);
        searchView.setBackgroundColor(getResources().getColor(R.color.colorsearch));
       // AutoCompleteTextView av = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
       // av.setAdapter(ad);
       // av.setThreshold(1);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                searchView.onActionViewCollapsed();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
            ad.getFilter().filter(newText);
                return false;
            }
        });








        return super.onCreateOptionsMenu(menu);
    }
}
