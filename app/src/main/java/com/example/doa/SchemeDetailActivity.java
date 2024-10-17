package com.example.doa;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SchemeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_scheme_detail);

        // Get data from Intent
        String schemeName = getIntent().getStringExtra("scheme_name");
        String schemeVideo = getIntent().getStringExtra("scheme_video");
        String schemeContent = getIntent().getStringExtra("scheme_content");

        // Set the scheme name
        TextView schemeNameTextView = findViewById(R.id.scheme_name);
        schemeNameTextView.setText(schemeName);

        // Set the scheme content
        TextView schemeContentTextView = findViewById(R.id.scheme_content);
        schemeContentTextView.setText(schemeContent);

        // Load YouTube video in WebView
        WebView webView = findViewById(R.id.youtube_webview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String iframe = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" +
                schemeVideo + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(iframe, "text/html", "utf-8");

    }
}
