package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    int defaultColor;
    SignatureView signatureView;
    ImageButton imgEraser,imgColor,imgSave;
    SeekBar seekBar;
    TextView txtPenSize;

    private static String fileName;

    File path=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/myPaintings");

//    File path=new File(System.getenv("EXTERNAL_STORAGE"));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this,""+path.exists(), Toast.LENGTH_SHORT).show();

        signatureView=findViewById(R.id.signature_view);
        seekBar=findViewById(R.id.penSize);
        txtPenSize=findViewById(R.id.txtPenSize);
        imgColor=findViewById(R.id.btnColor);
        imgEraser=findViewById(R.id.btnEraser);
        imgSave=findViewById(R.id.btnSave);

        askPermission();



        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String date=format.format(new Date());
        fileName=path+"/"+date+".png";




        if(!path.exists())
        {
            path.mkdirs();
        }
        signatureView.setPenSize(10);
        seekBar.setProgress(20);
        defaultColor= ContextCompat.getColor(MainActivity.this,R.color.black);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtPenSize.setText(progress+"dp");
                signatureView.setPenSize(progress);
                seekBar.setMax(50);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
        imgEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });
        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signatureView.isBitmapEmpty())
                {
                    try {
                        saveImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Couldn't Save!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void saveImage() throws IOException {
        File file=new File(fileName);

        Bitmap bitmap=signatureView.getSignatureBitmap();

        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,bos);
        byte [] bitmapData=bos.toByteArray();
        //Toast.makeText(MainActivity.this,""+ file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
        FileOutputStream fos=new FileOutputStream(file);

        fos.write(bitmapData);
        fos.flush();
        fos.close();
        Toast.makeText(this,"Painting saved!",Toast.LENGTH_SHORT).show();
    }

    private void openColorPicker() {
        AmbilWarnaDialog ambilWarnaDialog=new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor=color;
                signatureView.setPenColor(color);

            }
        });

        ambilWarnaDialog.show();
    }

    private void askPermission() {
        Dexter.withContext(this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(MainActivity.this,"Granted",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }
}