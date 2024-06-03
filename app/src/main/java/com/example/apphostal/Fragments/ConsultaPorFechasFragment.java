package com.example.apphostal.Fragments;




import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.ConteoRegistros;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.ListarRegistros1;
import com.example.apphostal.R;

import java.util.ArrayList;
import java.util.List;


public class ConsultaPorFechasFragment extends Fragment {

    private EditText edfechainicial, edfechafinal, tresultados;

    private ListarRegistros1 listarRegistros1;
    //private ListView listViewConsulta;
    private Button btnbuscar,btnFragmentCerrar;
    private List<String> detalles;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consulta_por_fechas, container, false);

        // Inicializar EditTexts y Botones
        edfechainicial = view.findViewById(R.id.edfechainicial);
        edfechafinal = view.findViewById(R.id.edfechafinal);
        btnbuscar = view.findViewById(R.id.btnbuscar);
        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);
        TextView txtLista = view.findViewById(R.id.txtLista);
        //listViewConsulta = view.findViewById(R.id.listViewConsulta);

        // Crear una instancia de ListarRegistros1
        listarRegistros1 = new ListarRegistros1(getActivity());
        ConteoRegistros conteoregistros = new ConteoRegistros();

        // Configurar listener para el botón buscar
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener las fechas de los EditText
                String fechaInicio = edfechainicial.getText().toString();
                String fechaFin = edfechafinal.getText().toString();

                List<String> detalles = new ArrayList<>();
                // Obtener la lista de registros

                // Llamar al método consultarRecuentoPorRangoDeFecha de ListarRegistros1
                ConteoRegistros conteoregistros = ListarRegistros1.consultarRecuentoPorRangoDeFecha(fechaInicio, fechaFin);

                // Obtener la lista de registros
                List<Registro> registros = listarRegistros1.getRegistros();

                // Crear un adaptador para mostrar los registros en el ListView
               // ConteoRegistrosAdapter adapter = new ConteoRegistrosAdapter(getContext(), registros);
                //listViewConsulta.setAdapter(adapter);

                Log.d("Datos conteoregistros ", conteoregistros.toString());
                Log.d("registros ", registros.toString());

                TextView txtLista = view.findViewById(R.id.txtLista);
                txtLista.setText(conteoregistros.toString());


            }
        });
                // Configurar listener para los EditTexts
                edfechainicial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mostrarCalendario(v);
                    }
                });

                edfechafinal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mostrarCalendario(v);
                    }
                });

        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el FragmentManager y quitar el fragment actual
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(ConsultaPorFechasFragment.this).commit();
            }
        });


                return view;
            }

            // Método para manejar el clic en los EditTexts desde el XML
            public void mostrarCalendario(View view) {
                if (view.getId() == R.id.edfechainicial) {
                    Calendario.mostrarCalendario(getActivity(), edfechainicial);
                } else if (view.getId() == R.id.edfechafinal) {
                    Calendario.mostrarCalendario(getActivity(), edfechafinal);
                }
            }

            public static ConsultaPorFechasFragment newInstance() {
                ConsultaPorFechasFragment fragment = new ConsultaPorFechasFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }


    }
