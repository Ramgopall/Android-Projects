package com.example.amit.jsonparsing1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Amit on 4/20/2017.
 */

class GetContacts extends AsyncTask<String,Integer,String> implements View.OnClickListener {
    ArrayList al_id,al_name,al_email,al_address,al_gender,al_mobile,al_home,al_office;
//    ListView lv1;
    Button b1;
    Context c;
    ArrayAdapter ad;
    ProgressDialog pd;

    public GetContacts(MainActivity mainActivity) {
        c=mainActivity;
        b1= (Button) mainActivity.findViewById(R.id.b1);
//        lv1 = (ListView) mainActivity.findViewById(R.id.lv1);
//        lv1.setOnItemClickListener(this);
        b1.setOnClickListener(this);
    }

    @Override
    protected void onPreExecute() {

        pd = new ProgressDialog(c);
        pd.setTitle("Please Wait..");
        pd.setMessage("Loading..");
        pd.setCancelable(false);
        pd.show();



        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... strings)
    {
        String s = strings[0];
        String ss = "";

        DownLoadURL du = new DownLoadURL();
        try {
            ss = du.downloadurl(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ss;
    }

    @Override
    protected void onPostExecute(String s) {
       // Intent i = new Intent(,MainActivity.class);
        pd.dismiss();

        al_id = new ArrayList();
        al_name = new ArrayList();
        al_email = new ArrayList();
        al_address = new ArrayList();
        al_gender = new ArrayList();
        al_mobile = new ArrayList();
        al_office = new ArrayList();
        al_home = new ArrayList();

        try {
            JSONObject jo = new JSONObject(s);
            JSONArray ja = jo.getJSONArray("contacts");

            for(int i =0; i<ja.length();i++)
            {
                JSONObject cjo = ja.getJSONObject(i);
                String id = cjo.getString("id");
                String name = cjo.getString("name");
                String email = cjo.getString("email");
                String address = cjo.getString("address");
                String gender = cjo.getString("gender");

                    JSONObject phone = cjo.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String office = phone.getString("office");
                        String home = phone.getString("home");
                al_id.add(id);
                al_name.add(name);
                al_email.add(email);
                al_address.add(address);
                al_gender.add(gender);
                al_mobile.add(mobile);
                al_home.add(home);
                al_office.add(office);
            }
            //ad = new ArrayAdapter(c,android.R.layout.simple_list_item_1,al_id);
           // lv1.setAdapter(ad);



        } catch (JSONException e) {
            e.printStackTrace();
        }

        super.onPostExecute(s);
    }

    @Override
    public void onClick(View view) {

        Intent ai = new Intent(c,Main3Activity.class);
        ai.putExtra("idd", al_id);
        ai.putExtra("namee", al_name);
        ai.putExtra("emaill", al_email);
        ai.putExtra("addresss", al_address);
        ai.putExtra("genderr", al_gender);
        ai.putExtra("mobilee", al_mobile);
        ai.putExtra("homee", al_home);
        ai.putExtra("officee", al_office);
        c.startActivity(ai);

    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//        Intent ai = new Intent(c,Main2Activity.class);
//        ai.putExtra("idd", String.valueOf(al_id.get(i)));
//        ai.putExtra("namee", String.valueOf(al_name.get(i)));
//        ai.putExtra("emaill", String.valueOf(al_email.get(i)));
//        ai.putExtra("addresss", String.valueOf(al_address.get(i)));
//        ai.putExtra("genderr", String.valueOf(al_gender.get(i)));
//        ai.putExtra("mobilee", String.valueOf(al_mobile.get(i)));
//        ai.putExtra("homee", String.valueOf(al_home.get(i)));
//        ai.putExtra("officee", String.valueOf(al_office.get(i)));
//        c.startActivity(ai);
//
//    }
}
