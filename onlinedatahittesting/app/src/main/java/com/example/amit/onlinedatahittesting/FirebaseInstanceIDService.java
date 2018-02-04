package com.example.amit.onlinedatahittesting;

import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Amit on 9/5/2017.
 */

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        registerToken(token);
    }

    private void registerToken(String token) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("Token",token).build();
        Request request = new Request.Builder().url("https://ramgopalverma7.000webhostapp.com/push.php").post(body).build();
        try {
            client.newCall(request).execute();
            PushNotifictionHelper pushNotifictionHelper = new PushNotifictionHelper();
            pushNotifictionHelper.sendPushNotification(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class PushNotifictionHelper {
        public final static String AUTH_KEY_FCM = "AIzaSyAx6tqY6nsZ5P0uGbKcrEeAoYKCfdwiZsk";
        public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

        public  String sendPushNotification(String deviceToken)
                throws IOException {
            String result = "";
            URL url = new URL(API_URL_FCM);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();

            try {
                json.put("to", deviceToken.trim());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject info = new JSONObject();
            try {
                info.put("title", "notification title"); // Notification title
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                info.put("body", "message body"); // Notification
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // body
            try {
                json.put("notification", info);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                OutputStreamWriter wr = new OutputStreamWriter(
                        conn.getOutputStream());
                wr.write(json.toString());
                wr.flush();

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    Toast.makeText(FirebaseInstanceIDService.this, ""+output, Toast.LENGTH_SHORT).show();
                }
                result = "SUCCESS";
            } catch (Exception e) {
                e.printStackTrace();
                result = "FAILURE";
            }
            System.out.println("GCM Notification is sent successfully");


            return result;

        }


}}
