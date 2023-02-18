package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class activity_alphabet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        String name = getIntent().getStringExtra("name").toLowerCase();
//        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        ImageView iv = findViewById(R.id.imageView21);
//        for audio
        int iid = getResources().getIdentifier(name, "drawable", getPackageName());
        iv.setImageResource(iid);
//for video
        int mid = getResources().getIdentifier(name, "raw", getPackageName());
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), mid);
        mp.start();
    }
}