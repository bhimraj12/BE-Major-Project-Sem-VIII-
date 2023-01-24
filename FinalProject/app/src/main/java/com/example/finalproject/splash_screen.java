package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash_screen extends AppCompatActivity {
    MediaPlayer welcome;
//    MediaPlayer welcome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        welcome = MediaPlayer.create(splash_screen.this,R.raw.welcome_back);
        welcome.start();
//        welcome2 = MediaPlayer.create(splash_screen.this,R.raw.welcome2);
//        welcome2.start();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextintent=new Intent(splash_screen.this, GamesList.class);
                startActivity(nextintent);
                finish();
            }
        },5000);
    }
}