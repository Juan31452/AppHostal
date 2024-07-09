package com.example.apphostal.Clases;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.example.apphostal.Entity.Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




public class CrearArchivo {


    public static void guardarCSV(Context context, List<Registro> listaRegistros) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Fecha,Habitacion,Estado,Bajeras,Encimeras,FundaAlmohada,ProtectorAlmohada,Nordica,ColchaVerano,ToallaDucha,ToallaLavabo," +
                "Alfombrin,Paid,ProtectorColchon,RellenoNordico\n"); // Encabezados

        for (Registro registro : listaRegistros) {
            csvContent.append(registro.getFecha()).append(",")
                    .append(registro.getHabitacion()).append(",")
                    .append(registro.getEstado()).append(",")
                    .append(registro.getBajera()).append(",")
                    .append(registro.getEncimera()).append(",")
                    .append(registro.getFundaA()).append(",")
                    .append(registro.getProtectorA()).append(",")
                    .append(registro.getNordica()).append(",")
                    .append(registro.getColchav()).append(",")
                    .append(registro.getToallaD()).append(",")
                    .append(registro.getToallaL()).append(",")
                    .append(registro.getAlfombrin()).append(",")
                    .append(registro.getPaid()).append(",")
                    .append(registro.getProtectorC()).append(",")
                    .append(registro.getRellenoN()).append(",")
                    .append("\n"); // Añade un salto de línea al final de cada registro

              }

        String fileName = "registros.csv";

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(csvContent.toString().getBytes());
            fileOutputStream.close();
            // Obtener y mostrar la ruta del archivo
            File file = context.getFileStreamPath(fileName);
            String filePath = file.getAbsolutePath();
            Log.d("CSV", "Archivo guardado correctamente en: " + filePath);
        } catch (IOException e) {
            Log.e("CSV", "Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static String leerCSV(Context context) {
        // Leer el archivo CSV
        String fileName = "registros.csv";
        StringBuilder contenido = new StringBuilder();
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contenido.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            Log.e("CSV", "Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }

    public static void abrirCSVConAppExterna(Context context) {
        String fileName = "registros.csv";
        File file = new File(context.getFilesDir(), fileName);
        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "text/csv");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Crear un intent para mostrar el selector de aplicaciones
        Intent chooserIntent = Intent.createChooser(intent, "Selecciona una aplicación para abrir el CSV");

        // Asegurarse de que el intent se pueda resolver a una actividad
        if (chooserIntent.resolveActivity(context.getPackageManager()) != null) {
            try {
                context.startActivity(chooserIntent);
            } catch (ActivityNotFoundException e) {
                Log.e("CSV", "No se pudo abrir el selector de aplicaciones", e);
                Toast.makeText(context, "No se pudo abrir el selector de aplicaciones", Toast.LENGTH_LONG).show();
            }
        } else {
            Log.e("CSV", "No se encontró una aplicación para abrir CSV");
            Toast.makeText(context, "No se encontró una aplicación para abrir archivos CSV", Toast.LENGTH_LONG).show();
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
