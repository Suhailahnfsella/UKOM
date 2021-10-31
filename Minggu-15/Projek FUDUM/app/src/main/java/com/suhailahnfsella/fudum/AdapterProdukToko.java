package com.suhailahnfsella.fudum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProdukToko extends RecyclerView.Adapter<AdapterProdukToko.ViewHolder>{

    RcvProdukToko[] rcvProdukt;
    Context context;

    public AdapterProdukToko(RcvProdukToko[] rcvProdukt, Toko activity) {
        this.rcvProdukt = rcvProdukt;
        this.context = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_produk_toko,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final RcvProdukToko rcvProdukList = rcvProdukt[i];
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
        return rcvProdukt.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        ImageView imgProduk1;
        TextView tvJudulProduk, tvKategoriProduk, tvHargaProduk, tvKecProduk, tvKabProduk, tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduk1 = itemView.findViewById(R.id.imgProduk1);
            tvJudulProduk = itemView.findViewById(R.id.tvJudulProduk);
            tvKategoriProduk = itemView.findViewById(R.id.tvKategoriProduk);
            tvHargaProduk = itemView.findViewById(R.id.tvRp);
            tvKecProduk = itemView.findViewById(R.id.tvKecProduk);
            tvKabProduk = itemView.findViewById(R.id.tvKabProduk);
            tvMenu = itemView.findViewById(R.id.tvMenu);
            tvMenu.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) { showPopMenu(v); }

        public void showPopMenu(View view){
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.menu_option);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_simpan:
                    Toast.makeText(context, "Simpan", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.menu_hapus:
                    Toast.makeText(context, "Hapus", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return false;
            }
        }
    }
}
