package com.example.yemeksitesi.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.yemeksitesi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Main2Activity extends Activity {

    private FirebaseAuth auth;
    private FirebaseUser currentuser;
    private ImageButton insanbutton, hayvanbutton;


    private void init() {

        auth = FirebaseAuth.getInstance();
        currentuser = auth.getCurrentUser();

        insanbutton = findViewById(R.id.insanbutton);
        hayvanbutton = findViewById(R.id.hayvanbutton);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();


        insanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentinsan = new Intent(Main2Activity.this, seciminsanActivity.class);
                startActivity(intentinsan);
            }
        });


        hayvanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intenthayvan = new Intent(Main2Activity.this, seciminsanActivity.class);
                startActivity(intenthayvan);
            }
        });
    }
}