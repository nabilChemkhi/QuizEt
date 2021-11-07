package com.example.quizet;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appName = findViewById(R.id.appNameId);

        Typeface typeface= ResourcesCompat.getFont(this, R.font.blacklist);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        appName.setAnimation(anim);

        new Thread(new Runnable() {
            @Override
            public void run() {
        try {
            sleep(3000);
            } catch (Exception e) {
            e.printStackTrace();
        }
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
                finish();

            }
        }).start();
    }
}