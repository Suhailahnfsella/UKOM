package com.suhailahnfsella.fudum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    public static Login ma;

    Button btnLogin, btnDaftarPg;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        btnLogin = findViewById(R.id.btnLogin);
        btnDaftarPg = findViewById(R.id.btnDaftarPg);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())){
                    String pesan = "Username dan Password harus diisi!";
                    Toast.makeText(Login.this, pesan, Toast.LENGTH_LONG).show();
                } else {
                    LoginModel loginModel = new LoginModel();
                    loginModel.setUsername(etUsername.getText().toString());
                    loginModel.setPassword(etPassword.getText().toString());

                    loginUser(loginModel);
                }
            }
        });

        btnDaftarPg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Daftar.class);
                startActivity(intent);
            }
        });
    }

    public void loginUser(LoginModel loginModel){
        Call<GetLogin> loginCall = ApiClient.getApi().loginUser(loginModel);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    LoginModel getLogin = response.body().getData();
                    startActivity(new Intent(Login.this,Home.class).putExtra("data", getLogin));
                    finish();
               }else {
                    Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
                String message = "Username atau Password salah!";
                Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loginAdmin(View view) {
        Intent intent = new Intent(this, LoginAdmin.class);
        startActivity(intent);
    }
}