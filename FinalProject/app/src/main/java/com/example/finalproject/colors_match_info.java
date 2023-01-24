package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class colors_match_info extends AppCompatActivity {
    ImageView circle;
    MediaPlayer color_info;
    Button got;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_match_info);
        color_info = MediaPlayer.create(colors_match_info.this,R.raw.color_info);
        color_info.start();

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        circle=findViewById(R.id.imageView3);

        int width= dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width*.7),(int)(height*.6));
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                circle.setRotation(circle.getRotation()+90);
                handler.postDelayed(this,1000);
            }
        },1000);

        got=findViewById(R.id.button3);
        got.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        return;
    }
}