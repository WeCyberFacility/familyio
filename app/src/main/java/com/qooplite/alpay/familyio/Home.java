package com.qooplite.alpay.familyio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    public static Familie angemeldeteFamilie;

    ImageView essenBtn;
    ImageView einkaufenBtn;
    ImageView familieBtn;
    ImageView notizenBtn;
    ImageView calenderBtn;
    ImageView moneyBtn;
    ImageView messageBtn;
    ImageView musicBtn;
    ImageView tvBtn;
    ImageView settingsBtn;
    ImageView gamesBtn;
    ImageView sireneBtn;
    ImageView carBtn;
    ConstraintLayout backgroundWallpaper;

    TextView familienname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        setContentView(R.layout.activity_home);

        hideSystemUI();

        getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {

                hideSystemUI();


            }

            @Override
            public void onViewDetachedFromWindow(View view) {

            }
        });


        //Variablenzuweisung mit findviewbyid()
        essenBtn = findViewById(R.id.essenbtn);
        einkaufenBtn = findViewById(R.id.einkaufenbtn);
        familieBtn = findViewById(R.id.familiebtn);
        notizenBtn = findViewById(R.id.notizenbtn);
        calenderBtn = findViewById(R.id.calenderbtn);
        moneyBtn = findViewById(R.id.moneybtn);
        messageBtn = findViewById(R.id.messagebtn);
        musicBtn = findViewById(R.id.musicbtn);
        tvBtn = findViewById(R.id.tvbtn);
        settingsBtn = findViewById(R.id.settingsbtn);
        gamesBtn = findViewById(R.id.gamesbtn);
        sireneBtn = findViewById(R.id.sirenebtn);
        carBtn = findViewById(R.id.carbtn);
        familienname = findViewById(R.id.Familienname);
        backgroundWallpaper = findViewById(R.id.backgroundwallpaper);





        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final MediaPlayer mpsirene = MediaPlayer.create(this, R.raw.sirenesound);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);

        familienname.setText(angemeldeteFamilie.getFamilienname());

        //mp2.start();

        // ----------------------------

        //Button drücken onClickListener()
        essenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                essenBtn.startAnimation(animation);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent intent = new Intent (getApplicationContext(), EssenTab.class);
                        startActivity(intent);

                    }
                }, 200);

            }
        });

        einkaufenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mp.start();
                einkaufenBtn.startAnimation(animation);
            }
        });

        familieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  mp.start();
                familieBtn.startAnimation(animation);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent intent = new Intent (getApplicationContext(), familieTab.class);
                        startActivity(intent);

                    }
                }, 200);

            }
        });

        notizenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mp.start();
                notizenBtn.startAnimation(animation);
            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  mp.start();
                messageBtn.startAnimation(animation);
            }
        });

        calenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //mp.start();
                calenderBtn.startAnimation(animation);
            }
        });

        moneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //mp.start();
                moneyBtn.startAnimation(animation);
            }
        });

        musicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  mp.start();
                musicBtn.startAnimation(animation);
            }
        });

        tvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  mp.start();
                tvBtn.startAnimation(animation);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   mp.start();
                settingsBtn.startAnimation(animation);
            }
        });

        gamesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  mp.start();
                gamesBtn.startAnimation(animation);
            }
        });

        sireneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                sireneBtn.startAnimation(animation);


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent intent = new Intent (getApplicationContext(), SireneTab.class);
                        startActivity(intent);

                    }
                }, 200);






            }
        });

        carBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mp.start();
                carBtn.startAnimation(animation);
            }
        });


        // ----------------------------

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
