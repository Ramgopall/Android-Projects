package com.example.amit.fcmpushnotification;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView lv1;
    EditText et1;
    Button b1;
    ArrayList<String> list_of_rooms = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    private String name;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1= (ListView) findViewById(R.id.lv1);
        b1= (Button) findViewById(R.id.button);
        et1= (EditText) findViewById(R.id.et1);

        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list_of_rooms);

        lv1.setAdapter(arrayAdapter);

request_user_name();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,Object> map = new HashMap<>();
                map.put(et1.getText().toString(),"");
                root.updateChildren(map);
            }
        });


root.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Set<String> set = new HashSet<String>();
        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext())
        {
            set.add(((DataSnapshot)i.next()).getKey());
        }
        list_of_rooms.clear();
        list_of_rooms.addAll(set);

        arrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ii = new Intent(MainActivity.this,Chatroom.class);
                ii.putExtra("room_name",((TextView)view).getText().toString());
                ii.putExtra("user_name",name);
                startActivity(ii);


            }
        });


    }

    private void request_user_name() {

        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
        setTitle("User Name");

        final EditText etusername = new EditText(this);
        alerBuilder.setView(etusername);

        alerBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                name = etusername.getText().toString();
            }
        });

        alerBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();
                request_user_name();
            }
        });

        alerBuilder.show();
    }
}
