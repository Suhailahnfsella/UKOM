package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Toko extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        getSupportActionBar().setTitle("Toko Saya");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }

        load();

        navView.setSelectedItemId(R.id.ic_home);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext()
                                ,Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_profil:
                        startActivity(new Intent(getApplicationContext()
                                ,AccountV1.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void load() {
            recyclerView = findViewById(R.id.rcvProdukToko);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            RcvProdukToko[] rcvProdukt = new RcvProdukToko[]{
                    new RcvProdukToko("Keripik Tempe", "Makanan Ringan", "10000","Tanggulangin", "Sidoarjo", R.drawable.keripik_tempe ),
                    new RcvProdukToko("Nasi Uduk", "Makanan Berat", "8000","Candi", "Sidoarjo", R.drawable.nasi_uduk ),
                    new RcvProdukToko("Sate Ayam", "Makanan Berat", "13000","Buduran", "Sidoarjo", R.drawable.sate_ayam ),
                    new RcvProdukToko("Sambal Bawang", "Lainnya", "20000","Krembung", "Sidoarjo", R.drawable.sambal_bawang ),
                    new RcvProdukToko("Sinom", "Minuman", "6000","Porong", "Sidoarjo", R.drawable.sinom ),
                    new RcvProdukToko("Jahe Merah Instan Yang Di Impor (Asli)", "Herbal", "12000","Krian", "Sidoarjo", R.drawable.jahe_merah_instan ),
                    new RcvProdukToko("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
                    new RcvProdukToko("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
                    new RcvProdukToko("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe )
            };

            AdapterProdukToko adapterProduk = new AdapterProdukToko(rcvProdukt, Toko.this);
            recyclerView.setAdapter(adapterProduk);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnTambahProduk(View view) {
        Intent intent = new Intent(this, InsertProduk.class);
        startActivity(intent);
    }

    public void btnHistoryOrder(View view) {
        Intent intent = new Intent(this, HistoryOrderan.class);
        startActivity(intent);
    }
}