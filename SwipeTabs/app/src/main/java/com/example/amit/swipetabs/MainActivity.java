package com.example.amit.swipetabs;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    ViewPager vp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);

        ViewPagerAdapter vpa = new ViewPagerAdapter();

        vp.setOffscreenPageLimit(2);


        vp.setAdapter(vpa);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 1").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 2").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 3").setTabListener(this));


        vp.addOnPageChangeListener(this);




    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        vp.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }








    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        getSupportActionBar().selectTab(getSupportActionBar().getTabAt(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }






    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout ll;
            int iid = 0;
            if(position==0)
            {
                iid = R.id.tab1;
            }

            if(position==1)
            {
                iid = R.id.tab2;
            }

            if(position==2)
            {
                iid = R.id.tab3;
            }
            ll= (LinearLayout) findViewById(iid);
            return ll;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
