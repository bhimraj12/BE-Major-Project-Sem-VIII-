package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class maths_quiz extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView f_num,S_num,Op,c_points;
    RadioButton opt1,opt2,opt3,opt4;
    Random r;
    ProgressBar progressBar;
    int ran,sum;
    int currstate=-1,starttime=8000,arrstate=-2,currpoints=0,currtime=8000;
    int [] opts={0,0,0,0},bound={9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,99,99,99,99,99},b_opt={18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,198,198,198,198,198};

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_quiz);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent nextintent=new Intent(maths_quiz.this, maths_info.class);

        startActivityForResult(nextintent,1);



    }

    void generateQ()
    {
        progressBar.setMax(starttime);
        progressBar.setProgress(starttime);

        c_points.setText("Score: "+currpoints);

        ran=r.nextInt(bound[currpoints])+1;
        f_num.setText(""+ran);

        ran=r.nextInt(bound[currpoints])+1;
        S_num.setText(""+ran);

        sum=Integer.parseInt(""+f_num.getText())+Integer.parseInt(""+S_num.getText());
        opts[0]=sum;

        for(int i=0;i<3;i++)
        {
            ran=r.nextInt(b_opt[currpoints])+1;
            if(opts[0]==ran || opts[1]==ran || opts[2]==ran || opts[3]==ran)
            {
                --i;
            }
            else
            {
                opts[i+1]=ran;
            }
        }
        ran=r.nextInt(4);
        if(ran==0)
        {
            opt1.setText(""+opts[0]);
        }
        else if(ran==1)
        {
            opt2.setText(""+opts[0]);
        }
        else if(ran==2)
        {
            opt3.setText(""+opts[0]);
        }
        else
        {
            opt4.setText(""+opts[0]);
        }
        arrstate=ran;
        int j=1;
        for(int i=0;i<4;i++)
        {

            if(i==0 && Integer.parseInt(""+opt1.getText())!=opts[0])
            {
                opt1.setText(""+opts[j]);
                j++;
            }
            else if(i==1 && Integer.parseInt(""+opt2.getText())!=opts[0])
            {
                opt2.setText(""+opts[j]);
                j++;
            }
            else if(i==2 && Integer.parseInt(""+opt3.getText())!=opts[0])
            {
                opt3.setText(""+opts[j]);
                j++;
            }
            else if(i==3 && Integer.parseInt(""+opt4.getText())!=opts[0])
            {
                opt4.setText(""+opts[j]);
                j++;
            }
        }
        //Toast.makeText(this, ""+opts[0]+" "+opts[1]+" "+opts[2]+" "+opts[3], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.btn_opt1) {
                opt2.setChecked(false);
                opt3.setChecked(false);
                opt4.setChecked(false);
                currstate=0;
            }
            if (buttonView.getId() == R.id.btn_opt2) {
                opt1.setChecked(false);
                opt3.setChecked(false);
                opt4.setChecked(false);
                currstate=1;
            }
            if (buttonView.getId() == R.id.btn_opt3) {
                opt2.setChecked(false);
                opt1.setChecked(false);
                opt4.setChecked(false);
                currstate=2;
            }
            if (buttonView.getId() == R.id.btn_opt4) {
                opt2.setChecked(false);
                opt3.setChecked(false);
                opt1.setChecked(false);
                currstate=3;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                f_num=findViewById(R.id.firstnum);
                S_num=findViewById(R.id.snumber);
                c_points=findViewById(R.id.currentpoints2);
                Op=findViewById(R.id.oper);

                opt1=findViewById(R.id.btn_opt1);
                opt2=findViewById(R.id.btn_opt2);
                opt3=findViewById(R.id.btn_opt3);
                opt4=findViewById(R.id.btn_opt4);

                opt1.setOnCheckedChangeListener(this);
                opt2.setOnCheckedChangeListener(this);
                opt3.setOnCheckedChangeListener(this);
                opt4.setOnCheckedChangeListener(this);

                progressBar=findViewById(R.id.bar_prog);

                r=new Random();

                generateQ();

                handler=new Handler();
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        currtime=currtime-100;
                        progressBar.setProgress(currtime);
                        if(currtime>0)
                        {
                            handler.postDelayed(runnable,100);
                        }
                        else
                        {
                            if(currstate==arrstate)
                            {
                                currpoints=currpoints+1;
                                if(currpoints==15)
                                {
                                    starttime=15000;
                                }
                                if(currpoints==20)
                                {
                                    //Toast.makeText(maths_quiz.this, "Completed !", Toast.LENGTH_SHORT).show();
                                    Intent nextintent1=new Intent(maths_quiz.this, maths_quiz_congo.class);
                                    startActivity(nextintent1);
                                    handler.removeCallbacks(runnable);
                                    finish();
                                }
                                starttime=starttime+100;

                                progressBar.setMax(starttime);
                                currtime=starttime;
                                progressBar.setProgress(currtime);

                                currstate=-1;
                                arrstate=-2;
                                opt1.setText("0");
                                opt2.setText("0");
                                opt3.setText("0");
                                opt4.setText("0");
                                generateQ();
                                opt1.setChecked(false);
                                opt2.setChecked(false);
                                opt3.setChecked(false);
                                opt4.setChecked(false);

                                handler.postDelayed(runnable,100);

                            }
                            else
                            {
                                Intent nextintent1=new Intent(maths_quiz.this, maths_quiz_result.class);
                                nextintent1.putExtra("score",currpoints);
                                startActivity(nextintent1);
                                finish();
                                //Toast.makeText(maths_quiz.this, "Game Over", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                };
                handler.postDelayed(runnable,100);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}