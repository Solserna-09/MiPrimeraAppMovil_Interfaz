package com.josesantosdev.miprimerapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {

                Intent i = new Intent(SplashScreenActivity.this, MiApp.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 5000);
    }
}
