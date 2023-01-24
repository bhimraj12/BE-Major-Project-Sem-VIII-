package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class popup_info_alphabet extends AppCompatActivity {
    TextView info;

    MediaPlayer popup;
    Button gotit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_alphabet);
        popup = MediaPlayer.create(popup_info_alphabet.this,R.raw.popup_info_alphabet);
        popup.start();

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width= dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width*.7),(int)(height*.6));
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        info=(TextView) findViewById(R.id.textView5);
        Animation animation=AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        animation.setDuration(2000);
        info.startAnimation(animation);

        gotit=(Button) findViewById(R.id.button);
        gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}