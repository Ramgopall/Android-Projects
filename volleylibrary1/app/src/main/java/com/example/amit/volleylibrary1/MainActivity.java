package com.example.amit.volleylibrary1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RequestQueue requestQueue;
    TextView tv1;
    ArrayList namee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1= (TextView) findViewById(R.id.tv1);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        /*Json Request*/
        String url = "https://api.androidhive.info/volley/person_object.json";



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        namee = new ArrayList();
//                        for (int i=0; i<response.length(); i++)
//                        {
                            try {
                                JSONObject uob = response.getJSONObject("phone");
                                String Name = uob.getString("mobile");
                                namee.add(Name);
                                tv1.setText((CharSequence) namee.get(0));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error onject", Toast.LENGTH_SHORT).show();
                    }
                });
        //add request to queue
        requestQueue.add(jsonObjectRequest);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                     public void onResponse(JSONArray response) {

//                        namee = new ArrayList();
//                        for (int i=0; i<response.length(); i++)
//                        {
//                            try {
//                                JSONObject uob = response.getJSONObject(i);
//                                String Name = uob.getString("Name");
//                                namee.add(Name);
//                                tv1.setText((CharSequence) namee.get(i));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error array", Toast.LENGTH_SHORT).show();
                    }
                });
        //add request to queue
        requestQueue.add(jsonArrayRequest);

    }
}
