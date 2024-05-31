package com.example.apphostal.Logica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Database.DatabaseHotel;

import java.util.ArrayList;
import java.util.List;

public class ListarRegistros1 {

    private DatabaseHotel dbHostal;
    private Context context;
    private List<Registro> registros;

    public ListarRegistros1(Context context) {
        dbHostal = new DatabaseHotel(context);
        this.context = context;
        this.registros = new ArrayList<>();
    }

    public void consultarRegistros() {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;

        try {
            String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_REGISTROS;

            // Ejecutar la consulta
            cursor = db.rawQuery(consulta, null);

            // Verificar si se encontraron resultados
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    // Crear una instancia del objeto Registro y llenarlo con los datos obtenidos
                    Registro registro = new Registro(
                            cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FECHA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_HABITACION)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ESTADO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_BAJERAS)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ENCIMERAS)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FUNDA_ALMOHADA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_NORDICA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_COLCHA_VERANO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_DUCHA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_LAVABO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ALFOMBRIN)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_COLCHON))
                    );

                    // Añadir el registro a la lista
                    registros.add(registro);

                    // Mostrar los valores en Log para depuración
                    Log.d("Datos del registro", registro.toString());
                } while (cursor.moveToNext());
            } else {
                // No se encontraron resultados
                mostrarMensaje("No se encontraron datos para los registros.");
            }
        } catch (Exception e) {
            mostrarMensaje("Error al consultar datos de los registros: " + e.getMessage());
        } finally {
            // Cerrar el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    public void consultarRegistrosPorFecha(String fecha) {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;
        registros.clear(); // Limpiar la lista de registros antes de la nueva consulta

        try {
            String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_REGISTROS +
                    " WHERE " + DatabaseHotel.COLUMN_FECHA + " = ?";

            // Ejecutar la consulta con el parámetro de fecha
            cursor = db.rawQuery(consulta, new String[]{fecha});

            // Verificar si se encontraron resultados
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    // Crear una instancia del objeto Registro y llenarlo con los datos obtenidos
                    Registro registro = new Registro(
                            cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FECHA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_HABITACION)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ESTADO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_BAJERAS)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ENCIMERAS)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FUNDA_ALMOHADA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_NORDICA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_COLCHA_VERANO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_DUCHA)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_LAVABO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ALFOMBRIN)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_COLCHON))
                    );

                    // Añadir el registro a la lista
                    registros.add(registro);

                    // Mostrar los valores en Log para depuración
                    Log.d("Datos del registro", registro.toString());
                } while (cursor.moveToNext());
            } else {
                // No se encontraron resultados
                mostrarMensaje("No se encontraron datos para la fecha: " + fecha);
            }
        } catch (Exception e) {
            mostrarMensaje("Error al consultar datos de los registros por fecha: " + e.getMessage());
        } finally {
            // Cerrar el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
