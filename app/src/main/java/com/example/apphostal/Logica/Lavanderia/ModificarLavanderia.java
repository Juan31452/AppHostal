package com.example.apphostal.Logica.Lavanderia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;
import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Entity.Lavanderia;

public class ModificarLavanderia {
    private DatabaseHotel dbHostal;
    private Context context;


    public ModificarLavanderia(Context context) {
        dbHostal = new DatabaseHotel(context); // Inicializar dbHostal
        this.context = context;
    }


    public void modificarRegistro(Lavanderia lavanderia) {
        SQLiteDatabase db = dbHostal.getWritableDatabase();
        Log.d("ModificarRegistro", "Base de datos abierta: " + db.isOpen());

        ContentValues values = new ContentValues();
        Log.d("DESDECLASEModificarRegistro", "Lavanderia: " + lavanderia.toString());
        values.put(DatabaseHotel.LAVANDERIA_ID, lavanderia.getId());
        values.put(DatabaseHotel.LAVANDERIA_BAJERAS, lavanderia.getBajera());
        values.put(DatabaseHotel.LAVANDERIA_ENCIMERAS, lavanderia.getEncimera());
        values.put(DatabaseHotel.LAVANDERIA_FUNDA_ALMOHADA, lavanderia.getFundaA());
        values.put(DatabaseHotel.LAVANDERIA_PROTECTOR_ALMOHADA, lavanderia.getProtectorA());
        values.put(DatabaseHotel.LAVANDERIA_NORDICA, lavanderia.getNordica());
        values.put(DatabaseHotel.LAVANDERIA_COLCHA_VERANO, lavanderia.getColchav());
        values.put(DatabaseHotel.LAVANDERIA_TOALLA_DUCHA, lavanderia.getToallaD());
        values.put(DatabaseHotel.LAVANDERIA_TOALLA_LAVABO, lavanderia.getToallaL());
        values.put(DatabaseHotel.LAVANDERIA_ALFOMBRIN, lavanderia.getAlfombrin());
        values.put(DatabaseHotel.LAVANDERIA_PAID, lavanderia.getPaid());
        values.put(DatabaseHotel.LAVANDERIA_PROTECTOR_COLCHON, lavanderia.getProtectorC());
        values.put(DatabaseHotel.LAVANDERA_RELLENO_NORDICO, lavanderia.getRellenoN());

        String selection = DatabaseHotel.LAVANDERIA_ID + " = ?";
        String[] selectionArgs = {String.valueOf(lavanderia.getId())};
        Log.d("ModificarRegistro", "Registro a modificar: " + lavanderia.getId());
        int count = db.update(DatabaseHotel.TABLE_LAVANDERIA, values, selection, selectionArgs);
        if (count > 0) {
            Log.d("ModificarRegistro", "Registro actualizado correctamente.");
            mostrarMensaje("Registro actualizado correctamente");

        } else {
            Log.d("ModificarRegistro", "Error al actualizar el registro.");
            mostrarMensaje("Error al actualizar el registro");

        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}