package com.example.apphostal.Clases;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CrearArchivo {

    public static void crearArchivoCSV(Context context, List<Registro> listaRegistros) {
        // Crear un archivo CSV en la memoria externa pública (directorio de descargas)
        File csvFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "registros.csv");

        try {
            FileOutputStream fos = new FileOutputStream(csvFile);

            // Escribir encabezados CSV (opcional)
            fos.write("Fecha,Habitacion,Estado,Bajeras,Encimeras,FundaAlmohada,ProtectorAlmohada,Nordica,ColchaVerano,ToallaDucha,ToallaLavabo,Alfombrin,Paid,ProtectorColchon,RellenoNordico\n".getBytes());

            // Iterar sobre la lista de Registros y escribir cada registro como línea CSV
            for (Registro registro : listaRegistros) {
                String lineaCSV = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        registro.getFecha(), registro.getHabitacion(), registro.getEstado(),
                        registro.getBajera(), registro.getEncimera(), registro.getFundaA(),
                        registro.getProtectorA(), registro.getNordica(), registro.getColchav(),
                        registro.getToallaD(), registro.getToallaL(), registro.getAlfombrin(),
                        registro.getPaid(), registro.getProtectorC(), registro.getRellenoN());

                fos.write(lineaCSV.getBytes());
            }

            fos.close();

            // Mostrar mensaje de éxito usando Toast
            Toast.makeText(context, "Archivo creado con éxito", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error al crear el archivo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
