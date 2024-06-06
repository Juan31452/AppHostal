package com.example.apphostal.Logica.Registros;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.apphostal.Database.DatabaseHotel;

public class EliminarRegistros {
    private DatabaseHotel dbHostal;

    public EliminarRegistros(Context context) {
        // Inicializar la instancia de DatabaseHotel
        dbHostal = new DatabaseHotel(context);
    }

    // Método para eliminar un registro por fecha y habitación
    public boolean eliminarRegistro(String fecha, String habitacion) {
        SQLiteDatabase db = null;

        try {
            // Obtener una instancia de escritura de la base de datos
            db = dbHostal.getWritableDatabase();

            // Definir la cláusula WHERE y los argumentos
            String whereClause = DatabaseHotel.COLUMN_FECHA + " = ? AND " + DatabaseHotel.COLUMN_HABITACION + " = ?";
            String[] whereArgs = { fecha, habitacion };

            // Ejecutar la eliminación
            int rowsDeleted = db.delete(DatabaseHotel.TABLE_REGISTROS, whereClause, whereArgs);

            // Retornar verdadero si se eliminó al menos una fila
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada
            return false;
        } finally {
            // Cerrar la conexión de la base de datos
            if (db != null) {
                db.close();
            }
        }
    }
}
