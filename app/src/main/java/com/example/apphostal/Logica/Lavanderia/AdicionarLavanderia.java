package com.example.apphostal.Logica.Lavanderia;

import android.content.Context;
import android.widget.Toast;

import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Database.DatabaseHotel;

public class AdicionarLavanderia {
    private DatabaseHotel dbHostal;
    private Context context;

    public AdicionarLavanderia(Context context) {
        this.context = context;
        dbHostal = new DatabaseHotel(context);
    }

    public void insertarLavanderia(Lavanderia lavanderia) {
        try {
            String query = "INSERT INTO " + DatabaseHotel.TABLE_LAVANDERIA + " (" +
                    DatabaseHotel.LAVANDERIA_FECHA + ", " +
                    DatabaseHotel.LAVANDERIA_BAJERAS + ", " +
                    DatabaseHotel.LAVANDERIA_ENCIMERAS + ", " +
                    DatabaseHotel.LAVANDERIA_FUNDA_ALMOHADA + ", " +
                    DatabaseHotel.LAVANDERIA_PROTECTOR_ALMOHADA + ", " +
                    DatabaseHotel.LAVANDERIA_NORDICA + ", " +
                    DatabaseHotel.LAVANDERIA_COLCHA_VERANO + ", " +
                    DatabaseHotel.LAVANDERIA_TOALLA_DUCHA + ", " +
                    DatabaseHotel.LAVANDERIA_TOALLA_LAVABO + ", " +
                    DatabaseHotel.LAVANDERIA_ALFOMBRIN + ", " +
                    DatabaseHotel.LAVANDERIA_PAID + ", " +
                    DatabaseHotel.LAVANDERIA_PROTECTOR_COLCHON + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            dbHostal.getWritableDatabase().execSQL(query, new String[]{
                    lavanderia.getFecha(), String.valueOf(lavanderia.getBajera()), String.valueOf(lavanderia.getEncimera()), String.valueOf(lavanderia.getFundaA()),
                    String.valueOf(lavanderia.getProtectorA()), String.valueOf(lavanderia.getNordica()), String.valueOf(lavanderia.getColchav()),
                    String.valueOf(lavanderia.getToallaD()), String.valueOf(lavanderia.getToallaL()), String.valueOf(lavanderia.getAlfombrin()), String.valueOf(lavanderia.getPaid()),
                    String.valueOf(lavanderia.getProtectorC())});

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
