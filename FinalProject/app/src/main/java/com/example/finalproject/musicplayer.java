package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class musicplayer extends AppCompatActivity {
    ImageView yt1,yt2,yt3,yt4,yt5,m1,m2,m3,m4,m5;
    MediaPlayer music = null;
    Boolean isplaying=false;
    String cpsong=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //music= MediaPlayer.create(getApplicationContext(),R.raw.johnyjohny);

        yt1=(ImageView) findViewById(R.id.imageView9);
        yt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=MR5XSOdjKMA"));

                startActivity(viewIntent);
            }
        });

        yt2=(ImageView) findViewById(R.id.imageView7);
        yt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=F4tHL8reNCs"));

                startActivity(viewIntent);
            }
        });

        yt3=(ImageView) findViewById(R.id.imageView11);
        yt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=Wm4R8d0d8kU"));

                startActivity(viewIntent);
            }
        });

        yt4=(ImageView) findViewById(R.id.imageView12);
        yt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=e_04ZrNroTo"));

                startActivity(viewIntent);
            }
        });

        yt5=(ImageView) findViewById(R.id.imageView14);
        yt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=yCjJyiqpAuU"));

                startActivity(viewIntent);
            }
        });
        //      /////////////////////////////////////////

        m1=(ImageView) findViewById(R.id.imageView8);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpsong == null) {
                    iconch();
                    m1.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.baba);
                    music.start();
                    cpsong = "Ba Ba Black Ship";
                    isplaying = true;
                } else if (cpsong == "Ba Ba Black Ship" && isplaying == true) {
                    iconch();
                    music.pause();
                    isplaying = false;
                } else if (cpsong != "Ba Ba Black Ship")
                {
                    iconch();
                    music.stop();
                    music.release();
                    m1.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.baba);
                    music.start();
                    cpsong = "Ba Ba Black Ship";
                    isplaying = true;
                }else if (cpsong == "Ba Ba Black Ship" && isplaying == false)
                {
                    iconch();
                    m1.setImageResource(android.R.drawable.ic_media_pause);
                    music.start();
                    isplaying = true;
                }
            }
        });

        m2=(ImageView) findViewById(R.id.imageView6);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpsong == null) {
                    iconch();
                    m2.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.johnyjohny);
                    music.start();
                    cpsong = "Johny Johny";
                    isplaying = true;
                } else if (cpsong == "Johny Johny" && isplaying == true) {
                    iconch();
                    music.pause();
                    isplaying = false;
                } else if (cpsong != "Johny Johny")
                {
                    iconch();
                    music.stop();
                    music.release();
                    m2.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.johnyjohny);
                    music.start();
                    cpsong = "Johny Johny";
                    isplaying = true;
                }else if (cpsong == "Johny Johny" && isplaying == false)
                {
                    iconch();
                    m2.setImageResource(android.R.drawable.ic_media_pause);
                    music.start();
                    isplaying = true;
                }
            }
        });

        m3=(ImageView) findViewById(R.id.imageView10);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpsong == null) {
                    iconch();
                    m3.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.old_macdonald);
                    music.start();
                    cpsong = "Old Mac";
                    isplaying = true;
                } else if (cpsong == "Old Mac" && isplaying == true) {
                    iconch();
                    music.pause();
                    isplaying = false;
                } else if (cpsong != "Old Mac")
                {
                    iconch();
                    music.stop();
                    music.release();
                    m3.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.old_macdonald);
                    music.start();
                    cpsong = "Old Mac";
                    isplaying = true;
                }else if (cpsong == "Old Mac" && isplaying == false)
                {
                    iconch();
                    m3.setImageResource(android.R.drawable.ic_media_pause);
                    music.start();
                    isplaying = true;
                }
            }
        });

        m4=(ImageView) findViewById(R.id.imageView13);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpsong == null) {
                    iconch();
                    m4.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.the_wheels_on_the_bus);
                    music.start();
                    cpsong = "The Wheels";
                    isplaying = true;
                } else if (cpsong == "The Wheels" && isplaying == true) {
                    iconch();
                    music.pause();
                    isplaying = false;
                } else if (cpsong != "The Wheels")
                {
                    iconch();
                    music.stop();
                    music.release();
                    m4.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.the_wheels_on_the_bus);
                    music.start();
                    cpsong = "The Wheels";
                    isplaying = true;
                }else if (cpsong == "The Wheels" && isplaying == false)
                {
                    iconch();
                    m4.setImageResource(android.R.drawable.ic_media_pause);
                    music.start();
                    isplaying = true;
                }
            }
        });

        m5=(ImageView) findViewById(R.id.imageView15);
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cpsong == null) {
                    iconch();
                    m5.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.twinkle);
                    music.start();
                    cpsong = "Twinkle";
                    isplaying = true;
                } else if (cpsong == "Twinkle" && isplaying == true) {
                    iconch();
                    music.pause();
                    isplaying = false;
                } else if (cpsong != "Twinkle")
                {
                    iconch();
                    music.stop();
                    music.release();
                    m5.setImageResource(android.R.drawable.ic_media_pause);
                    music = MediaPlayer.create(getApplicationContext(), R.raw.twinkle);
                    music.start();
                    cpsong = "Twinkle";
                    isplaying = true;
                }else if (cpsong == "Twinkle" && isplaying == false)
                {
                    iconch();
                    m5.setImageResource(android.R.drawable.ic_media_pause);
                    music.start();
                    isplaying = true;
                }
            }
        });

    }
    public void iconch()
    {
        m1.setImageResource(android.R.drawable.ic_media_play);
        m2.setImageResource(android.R.drawable.ic_media_play);
        m3.setImageResource(android.R.drawable.ic_media_play);
        m4.setImageResource(android.R.drawable.ic_media_play);
        m5.setImageResource(android.R.drawable.ic_media_play);

    }
    @Override
    protected void onPause() {
        super.onPause();
        music.release();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        music.release();
    }
}