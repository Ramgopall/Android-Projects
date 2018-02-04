package com.example.amit.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    ViewPager vp;

    ListView lv1;

    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };
    Integer[] imageId = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);

        ViewPagerAdapter vpa = new ViewPagerAdapter();

        vp.setOffscreenPageLimit(4);


        vp.setAdapter(vpa);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 1").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 2").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 3").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 4").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("My Tab 5").setTabListener(this));

        vp.addOnPageChangeListener(this);

        lv1 = (ListView) findViewById(R.id.lv1);

        CustomAdapter ca = new CustomAdapter();

        lv1.setAdapter(ca);
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        vp.setCurrentItem(tab.getPosition());
        Toast.makeText(this, "" + tab.getPosition(), Toast.LENGTH_SHORT).show();
        int idd = 0;
        if (tab.getPosition() == 0) {
//            idd = R.id.tab1;
//            ft.replace(idd, new fragment1());
        } else if (tab.getPosition() == 1) {
            idd = R.id.tab2;
            ft.replace(idd, new Main2Activity());
        } else if (tab.getPosition() == 2) {
            idd = R.id.tab3;
            ft.replace(idd, new fragment3());
        } else if (tab.getPosition() == 3) {
            idd = R.id.tab4;
            ft.replace(idd, new fragment4());
        } else if (tab.getPosition() == 4) {
            idd = R.id.tab5;
            ft.replace(idd, new fragment5());
        }


    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // getSupportActionBar().selectTab(getSupportActionBar().getTabAt(position));
    }

    @Override
    public void onPageSelected(int position) {

        getSupportActionBar().selectTab(getSupportActionBar().getTabAt(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //getSupportActionBar().selectTab(getSupportActionBar().getTabAt(position));
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
        if(position==3)
        {
            iid = R.id.tab4;
        }
        if(position==4)
        {
            iid = R.id.tab5;
        }
        ll= (LinearLayout) findViewById(iid);
        return ll;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}


    private class CustomAdapter implements ListAdapter{
        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return web.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.customlist,null);

            TextView tv = (TextView) v.findViewById(R.id.txt);
            final ImageView iv = (ImageView) v.findViewById(R.id.img);

            tv.setText(web[position]);
            iv.setImageResource(imageId[position]);
            return v;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return web.length;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}






