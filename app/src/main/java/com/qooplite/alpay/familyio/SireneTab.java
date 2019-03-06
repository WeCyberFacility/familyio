package com.qooplite.alpay.familyio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

public class SireneTab extends AppCompatActivity {


    ImageView thepurgeannBtn;
    ImageView thepurgesireneBtn;
    ImageView backBtn;
    ImageView polizeisireneBtn;
    ImageView policesireneBtn;
    boolean soundIsPlaying;


    MediaPlayer mpsirene1;
    MediaPlayer mpsirene2;
    MediaPlayer mpsirene3;
    MediaPlayer mpsirene4;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirene_tab);
        hideSystemUI();

        mp = MediaPlayer.create(this, R.raw.pop);
        mpsirene1 = MediaPlayer.create(this, R.raw.thepurgeannouncment);
        mpsirene2 = MediaPlayer.create(this, R.raw.theprugesirene);
        mpsirene3 = MediaPlayer.create(this, R.raw.polizeisirene);
        mpsirene4 = MediaPlayer.create(this, R.raw.policesirene);

        thepurgeannBtn = findViewById(R.id.thepurgeannbtn);
        thepurgesireneBtn = findViewById(R.id.thepurgesirenebtn);
        backBtn = findViewById(R.id.backbtn);
        polizeisireneBtn = findViewById(R.id.polizeisrienebtn);
        policesireneBtn = findViewById(R.id.policesirenebtn);

        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);


        thepurgeannBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thepurgeannBtn.startAnimation(animation);
                mp.start();

                if(mpsirene1.isPlaying()) {

                    mpsirene1.pause();
                    mpsirene1.seekTo(0);
                    thepurgeannBtn.setImageResource(R.mipmap.theprugeannouncmentlogo);

                } else {

                    soundIsPlaying = true;
                    mpsirene1.start();
                    thepurgeannBtn.setImageResource(R.mipmap.stopsoundlogo);
                }


            }
        });


        thepurgesireneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thepurgesireneBtn.startAnimation(animation);
                mp.start();

                if(mpsirene2.isPlaying()) {

                    mpsirene2.pause();
                    mpsirene2.seekTo(0);
                    thepurgesireneBtn.setImageResource(R.mipmap.thepurgesirenelogo);

                } else {

                    soundIsPlaying = true;
                    mpsirene2.start();
                    thepurgesireneBtn.setImageResource(R.mipmap.stopsoundlogo);
                }



            }
        });


        polizeisireneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polizeisireneBtn.startAnimation(animation);
                mp.start();

                if(mpsirene3.isPlaying()) {

                    mpsirene3.pause();
                    mpsirene3.seekTo(0);
                    polizeisireneBtn.setImageResource(R.mipmap.polizeisirenelogo);

                } else {

                    soundIsPlaying = true;
                    mpsirene3.start();
                    polizeisireneBtn.setImageResource(R.mipmap.stopsoundlogo);
                }


            }
        });


        policesireneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                policesireneBtn.startAnimation(animation);
                mp.start();

                if(mpsirene4.isPlaying()) {

                    mpsirene4.pause();
                    mpsirene4.seekTo(0);
                    policesireneBtn.setImageResource(R.mipmap.policesirenelogo);

                } else {

                    soundIsPlaying = true;
                    mpsirene4.start();
                    policesireneBtn.setImageResource(R.mipmap.stopsoundlogo);
                }


            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backBtn.startAnimation(animation);
                mp.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        onBackPressed();
                        hideSystemUI();
                    }
                }, 100);



            }
        });




    }


    public void hideSystemUI(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

         mpsirene1.stop();
         mpsirene2.stop();
         mpsirene3.stop();
         mpsirene4.stop();
        mpsirene1.release();
        mpsirene2.release();
        mpsirene3.release();
        mpsirene4.release();
        mp.stop();
        mp.release();




    }
}
