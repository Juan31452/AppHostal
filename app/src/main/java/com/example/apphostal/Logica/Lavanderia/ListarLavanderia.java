package com.example.apphostal.Logica.Lavanderia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Entity.Registro;

import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ListarLavanderia {
    private DatabaseHotel dbHostal;
    private Context context;
    private static List<Lavanderia> lavanderia;
    private List<Lavanderia> lavanderiaList;

    public ListarLavanderia(Context context) {
        this.dbHostal = new DatabaseHotel(context);
        this.context = context;
        this.lavanderia = new ArrayList<>();
    }

    public List<Lavanderia> consultarLavanderia() {
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;
        List<Lavanderia> lavanderiaList = new ArrayList<>();

        try {

            String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_LAVANDERIA + " LIMIT 20";
            cursor = db.rawQuery(consulta, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_ID));
                    String fecha = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_FECHA));
                    int bajeras = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_BAJERAS));
                    int encimeras = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_ENCIMERAS));
                    int fundaAlmohada = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_FUNDA_ALMOHADA));
                    int protectorAlmohada = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_PROTECTOR_ALMOHADA));
                    int nordica = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_NORDICA));
                    int colchaVerano = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_COLCHA_VERANO));
                    int toallaDucha = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_TOALLA_DUCHA));
                    int toallaLavabo = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_TOALLA_LAVABO));
                    int alfombrin = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_ALFOMBRIN));
                    int protectorColchon = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_PROTECTOR_COLCHON));
                    int rellenoNordico = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERA_RELLENO_NORDICO));

                    // Cambia el nombre de la variable para evitar la colisión
                    Lavanderia lavanderiaItem = new Lavanderia(id, fecha, bajeras, encimeras, fundaAlmohada,
                            protectorAlmohada, nordica, colchaVerano, toallaDucha, toallaLavabo,
                            alfombrin, protectorColchon, rellenoNordico);

                    lavanderiaList.add(lavanderiaItem); // Agrega el objeto a la lista
                    Log.d("Datos del registro", lavanderiaItem.toString());

                } while (cursor.moveToNext());
            } else {
                mostrarMensaje("No se encontraron datos para los registros.");
            }
        } catch (Exception e) {
            // Imprime el mensaje completo de la excepción para depuración
            e.printStackTrace();
            mostrarMensaje("Error al consultar datos de los registros: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return lavanderiaList;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
