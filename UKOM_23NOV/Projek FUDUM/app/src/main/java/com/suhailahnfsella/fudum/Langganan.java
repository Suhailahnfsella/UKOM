package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Langganan extends AppCompatActivity {

    LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langganan);

        getSupportActionBar().setTitle("Mulai Berlangganan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            loginModel = (LoginModel) intent.getSerializableExtra("data");
            loginModel.setIdtoko(loginModel.getId().toString());
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

    public void btnWaFudum(View view) {
        Intent intent = new Intent(this, AccountV2.class).putExtra("data",loginModel);
        startActivity(intent);
    }
}