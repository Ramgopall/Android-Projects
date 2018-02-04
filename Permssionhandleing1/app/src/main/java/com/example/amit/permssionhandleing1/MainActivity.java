package com.example.amit.permssionhandleing1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText ed1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= (EditText) findViewById(R.id.ed1);
        b1= (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String c = ed1.getText().toString();

         i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

          //  Toast.makeText(this, "No Permission Granted", Toast.LENGTH_SHORT).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE))
            {
//                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
//                alertBuilder.setCancelable(true);
//                alertBuilder.setTitle("Permission necessary");
//                alertBuilder.setMessage("Write calendar permission is necessary to write event!!!");
//                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 8);
//                    }
//                });
//                AlertDialog alert = alertBuilder.create();
//                alert.show();
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},8);
            }

        }
        else {

            startActivityForResult(i,11);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 8:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivityForResult(i,11);
                } else {
                    //code for deny
                    Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11 && resultCode==RESULT_OK && data!=null)
        {
            Uri selectedimage = data.getData();
            String[] filepathcolum = {MediaStore.Images.Media.DATA};

            Cursor c = getContentResolver().query(selectedimage,filepathcolum,null,null,null);
            c.moveToFirst();

            int columindex = c.getColumnIndex(filepathcolum[0]);
            String imgdecodable = c.getString(columindex);

            //c.close();


           // iv1.setImageBitmap(BitmapFactory.decodeFile(imgdecodable));

        }

    }


}
