package com.example.amit.onlinedatahittesting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText name,price,details;
    Button insert,getdata,convert,select;
    ImageView img;
    String imgstring,text ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        price= (EditText) findViewById(R.id.price);
        details= (EditText) findViewById(R.id.details);
        insert= (Button) findViewById(R.id.insert);
        getdata= (Button) findViewById(R.id.show);
        convert= (Button) findViewById(R.id.convert);
        select= (Button) findViewById(R.id.select);
        img= (ImageView) findViewById(R.id.img);
        img.setImageResource(R.mipmap.ic_launcher);


        FirebaseMessaging.getInstance().subscribeToTopic("test");
        FirebaseInstanceId.getInstance().getToken();



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,password,emaill;
                username = name.getText().toString();
                password = price.getText().toString();
                emaill = details.getText().toString();
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                PostDataToServer p = new PostDataToServer(getApplicationContext(), username,password,emaill);
                p.execute();

            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neww = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(neww);

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bd = (BitmapDrawable) img.getDrawable();
                Bitmap b = bd.getBitmap();

                ByteArrayOutputStream boos = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.PNG,100,boos);
                byte[] imgg = boos.toByteArray();

                imgstring = Base64.encodeToString(imgg,Base64.DEFAULT);
                details.setText(imgstring);

            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,1);

            }
        });

    }

    private class PostDataToServer extends AsyncTask<String, String, String> {
        Context cc;
        String password, emaill,username;


        public PostDataToServer(Context context, String username, String password, String emaill) {
            this.cc = context;
            this.password = password;
            this.username = username;
            this.emaill = emaill;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                // name params
                String data = URLEncoder.encode("name", "UTF-8")
                        + "=" + URLEncoder.encode(String.valueOf(username), "UTF-8");
                Log.d("++++", "++++=name+++" + username);
// email params
                data += "&" + URLEncoder.encode("description", "UTF-8") + "="
                        + URLEncoder.encode(String.valueOf(emaill), "UTF-8");
                Log.d("++++", "++++=name+++" + emaill);
                //address paraams
                data += "&" + URLEncoder.encode("price", "UTF-8") + "="
                        + URLEncoder.encode(String.valueOf(password), "UTF-8");
                Log.d("++++", "++++=name+++" + password);

//                Toast.makeText(cc, "0", Toast.LENGTH_SHORT).show();
                URL uu = new URL("https://ramgopalverma7.000webhostapp.com/insert.php");
              //  Toast.makeText(cc, "1", Toast.LENGTH_SHORT).show();

                HttpURLConnection huc = (HttpURLConnection) uu.openConnection();
                huc.setDoOutput(true);
//                Toast.makeText(cc, "2", Toast.LENGTH_SHORT).show();
                OutputStreamWriter osw = new OutputStreamWriter(huc.getOutputStream());
                osw.write(data);
                osw.flush();
             //   Toast.makeText(cc, "3", Toast.LENGTH_SHORT).show();

                BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    // Append server response in string
                    sb.append(line + "\n");
                }
               // Toast.makeText(cc, "4", Toast.LENGTH_SHORT).show();

                text = sb.toString();
                br.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (text != null) {
                Log.d("dddddddimggg", text + "");
                TextView txt = (TextView) findViewById(R.id.txtt);
                txt.setText(""+text);

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Uri selectimage = data.getData();

            Bitmap b = null;
            try {
                b = MediaStore.Images.Media.getBitmap(getContentResolver(),selectimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            img.setImageBitmap(b);
        }



    }
}
