package com.example.apphostal.Logica;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.apphostal.Database.DatabaseHotel;

public class ListarExtras {
    private DatabaseHotel dbHostal;
    private Context context;
    public ListarExtras(Context context) {
        dbHostal = new DatabaseHotel(context);
        this.context = context;
    }
    public void consultarExtras(String registroId) {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;


        try {
            String query = "SELECT * FROM " + DatabaseHotel.TABLE_EXTRAS +
                    " WHERE " + DatabaseHotel.COLUMN_REGISTRO_ID + " = ?";
            cursor = db.rawQuery(query, new String[]{registroId});

            // Verificar si se encontraron resultados
            if (cursor != null && cursor.moveToFirst()) {
                // Iterar sobre los resultados y mostrarlos o procesarlos de alguna manera
                do {
                    // Ejemplo de procesamiento: Mostrar los valores en Log
                    // Datos de la tabla "extras"
                    String registroid = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_REGISTRO_ID));
                    String agua = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_AGUA));
                    String papelH = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAPELH));
                    String cafeN = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_CAFEN));
                    String cafeC = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_CAFEC));
                    String leche = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_LECHE));
                    String teManzanilla = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TE_MANZANILLA));
                    String teNegro = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TE_NEGRO));
                    String galletas = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_GALLETAS));
                    String azucar = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_AZUCAR));
                    String sacarina = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_SACARINA));
                    String maquillaje = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_MAQUILLAJE));
                    String dulceExtra = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_DULCE_EXTRA));

                    // Otros campos...
                    Log.d("Datos de extras", "Agua: " + agua + ", PapelH: " + papelH);
                    // Puedes hacer lo que necesites con estos datos, como mostrarlos en la interfaz de usuario
                } while (cursor.moveToNext());
            } else {
                // No se encontraron resultados
               // mostrarMensaje("No se encontraron datos para el registroId: " + registroId);
            }
        } catch (Exception e) {
            //mostrarMensaje("Error al consultar datos extras: " + e.getMessage());
        } finally {
            // Cerrar el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    private void mostrarMensaje(String mensaje) {
       // Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}
