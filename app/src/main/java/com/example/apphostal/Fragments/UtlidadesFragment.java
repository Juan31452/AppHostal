package com.example.apphostal.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Clases.CrearArchivo;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class UtlidadesFragment extends Fragment {

private ListarRegistros1 listarRegistros1;
private CrearArchivo crearArchivo;
    private List<Registro> dataList;
private Button btnExportar,btnMenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utlidades, container, false);

        btnExportar = view.findViewById(R.id.btnExportar);
        btnMenu=view.findViewById(R.id.btnMenu);

        // Inicializar la clase ListarRegistros1
        listarRegistros1 = new ListarRegistros1(requireContext());


        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método para consultar registros y obtener la lista
                List<Registro> listaRegistros = listarRegistros1.consultarRegistrosTodo();

                if (listaRegistros != null && !listaRegistros.isEmpty()) {
                    CrearArchivo.crearArchivoCSV(requireContext(), listaRegistros); // Llama al método estático para crear el archivo CSV
                } else {
                    // Manejo si la lista está vacía o es null
                    Toast.makeText(requireContext(), "No hay registros para exportar", Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad actual y volver a abrirla
                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return view;
    }

    public static UtlidadesFragment newInstance() {
        UtlidadesFragment fragment = new UtlidadesFragment();
        return fragment;
    }
}