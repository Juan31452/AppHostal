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
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.R;

import java.util.ArrayList;
import java.util.List;


public class ConsultaPorFechasFragment extends Fragment {

    private EditText edfechainicial, edfechafinal, tresultados;
    private TextView edhabitacion, edfecha, edestado, edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro;

    private ListarRegistros1 listarRegistros1;
    private ConteoRegistros conteoregistros;
    //private ListView listViewConsulta;
    private List<Registro> dataList;
    private Button btnbuscar,btnFragmentCerrar;
    private List<String> detalles;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consulta_por_fechas, container, false);

       // edRegistro = view.findViewById(R.id.edRegistro);
     //   edhabitacion = view.findViewById(R.id.edhabitacion);
     //   edfecha = view.findViewById(R.id.editTextFecha); // Agregado
     //   edestado = view.findViewById(R.id.edestado);
        edbajeras = view.findViewById(R.id.item_bajera1);
        edencimeras = view.findViewById(R.id.item_encimeras1);
        edfundalomohada = view.findViewById(R.id.item_FundaA1);
        edprotectora = view.findViewById(R.id.item_ProtectorA1);
        ednordica = view.findViewById(R.id.item_Nordicas1);
        edcolchav = view.findViewById(R.id.item_ColchaVerano1);
        edtoallaD = view.findViewById(R.id.item_ToallaDucha1);
        edtoallaL = view.findViewById(R.id.item_ToallaLavabo1);
        edalfombrim = view.findViewById(R.id.item_Alfombrin1);
        //edpaid = view.findViewById(R.id.paid);
        edprotectC = view.findViewById(R.id.item_ProtectorColchon1);

        // Inicializar EditTexts y Botones
        edfechainicial = view.findViewById(R.id.edfechainicial);
        edfechafinal = view.findViewById(R.id.edfechafinal);
        btnbuscar = view.findViewById(R.id.btnbuscar);
        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);
        TextView txtLista = view.findViewById(R.id.txtLista);
        //listViewConsulta = view.findViewById(R.id.listViewConsulta);

        // Crear una instancia de ListarRegistros1
        //listarRegistros1 = new ListarRegistros1(getActivity());
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
                //dataList = listarRegistros1.getRegistros();

                // Crear un adaptador para mostrar los registros en el ListView
               // ConteoRegistrosAdapter adapter = new ConteoRegistrosAdapter(getContext(), registros);
                //listViewConsulta.setAdapter(adapter);

                Log.d("Datos conteoregistros ", conteoregistros.toString());
                //Log.d("registros ", registros.toString());

                //TextView txtLista = view.findViewById(R.id.txtLista);
                //txtLista.setText(conteoregistros.toString());

                actualizarCampos(conteoregistros);


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


    private void actualizarCampos(ConteoRegistros conteoregistro) {
        //edRegistro.setText(String.valueOf(registro.getId()));
        //edhabitacion.setText(registro.getHabitacion());
        //edfecha.setText(registro.getFecha());
        //edestado.setText(registro.getEstado());
        edbajeras.setText(String.valueOf(conteoregistro.getCountBajeras()));
        edencimeras.setText(String.valueOf(conteoregistro.getCountEncimeras()));
        edfundalomohada.setText(String.valueOf(conteoregistro.getCountFundaAlmohada()));
        edprotectora.setText(String.valueOf(conteoregistro.getCountProtectorAlmohada()));
        ednordica.setText(String.valueOf(conteoregistro.getCountNordica()));
        edcolchav.setText(String.valueOf(conteoregistro.getCountColchaVerano()));
        edtoallaD.setText(String.valueOf(conteoregistro.getCountToallaDucha()));
        edtoallaL.setText(String.valueOf(conteoregistro.getCountToallaLavabo()));
        edalfombrim.setText(String.valueOf(conteoregistro.getCountAlfombrin()));
        //edpaid.setText(registro.getPaid());
        edprotectC.setText(String.valueOf(conteoregistro.getCountProtectorColchon()));
    }

    public static ConsultaPorFechasFragment newInstance() {
                ConsultaPorFechasFragment fragment = new ConsultaPorFechasFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }


    }
