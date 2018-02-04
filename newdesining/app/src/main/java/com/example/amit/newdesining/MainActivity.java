package com.example.amit.newdesining;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabLayout.OnTabSelectedListener {

    Toolbar tb;
    TextView tv;
    ActionBarDrawerToggle adt ;
    ViewPager viewPager;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.toolbar);
        tv= (TextView) findViewById(R.id.tv1);
        final DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerlayooutid);

        adt = new ActionBarDrawerToggle(this,dl,R.string.app_name,R.string.app_name);
        viewPager = (ViewPager) findViewById(R.id.viewpager);






        setSupportActionBar(tb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("tab1"));
        tab.addTab(tab.newTab().setText("tab2"));


        tab.setHorizontalScrollBarEnabled(true);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);



        tv.setOnClickListener(this);
        tab.setOnTabSelectedListener(this);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(vpa);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.more)
        {
            Toast.makeText(this, "more selected", Toast.LENGTH_SHORT).show();
        }

        else if (item.getItemId()==R.id.m1)
        {
            Toast.makeText(this, "m1 selected", Toast.LENGTH_SHORT).show();
        }
        else if (adt.onOptionsItemSelected(item))
        {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Toolbar is selected", Toast.LENGTH_SHORT).show();
    }

    public void prof(View v)
    {
        Toast.makeText(this, "prof clicked", Toast.LENGTH_SHORT).show();
    }








    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int numoftab;
        public ViewPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
            super(supportFragmentManager);
            numoftab = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    googlemap tab1 = new googlemap();
                    return tab1;
                case 1:
                    fragment2 tab2 = new fragment2();
                    return tab2;
                default:
                    return null;
            }
                    }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
