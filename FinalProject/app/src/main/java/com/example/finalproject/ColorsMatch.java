package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ColorsMatch extends AppCompatActivity {

    ImageButton timg;
    TextView tv_points;
    ImageView arrow;

    Handler handler;
    Runnable runnable;

    ProgressBar progressBar;

    int currstate=0,starttime=4000,arrstate=0,currpoints=0,currtime=4000;
    Random r;
    //0->blue 1->red 2->yellow 3->green
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_match);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent nextintent=new Intent(ColorsMatch.this, colors_match_info.class);

        startActivityForResult(nextintent,1);


    }

    private void setArrowImage(int state)
    {
        switch(state)
        {
            case 0:
                arrow.setImageResource(R.drawable.ic_bluet);
                break;
            case 1:
                arrow.setImageResource(R.drawable.ic_redt);
                break;
            case 2:
                arrow.setImageResource(R.drawable.ic_yellowt);
                break;
            case 3:
                arrow.setImageResource(R.drawable.ic_greent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                timg = findViewById(R.id.iv_button);
                tv_points = findViewById(R.id.currentpoints);
                arrow = findViewById(R.id.iv_arrow);
                progressBar = findViewById(R.id.progressBar2);

                progressBar.setMax(starttime);
                progressBar.setProgress(starttime);

                r = new Random();
                arrstate = r.nextInt(4);
                setArrowImage(arrstate);

                timg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timg.setRotation(timg.getRotation() + 90);
                        currstate = currstate + 1;
                        if (currstate == 4) {
                            currstate = 0;
                        }

                    }
                });
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currtime = currtime - 100;
                        progressBar.setProgress(currtime);
                        if (currtime > 0) {
                            handler.postDelayed(runnable, 100);
                        } else {
                            if (currstate == arrstate) {
                                currpoints = currpoints + 1;
                                tv_points.setText("Score :" + currpoints);
                                starttime = starttime - 100;
                                if (starttime < 1000) {
                                    starttime = 2000;
                                }
                                progressBar.setMax(starttime);
                                currtime = starttime;
                                progressBar.setProgress(currtime);

                                arrstate = r.nextInt(4);
                                setArrowImage(arrstate);

                                handler.postDelayed(runnable, 100);

                            } else {
                                timg.setEnabled(false);
                                //Toast.makeText(ColorsMatch.this, "Game Over", Toast.LENGTH_SHORT).show();
                                Intent nextintent1=new Intent(ColorsMatch.this, colors_match_result.class);
                                nextintent1.putExtra("score",currpoints);
                                startActivity(nextintent1);
                                finish();
                            }
                        }
                    }
                };
                handler.postDelayed(runnable, 100);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}