package com.example.apphostal.Logica;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.apphostal.Entity.Extras;
import com.example.apphostal.Database.DatabaseHotel;

public class ModificarExtras {
    private DatabaseHotel dbHostal;

    public ModificarExtras(Context context) {

        dbHostal = new DatabaseHotel(context);
    }

    public boolean modificarDatos(Extras extras) {

        SQLiteDatabase db = null;
        boolean resultado = false;

        try {
            // Obtener una instancia de la base de datos en modo escritura
            db = dbHostal.getWritableDatabase();
            // Crear un objeto ContentValues para contener los nuevos valores
            ContentValues values = new ContentValues();
            values.put(DatabaseHotel.COLUMN_AGUA, extras.getAgua());
            values.put(DatabaseHotel.COLUMN_PAPELH, extras.getPapleh());
            values.put(DatabaseHotel.COLUMN_CAFEN, extras.getCafen());
            values.put(DatabaseHotel.COLUMN_CAFEC, extras.getCafec());
            values.put(DatabaseHotel.COLUMN_LECHE, extras.getLeche());
            values.put(DatabaseHotel.COLUMN_TE_MANZANILLA, extras.getTem());
            values.put(DatabaseHotel.COLUMN_TE_NEGRO, extras.getTenegro());
            values.put(DatabaseHotel.COLUMN_GALLETAS, extras.getGalletas());
            values.put(DatabaseHotel.COLUMN_AZUCAR, extras.getAzucar());
            values.put(DatabaseHotel.COLUMN_SACARINA, extras.getSacarinas());
            values.put(DatabaseHotel.COLUMN_MAQUILLAJE, extras.getMaquillaje());
            values.put(DatabaseHotel.COLUMN_DULCE_EXTRA, extras.getDulceextra());

            // Realizar la actualización en la base de datos
            int rows = db.update(DatabaseHotel.TABLE_EXTRAS, values, DatabaseHotel.COLUMN_REGISTRO_ID + " = ?", new String[]{String.valueOf(extras.getRegistro())});


            // Comprobar si se actualizaron filas con éxito
            if (rows > 0) {
                resultado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión de la base de datos
            if (db != null) {
                db.close();
            }
        }

        return resultado;
    }


}
