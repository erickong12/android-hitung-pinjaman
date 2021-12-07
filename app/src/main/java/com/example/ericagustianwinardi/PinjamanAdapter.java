package com.example.ericagustianwinardi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;

public class PinjamanAdapter extends RecyclerView.Adapter<PinjamanAdapter.ViewHolder> {

    public Map<String, Map> data;
    @NonNull
    @Override
    public PinjamanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pinjaman, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PinjamanAdapter.ViewHolder holder, int number) {
        holder.bulanKe.setText("Bulan Ke " + String.valueOf(number));
        holder.bunga.setText("Rp. " + String.format("%,.2f",data.get(String.valueOf(number)).get("Bunga")));
        holder.pokok.setText("Rp. " + String.format("%,.2f",data.get(String.valueOf(number)).get("Pokok")));
        holder.total.setText("Rp. " + String.format("%,.2f",data.get(String.valueOf(number)).get("Total")));
        holder.sisa.setText("Rp. " + String.format("%,.2f",data.get(String.valueOf(number)).get("Sisa")));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bulanKe,bunga,pokok,total,sisa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bulanKe = (TextView)itemView.findViewById(R.id.bulan);
            bunga = (TextView)itemView.findViewById(R.id.bunga);
            pokok = (TextView)itemView.findViewById(R.id.pokok);
            total = (TextView)itemView.findViewById(R.id.total);
            sisa = (TextView)itemView.findViewById(R.id.sisapinjaman);
        }
    }
}
