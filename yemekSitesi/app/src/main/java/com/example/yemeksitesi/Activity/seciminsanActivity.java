package com.example.yemeksitesi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksitesi.R;


public class seciminsanActivity extends AppCompatActivity {

    ImageButton paylas, liste;


    private void init(){

        paylas = findViewById(R.id.paylas);
        liste = findViewById(R.id.liste);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seciminsan);

        init();


        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gecis = new Intent(seciminsanActivity.this, AdresEkleActivity.class);
                startActivity(gecis);
            }
        });


        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new seciminsanActivity();

                Intent gecis2 = new Intent(seciminsanActivity.this, YemekListesi.class);
                startActivity(gecis2);

            }
        });


    }
}