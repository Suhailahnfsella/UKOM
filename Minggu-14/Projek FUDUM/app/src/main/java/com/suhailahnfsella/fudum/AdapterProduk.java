package com.suhailahnfsella.fudum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProduk extends RecyclerView.Adapter<AdapterProduk.ViewHolder>{

    RcvProduk[] rcvProduks;
    Context context;

    public AdapterProduk(RcvProduk[] rcvProduks, Home activity) {
        this.rcvProduks = rcvProduks;
        this.context = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_produk,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RcvProduk rcvProdukList = rcvProduks[position];
        holder.tvJudulProduk.setText(rcvProdukList.getTvJudulProduk());
        holder.tvKategoriProduk.setText(rcvProdukList.getTvKategoriProduk());
        holder.tvHargaProduk.setText(rcvProdukList.getTvHargaProduk());
        holder.tvKecProduk.setText(rcvProdukList.getTvKecProduk());
        holder.tvKabProduk.setText(rcvProdukList.getTvKabProduk());
        holder.imgProduk1.setImageResource(rcvProdukList.getImgProduk1());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, rcvProdukList.getTvJudulProduk(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rcvProduks.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProduk1;
        TextView tvJudulProduk, tvKategoriProduk, tvHargaProduk, tvKecProduk, tvKabProduk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduk1 = itemView.findViewById(R.id.imgProduk1);
            tvJudulProduk = itemView.findViewById(R.id.tvJudulProduk);
            tvKategoriProduk = itemView.findViewById(R.id.tvKategoriProduk);
            tvHargaProduk = itemView.findViewById(R.id.tvHargaProduk);
            tvKecProduk = itemView.findViewById(R.id.tvKecProduk);
            tvKabProduk = itemView.findViewById(R.id.tvKabProduk);
        }
    }
}
