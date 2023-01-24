package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class congalpha extends AppCompatActivity {
    LottieAnimationView star2,star3;
    Button again,home;
    MediaPlayer congrats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congalpha);
        congrats = MediaPlayer.create(congalpha.this,R.raw.congratulations_by_alex);
        congrats.start();

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width= dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int)(height*.6));
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        star3=findViewById(R.id.animation_view3);
        star2=findViewById(R.id.animation_view2);
        again=findViewById(R.id.button11);
        home=findViewById(R.id.button12);

        int stars= getIntent().getIntExtra("stars",1);
        if(stars==2)
        {
            star3.setVisibility(View.GONE);
        }
        else if(stars==1)
        {
            star3.setVisibility(View.GONE);
            star2.setVisibility(View.GONE);
        }

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(congalpha.this, AlphabetTraining.class);
                startActivity(nextintent);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}