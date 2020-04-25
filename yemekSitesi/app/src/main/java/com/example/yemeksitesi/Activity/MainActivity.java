package com.example.yemeksitesi.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksitesi.R;

public class MainActivity extends AppCompatActivity {

    private Button butongiris, butonkayit;


    public void init(){

        butongiris = findViewById(R.id.giris);
        butonkayit = findViewById(R.id.kayit);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        butongiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentlogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentlogin);

            }
        });

        butonkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentkayit = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(intentkayit);


            }
        });

    }


}
