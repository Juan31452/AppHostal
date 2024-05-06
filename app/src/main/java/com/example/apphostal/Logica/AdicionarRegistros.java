package com.example.apphostal.Logica;

import android.content.Context;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;

public class AdicionarRegistros {
    private DatabaseHotel dbHostal;
    private Context context;
    public AdicionarRegistros(Context context) {
        // Inicializar la instancia de DatabaseHotel
        dbHostal = new DatabaseHotel(context);
        // Almacenar el Context recibido en una variable de instancia
        this.context = context;
    }

    // Método para insertar un registro en la tabla "registros"
    public void insertarRegistro(String fecha, String habitacion,
                                 String estado, String bajera,
                                 String encimera, String fundaA,
                                 String protectorA, String nordica,
                                 String toallaD, String toallaL,
                                 String alfombrin, String paid,
                                 String protectorC) {

        try {
            // Utiliza una consulta preparada para evitar la inyección SQL
            String query = "INSERT INTO " + DatabaseHotel.TABLE_REGISTROS + " (" +
                            DatabaseHotel.COLUMN_FECHA + ", " +
                            DatabaseHotel.COLUMN_HABITACION + ", " +
                            DatabaseHotel.COLUMN_ESTADO + ", " +
                            DatabaseHotel.COLUMN_BAJERAS + ", " +
                            DatabaseHotel.COLUMN_ENCIMERAS + ", " +
                            DatabaseHotel.COLUMN_FUNDA_ALMOHADA + ", " +
                            DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA + ", " +
                            DatabaseHotel.COLUMN_NORDICA + ", " +
                            DatabaseHotel.COLUMN_TOALLA_DUCHA + ", " +
                            DatabaseHotel.COLUMN_TOALLA_LAVABO + ", " +
                            DatabaseHotel.COLUMN_ALFOMBRIN + ", " +
                            DatabaseHotel.COLUMN_PAID + ", " +
                            DatabaseHotel.COLUMN_PROTECTOR_COLCHON + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            dbHostal.getWritableDatabase().execSQL(query, new String[]{
                            fecha, habitacion, estado, bajera, encimera, fundaA,
                            protectorA, nordica, toallaD, toallaL, alfombrin, paid,
                            protectorC});

            // Muestra un mensaje indicando que el registro se guardó correctamente
            mostrarMensaje("Registro guardado correctamente");
        } catch (Exception e) {
            // Muestra un mensaje de error si ocurre algún problema al guardar el registro
            mostrarMensaje("Error al guardar el registro: " + e.getMessage());
        }
    }

    // Método para mostrar un mensaje (puede ser modificado según tus necesidades)
    private void mostrarMensaje(String mensaje) {
        // Muestra un Toast con el mensaje proporcionado
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}