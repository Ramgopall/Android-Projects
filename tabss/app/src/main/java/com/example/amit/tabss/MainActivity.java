package com.example.amit.tabss;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.amit.tabss.R.id.tab1;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ViewPager viewPager;
    ActionBar ab;
    CollectionPagerAdapter mCollectionPagerAdapter;
    public int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        //Creating our pager adapter

        mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        ab = getSupportActionBar();
        ab.setHomeButtonEnabled(false);
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Adding adapter to pager
        viewPager.setAdapter(mCollectionPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                ab.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });

        for (int i = 0; i < mCollectionPagerAdapter.getCount(); i++) {
            ab.addTab(ab.newTab()
                    .setText(mCollectionPagerAdapter.getPageTitle(i))
                    .setTabListener(this));
        }



//        ab.addTab(ab.newTab().setText("tab1").setTabListener(this));
//        ab.addTab(ab.newTab().setText("tab2").setTabListener(this));
//        ab.addTab(ab.newTab().setText("tab3").setTabListener(this));


       
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        viewPager.setCurrentItem(tab.getPosition());
//        int a = tab.getPosition();
//
//        switch (a){
//            case 0: setContentView(R.layout.actionbar_tab1);
//                break;
//            case 1 : setContentView(R.layout.actionbar_tab2);
//                break;
//            case 2: setContentView(R.layout.actionbar_tab3);
//                break;
//
//        }
        


    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }











    public class CollectionPagerAdapter extends FragmentPagerAdapter {
        final int NUM_ITEMS = 3;
        public CollectionPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new TabFragment();
            Bundle args = new Bundle();
            args.putInt(TabFragment.ARG_OBJECT, i);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String tabLabel = null;
            switch (position) {
                case 0:
                    tabLabel = getString(R.string.lable1);
                    break;
                case 1:
                    tabLabel = getString(R.string.lable2);
                    break;
                case 2:
                    tabLabel = getString(R.string.lable3);
                    break;

            }

            return tabLabel;

        }

    }

    public static class TabFragment extends Fragment {
        public static final String ARG_OBJECT ="object" ;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Bundle args = getArguments();
            int position = args.getInt(ARG_OBJECT);
            int tabLayout = 0;
            switch (position) {
                case 0:
                    tabLayout = R.layout.actionbar_tab1;
                    break;
                case 1:
                    tabLayout = R.layout.actionbar_tab2;
                    break;
                case 2:
                    tabLayout = R.layout.actionbar_tab3;
                    break;
            }

            View rootView = inflater.inflate(tabLayout, container, false);
            return rootView;

        }

    }
}

