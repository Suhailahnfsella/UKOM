package com.suhailahnfsella.fudum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterHistoryOrderan extends RecyclerView.Adapter<AdapterHistoryOrderan.ViewHolder>{

    RcvHistoryOrderan[] rcvHistoryOrderans;
    Context context;

    public AdapterHistoryOrderan(RcvHistoryOrderan[] rcvHistoryOrderans, HistoryOrderan activity) {
        this.rcvHistoryOrderans = rcvHistoryOrderans;
        this.context = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_history_order,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final RcvHistoryOrderan rcvProdukList = rcvHistoryOrderans[i];
        holder.tvKodeProduk.setText(rcvProdukList.getTvKodeProduk());
        holder.tvJumlahProduk.setText(rcvProdukList.getTvJumlahProduk());
        holder.tvNamaPemesan.setText(rcvProdukList.getTvNamaPemesan());
        holder.tvAlamatPenerima.setText(rcvProdukList.getTvAlamatPenerima());
        holder.tvTglOrder.setText(rcvProdukList.getTvTglOrder());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, rcvProdukList.getTvKodeProduk(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rcvHistoryOrderans.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvKodeProduk, tvNamaPemesan, tvAlamatPenerima, tvJumlahProduk, tvTglOrder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeProduk = itemView.findViewById(R.id.tvJudulProduk);
            tvJumlahProduk = itemView.findViewById(R.id.tvJumlahProduk);
            tvNamaPemesan = itemView.findViewById(R.id.tvNamaPemesan);
            tvAlamatPenerima = itemView.findViewById(R.id.tvAlamatPenerima);
            tvTglOrder = itemView.findViewById(R.id.tvKecProduk);
        }
    }
}
