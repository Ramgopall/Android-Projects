package com.example.amit.webview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7;
    EditText ed1;
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        ed1= (EditText) findViewById(R.id.ed1);
        wv1= (WebView) findViewById(R.id.wv1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        wv1.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                super.onScaleChanged(view, oldScale, newScale);
            }
        }
        );  //To Open All Links within This WEbView


        wv1.setWebChromeClient(new WebChromeClient()

        {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                b7.setText(newProgress+"");
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setIcon(new BitmapDrawable(getResources(),icon));
            }
        });
        wv1.getSettings().setJavaScriptEnabled(true);
        //wv1.getUrl();
//wv1.goBack();
//wv1.reload();

    }

    @Override
    public void onClick(View view) {
        if (view==b1)
        {
            if (ed1.getText().toString().equals(""))
            {
                wv1.loadUrl("https://www.google.com");
            }
            else {

                wv1.loadUrl("https://www.google.com/search?q="+ed1.getText());
            }
        }
        else if (view==b2)
        {
            wv1.loadUrl("https://www.facebook.com");
        }
        else if (view==b3)
        {
            wv1.loadUrl("https://www.twitter.com");
        }
        else if (view==b4)
        {
            wv1.loadUrl("https://www.linkedin.com");
        }
        else if (view==b5)
        {
            wv1.loadUrl("https://www.gmail.com");
        }
        else if (view==b6)
        {
            wv1.loadUrl("https://login.yahoo.com");
        }
        else if (view==b7)
        {
            wv1.loadUrl("https://www.youtube.com");
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (wv1.canGoBack())
        {
            wv1.goBack();
        }
        else {
            Toast.makeText(MainActivity.this,"can't go back",Toast.LENGTH_SHORT).show();
        }
    }
}
