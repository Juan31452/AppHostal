package com.example.apphostal.Logica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Clases.Extras;
import com.example.apphostal.Database.DatabaseHotel;


public class ListarExtras {
    private DatabaseHotel dbHostal;
    private Context context;

    public ListarExtras(Context context) {
        dbHostal = new DatabaseHotel(context);
        this.context = context;
    }

    public Extras consultarExtras(String registroId) {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;
        Extras extras = null;

        try {
            String query = "SELECT * FROM " + DatabaseHotel.TABLE_EXTRAS +
                    " WHERE " + DatabaseHotel.COLUMN_REGISTRO_ID + " = ?";
            cursor = db.rawQuery(query, new String[]{registroId});

            // Verificar si se encontraron resultados
            if (cursor != null && cursor.moveToFirst()) {
                // Crear una instancia del objeto Extras y llenarlo con los datos obtenidos
                extras = new Extras(
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_REGISTRO_ID)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_AGUA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAPELH)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_CAFEN)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_CAFEC)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_LECHE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TE_MANZANILLA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TE_NEGRO)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_GALLETAS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_AZUCAR)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_SACARINA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_MAQUILLAJE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_DULCE_EXTRA))
                );

                // Mostrar los valores en Log para depuración
                Log.d("Datos de extras", extras.toString());
            } else {
                // No se encontraron resultados
                mostrarMensaje("No se encontraron datos para el registroId: " + registroId);
            }
        } catch (Exception e) {
            mostrarMensaje("Error al consultar datos extras: " + e.getMessage());
        } finally {
            // Cerrar el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return extras;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
