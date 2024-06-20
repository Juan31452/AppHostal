package com.example.apphostal.Logica.RopaSucia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Entity.RopaSucia;


import java.util.ArrayList;
import java.util.List;

public class ListarRopaSucia {
    private static DatabaseHotel dbHostal;
    private static Context context;
    private static List<RopaSucia> ropasucia;

    public ListarRopaSucia(Context context){
        this.dbHostal = new DatabaseHotel(context);
        this.context = context;
        this.ropasucia = new ArrayList<>();

    }

    public List<RopaSucia> ConsultarRopaSucia(){
        SQLiteDatabase db = dbHostal.getReadableDatabase();
        Cursor cursor = null;
        List<RopaSucia> ropaSuciaList = new ArrayList<>();

        try {

            String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_ROPA_SUCIA;
            cursor = db.rawQuery(consulta, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_ID));
                    String fecha = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_FECHA));
                    int bajeras = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_BAJERAS));
                    int encimeras = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_ENCIMERAS));
                    int funda_a = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_FUNDA_ALMOHADA));
                    int protector_a = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_PROTECTOR_ALMOHADA));
                    int nordicante = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_NORDICA));
                    int colcha_v = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_COLCHA_VERANO));
                    int toalla_d = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_TOALLA_DUCHA));
                    int toalla_l = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_TOALLA_LAVABO));
                    int alfombrin = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_ALFOMBRIN));
                    int paid = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_PAID));
                    int protector_c = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_PROTECTOR_COLCHON));
                    int relleno_n = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_RELLENO_NORDICO));
                    String entregado = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHotel.ROPA_SUCIA_ENTREGADO));

                    RopaSucia ropaSuciaItem = new RopaSucia(id, fecha, bajeras, encimeras, funda_a, protector_a, nordicante, colcha_v,toalla_d,toalla_l,
                            alfombrin,paid,protector_c,relleno_n,entregado);
                    ropaSuciaList.add(ropaSuciaItem);

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
        return ropaSuciaList;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}
