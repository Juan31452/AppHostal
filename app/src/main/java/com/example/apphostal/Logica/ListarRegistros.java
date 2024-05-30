package com.example.apphostal.Logica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.apphostal.Database.DatabaseHotel;

import java.util.ArrayList;
import java.util.List;

public class ListarRegistros {
    private DatabaseHotel dbHostal;

    public ListarRegistros(Context context) {
        // Inicializar la instancia de DatabaseHotel
        dbHostal = new DatabaseHotel(context);
    }

    // Método para obtener una lista de registros desde la base de datos
    public List<String> obtenerRegistros() {
        List<String> listaRegistros = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            // Obtener una instancia de lectura de la base de datos
            db = dbHostal.getReadableDatabase();

            // Definir la consulta SQL
            String consulta = "SELECT r.*, e.* FROM " + DatabaseHotel.TABLE_REGISTROS + " r LEFT JOIN " + DatabaseHotel.TABLE_EXTRAS +
                    " e ON r." + DatabaseHotel.COLUMN_ID + " = e." + DatabaseHotel.COLUMN_REGISTRO_ID;


            // Ejecutar la consulta
            cursor = db.rawQuery(consulta, null);

            // Iterar sobre los resultados y agregarlos a la lista de registros
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    // Obtener los valores de las columnas
                    String idRegistro = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ID));
                    String fecha = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FECHA));
                    String habitacion = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_HABITACION));
                    String estado = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ESTADO));
                    String bajera = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_BAJERAS));
                    String encimera = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ENCIMERAS));
                    String fundaA = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FUNDA_ALMOHADA));
                    String protectorA = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA));
                    String nordica = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_NORDICA));
                    String toallaD = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_DUCHA));
                    String toallaL = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_LAVABO));
                    String alfombrin = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ALFOMBRIN));
                    String paid = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAID));
                    String protectorC = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_COLCHON));

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

                    // Imprimir los valores de ambas tablas
                    Log.d("Datos del registro y extras", registroid + ", " + agua + ", " + papelH + ", " + cafeN + ", " + cafeC + ", " + leche + ", " +
                            teManzanilla + ", " + teNegro + ", " + galletas + ", " + azucar + ", " + sacarina + ", " +
                            maquillaje + ", " + dulceExtra);

                    // Construir una cadena con los valores obtenidos
                    String registro = idRegistro + "," + fecha + "," + habitacion + "," + estado + "," + bajera + "," + encimera + "," + fundaA + "," +
                            protectorA + "," + nordica + "," + toallaD + "," + toallaL + "," + alfombrin + "," +
                            paid + "," + protectorC;

                    // Agregar el registro a la lista
                    listaRegistros.add(registro);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada
        } finally {
            // Cerrar el cursor y la conexión de la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        // Retornar la lista de registros
        return listaRegistros;
    }

    // Método para obtener registros por fecha
    public List<String> obtenerRegistrosPorFecha(String fecha) {
        List<String> listaRegistros = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            // Obtener una instancia de lectura de la base de datos
            db = dbHostal.getReadableDatabase();

            // Definir la consulta SQL para buscar por fecha
            String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_REGISTROS + " WHERE " + DatabaseHotel.COLUMN_FECHA + " = ?";

            // Ejecutar la consulta
            cursor = db.rawQuery(consulta, new String[]{fecha});

            // Iterar sobre los resultados y agregarlos a la lista de registros
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    // Obtener los valores de las columnas
                    String idRegistro = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ID));
                    fecha = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FECHA));
                    String habitacion = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_HABITACION));
                    String estado = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ESTADO));
                    String bajera = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_BAJERAS));
                    String encimera = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ENCIMERAS));
                    String fundaA = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_FUNDA_ALMOHADA));
                    String protectorA = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_ALMOHADA));
                    String nordica = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_NORDICA));
                    String toallaD = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_DUCHA));
                    String toallaL = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_TOALLA_LAVABO));
                    String alfombrin = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_ALFOMBRIN));
                    String paid = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PAID));
                    String protectorC = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.COLUMN_PROTECTOR_COLCHON));

                    String registro = idRegistro + "," + fecha + "," + habitacion + "," + estado + "," + bajera + "," + encimera + "," + fundaA + "," +
                            protectorA + "," + nordica + "," + toallaD + "," + toallaL + "," + alfombrin + "," +
                            paid + "," + protectorC;

                    // Agregar el registro a la lista
                    listaRegistros.add(registro);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada
        } finally {
            // Cerrar el cursor y la conexión de la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        // Retornar la lista de registros
        return listaRegistros;
    }
}
