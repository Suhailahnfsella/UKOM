package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class CheckOut extends AppCompatActivity {
    Dialog dialog;
    public static CheckOut ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        TextView tvNamaToko, tvJudulProduk, tvKategoriProduk, tvRp, tvKodeProduk;
        ImageView imgToko, imgProduk1;
        ApiInterface mApiInterface;
        ma=this;

        getSupportActionBar().setTitle("Pemesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Intent mIntent = getIntent();

        tvNamaToko = (TextView) findViewById(R.id.tvNamaToko);
        tvJudulProduk = (TextView) findViewById(R.id.tvJudulProduk);
        tvKategoriProduk = (TextView) findViewById(R.id.tvKategoriProduk);
        tvRp = (TextView) findViewById(R.id.tvRp);
        tvKodeProduk = (TextView) findViewById(R.id.tvKodeProduk);
        imgProduk1 = (ImageView) findViewById(R.id.imgProduk1);
        imgToko = (ImageView) findViewById(R.id.imgUser);

        tvNamaToko.setText(mIntent.getStringExtra("Owner"));
        tvJudulProduk.setText(mIntent.getStringExtra("Produk"));
        tvKategoriProduk.setText(mIntent.getStringExtra("Kategori"));
        tvRp.setText(String.valueOf(mIntent.getIntExtra("Rp",0)));
        tvKodeProduk.setText(mIntent.getStringExtra("KodeProduk"));
        Glide.with(CheckOut.this)
                .load("" + mIntent.getStringExtra("GambarProduk"))
                .apply(new RequestOptions().override(0, 200))
                .into(imgProduk1);
        Glide.with(CheckOut.this)
                .load("" + mIntent.getStringExtra("GambarToko"))
                .apply(new RequestOptions().override(0, 200))
                .into(imgToko);

        EditText etNamaPenerima, etAlamatPenerima, etJumlahProduk, etTempelKode;

        etNamaPenerima = (EditText) findViewById(R.id.etNamaPenerima);
        etAlamatPenerima = (EditText) findViewById(R.id.etAlamatPenerima);
        etJumlahProduk = (EditText) findViewById(R.id.etJumlahProduk);
        etTempelKode = (EditText) findViewById(R.id.etTempelKode);

        etNamaPenerima.getText().toString();
        etAlamatPenerima.getText().toString();
        etJumlahProduk.getText().toString();
        etTempelKode.getText().toString();

        Button btAlert = findViewById(R.id.btnPeriksaDetail);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
        if (etNamaPenerima.length() > 0){
            if (etAlamatPenerima.length() > 0){
                if (etJumlahProduk.length() > 0){
                    if (etTempelKode.length() > 0){
                            showDialog();
                            } else {
                        Toast.makeText(CheckOut.this, "Isi Kode Produk!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                        Toast.makeText(CheckOut.this,"Isi Jumlah Pesanan Produk!",Toast. LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(CheckOut.this,"Isi Alamat Penerima!",Toast. LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(CheckOut.this,"Isi Nama Penerima!",Toast. LENGTH_SHORT).show();
            }
        }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDialog(){
        EditText etNamaPenerima, etAlamatPenerima, etJumlahProduk, etTempelKode;

        etNamaPenerima = (EditText) findViewById(R.id.etNamaPenerima);
        etAlamatPenerima = (EditText) findViewById(R.id.etAlamatPenerima);
        etJumlahProduk = (EditText) findViewById(R.id.etJumlahProduk);
        etTempelKode = (EditText) findViewById(R.id.etTempelKode);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Detail pesanan");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage(Html.fromHtml
                        ("<b>" + "Nama Penerima :" + "</b>" +
                                "<br>" + etNamaPenerima.getText().toString() + "<br><br>" +
                                "<b>" + "Alamat Penerima :" + "</b>" +
                                "<br>" + etAlamatPenerima.getText().toString() + "<br><br>" +
                                "<b>" + "Jumlah Pesanan Produk :" + "</b>" +
                                "<br>" + etJumlahProduk.getText().toString() + "<br><br>" +
                                "<b>" + "Kode Produk :" + "</b>" +
                                "<br>" + etTempelKode.getText().toString()
                        , Html.FROM_HTML_MODE_LEGACY))
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // do something
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alert = alertDialogBuilder.create();

        // menampilkan alert dialog
        alert.show();
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