package com.example.apphostal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.R;

import java.util.List;

public class DetallesAdapterLavanderia extends RecyclerView.Adapter<DetallesAdapterLavanderia.MyViewHolder> {

    private Context context;
    private List<Lavanderia> dataList;
    private OnItemClickListener onItemClickListener;
    private int selectedPosition = -1;
    private int selectedId = -1; // ID seleccionado

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public DetallesAdapterLavanderia(List<Lavanderia> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int id) {
        selectedId = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_lavanderia, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lavanderia data = dataList.get(position);
        holder.id.setText(String.valueOf(data.getId()));
        holder.fecha.setText(data.getFecha());

        if (selectedPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.selected_item));
            setSelectedId(data.getId());
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_item));
        }

        holder.itemView.setOnClickListener(v -> {
            notifyItemChanged(selectedPosition);
            selectedPosition = position;
            notifyItemChanged(selectedPosition);

            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, fecha;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_id);
            fecha = itemView.findViewById(R.id.item_fecha);

        }
    }
}
