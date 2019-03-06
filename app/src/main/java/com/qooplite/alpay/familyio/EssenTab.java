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

public class EssenTab extends AppCompatActivity {


    ImageView backbtnessenTab;
    ImageView kochenBtn;
    ImageView kochbuchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essen_tab);

        hideSystemUI();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);


        kochenBtn = findViewById(R.id.kochenbtn);
        kochbuchBtn = findViewById(R.id.kochbuchbtn);
        backbtnessenTab = findViewById(R.id.backbtnessentab);


        backbtnessenTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backbtnessenTab.startAnimation(animation);
                mp.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        onBackPressed();
                    }
                }, 100);


            }
        });


        kochenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kochenBtn.startAnimation(animation);
                mp.start();
            }
        });


        kochbuchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kochbuchBtn.startAnimation(animation);
                mp.start();


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent intent = new Intent (getApplicationContext(), kochbuchUnterTab.class);
                        startActivity(intent);

                    }
                }, 250);
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
}
