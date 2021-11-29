package com.suhailahnfsella.fudum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                loginUser(loginModel);
                startActivity(new Intent(MainActivity.this, Home.class));
                finish();
            }
        };

        Handler h = new Handler();
        h.postDelayed(r,3000);

    }

    public void loginUser(LoginModel loginModel){
        Call<GetLogin> loginCall = ApiClient.getApi().loginUser(loginModel);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    LoginModel getLogin = response.body().getData();
                    startActivity(new Intent(MainActivity.this,Home.class).putExtra("data", getLogin));
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
//                String message = "Username atau Password salah!";
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}