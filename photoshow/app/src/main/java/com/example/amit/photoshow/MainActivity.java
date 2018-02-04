package com.example.amit.photoshow;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        iv1 = (ImageView) findViewById(R.id.iv1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
if(view==b1){
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,1);}
        else if (view==b2)
{
    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
    StrictMode.setVmPolicy(builder.build());
    Intent c = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    File file = new File(Environment.getExternalStorageDirectory()+File.separator + "image.jpg");
    c.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
    startActivityForResult(c, 2);
}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Uri selectedimage = data.getData();
            String[] filepathcolum = {MediaStore.Images.Media.DATA};

            Cursor c = getContentResolver().query(selectedimage,filepathcolum,null,null,null);
            c.moveToFirst();

            int columindex = c.getColumnIndex(filepathcolum[0]);
            String imgdecodable = c.getString(columindex);

            //c.close();


           iv1.setImageBitmap(BitmapFactory.decodeFile(imgdecodable));

        }
        else if (requestCode==2 && resultCode==RESULT_OK )
        {
            //Toast.makeText(this, "hhh", Toast.LENGTH_SHORT).show();
            //String[] filepath = new String[]{Environment.getExternalStorageDirectory() + File.separator + "image.jpg"};
           // Bitmap b = (Bitmap) data.getExtras().get("data");
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            File imgFile = new  File("/sdcard/image.jpg");
            Bitmap bmImg = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Bitmap bitmapResized = Bitmap.createScaledBitmap(bmImg,
                    (int) (bmImg.getWidth() * 0.5), (int) (bmImg.getHeight() * 0.5), false);
            iv1.setImageBitmap(bitmapResized);


        }
    }




}
