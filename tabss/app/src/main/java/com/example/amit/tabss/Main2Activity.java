package com.example.amit.tabss;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class Main2Activity extends AppCompatActivity {

    TabHost th;
    TabHost.TabSpec ts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        th= (TabHost) findViewById(R.id.th);
        th.setup();


        ts = th.newTabSpec("Tag1");
        ts.setIndicator("My Tab 1");
        ts.setContent(R.id.tab1);
        th.addTab(ts);

        ts = th.newTabSpec("Tag2");
        ts.setIndicator("My Tab 2");
        ts.setContent(R.id.tab2);
        th.addTab(ts);

        ts = th.newTabSpec("Tag3");
        ts.setIndicator("My Tab 3");
        ts.setContent(R.id.tab3);
        th.addTab(ts);







        th.setCurrentTab(1);

        th.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("Tag1"))
                {
                   getSupportActionBar().setTitle("My Tab1");
                }

                else if(s.equals("Tag2"))
                {
                    getSupportActionBar().setTitle("My Tab2");

                }
            }
        });


    }


}
