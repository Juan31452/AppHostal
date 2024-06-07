package com.example.apphostal.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Clases.OnItemClickListener;
import com.example.apphostal.R;

import java.util.List;

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.MyViewHolder> {
    private Context context;
    private List<Registro> dataList;
    private int selectedPosition = -1;
    private OnItemClickListener onItemClickListener;

    public DetallesAdapter(List<Registro> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
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
        holder.id.setText(String.valueOf(data.getId()));
        holder.fecha.setText(data.getFecha());
        holder.habitacion.setText(data.getHabitacion());
        holder.estado.setText(data.getEstado());

        if (selectedPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.selected_item));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_item));
        }

        holder.itemView.setOnClickListener(v -> {
            notifyItemChanged(selectedPosition);
            selectedPosition = position;
            notifyItemChanged(selectedPosition);
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(data.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, fecha, habitacion, estado;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_id);
            fecha = itemView.findViewById(R.id.item_fecha);
            habitacion = itemView.findViewById(R.id.item_habitacion);
            estado = itemView.findViewById(R.id.item_estado);
        }
    }
}
