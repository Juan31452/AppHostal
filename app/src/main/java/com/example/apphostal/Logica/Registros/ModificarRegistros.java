package com.example.apphostal.Logica.Registros;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.apphostal.Database.DatabaseHotel;

public class ModificarRegistros {
    private DatabaseHotel dbHostal;

    public ModificarRegistros(Context context) {

        dbHostal = new DatabaseHotel(context);
    }

    public boolean modificarRegistro(int id, String estado, String bajeras, String encimeras,
                                     String fundaAlmohada, String protectorAlmohada, String nordica, String colchav, String toallaDucha,
                                     String toallaLavabo, String alfombrin, String paid, String protectorColchon, int rellenoN) {
        SQLiteDatabase db = null;
        boolean resultado = false;

        try {
            db = dbHostal.getWritableDatabase();
            ContentValues values = new ContentValues();
            //values.put(DatabaseHotel.COLUMN_FECHA, fecha);
            values.put(DatabaseHotel.COLUMN_ESTADO, estado);
            values.put(DatabaseHotel.COLUMN_BAJERAS, bajeras);
            values.put(DatabaseHotel.COLUMN_ENCIMERAS, encimeras);
            values.put(DatabaseHotel.COLUMN_FUNDA_ALMOHADA, fundaAlmohada);
            values.put(DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA, protectorAlmohada);
            values.put(DatabaseHotel.COLUMN_NORDICA, nordica);
            values.put(DatabaseHotel.COLUMN_COLCHA_VERANO, colchav);
            values.put(DatabaseHotel.COLUMN_TOALLA_DUCHA, toallaDucha);
            values.put(DatabaseHotel.COLUMN_TOALLA_LAVABO, toallaLavabo);
            values.put(DatabaseHotel.COLUMN_ALFOMBRIN, alfombrin);
            values.put(DatabaseHotel.COLUMN_PAID, paid);
            values.put(DatabaseHotel.COLUMN_PROTECTOR_COLCHON, protectorColchon);
            values.put(DatabaseHotel.COLUMN_RELLENO_NORDICO, rellenoN);

            // Actualizar la fila correspondiente a la habitación especificada
            int rows = db.update(DatabaseHotel.TABLE_REGISTROS, values, DatabaseHotel.COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
            if (rows > 0) {
                resultado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return resultado;
    }
}