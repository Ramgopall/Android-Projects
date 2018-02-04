package com.example.amit.pushnotification;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button idd = (Button) findViewById(R.id.idd);
       idd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseMessaging.getInstance().subscribeToTopic("test");
               FirebaseInstanceId.getInstance().getToken();

               PostDataToServer p = new PostDataToServer();
                p.execute();
           }
       });

    }

    private class PostDataToServer extends AsyncTask<String,Integer,String> {
        String text;
        @Override
        protected String doInBackground(String... strings) {
            URL u = null;
            try {
                u = new URL("https://ramgopalverma7.000webhostapp.com/sendd.php");
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

                Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();




            }
            else {
                Toast.makeText(MainActivity.this, "nullllll", Toast.LENGTH_SHORT).show();
            }
        }
    }

}