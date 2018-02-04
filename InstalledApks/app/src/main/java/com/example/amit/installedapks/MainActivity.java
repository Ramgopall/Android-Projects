package com.example.amit.installedapks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<PackageInfo> packageInfos ;
    List<PackageInfo> packageInfos2 ;
    PackageManager packageManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packageManager = getPackageManager();
        listView = (ListView) findViewById(R.id.lv);





    }

    @Override
    protected void onResume() {
        super.onResume();

        packageInfos = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        packageInfos2 = new ArrayList<PackageInfo>();
        for(PackageInfo pi: packageInfos){
            boolean b = isSystemPackage(pi);
            if(!b) {
                packageInfos2.add(pi);
            }
        }

        ArrayAdapterr ar = new ArrayAdapterr(this,packageInfos2,packageManager);

        listView.setAdapter(ar);
        listView.setOnItemClickListener(this);


    }

    private boolean isSystemPackage(PackageInfo pi) {
        return ((pi.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true
                : false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        PackageInfo packageInfo = (PackageInfo) adapterView.getItemAtPosition(i);
        AppData appData = (AppData) getApplicationContext();
        appData.setPackageInfo(packageInfo);

        Intent appInfo = new Intent(getApplicationContext(), ApkInfo.class);
        startActivity(appInfo);
    }



    private class ArrayAdapterr implements ListAdapter {

        Context cc;
        List<PackageInfo> packageInfos;
        PackageManager packageManager;

        public ArrayAdapterr(MainActivity mainActivity, List<PackageInfo> packageInfos2, PackageManager packageManager) {

            this.cc = mainActivity;
            this.packageInfos = packageInfos2;
            this.packageManager = packageManager;
        }


        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int i) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return packageInfos.size();
        }

        @Override
        public Object getItem(int i) {
            return packageInfos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           View v =  getLayoutInflater().inflate(R.layout.customlist,null);
            ImageView imageView = (ImageView) v.findViewById(R.id.img);
            TextView textView = (TextView) v.findViewById(R.id.textView);
            PackageInfo packageInfoo = (PackageInfo) getItem(i);
            Drawable dr = packageManager.getApplicationIcon(packageInfoo.applicationInfo);
            Bitmap img = ((BitmapDrawable) dr).getBitmap();
            imageView.setImageBitmap(img);
            textView.setText(packageManager.getApplicationLabel(packageInfoo.applicationInfo).toString());


            return v;
        }

        @Override
        public int getItemViewType(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return packageInfos.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
