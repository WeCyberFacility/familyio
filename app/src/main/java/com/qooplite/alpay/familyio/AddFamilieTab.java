package com.qooplite.alpay.familyio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFamilieTab extends AppCompatActivity {

    ImageView checkinbackBtn;
    ImageView checkinBtn;
    EditText familiennameTxt;
    EditText familienpasswortTxt;
    EditText anzahlKinderTxt;
    EditText wohnortTxt;
    EditText strasseTxt;
    EditText aktivierungscodeTxt;

    //booleans:

    boolean codeIsOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_familie_tab);

        hideSystemUI();


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popsmall);

        checkinbackBtn = findViewById(R.id.checkinbackbtn);
        checkinBtn = findViewById(R.id.checkinbtn);
        familiennameTxt = findViewById(R.id.familiennametxt);
        familienpasswortTxt = findViewById(R.id.familienpassworttxt);
        anzahlKinderTxt = findViewById(R.id.anzahlkindertxt);
        wohnortTxt = findViewById(R.id.wohnorttxt);
        strasseTxt = findViewById(R.id.strassetxt);
        aktivierungscodeTxt = findViewById(R.id.aktivierungscodetxt);

        //Butttons onClickedListeners:

        checkinbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkinbackBtn.startAnimation(animation);
                mp.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        onBackPressed();

                        familiennameTxt.setText("");
                        familienpasswortTxt.setText("");
                        anzahlKinderTxt.setText("");
                        wohnortTxt.setText("");
                        strasseTxt.setText("");
                        aktivierungscodeTxt.setText("");

                        hideSystemUI();

                    }
                }, 100);

            }
        });


        checkinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkinBtn.startAnimation(animation);
                mp.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms

                        aktivierungscodeEingeben();
                        checkActivation();


                    }
                }, 100);

            }
        });


    }


    public void aktivierungscodeEingeben(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Aktivierungscodes");

        Aktivierungscode neu = new Aktivierungscode("1234", "");

        myRef.child("1234").setValue(neu);


    }


    public void checkActivation() {

        //check if any EditText Field is empty:
        final String familiennameeingabe = familiennameTxt.getText().toString().trim();
        final String familienpassworteingabe = familienpasswortTxt.getText().toString().trim();
        final String anzahlkindereingabe = anzahlKinderTxt.getText().toString().trim();
        final String wohnorteingabe = wohnortTxt.getText().toString().trim();
        final String strasseeingabe = strasseTxt.getText().toString().trim();
        final String aktivierungscodeeingabe = aktivierungscodeTxt.getText().toString().trim();

        if(familiennameeingabe.equals("") || familienpassworteingabe.equals("") || anzahlkindereingabe.equals("") || wohnorteingabe.equals("")
                || strasseeingabe.equals("") || aktivierungscodeeingabe.equals("")) {

            Toast.makeText(this, "Bitte alle Felder ausfüllen!", Toast.LENGTH_SHORT).show();

        } else {

            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference("Aktivierungscodes");



            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot ds : dataSnapshot.getChildren()) {

                        Aktivierungscode currentCode = ds.getValue(Aktivierungscode.class);

                        if(currentCode.getAktivierungscode().equals(aktivierungscodeeingabe)) {

                            if(currentCode.getFamilie().equals("")) {

                                Toast.makeText(AddFamilieTab.this, "Aktivierungscode gefunden!", Toast.LENGTH_SHORT).show();
                                codeIsOk = true;

                                Aktivierungscode neuerCode = currentCode;
                                neuerCode.setFamilie(familiennameeingabe);
                                myRef.child(currentCode.getAktivierungscode()).setValue(neuerCode);
                                break;

                            } else {

                                Toast.makeText(AddFamilieTab.this, "Aktivierungscode ist bereits aktiviert!", Toast.LENGTH_SHORT).show();
                                break;

                            }


                        } else {

                            continue;


                        }


                    }


                    if(codeIsOk) {

                        //Familie in die Datenbank einfügen:

                        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
                        DatabaseReference myRef2 = database2.getReference("Familien");

                        String id = myRef2.push().getKey();


                        Familie neueFamilie = new Familie(id, familiennameeingabe, familienpassworteingabe, anzahlkindereingabe, wohnorteingabe, strasseeingabe, aktivierungscodeeingabe, "");
                        myRef2.child(id).child("Daten").setValue(neueFamilie);



                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms

                                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        }, 100);

                    } else {

                        Toast.makeText(AddFamilieTab.this, "Aktivierungscode nicht gefunden!", Toast.LENGTH_SHORT).show();

                    }





                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    System.out.println("Abgebrochen!");

                }
            });


        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hideSystemUI();
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
