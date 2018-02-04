package com.example.amit.onlinedatahittesting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {
    LinearLayout linearLayout;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linearLayout= (LinearLayout) findViewById(R.id.linearlayout);
        Button btn = (Button) findViewById(R.id.getdataa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostDataToServer p = new PostDataToServer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                    p.execute();
                }
            }
        });
    }






    private class PostDataToServer extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... strings) {
            URL u = null;
            try {
                u = new URL("https://ramgopalverma7.000webhostapp.com");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) u.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                conn.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            InputStream in = null;
            try {
                in = new BufferedInputStream(conn.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = sb.toString();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return text;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (text != null) {

                Toast.makeText(Main2Activity.this, ""+text, Toast.LENGTH_SHORT).show();


                try {
                    JSONObject ob = new JSONObject(text);
                    JSONArray ar = ob.getJSONArray("employee_name");
                    for(int i=0; i<ar.length(); i++)
                    {
                        JSONObject obb = ar.getJSONObject(i);
                        String img = obb.getString("description");

                        byte[] bt = Base64.decode(img,Base64.DEFAULT);
                        ImageView imv = new ImageView(getApplicationContext());
                        imv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        imv.setImageBitmap(BitmapFactory.decodeByteArray(bt,0,bt.length));
                        linearLayout.addView(imv);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
            else {
                Toast.makeText(Main2Activity.this, "nullllll", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
