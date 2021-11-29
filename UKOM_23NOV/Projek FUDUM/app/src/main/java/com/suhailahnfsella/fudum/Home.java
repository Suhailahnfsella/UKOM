package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    ApiInterface mApiInterface;
    LoginModel loginModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Home ma, mi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            loginModel = (LoginModel) intent.getSerializableExtra("data");
            loginModel.setIdtoko(loginModel.getId().toString());
        }

        getSupportActionBar().hide();

        navView.setSelectedItemId(R.id.ic_home);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:

                        return true;

                    case R.id.ic_profil:
                        if (intent.getExtras() == null){
                            startActivity(new Intent(getApplicationContext()
                                    ,Login.class));
                            overridePendingTransition(0,0);
                        } else if (loginModel.getStatus() == 0){
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

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvHome);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

        panggilRetrofit();

        Intent nwIntent = new Intent();
        nwIntent.putExtra("data", intent.getExtras());
    }

    public void btnMknBrt(View view){
        Integer idkategori = 1;
        Intent getintent = getIntent();
        if (getintent.getExtras() != null){
            loginModel = (LoginModel) getintent.getSerializableExtra("data");
        }
        Intent intent = new Intent(this, Kategori.class);
        intent.putExtra("IdKategori", idkategori);
        intent.putExtra("data", loginModel);
        startActivity(intent);
    }

    public void btnMknRgn(View view){
        Integer idkategori = 2;
        Intent getintent = getIntent();
        if (getintent.getExtras() != null){
            loginModel = (LoginModel) getintent.getSerializableExtra("data");
        }
        Intent intent = new Intent(this, Kategori.class);
        intent.putExtra("IdKategori", idkategori);
        intent.putExtra("data", loginModel);
        startActivity(intent);
    }

    public void btnMnm(View view){
        Integer idkategori = 3;
        Intent getintent = getIntent();
        if (getintent.getExtras() != null){
            loginModel = (LoginModel) getintent.getSerializableExtra("data");
        }
        Intent intent = new Intent(this, Kategori.class);
        intent.putExtra("IdKategori", idkategori);
        intent.putExtra("data", loginModel);
        startActivity(intent);
    }

    public void btnHrbl(View view){
        Integer idkategori = 4;
        Intent getintent = getIntent();
        if (getintent.getExtras() != null){
            loginModel = (LoginModel) getintent.getSerializableExtra("data");
        }
        Intent intent = new Intent(this, Kategori.class);
        intent.putExtra("IdKategori", idkategori);
        intent.putExtra("data", loginModel);
        startActivity(intent);
    }

    public void btnLain(View view){
        Integer idkategori = 5;
        Intent getintent = getIntent();
        if (getintent.getExtras() != null){
            loginModel = (LoginModel) getintent.getSerializableExtra("data");
        }
        Intent intent = new Intent(this, Kategori.class);
        intent.putExtra("IdKategori", idkategori);
        intent.putExtra("data", loginModel);
        startActivity(intent);
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
                mAdapter = new AdapterProduk(ListMenu);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMenu> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    //public void isiData(){
    //    produkList = new ArrayList<Produk>();
    //    siswaList.add(new Produk())
    //}

}