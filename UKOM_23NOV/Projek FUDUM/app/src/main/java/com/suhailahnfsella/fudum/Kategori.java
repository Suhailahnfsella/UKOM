package com.suhailahnfsella.fudum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Kategori extends AppCompatActivity {

    LoginModel loginModel;

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Kategori ma, mi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_berat);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        navView.setSelectedItemId(R.id.ic_home);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            loginModel = (LoginModel) intent.getSerializableExtra("data");
        }

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
                        if (loginModel.getStatus() == 0){
                            startActivity(new Intent(getApplicationContext()
                                    ,AccountV1.class).putExtra("data", loginModel));
                            overridePendingTransition(0,0);
                        } else if (loginModel.getStatus() == 1){
                            startActivity(new Intent(getApplicationContext()
                                    ,AccountV2.class).putExtra("data", loginModel));
                            overridePendingTransition(0,0);
                        }
                        return true;
                }
                return false;
            }
        });

        int value = intent.getIntExtra("IdKategori",0);

        if (value == 1){
            getSupportActionBar().setTitle("Kategori Makanan Berat");
        } else if (value == 2){
            getSupportActionBar().setTitle("Kategori Makanan Ringan");
        } else if (value == 3){
            getSupportActionBar().setTitle("Kategori Minuman");
        } else if (value == 4){
            getSupportActionBar().setTitle("Kategori Herbal");
        } else if (value == 5){
            getSupportActionBar().setTitle("Kategori Lainnya");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
            if (actionBar !=null){
             actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
            }

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvMakananBerat);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        panggilRetrofit();
        jalankan();
    }

    private void jalankan() {
        ma=this;
        Intent mIntent = getIntent();
        Intent intent = new Intent();
        intent.putExtra("IdKategori", mIntent.getIntExtra("IdKategori",0));
    }

    public void panggilRetrofit() {
        Call<GetMenu> kontakCall = mApiInterface.getMenu();
        kontakCall.enqueue(new Callback<GetMenu>() {
            @Override
            public void onResponse(Call<GetMenu> call, Response<GetMenu>
                    response) {
                List<Menu> ListMenu = response.body().getData();
                Collections.sort(ListMenu, new Comparator<Menu>() {
                    @Override
                    public int compare(Menu lhs, Menu rhs) {
                        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                        return lhs.getIdmenu() > rhs.getIdmenu() ? -1 : (lhs.getIdmenu() < rhs.getIdmenu() ) ? 1 : 0;
                    }
                });
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(ListMenu.size()));
                mAdapter = new AdapterKategori(ListMenu);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMenu> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
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
}