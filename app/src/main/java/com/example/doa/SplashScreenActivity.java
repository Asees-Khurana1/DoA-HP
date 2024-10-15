package com.example.doa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Display the splash screen for 3 seconds (3000 milliseconds)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Navigate to MainActivity after 3 seconds
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Close the SplashScreenActivity
        }, 3000);
    }
}
