package com.forbitbd.bcspreperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forbitbd.bcspreperation.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 3000;
    private Animation slideup;
    private LinearLayout linearLayout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        setContentView(R.layout.activity_splash);

        linearLayout = findViewById(R.id.layout);
        textView = findViewById(R.id.slogan);
        slideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
    }

    @Override
    protected void onStart() {
        linearLayout.startAnimation(slideup);
        textView.startAnimation(slideup);
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