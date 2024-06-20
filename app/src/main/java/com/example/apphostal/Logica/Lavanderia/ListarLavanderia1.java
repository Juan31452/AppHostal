package com.example.apphostal.Logica.Lavanderia;

import android.content.Context;
import android.database.Cursor;

import com.example.apphostal.Clases.BaseDataAccessor;
import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Entity.Lavanderia;

import java.util.List;

public class ListarLavanderia1 extends BaseDataAccessor<Lavanderia> {

    public ListarLavanderia1(Context context) {
        super(context);
    }

    @Override
    protected Lavanderia parseCursor(Cursor cursor) {
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
        int paid = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_PAID));
        int protectorColchon = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERIA_PROTECTOR_COLCHON));
        int rellenoNordico = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHotel.LAVANDERA_RELLENO_NORDICO));

        return new Lavanderia(id, fecha, bajeras, encimeras, fundaAlmohada, protectorAlmohada, nordica, colchaVerano, toallaDucha, toallaLavabo,
                alfombrin, paid, protectorColchon, rellenoNordico);
    }

    public List<Lavanderia> consultarLavanderia(){
        String query = "SELECT * FROM " + DatabaseHotel.TABLE_LAVANDERIA;
        List<Lavanderia> resultList = executeQuery(query, null);

        if (resultList.isEmpty()) {
            mostrarMensaje("No se encontraron datos en la Base de Datos");
        }

        return resultList;

    }
    public List<Lavanderia> consultarRegistroPorId(int itemId) {
        String consulta = "SELECT * FROM " + DatabaseHotel.TABLE_LAVANDERIA + " WHERE " + DatabaseHotel.LAVANDERIA_ID + " = ?";
        List<Lavanderia> resultList = executeQuery(consulta, new String[]{String.valueOf(itemId)});

        if (resultList.isEmpty()) {
            mostrarMensaje("No se encontraron datos para el registro con ID: " + itemId);
        }
        return resultList;
    }

}
