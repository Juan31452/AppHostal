package com.example.apphostal.Logica.Lavanderia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;

public class EliminarLavanderia {
    private DatabaseHotel dbHostal;
    private Context context;

    public EliminarLavanderia(Context context) {
        dbHostal = new DatabaseHotel(context); // Inicializar dbHostal
    }

    public void eliminarRegistro(int idLavanderia) {
        SQLiteDatabase db = null;
        this.context = context;

        try {
            db = dbHostal.getWritableDatabase();
            db.execSQL("DELETE FROM Lavanderia WHERE _id_lavanderia = ?", new Object[]{idLavanderia});
            Log.d("EliminarLavanderia", "Registro eliminado con ID: " + idLavanderia);
            mostrarMensaje("Registro Eliminado correctamente");
        } catch (Exception e) {
            Log.e("EliminarLavanderia", "Error al eliminar el registro con ID: " + idLavanderia, e);
            mostrarMensaje("Error al Eliminar Registro");
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
