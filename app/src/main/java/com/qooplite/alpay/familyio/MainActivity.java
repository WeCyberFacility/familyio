package com.qooplite.alpay.familyio;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    ImageView LoginBtn;
    EditText passwortEingabe;
    ImageView addBtn;
    boolean gefunden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         hideSystemUI();

        LoginBtn = findViewById(R.id.loginbtn);
        passwortEingabe = findViewById(R.id.passworteingabe);
        addBtn = findViewById(R.id.addbtn);


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);



        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

                LoginBtn.startAnimation(animation);

                mp.start();


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        checkLogin();

                    }
                }, 400);




            }
        });


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);

                addBtn.startAnimation(animation);

                mp.start();


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent intent = new Intent (getApplicationContext(), AddFamilieTab.class);
                        startActivity(intent);

                    }
                }, 200);


            }
        });


    }


    public void hideKeyboard(View v ){
        InputMethodManager IpM = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        IpM.hideSoftInputFromWindow(v.getWindowToken(),0);
    }



    public void checkLogin() {

        if(passwortEingabe.getText().toString().trim().equals("")) {

            Toast.makeText(this, "Bitte Familienpasswort eingeben!", Toast.LENGTH_SHORT).show();
        } else {


            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Familien");

            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        Familie currentFamilie = ds.child("Daten").getValue(Familie.class);
                        if (passwortEingabe.getText().toString().trim().equals(currentFamilie.getFamilienpasswort())) {

                            gefunden = true;
                            Home.angemeldeteFamilie = currentFamilie;
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                            passwortEingabe.setText("");
                            finish();
                            break;
                        } else {

                            continue;

                        }

                    }

                    if(gefunden) {

                    } else {

                        Toast.makeText(MainActivity.this, "Familienpassword nicht gefunden!", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(MainActivity.this, "Unbekannter Fehler ist aufgetreten", Toast.LENGTH_SHORT).show();


                }
            });

        }

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
