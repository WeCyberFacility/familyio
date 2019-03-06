package com.qooplite.alpay.familyio;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class kochbuchUnterTab extends AppCompatActivity {


    ImageView backbtnkochbuch;
    RecyclerView kochbuchrv;
    ArrayList<Kochbuch> kochbuchliste = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kochbuch_unter_tab);
        hideSystemUI();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);


        backbtnkochbuch = findViewById(R.id.backbtnkochbuch);
        kochbuchrv = findViewById(R.id.rvkochbuecher);

        kochbuchrv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        backbtnkochbuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backbtnkochbuch.startAnimation(animation);
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


        findeKochBuecher();




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

    public void findeKochBuecher(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Familien");
        myRef = myRef.child(Home.angemeldeteFamilie.getId()).child("Kochbucher");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()) {

                    Kochbuch currentKochBuch = ds.child("Daten").getValue(Kochbuch.class);

                    kochbuchliste.add(currentKochBuch);

                }


                kochbuchrv.setAdapter(new KochbuecherAdapter(kochbuchliste, getApplicationContext()));




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }


    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }
}
