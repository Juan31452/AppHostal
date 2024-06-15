package com.example.apphostal.Logica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;
import com.example.apphostal.Entity.Extras;
import com.example.apphostal.Database.DatabaseHotel;

public class AdicionarExtras {
    private DatabaseHotel dbHostal;
    private Context context;

    public AdicionarExtras(Context context) {
        dbHostal = new DatabaseHotel(context);
        this.context = context;
    }

    public void insertarExtras(Extras extras) {
        SQLiteDatabase db = dbHostal.getWritableDatabase();
        // Imprimir el valor en el Log
        Log.d("Datos a insertar", extras.toString());
        try {
            String query = "INSERT INTO " + DatabaseHotel.TABLE_EXTRAS + " (" +
                    DatabaseHotel.COLUMN_REGISTRO_ID + ", " +
                    DatabaseHotel.COLUMN_AGUA + ", " +
                    DatabaseHotel.COLUMN_PAPELH + ", " +
                    DatabaseHotel.COLUMN_CAFEN + ", " +
                    DatabaseHotel.COLUMN_CAFEC + ", " +
                    DatabaseHotel.COLUMN_LECHE + ", " +
                    DatabaseHotel.COLUMN_TE_MANZANILLA + ", " +
                    DatabaseHotel.COLUMN_TE_NEGRO + ", " +
                    DatabaseHotel.COLUMN_GALLETAS + ", " +
                    DatabaseHotel.COLUMN_AZUCAR + ", " +
                    DatabaseHotel.COLUMN_SACARINA + ", " +
                    DatabaseHotel.COLUMN_MAQUILLAJE + ", " +
                    DatabaseHotel.COLUMN_DULCE_EXTRA + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            db.execSQL(query, new Object[]{
                    extras.getRegistro(), extras.getAgua(), extras.getPapleh(),
                    extras.getCafen(), extras.getCafec(), extras.getLeche(),
                    extras.getTem(), extras.getTenegro(), extras.getGalletas(),
                    extras.getAzucar(), extras.getSacarinas(), extras.getMaquillaje(),
                    extras.getDulceextra()});

            mostrarMensaje("Registro guardado correctamente");
        } catch (Exception e) {
            mostrarMensaje("Error al guardar el registro: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
