package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    //List<Produk> produkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        getSupportActionBar().hide();

        navView.setSelectedItemId(R.id.ic_home);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:

                        return true;

                    case R.id.ic_profil:

                        return true;
                }
                return false;
            }
        });

        final ImageButton btnmknbrt = (ImageButton) findViewById(R.id.btnmknbrt);
        btnmknbrt.setBackgroundDrawable(getDrawable(R.drawable.rounded_button));

        final ImageButton btnmknrgn = (ImageButton) findViewById(R.id.btnmknrgn);
        btnmknrgn.setBackgroundDrawable(getDrawable(R.drawable.rounded_button));

        final ImageButton btnmnm = (ImageButton) findViewById(R.id.btnmnm);
        btnmnm.setBackgroundDrawable(getDrawable(R.drawable.rounded_button));

        final ImageButton btnhrbl = (ImageButton) findViewById(R.id.btnhrbl);
        btnhrbl.setBackgroundDrawable(getDrawable(R.drawable.rounded_button));

        final ImageButton btnlain = (ImageButton) findViewById(R.id.btnlain);
        btnlain.setBackgroundDrawable(getDrawable(R.drawable.rounded_button));

        load();
        //isiData();
    }

    public void btnMknBrt(View view){
        Intent intent = new Intent(this, MakananBerat.class);
        startActivity(intent);
    }

    public void btnMknRgn(View view){
        Intent intent = new Intent(this, MakananRingan.class);
        startActivity(intent);
    }

    public void btnMnm(View view){
        Intent intent = new Intent(this, Minuman.class);
        startActivity(intent);
    }

    public void btnHrbl(View view){
        Intent intent = new Intent(this, Herbal.class);
        startActivity(intent);
    }

    public void btnLain(View view){
        Intent intent = new Intent(this, Lainnya.class);
        startActivity(intent);
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RcvProduk[] rcvProduks = new RcvProduk[]{
                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Tanggulangin", "Sidoarjo", R.drawable.keripik_tempe ),
                new RcvProduk("Nasi Uduk", "Makanan Berat", "8000","Candi", "Sidoarjo", R.drawable.nasi_uduk ),
                new RcvProduk("Sate Ayam", "Makanan Berat", "13000","Buduran", "Sidoarjo", R.drawable.sate_ayam ),
                new RcvProduk("Sambal Bawang", "Lainnya", "20000","Krembung", "Sidoarjo", R.drawable.sambal_bawang ),
                new RcvProduk("Sinom", "Minuman", "6000","Porong", "Sidoarjo", R.drawable.sinom ),
                new RcvProduk("Jahe Merah Instan", "Herbal", "12000","Krian", "Sidoarjo", R.drawable.jahe_merah_instan ),
                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe )
        };

        AdapterProduk adapterProduk = new AdapterProduk(rcvProduks, Home.this);
        recyclerView.setAdapter(adapterProduk);
    }

    //public void isiData(){
    //    produkList = new ArrayList<Produk>();
    //    siswaList.add(new Produk())
    //}

}