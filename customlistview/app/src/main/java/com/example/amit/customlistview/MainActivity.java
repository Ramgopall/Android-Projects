package com.example.amit.customlistview;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Context context;
    int pos;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;
    Integer[] imageId = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.drawable.abc

    };

//    public void hello(View v)
//    {
//
//        Toast.makeText(context, "Hello Hello"+pos, Toast.LENGTH_SHORT).show();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;


        //CustomArrayAdapter adapter= new CustomArrayAdapter(this,R.layout.custom_list,imageId);
        MyAdapter adapter = new MyAdapter();
        list= (ListView) findViewById(R.id.lv1);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
                Toast.makeText(MainActivity.this, "You Clicked at " +web[+ i], Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private class CustomArrayAdapter extends ArrayAdapter
//    {
//
//
//        public CustomArrayAdapter(Context context, int resource, Object[] objects) {
//            super(context, resource, objects);
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View v = getLayoutInflater().inflate(R.layout.custom_list,null);
//
//            TextView tv = (TextView) v.findViewById(R.id.txt);
//            ImageView iv = (ImageView) v.findViewById(R.id.img);
//
//            tv.setText(web[position]);
//            iv.setImageResource(imageId[position]);
//
//
//
//            return v;
//        }
//    }

    private class MyAdapter implements ListAdapter {
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
            return web.length;
        }

        @Override
        public Object getItem(int i) {

            return i;
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
            View v = getLayoutInflater().inflate(R.layout.custom_list,null);

            TextView tv = (TextView) v.findViewById(R.id.txt);
            final ImageView iv = (ImageView) v.findViewById(R.id.img);

            tv.setText(web[i]);
            iv.setImageResource(imageId[i]);
            iv.setTag(i);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                   if (iv.getTag().toString().equals("0"))
                   {
                       Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                   }
                   else if (iv.getTag().toString().equals("1"))
                   {
                       Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();

                   }
                   else if (iv.getTag().toString().equals("2"))
                   {
                       Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();

                   }
                   else if (iv.getTag().toString().equals("3"))
                   {
                       Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();

                   }
                   else if (iv.getTag().toString().equals("4"))
                   {
                       Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();

                   }
                   else if (iv.getTag().toString().equals("5"))
                   {
                       Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();

                   }
                   else if (iv.getTag().toString().equals("6"))
                   {
                       Toast.makeText(MainActivity.this, "6", Toast.LENGTH_SHORT).show();

                   }

                   // Toast.makeText(MainActivity.this, ""+iv.getTag().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            return v;
        }

        @Override
        public int getItemViewType(int i) {
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
