package com.example.apphostal.Clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataAccessor<T> {

    protected DatabaseHotel dbHelper;
    protected Context context;

    public BaseDataAccessor(Context context) {
        this.context = context;
        dbHelper = new DatabaseHotel(context);
    }

    protected abstract T parseCursor(Cursor cursor);

    protected List<T> executeQuery(String query, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<T> resultList = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(query, selectionArgs);
            if (cursor.moveToFirst()) {
                do {
                    resultList.add(parseCursor(cursor));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            // Manejar errores
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return resultList;
    }

    protected void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
