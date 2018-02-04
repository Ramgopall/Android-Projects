package com.example.amit.expendablelistviewtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView elv1;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListitem;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elv1=(ExpandableListView) findViewById(R.id.elv1);
        expandableListitem = ExpandableListData.getData();
        expandableListTitle = new ArrayList<>(expandableListitem.keySet());

        expandableListAdapter = new CustomExpandableAdapter(this,expandableListTitle,expandableListitem);

        elv1.setAdapter(expandableListAdapter);

        elv1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {

                Toast.makeText(MainActivity.this, expandableListTitle.get(i)+"Expanded", Toast.LENGTH_SHORT).show();

            }
        });


        elv1.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {

                Toast.makeText(MainActivity.this, expandableListTitle.get(i)+"Colapsed", Toast.LENGTH_SHORT).show();


            }
        });


        elv1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Toast.makeText(MainActivity.this, ""+expandableListitem.get(expandableListTitle.get(i)).get(i1), Toast.LENGTH_SHORT).show();

                return false;
            }
        });



    }
}
