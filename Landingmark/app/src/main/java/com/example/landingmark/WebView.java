package com.example.landingmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;

public class WebView extends AppCompatActivity {
    android.webkit.WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        if (link != ""){
            webView.loadUrl(link);
        }
    }
}
