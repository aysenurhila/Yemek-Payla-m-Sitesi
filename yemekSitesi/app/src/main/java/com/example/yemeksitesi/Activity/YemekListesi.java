package com.example.yemeksitesi.Activity;

import android.os.Bundle;

import com.example.yemeksitesi.Model.Yemek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.yemeksitesi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class YemekListesi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private YemekAdapter yemekAdapter;
    private ArrayList<Yemek> yemekListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_listesi);


        recyclerView = findViewById(R.id.lyYemekRecListView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        yemekListesiniDoldur();

    }

    public void yemekListesiniDoldur(){
        yemekListesi = new ArrayList<Yemek>();
        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Yemek Yerleri").child(id);

        System.out.println("hilalll+++++"+ reference);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datas : dataSnapshot.getChildren()){
                    Yemek yee = new Yemek(datas.child("gönderihaberlesme").getValue().toString(),
                            datas.child("gönderisim").getValue().toString(),
                            datas.child("gönderikisi").getValue().toString(),
                            datas.child("enlem").getValue().toString(),
                            datas.child("boylam").getValue().toString());
                    yemekListesi.add(yee);
                }




                yemekAdapter = new YemekAdapter(getApplicationContext(),yemekListesi);
                recyclerView.setAdapter(yemekAdapter);
                System.out.println("YemekListesi Size = " + yemekListesi.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });


    }

}
