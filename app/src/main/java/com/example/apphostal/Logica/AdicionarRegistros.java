package com.example.apphostal.Logica;

import android.content.Context;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;

public class AdicionarRegistros {
    private DatabaseHotel dbHostal;
    private Context context;

    public AdicionarRegistros(Context context) {
        dbHostal = new DatabaseHotel(context);
        this.context = context;
    }

    public void insertarRegistro(String fecha, String habitacion,
                                 String estado, String bajera,
                                 String encimera, String fundaA,
                                 String protectorA, String nordica,
                                 String toallaD, String toallaL,
                                 String alfombrin, String paid,
                                 String protectorC) {

        try {


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

            mostrarMensaje("Registro guardado correctamente");
        } catch (Exception e) {
            mostrarMensaje("Error al guardar el registro: " + e.getMessage());
        } finally {
            // Cierra la base de datos cuando ya no se necesite
            dbHostal.close();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
