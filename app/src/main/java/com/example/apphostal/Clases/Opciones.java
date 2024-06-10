package com.example.apphostal.Clases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

public class Opciones {
    private Context context;
    private EditText edhabitacion;
    private EditText edestado;

    public Opciones(Context context, EditText edhabitacion, EditText edestado) {
        this.context = context;
        this.edhabitacion = edhabitacion;
        this.edestado = edestado;
    }

    public void mostrarListaHabitaciones() {
        // Obtén la lista de habitaciones desde la clase Habitacion
        String[] habitaciones = Habitacion.obtenerHabitaciones();

        // Crea un diálogo de selección con la lista de habitaciones
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Lista de Habitaciones")
                .setItems(habitaciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de una habitación (puedes hacer lo que necesites con ella)
                        String habitacionSeleccionada = habitaciones[which];
                        // Por ejemplo, puedes establecer la habitación seleccionada en el EditText
                        edhabitacion.setText(habitacionSeleccionada);
                    }
                });
        builder.create().show();
    }

    public void mostrarListaEstado() {
        // Obtén la lista de estados desde la clase Estado
        String[] estados = Estado.obtenerEstado();

        // Crea un diálogo de selección con la lista de estados
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Lista de Estados")
                .setItems(estados, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de un estado (puedes hacer lo que necesites con él)
                        String estadoSeleccionado = estados[which];
                        // Por ejemplo, puedes establecer el estado seleccionado en el EditText
                        edestado.setText(estadoSeleccionado);
                    }
                });

        builder.create().show();
    }
}
