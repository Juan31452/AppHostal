package com.example.apphostal.Logica.RopaSucia;

import android.content.Context;
import android.renderscript.Double4;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Entity.RopaSucia;

public class AdicionarRopaSucia {
    private DatabaseHotel dbHostal;
    private Context context;

    public AdicionarRopaSucia(Context context) {
        this.context = context;
        dbHostal = new DatabaseHotel(context);
    }

    public void insertarRopaSucia(RopaSucia ropaSucia) {

        try {
            String query = "INSERT INTO " + DatabaseHotel.TABLE_ROPA_SUCIA + " (" +
                    DatabaseHotel.ROPA_SUCIA_FECHA + ", " +
                    DatabaseHotel.ROPA_SUCIA_BAJERAS + ", " +
                    DatabaseHotel.ROPA_SUCIA_ENCIMERAS + ", " +
                    DatabaseHotel.ROPA_SUCIA_FUNDA_ALMOHADA + ", " +
                    DatabaseHotel.ROPA_SUCIA_PROTECTOR_ALMOHADA + ", " +
                    DatabaseHotel.ROPA_SUCIA_NORDICA  + ", " +
                    DatabaseHotel.ROPA_SUCIA_COLCHA_VERANO + ", " +
                     DatabaseHotel.ROPA_SUCIA_TOALLA_DUCHA + ", " +
                    DatabaseHotel.ROPA_SUCIA_TOALLA_LAVABO + ", " +
                    DatabaseHotel.ROPA_SUCIA_ALFOMBRIN + ", " +
                    DatabaseHotel.ROPA_SUCIA_PAID + ", " +
                    DatabaseHotel.ROPA_SUCIA_PROTECTOR_COLCHON + ", " +
                    DatabaseHotel.ROPA_SUCIA_RELLENO_NORDICO + ", " +
                    DatabaseHotel.ROPA_SUCIA_ENTREGADO + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? , ?)";

                   dbHostal.getWritableDatabase().execSQL(query, new String[]{
                           ropaSucia.getFecha(), String.valueOf(ropaSucia.getBajeras()), String.valueOf(ropaSucia.getEncimeras()), String.valueOf(ropaSucia.getFundaAlmohada()),
                           String.valueOf(ropaSucia.getProtectorAlmohada()), String.valueOf(ropaSucia.getNordica()), String.valueOf(ropaSucia.getColchaVerano()),
                           String.valueOf(ropaSucia.getToallaDucha()), String.valueOf(ropaSucia.getToallaLavabo()), String.valueOf(ropaSucia.getAlfombrin()),
                           String.valueOf(ropaSucia.getPaid()), String.valueOf(ropaSucia.getProtectorColchon()), String.valueOf(ropaSucia.getRellenoNordico()),ropaSucia.getEntregado()
                   });
            mostrarMensaje("Registro guardado correctamente");
            Log.d("RopaSucia", "RopaSucia guardada correctamente");
        } catch (Exception e) {
            mostrarMensaje("Error al guardar el registro: " + e.getMessage());
            Log.e("RopaSucia", "Error al guardar el registro: " + e.getMessage());
        } finally {
            // Cierra la base de datos cuando ya no se necesite
            dbHostal.close();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}
