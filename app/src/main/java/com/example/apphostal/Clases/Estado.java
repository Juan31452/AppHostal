package com.example.apphostal.Clases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;


public class Estado  {
    private static String[] estados = {"Salida", "Estancia", "Repaso", "SalidaEntrada", "NoMolestar"};

    // Método para obtener el array de estado

    public static String[] obtenerEstado() {

        return new String[]{"Salida", "Estancia", "Repaso", "SalidaEntrada", "NoMolestar"};
    }

    // Método para mostrar el diálogo de selección de estados
    public static void mostrarListaEstado(Context context, final EditText edestado) {
        // Obtén la lista de estados
        String[] estados = obtenerEstado();

        // Crea un diálogo de selección con la lista de estados
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Lista de Estados")
                .setItems(estados, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de un estado
                        String estadoSeleccionado = estados[which];
                        // Establece el estado seleccionado en el EditText
                        edestado.setText(estadoSeleccionado);
                    }
                });

        // Muestra el diálogo
        builder.show();
    }
}


