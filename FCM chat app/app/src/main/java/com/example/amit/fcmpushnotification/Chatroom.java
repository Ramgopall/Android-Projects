package com.example.amit.fcmpushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Chatroom extends AppCompatActivity {

    EditText et2;
    //TextView textView,textView2;
    Button b2;
    String user_name,room_name;
    DatabaseReference root;
    private String tmpkey;
    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        et2= (EditText) findViewById(R.id.editText);
        b2= (Button) findViewById(R.id.button2);
//        textView = (TextView) findViewById(R.id.textView);
//        textView2 = (TextView) findViewById(R.id.textView2);
        ll1 = (LinearLayout) findViewById(R.id.ll1);

        user_name = getIntent().getExtras().get("user_name").toString();
        room_name = getIntent().getExtras().get("room_name").toString();

        root = FirebaseDatabase.getInstance().getReference().child(room_name);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String,Object> map = new HashMap<>();
                tmpkey = root.push().getKey();
                root.updateChildren(map);

                DatabaseReference message_root = root.child(tmpkey);

                Map<String,Object> map2 = new HashMap<>();
                map2.put("name",user_name);
                map2.put("msg",et2.getText().toString());

                message_root.updateChildren(map2);
                et2.setText("");
                et2.clearFocus();


            }
        });


        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_child_conversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_child_conversation(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    String chat_mmsg,chat_user_name;
    private void append_child_conversation(DataSnapshot dataSnapshot) {

        Iterator ii = dataSnapshot.getChildren().iterator();

        while (ii.hasNext()){
            chat_mmsg = (String) ((DataSnapshot)ii.next()).getValue();
            chat_user_name = (String) ((DataSnapshot)ii.next()).getValue();

            if (chat_user_name.equals("Ramgopal")){
                //LinearLayout ll2 = new LinearLayout(Chatroom.this);
               // ll2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
               // ll2.setGravity();
                TextView txt2 = new TextView(Chatroom.this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
               // params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;

                txt2.setLayoutParams(params);
                txt2.setBackgroundResource(R.drawable.msg_out);
                txt2.append(chat_user_name+":"+chat_mmsg+"\n");

                //ll2.addView(txt2);
                ll1.addView(txt2);

            }
else {
                TextView txt = new TextView(Chatroom.this);
                txt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                //txt2.setGravity(Gravity.RIGHT);
                txt.setBackgroundResource(R.drawable.msg_in);

                txt.append(chat_user_name+":"+chat_mmsg+"\n");
                ll1.addView(txt);

                Intent i = new Intent(this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setAutoCancel(true).setContentTitle("FCM Test").setContentText(chat_mmsg).setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());

            }  }

    }
}
