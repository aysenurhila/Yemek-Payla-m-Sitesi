package com.example.yemeksitesi.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksitesi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailgiris, passwordgiris;
    private Button girisyap;
    private FirebaseAuth mAuth;
    private FirebaseUser currentuser;

    public void init(){


        emailgiris = findViewById(R.id.emailgiris);
        passwordgiris =findViewById(R.id.passwordgiris);
        girisyap = findViewById(R.id.girisyap);

        mAuth =FirebaseAuth.getInstance();
        currentuser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });


    }

    private void loginuser() {

        String email = emailgiris.getText().toString();
        String password = passwordgiris.getText().toString();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Email Alanı boş olamaz", Toast.LENGTH_LONG).show();

        }

        else if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Sifre Alanı Boş Olamaz", Toast.LENGTH_LONG).show();

        }

        else {

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){//Bu görev basarılıysa

                        Toast.makeText(LoginActivity.this,"Giriş Başarılı", Toast.LENGTH_LONG).show();
                        Intent mainactivity = new Intent(LoginActivity.this,seciminsanActivity.class);
                        startActivity(mainactivity);
                    }

                    else{

                        Toast.makeText(LoginActivity.this,"Giriş Başarısız", Toast.LENGTH_LONG).show();

                    }
                }
            });

        }


    }
}
