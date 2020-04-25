package com.example.yemeksitesi.Activity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yemeksitesi.Model.Yemek;
import com.example.yemeksitesi.R;
import com.google.android.gms.maps.GoogleMap;


import java.util.ArrayList;


public class YemekAdapter extends RecyclerView.Adapter<YemekAdapter.YemekListHolder> {
    private Context mContext;
    private ArrayList<Yemek> yemekList;
    private GoogleMap nmap;
    LocationManager locationManager;


    public YemekAdapter(Context mContext, ArrayList<Yemek> yemekList) {
        this.mContext = mContext;
        this.yemekList = yemekList;
    }

    public class YemekListHolder extends RecyclerView.ViewHolder {
        private CardView yemekCard;
        private TextView yemekIsim;
        private TextView yemekKisi;
        private TextView yemekHaberlesme;

        public YemekListHolder(@NonNull View itemView) {
            super(itemView);

            yemekCard = itemView.findViewById(R.id.lyCardViewYemek);
            yemekIsim = itemView.findViewById(R.id.lyYemekIsim);
            yemekKisi = itemView.findViewById(R.id.lyYemekKisi);
            yemekHaberlesme =itemView.findViewById(R.id.lyYemekHaberlesme);
        }
    }

    @NonNull
    @Override
    public YemekListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.yemek_item, parent, false);
        return new YemekListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull YemekListHolder holder, final int position) {
        String ymkIsim = yemekList.get(position).getIsim();
        String ymkKisi = yemekList.get(position).getKisi();
        String ymkHaberlesme =yemekList.get(position).getHaberlesmeTuru();

        holder.yemekIsim.setText(ymkIsim);
        holder.yemekKisi.setText(ymkKisi);
        holder.yemekHaberlesme.setText(ymkHaberlesme);


        holder.yemekCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enlem = yemekList.get(position).getEnlem();
                String boylam = yemekList.get(position).getBoylam();

                Intent adresactivity = new Intent(mContext.getApplicationContext(), GosteriMapActivity.class);
                adresactivity.putExtra("enlem",enlem);
                adresactivity.putExtra("boylam",boylam);
                mContext.startActivity(adresactivity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return yemekList.size();
    }
}
