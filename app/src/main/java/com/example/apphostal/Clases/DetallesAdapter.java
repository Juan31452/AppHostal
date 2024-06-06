package com.example.apphostal.Clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.R;

import java.util.List;

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.MyViewHolder> {

    private List<Registro> dataList;

    public DetallesAdapter(List<Registro> dataList) {

        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Registro data = dataList.get(position);
        holder.fecha.setText(data.getFecha());
        holder.habitacion.setText(data.getHabitacion());
        holder.estado.setText(data.getEstado());
        // Set other fields as needed
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fecha, habitacion, estado;
        // Declare other TextViews here

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.item_fecha);
            habitacion = itemView.findViewById(R.id.item_habitacion);
            estado = itemView.findViewById(R.id.item_estado);
            // Initialize other TextViews here
        }
    }
}
