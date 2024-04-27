package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.stream.Stream;

public class MainActivity2 extends AppCompatActivity {
WebView we;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        we=findViewById(R.id.w);

        we.setWebViewClient(new WebViewClient());
        Intent i=getIntent();
        String extra=i.getStringExtra("load");

        if(extra.equals("default12"))
        {
            we.loadUrl("https://lms.nmamit.in/login/index.php");
        }
        else{
            Log.i("MSSGG", "onCreate: ");
            we.loadUrl(extra);
        }
    }
}