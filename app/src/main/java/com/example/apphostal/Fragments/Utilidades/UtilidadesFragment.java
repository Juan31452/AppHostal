package com.example.apphostal.Fragments.Utilidades;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.example.apphostal.Clases.CrearArchivo;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Registros.AdicionarRegistros;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class UtilidadesFragment extends Fragment {

    private Button btnExportar;
    private Button btnImportar;
    private Button btnMenu;
    private ListarRegistros1 listarRegistros1;
    private AdicionarRegistros adicionarRegistros;
    private static final int REQUEST_WRITE_STORAGE = 112;

    public static UtilidadesFragment newInstance() {
        return new UtilidadesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utlidades, container, false);

        btnExportar = view.findViewById(R.id.btnExportar);
        btnImportar = view.findViewById(R.id.btnImportar);
        btnMenu = view.findViewById(R.id.btnMenu);

        listarRegistros1 = new ListarRegistros1(requireContext());
        adicionarRegistros = new AdicionarRegistros(requireContext());

        btnExportar.setOnClickListener(v -> {

                    exportarArchivo();
                    AbrirArchivo();
                    //String contenidoCSV = LeerArchivo();
                    //Log.d("CSV", "Contenido del archivo:\n" + contenidoCSV);

        });


        btnImportar.setOnClickListener(v -> {
           // verificarYPedirPermisosDeAlmacenamiento();
            importarArchivo();
        });

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });



        return view;
    }


    private final ActivityResultLauncher<String[]> requestPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                boolean allGranted = true;
                for (Boolean granted : result.values()) {
                    allGranted &= granted;
                }
                if (allGranted) {
                    // Permisos concedidos, procede a leer/escribir archivos
                    exportarArchivo();
                } else {
                    // Permisos denegados, maneja la situación
                    Toast.makeText(getContext(), "Permisos denegados para leer/escribir en el almacenamiento externo", Toast.LENGTH_SHORT).show();
                    Log.d("Permisos denegados", "Permisos denegados para leer/escribir en el almacenamiento externo");
                }
            });

    private void exportarArchivo() {
        List<Registro> listaRegistros = listarRegistros1.consultarRegistrosTodo();
        if (listaRegistros != null && !listaRegistros.isEmpty()) {
            CrearArchivo.guardarCSV(requireContext(),listaRegistros);
        } else {
            Toast.makeText(requireContext(), "No hay registros para exportar", Toast.LENGTH_SHORT).show();
        }
    }

    private void importarArchivo() {
        List<Registro> listaRegistros = CrearArchivo.importarArchivoCSV(requireContext());
        if (listaRegistros != null && !listaRegistros.isEmpty()) {
            for (Registro registro : listaRegistros) {
                adicionarRegistros.insertarRegistro(registro);
            }
            Toast.makeText(requireContext(), "Registros importados con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "No se encontraron registros para importar", Toast.LENGTH_SHORT).show();
        }
    }

    private void AbrirArchivo(){
        CrearArchivo.abrirCSVConAppExterna(requireContext());
    }
    private String LeerArchivo(){
        String contenidoCSV = CrearArchivo.leerCSV(requireContext());
        Log.d("CSV", "Contenido del archivo: " + contenidoCSV);
        return contenidoCSV;
    }
}
