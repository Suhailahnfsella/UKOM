package com.suhailahnfsella.fudum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
    }

    public void btnLogin(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void btnDaftarPg(View view) {
        Intent intent = new Intent(this, Daftar.class);
        startActivity(intent);
    }
}