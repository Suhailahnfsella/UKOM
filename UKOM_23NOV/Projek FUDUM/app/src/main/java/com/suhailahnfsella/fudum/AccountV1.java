package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountV1 extends AppCompatActivity {

    LoginModel loginModel;
    ImageView imgUser;
    TextView namaPanjang, tvUsNam;

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

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            loginModel = (LoginModel) intent.getSerializableExtra("data");
            loginModel.setIdtoko(loginModel.getId().toString());
        }

        namaPanjang = findViewById(R.id.namaPanjang);
        tvUsNam = findViewById(R.id.tvUsNam);
        imgUser = findViewById(R.id.imgUser);

        namaPanjang.setText(loginModel.getNamapanjang());
        tvUsNam.setText(loginModel.getUsername());
        Glide.with(AccountV1.this)
                .load("" + loginModel.getFotoprofil())
                .apply(new RequestOptions().override(0, 200))
                .into(imgUser);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext()
                                ,Home.class).putExtra("data", loginModel));
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
        Intent intent = new Intent(this, FormToko.class).putExtra("data",loginModel);
        startActivity(intent);
    }
}