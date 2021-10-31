package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountV1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_v1);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        getSupportActionBar().setTitle("Akun");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }

        navView.setSelectedItemId(R.id.ic_profil);

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

    public void pengaturanAkun(View view) {
        Intent intent = new Intent(this, SettingAccount.class);
        startActivity(intent);
    }

    public void btnMulaiJual(View view) {
        Intent intent = new Intent(this, FormToko.class);
        startActivity(intent);
    }
}