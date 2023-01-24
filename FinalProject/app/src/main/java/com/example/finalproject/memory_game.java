package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class memory_game extends AppCompatActivity {
    Random r;
    int ran,swapnumb=0,attempts=0,cardrev=0;
    Handler handler;
    Runnable runnable;
    int [] ranselected={-1,-1,-1,-1},posselected={-1,-1,-1,-1,-1,-1,-1,-1},posfinal={-1,-1,-1,-1,-1,-1,-1,-1};
    Boolean delay=false;
    TextView box1,box2,box3,box4,box5,box6,box7,box8;
    TextView attnum;
    TextView[] arrtextview={box1,box2,box3,box4,box5,box6,box7,box8};
    TextView[] seltextview={null,null};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        box1=(TextView) findViewById(R.id.textView23);
        box2=(TextView) findViewById(R.id.textView24);
        box3=(TextView) findViewById(R.id.textView25);
        box4=(TextView) findViewById(R.id.textView26);
        box5=(TextView) findViewById(R.id.textView27);
        box6=(TextView) findViewById(R.id.textView28);
        box7=(TextView) findViewById(R.id.textView29);
        box8=(TextView) findViewById(R.id.textView30);

        attnum=(TextView)findViewById(R.id.textView22);

        generateseq();

        box1.setText(posfinal[0]+"");
        box2.setText(posfinal[1]+"");
        box3.setText(posfinal[2]+"");
        box4.setText(posfinal[3]+"");
        box5.setText(posfinal[4]+"");
        box6.setText(posfinal[5]+"");
        box7.setText(posfinal[6]+"");
        box8.setText(posfinal[7]+"");

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(1);
            }
        });
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(2);
            }
        });
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(3);
            }
        });
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(4);
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(5);
            }
        });
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(6);
            }
        });
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(7);
            }
        });
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap(8);
            }
        });
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if (cardrev < 4) {
                    if (swapnumb < 2) {
                        handler.postDelayed(runnable, 100);
                    } else if (swapnumb == 2) {
                        if (seltextview[0].getText().equals(seltextview[1].getText())) {
                            seltextview[0].setEnabled(false);
                            seltextview[1].setEnabled(false);
                            cardrev++;
                            seltextview[0] = null;
                            seltextview[1] = null;
                            swapnumb = 0;
                            attempts++;
                            attnum.setText("Attempts: " + attempts);
                            handler.postDelayed(runnable,100);
                        } else {
                            if(delay==false) {
                                handler.postDelayed(runnable, 2000);
                                delay=true;
                            }
                            else
                            {
                                seltextview[0].setTextColor(Color.TRANSPARENT);
                                seltextview[0].setBackgroundResource(R.drawable.question);
                                seltextview[1].setTextColor(Color.TRANSPARENT);
                                seltextview[1].setBackgroundResource(R.drawable.question);
                                seltextview[0] = null;
                                seltextview[1] = null;
                                swapnumb=0;

                                delay=false;
                                attempts++;
                                attnum.setText("Attempts: " + attempts);

                                handler.postDelayed(runnable,1000);
                            }
                            //seltextview
                        }

                    }
                }
                else
                {
                    Intent nextintent1=new Intent(memory_game.this, memory_game_cong.class);
                    nextintent1.putExtra("score",attempts);
                    startActivity(nextintent1);
                    finish();
                   // Toast.makeText(memory_game.this, "Nice1", Toast.LENGTH_SHORT).show();
                }
            }

        };
        handler.postDelayed(runnable,100);
    }
    void swap(int card)
    {
        switch (card)
        {
            case 1:
                if(swapnumb<2 && seltextview[0]!=box1) {
                    box1.setTextColor(Color.RED);
                    box1.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box1;
                }
                break;
            case 2:
                if(swapnumb<2 && seltextview[0]!=box2) {
                    box2.setTextColor(Color.RED);
                    box2.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box2;
                }
                break;
            case 3:
                if(swapnumb<2 && seltextview[0]!=box3) {
                    box3.setTextColor(Color.RED);
                    box3.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box3;
                }
                break;
            case 4:
                if(swapnumb<2 && seltextview[0]!=box4) {
                    box4.setTextColor(Color.RED);
                    box4.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box4;
                }
                break;
            case 5:
                if(swapnumb<2 && seltextview[0]!=box5) {
                    box5.setTextColor(Color.RED);
                    box5.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box5;
                }
                break;
            case 6:
                if(swapnumb<2 && seltextview[0]!=box6) {
                    box6.setTextColor(Color.RED);
                    box6.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box6;
                }
                break;
            case 7:
                if(swapnumb<2 && seltextview[0]!=box7) {
                    box7.setTextColor(Color.RED);
                    box7.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box7;
                }
                break;
            case 8:
                if(swapnumb<2 && seltextview[0]!=box8) {
                    box8.setTextColor(Color.RED);
                    box8.setBackgroundResource(0);
                    swapnumb++;
                    seltextview[swapnumb-1]=box8;
                }
                break;

        };
    }
    void generateseq()
    {
        r=new Random();
        for(int i=0;i<4;) {
            ran = r.nextInt(10);
            if(ran!=ranselected[0] && ran!=ranselected[1] && ran!=ranselected[2] && ran!=ranselected[3])
            {
                ranselected[i]=ran;
                i++;
            }
        }
        for(int i=0;i<8;) {
            ran = r.nextInt(8);
            if(ran!=posselected[0] && ran!=posselected[1] && ran!=posselected[2] && ran!=posselected[3] && ran!=posselected[4] && ran!=posselected[5] && ran!=posselected[6] && ran!=posselected[7] )
            {
                posselected[i]=ran;
                i++;
            }
        }
        for(int i=0;i<4;i++)
        {
            posfinal[posselected[i*2]]=ranselected[i];
            posfinal[posselected[(i*2)+1]]=ranselected[i];
        }


    }

}