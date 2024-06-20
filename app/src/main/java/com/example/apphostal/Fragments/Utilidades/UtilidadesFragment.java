package com.example.apphostal.Fragments.Utilidades;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.apphostal.Clases.CrearArchivo;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Registros.AdicionarRegistros;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class UtilidadesFragment extends Fragment {

    private static final int CodigodePermisoAlmacenamiento = 1;

    private Button btnExportar;
    private Button btnImportar;
    private Button btnMenu;
    private ListarRegistros1 listarRegistros1;
    private AdicionarRegistros adicionarRegistros;

    private ActivityResultLauncher<String> requestPermissionLauncher;

    public static UtilidadesFragment newInstance() {
        return new UtilidadesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                // Permiso concedido
                permisoDeAlmacenamientoConcedido();
            } else {
                // Permiso denegado
                permisoDeAlmacenamientoDenegado();
            }
        });
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
            verificarYPedirPermisosDeAlmacenamiento(() -> exportarArchivo());
        });

        btnImportar.setOnClickListener(v -> {
            verificarYPedirPermisosDeAlmacenamiento(() -> importarArchivo());
        });

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void verificarYPedirPermisosDeAlmacenamiento(Runnable onPermissionGranted) {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Si no tiene permisos, pedimos permisos
            requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            // Si ya tiene permisos, ejecutar lo necesario
            onPermissionGranted.run();
        }
    }

    private void permisoDeAlmacenamientoConcedido() {
        // Aquí puedes colocar cualquier acción que requiera el permiso
        Toast.makeText(requireContext(), "Permiso concedido", Toast.LENGTH_SHORT).show();
        importarArchivo();
    }

    private void permisoDeAlmacenamientoDenegado() {
        // Aquí puedes colocar cualquier acción que necesites tomar si el permiso es denegado
        Toast.makeText(requireContext(), "Permiso denegado", Toast.LENGTH_SHORT).show();
    }

    private void exportarArchivo() {
        List<Registro> listaRegistros = listarRegistros1.consultarRegistrosTodo();
        if (listaRegistros != null && !listaRegistros.isEmpty()) {
            CrearArchivo.crearArchivoCSV(requireContext(), listaRegistros);
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
}
