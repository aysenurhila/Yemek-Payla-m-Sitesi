package com.example.yemeksitesi.Activity;

import android.content.Intent;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksitesi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitActivity extends AppCompatActivity {

    EditText emailedt, sifreedt;
    Button kayit;


    public void init(){


    }
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        init();

        emailedt = findViewById(R.id.email_edt);
        sifreedt = findViewById(R.id.sifre_edt);
        kayit = findViewById(R.id.kayit_button);
        mAuth = FirebaseAuth.getInstance();



        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;

                email =emailedt.getText().toString().trim();
                password =sifreedt.getText().toString().trim();

                if(!email.equals("") && !password.equals("")){

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(KayitActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Intent girisegit = new Intent(KayitActivity.this, LoginActivity.class);
                                        startActivity(girisegit);
                                        Toast.makeText(KayitActivity.this,"Kullanici Kaydi Basarili :) ", Toast.LENGTH_LONG).show();


                                    } else {
                                        Toast.makeText(KayitActivity.this,"Kullanici Kaydi Basarisiz!!", Toast.LENGTH_LONG).show();

                                    }

                                }
                            });

                }

                else {

                    Toast.makeText(KayitActivity.this, "Lütfen Boş Alan Bırakmayınız", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

