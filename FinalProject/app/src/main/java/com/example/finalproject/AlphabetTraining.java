package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ml.AtoI;
import com.example.finalproject.ml.JtoR;
import com.example.finalproject.ml.StoZ;
import com.kyanogen.signatureview.SignatureView;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

public class AlphabetTraining extends AppCompatActivity {

    TextView alpha;
    boolean rubstate=false,resultf=false,info=true;
    SignatureView signatureView;
    ImageButton clearall,rub;
    Button predict;
    Bitmap img;
    ImageView star1,star2,star3;
    int j,stars=3;
    TensorBuffer outputFeature0;
    float resarr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_training);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent nextintent=new Intent(AlphabetTraining.this, popup_info_alphabet.class);
        startActivity(nextintent);

        alpha=(TextView) findViewById(R.id.alphabet);
        signatureView=findViewById(R.id.signatureView);
        star1=(ImageView)findViewById(R.id.imageView17);
        star2=(ImageView)findViewById(R.id.imageView18);
        star3=(ImageView)findViewById(R.id.imageView19);
        clearall=(ImageButton) findViewById(R.id.clearall);
        rub=(ImageButton) findViewById(R.id.Rubber);
        predict=(Button) findViewById(R.id.button5);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabetArr = alphabet.toCharArray();

        Random random = new Random();
        int randomInt = random.nextInt(alphabet.length());

        alpha.setText(""+alphabetArr[randomInt]);

        rub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rubstate==false) {
                    rubstate=true;
                    rub.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                    signatureView.setPenSize(40);
                    signatureView.setPenColor(Color.parseColor("#FFFFFFFF"));
                }
                else
                {
                    rubstate=false;
                    signatureView.setPenSize(7.5f);
                    signatureView.setPenColor(Color.parseColor("#FF000000"));
                    rub.setBackgroundColor(Color.parseColor("#9DB3E1"));
                }
            }
        });
        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img=signatureView.getSignatureBitmap();
                img=Bitmap.createScaledBitmap(img,224,224,true);

                try {
                    AtoI modelAtoI = AtoI.newInstance(getApplicationContext());
                    JtoR modelJtoR = JtoR.newInstance(getApplicationContext());
                    StoZ modelStoZ = StoZ.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.UINT8);

                    TensorImage tensorImage=new TensorImage(DataType.UINT8);
                    tensorImage.load(img);

                    ByteBuffer byteBuffer=tensorImage.getBuffer();

                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    if(randomInt<9) {
                        AtoI.Outputs outputs = modelAtoI.process(inputFeature0);
                        outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                        j=0;

                    }
                    else if(randomInt<18)
                    {
                        JtoR.Outputs outputs = modelJtoR.process(inputFeature0);
                        outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                        j=1;

                    }
                    else
                    {
                        StoZ.Outputs outputs = modelStoZ.process(inputFeature0);
                        outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                        j=2;
                    }
                    int maxind=0;
                    resarr=outputFeature0.getFloatArray();
                    float maximum = resarr[0];   // start with the first value
                    for (int i=1; i<resarr.length; i++) {
                        if (resarr[i] > maximum) {
                            maximum = resarr[i];   // new maximum
                            maxind=i;
                        }
                    }
                    if(j==0) {
                        if (maxind == randomInt) {
                            resultf=true;
                        }
                        else
                        {
                            resultf=false;
                        }
                    }
                    else if(j==1)
                    {
                        if (maxind == randomInt-9) {
                            resultf=true;
                        }
                        else
                        {
                            resultf=false;
                        }
                    }
                    else
                    {
                        if (maxind == randomInt-18) {
                            resultf=true;
                        }
                        else
                        {
                            resultf=false;
                        }
                    }
                    if(resultf==true)
                    {

                        //Toast.makeText(AlphabetTraining.this, "True", Toast.LENGTH_SHORT).show();
                        //result.setText("True");
                        Intent nextintent=new Intent(AlphabetTraining.this, congalpha.class);
                        nextintent.putExtra("stars",stars);
                        startActivity(nextintent);

                        finish();

                    }
                    else
                    {
                        Toast.makeText(AlphabetTraining.this, "Wrong Try Again!", Toast.LENGTH_SHORT).show();
                        signatureView.clearCanvas();
                        if(stars==3)
                        {
                            star3.setImageResource(android.R.drawable.btn_star_big_off);
                            stars--;
                        }
                        else if(stars==2)
                        {
                            star2.setImageResource(android.R.drawable.btn_star_big_off);
                            stars--;
                        }
                        else
                        {
                            //Toast.makeText(AlphabetTraining.this, "Failed", Toast.LENGTH_SHORT).show();
                            Intent nextintent=new Intent(AlphabetTraining.this, tryagainpopup.class);
                            startActivity(nextintent);

                            finish();
                        }
                    }
                    modelAtoI.close();
                    modelJtoR.close();
                    modelStoZ.close();


                } catch (IOException e) {
                    // TODO Handle the exception
                }
            }
        });
    }
}