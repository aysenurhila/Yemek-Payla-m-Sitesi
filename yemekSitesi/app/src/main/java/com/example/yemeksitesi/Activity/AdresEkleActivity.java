package com.example.yemeksitesi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yemeksitesi.R;

public class AdresEkleActivity extends AppCompatActivity {

    Button adres;

    private void init(){
        adres = findViewById(R.id.adres);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adres_ekle);

        init();


        adres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecis = new Intent(AdresEkleActivity.this, MapsActivity.class);
                startActivity(gecis);
            }
        });

    }
}
