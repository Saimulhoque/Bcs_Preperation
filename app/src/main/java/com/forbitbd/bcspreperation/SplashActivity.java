package com.forbitbd.bcspreperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.forbitbd.bcspreperation.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1000;
    private Animation slideup;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.logo);
        slideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
    }

    @Override
    protected void onStart() {
        image.startAnimation(slideup);
        super.onStart();
    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,delay);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        },delay);

        super.onResume();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }
}