package com.example.apphostal.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.apphostal.Clases.CrearArchivo;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class UtlidadesFragment extends Fragment {

    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    private Button btnExportar;
    private Button btnMenu;
    private ListarRegistros1 listarRegistros1;

    public UtlidadesFragment() {
        // Required empty public constructor
    }

    public static UtlidadesFragment newInstance() {
        return new UtlidadesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utlidades, container, false);

        btnExportar = view.findViewById(R.id.btnExportar);
        btnMenu = view.findViewById(R.id.btnMenu);

        // Inicializar la clase ListarRegistros1
        listarRegistros1 = new ListarRegistros1(requireContext());



        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPermissionAndWriteFile();
                Log.d("checkPermissionAndWriteFile", "checkPermissionAndWriteFile");
            }
        });

        btnMenu.setOnClickListener(v -> {
            // Cerrar la actividad actual y volver a abrir MainActivity
            requireActivity().finish();
            startActivity(new Intent(requireContext(), MainActivity.class));
        });

        return view;
    }

    private void checkPermissionAndWriteFile() {
        // Verificar si el permiso WRITE_EXTERNAL_STORAGE está concedido
        Log.d("checkPermissionAndWriteFile", "checkPermissionAndWriteFile");
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Si el permiso no está concedido, solicitarlo al usuario
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_EXTERNAL_STORAGE);
        } else {
            // Si el permiso está concedido, proceder con la operación de escritura
            exportarArchivo();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, proceder con la acción que requiere permisos
                Log.d("Fragment", "WRITE_EXTERNAL_STORAGE permission granted");
                // Llamar a tu método para escribir el archivo aquí
                // ExportarRegistros();
            } else {
                // Permiso denegado
                Log.d("Fragment", "WRITE_EXTERNAL_STORAGE permission denied");
                Toast.makeText(requireContext(), "Permiso de escritura denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void exportarArchivo() {
        List<Registro> listaRegistros = listarRegistros1.consultarRegistrosTodo();
        Log.d("Registros", listaRegistros.toString());
        if (listaRegistros != null && !listaRegistros.isEmpty()) {
            CrearArchivo.crearArchivoCSV(requireContext(), listaRegistros);
        } else {
            Toast.makeText(requireContext(), "No hay registros para exportar", Toast.LENGTH_SHORT).show();
        }
    }


}
