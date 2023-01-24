package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class GamesList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton g1=(ImageButton) findViewById(R.id.btn_alphabet_training);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, AlphabetTraining.class);
                startActivity(nextintent);
            }
        });
        ImageButton g2=(ImageButton) findViewById(R.id.btn_colors_matching);
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, ColorsMatch.class);
                startActivity(nextintent);
            }
        });
        ImageButton g3=(ImageButton) findViewById(R.id.btn_maths_quiz);
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, maths_quiz.class);
                startActivity(nextintent);
            }
        });
        ImageButton g4=(ImageButton) findViewById(R.id.btn_memory);
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, memory_game.class);
                startActivity(nextintent);
            }
        });
        ImageButton g5=(ImageButton) findViewById(R.id.btn_draw);
        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, MainActivity.class);
                startActivity(nextintent);
            }
        });
        ImageButton g6=(ImageButton) findViewById(R.id.btn_music);
        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextintent=new Intent(GamesList.this, musicplayer.class);
                startActivity(nextintent);
            }
        });
    }
}