package com.suhailahnfsella.fudum;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MakananBerat extends AppCompatActivity {

    //RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_berat);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

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

                        return true;
                }
                return false;
            }
        });

        getSupportActionBar().setTitle("Kategori Makanan Berat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
            if (actionBar !=null){
             actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
            }

        //load();
    }

    //private void load() {
    //        recyclerView = findViewById(R.id.rcvMakananBerat);
    //        recyclerView.setHasFixedSize(true);
    //        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    //        RcvProduk[] rcvProduks = new RcvProduk[]{
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //               new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe ),
    //                new RcvProduk("Keripik Tempe", "Makanan Ringan", "10000","Candi", "Sidoarjo", R.drawable.keripik_tempe )
    //        };
    //}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}