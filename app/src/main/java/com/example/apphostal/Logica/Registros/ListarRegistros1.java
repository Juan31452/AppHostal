package com.example.apphostal.Logica.Registros;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Clases.ConteoRegistros;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Database.DatabaseHotel;

import java.util.ArrayList;
import java.util.List;

public class ListarRegistros1 {

    private static DatabaseHotel dbHostal;
    private static Context context;
    private static List<Registro> registros;

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
    @SuppressLint("Range")
    public static ConteoRegistros consultarRecuentoPorRangoDeFecha(String fechaInicio, String fechaFin) {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;
        ConteoRegistros conteoregistros = null;

        try {
            // Consulta para obtener el recuento de cada columna dentro del rango de fechas
            String consulta = "SELECT " +
                    "SUM(" + DatabaseHotel.COLUMN_BAJERAS + ") AS count_bajeras, " +
                    "SUM(" + DatabaseHotel.COLUMN_ENCIMERAS + ") AS count_encimeras, " +
                    "SUM(" + DatabaseHotel.COLUMN_FUNDA_ALMOHADA + ") AS count_funda_alomohada, " +
                    "SUM(" + DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA + ") AS count_protector_alomohada, " +
                    "SUM(" + DatabaseHotel.COLUMN_NORDICA + ") AS count_nordica, " +
                    "SUM(" + DatabaseHotel.COLUMN_COLCHA_VERANO + ") AS count_colcha_verano, " +
                    "SUM(" + DatabaseHotel.COLUMN_TOALLA_DUCHA + ") AS count_toalla_ducha, " +
                    "SUM(" + DatabaseHotel.COLUMN_TOALLA_LAVABO + ") AS count_toalla_lavabo, " +
                    "SUM(" + DatabaseHotel.COLUMN_ALFOMBRIN + ") AS count_alfombrin, " +
                    "SUM(" + DatabaseHotel.COLUMN_PAID + ") AS count_paid, " +
                    "SUM(" + DatabaseHotel.COLUMN_PROTECTOR_COLCHON + ") AS count_protector_colchon " +
                    "FROM " + DatabaseHotel.TABLE_REGISTROS +
                    " WHERE " + DatabaseHotel.COLUMN_FECHA + " BETWEEN ? AND ?";
            cursor = db.rawQuery(consulta, new String[]{fechaInicio, fechaFin});

            // Verificar si se encontraron resultados
            if (cursor != null && cursor.moveToFirst()) {
                // Obtener el recuento de cada columna
                conteoregistros = new ConteoRegistros();
                conteoregistros.setCountBajeras(cursor.getInt(cursor.getColumnIndex("count_bajeras")));
                conteoregistros.setCountEncimeras(cursor.getInt(cursor.getColumnIndex("count_encimeras")));
                conteoregistros.setCountFundaAlmohada(cursor.getInt(cursor.getColumnIndex("count_funda_alomohada")));
                conteoregistros.setCountProtectorAlmohada(cursor.getInt(cursor.getColumnIndex("count_protector_alomohada")));
                conteoregistros.setCountNordica(cursor.getInt(cursor.getColumnIndex("count_nordica")));
                conteoregistros.setCountColchaVerano(cursor.getInt(cursor.getColumnIndex("count_colcha_verano")));
                conteoregistros.setCountToallaDucha(cursor.getInt(cursor.getColumnIndex("count_toalla_ducha")));
                conteoregistros.setCountToallaLavabo(cursor.getInt(cursor.getColumnIndex("count_toalla_lavabo")));
                conteoregistros.setCountAlfombrin(cursor.getInt(cursor.getColumnIndex("count_alfombrin")));
                conteoregistros.setCountPaid(cursor.getInt(cursor.getColumnIndex("count_paid")));
                conteoregistros.setCountProtectorColchon(cursor.getInt(cursor.getColumnIndex("count_protector_colchon")));
            } else {
                mostrarMensaje("No se encontraron registros para el rango de fechas.");
            }
        } catch (Exception e) {
            mostrarMensaje("Error al consultar el recuento de registros por rango de fechas: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return conteoregistros;
    }

    public List<Registro> getRegistros() {

        return registros;
    }


    private static void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}