package com.example.apphostal.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Clases.OnItemClickListener;
import com.example.apphostal.R;

import java.util.List;

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.MyViewHolder> {

    private Context context;
    private List<Registro> dataList;
    private OnItemClickListener onItemClickListener;
    private int selectedPosition = -1;
    private int selectedId = -1; // ID seleccionado

    public DetallesAdapter(List<Registro> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    // Método para obtener el ID seleccionado
    public int getSelectedId() {
        return selectedId;
    }

    // Método para establecer el ID seleccionado
    public void setSelectedId(int id) {
        selectedId = id;
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

        // Establecer el color de fondo del elemento seleccionado
        if (selectedPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.selected_item));
            setSelectedId(data.getId()); // Establecer el ID seleccionado
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_item));
        }

        holder.itemView.setOnClickListener(v -> {
            notifyItemChanged(selectedPosition);
            selectedPosition = position;
            notifyItemChanged(selectedPosition);
            notifyDataSetChanged(); // Notificar cambios en el adaptador
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
