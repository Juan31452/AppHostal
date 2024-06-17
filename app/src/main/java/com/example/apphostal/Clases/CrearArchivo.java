package com.example.apphostal.Clases;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.apphostal.Entity.Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
                Log.d("Id", registro.getFecha());
                fos.write(lineaCSV.getBytes());
            }

            fos.close();

            // Mostrar mensaje de éxito usando Toast
            Toast.makeText(context, "Archivo creado con éxito", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error al crear el archivo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("Error al crear el archivo: " , e.getMessage());
        }
    }

    public static List<Registro> importarArchivoCSV(Context context) {
        List<Registro> listaRegistros = new ArrayList<>();
        File csvFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "registrosImportar.csv");

        if (csvFile.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                String line;
                // Saltar encabezado
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Registro registro = new Registro(
                            getValueOrZero(values, 0), // Fecha
                            getValueOrZeroForHabitacion(values, 1), // Habitación
                            getValueOrZero(values, 2), // Estado
                            getValueOrZero(values, 3), // Bajera
                            getValueOrZero(values, 4), // Encimera
                            getValueOrZero(values, 5), // Funda Almohada
                            getValueOrZero(values, 6), // Protector Almohada
                            getValueOrZero(values, 7), // Nórdica
                            getValueOrZero(values, 8), // Colcha Verano
                            getValueOrZero(values, 9), // Toalla Ducha
                            getValueOrZero(values, 10), // Toalla Lavabo
                            getValueOrZero(values, 11), // Alfombrín
                            getValueOrZero(values, 12), // Paid
                            getValueOrZero(values, 13), // Protector Colchón
                            getValueOrZero(values, 14)  // Relleno Nórdico
                    );
                    listaRegistros.add(registro);
                    Log.d("ListaRegistros", listaRegistros.toString());

                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, "Error al importar el archivo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error al importar el archivo: " , e.getMessage());
            }
        } else {
            Toast.makeText(context, "El archivo no existe", Toast.LENGTH_SHORT).show();
        }

        return listaRegistros;
    }

    private static String getValueOrZero(String[] values, int index) {
        if (index < values.length && values[index] != null && !values[index].isEmpty()) {
            return values[index];
        }
        return "0";
    }

    private static String getValueOrZeroForHabitacion(String[] values, int index) {
        String value = getValueOrZero(values, index);
        if (value.equals("2")) {
            return "002";
        }
        return value;
    }

}
