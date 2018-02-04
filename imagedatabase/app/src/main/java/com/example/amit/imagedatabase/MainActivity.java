package com.example.amit.imagedatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    EditText ed1,ed2;
    ImageView iv1,iv2;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        sb = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory().getAbsolutePath()+"/image.sqlite",null);
        sb.execSQL("Create table if not exists tbname (Name varchar,Image blob);");

        }

    @Override
    public void onClick(View view) {

        if (view==b1)
        {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,1);

        }
        else if (view==b2)
        {
            BitmapDrawable bd = (BitmapDrawable) iv1.getDrawable();
            Bitmap b = bd.getBitmap();

            ByteArrayOutputStream boos = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.PNG,100,boos);
            byte[] img = boos.toByteArray();

            ContentValues cv = new ContentValues();
            cv.put("Name",ed1.getText().toString());
            cv.put("Image",img);

            sb.insert("tbname",null,cv);

        }
        else if (view==b3)
        {
            Cursor cr = sb.rawQuery("Select Image from tbname where Name = '"+ed2.getText().toString()+"'",null);
            cr.moveToFirst();
            byte[] imgb = cr.getBlob(0);
            Bitmap b = BitmapFactory.decodeByteArray(imgb,0,imgb.length);
            iv2.setImageBitmap(b);

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
            iv1.setImageBitmap(b);
        }



    }
}
