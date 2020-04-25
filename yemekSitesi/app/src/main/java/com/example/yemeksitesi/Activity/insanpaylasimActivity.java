package com.example.yemeksitesi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.yemeksitesi.Model.insanyemek;
import com.example.yemeksitesi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class insanpaylasimActivity extends AppCompatActivity {


    EditText isimyemek, kisiyemekk, haberlesmeyemek;
    Button gönder;
    ImageView kapat;


    private void init() {
        gönder = findViewById(R.id.gönder);
        isimyemek = findViewById(R.id.isimyemek);
        kisiyemekk = findViewById(R.id.kisiyemekk);
        haberlesmeyemek = findViewById(R.id.haberlesmeyemek);
        kapat = findViewById(R.id.kapat);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insanpaylasim);

        init();

        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();


        gönder.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                gönderiekle();

                Intent gecis = new Intent(insanpaylasimActivity.this,YemekListesi.class);
                startActivity(gecis);

            }

        });
    }

    private void gönderiekle() {
        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        String enlem = getIntent().getExtras().getString("veri");
        String boylam = getIntent().getExtras().getString("boylam");
        String adres = getIntent().getExtras().getString("address");

        String yemekAdi = isimyemek.getText().toString();
        String kisiSayisi = kisiyemekk.getText().toString();
        String aciklama = haberlesmeyemek.getText().toString();

        insanyemek insanyemek = new insanyemek(yemekAdi, kisiSayisi, aciklama, enlem, boylam, adres);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Yemek Yerleri").child(id);

        reference.push().setValue(insanyemek);
    }

}
