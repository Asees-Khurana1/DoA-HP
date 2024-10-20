package com.example.doa;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.AppCompatDelegate;

public class SchemeDetailActivity extends AppCompatActivity {

    private boolean isEligibilityVisible = false;
    private boolean isHowToApplyVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ensure the app follows the system's light/dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_scheme_detail);

        // Handle back button click
//        ImageView backButton = findViewById(R.id.back_button);
//        backButton.setOnClickListener(v -> finish());

        // Get data from Intent
        String schemeName = getIntent().getStringExtra("scheme_name");
        String schemeVideo = getIntent().getStringExtra("scheme_video");
        String schemeContent = getIntent().getStringExtra("scheme_content");

        // Set scheme name and content
        TextView schemeNameTextView = findViewById(R.id.scheme_name);
        schemeNameTextView.setText(schemeName);

        TextView schemeContentTextView = findViewById(R.id.scheme_content);
        schemeContentTextView.setText(schemeContent);

        // Load YouTube video in WebView
        WebView webView = findViewById(R.id.youtube_webview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(schemeVideo);

        // Find buttons and content TextViews
        Button eligibilityButton = findViewById(R.id.eligibility_button);
        Button howToApplyButton = findViewById(R.id.how_to_apply_button);

        CardView eligibilityCard = findViewById(R.id.eligibility_card);
        CardView howToApplyCard = findViewById(R.id.how_to_apply_card);

        // Set click listeners for buttons
        eligibilityButton.setOnClickListener(view -> {
            if (!isEligibilityVisible) {
                eligibilityCard.setVisibility(View.VISIBLE);
                howToApplyCard.setVisibility(View.GONE);  // Hide other card
                isHowToApplyVisible = false;              // Reset other visibility flag
            } else {
                eligibilityCard.setVisibility(View.GONE);
            }
            isEligibilityVisible = !isEligibilityVisible;  // Toggle visibility flag
        });

        howToApplyButton.setOnClickListener(view -> {
            if (!isHowToApplyVisible) {
                howToApplyCard.setVisibility(View.VISIBLE);
                eligibilityCard.setVisibility(View.GONE);  // Hide other card
                isEligibilityVisible = false;              // Reset other visibility flag
            } else {
                howToApplyCard.setVisibility(View.GONE);
            }
            isHowToApplyVisible = !isHowToApplyVisible;  // Toggle visibility flag
        });
    }
}