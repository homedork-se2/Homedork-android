package com.example.homedork.Fun;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.R;

public class webGame extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_game);
        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("http://b677-90-231-106-245.ngrok.io/gameMobile.jsp");

    }
}