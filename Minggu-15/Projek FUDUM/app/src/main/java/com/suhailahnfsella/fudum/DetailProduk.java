package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class DetailProduk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        getSupportActionBar().setTitle("Tambah Produk");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }
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

    public void btnKunjungiToko(View view) {
        Intent intent = new Intent(this, KunjungiToko.class);
        startActivity(intent);
    }

    public void btnBeli(View view) {
        Intent intent = new Intent(this, CheckOut.class);
        startActivity(intent);
    }
}