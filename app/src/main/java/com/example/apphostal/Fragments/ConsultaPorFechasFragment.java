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
import android.widget.Toast;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.ConteoRegistros;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.R;


public class ConsultaPorFechasFragment extends Fragment {

    private EditText edfechainicial, edfechafinal;
    private TextView edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica, edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC, edRellenoN;
    private Button btnbuscar, btnFragmentCerrar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_consulta_por_fechas, container, false);

        // Inicializar TextViews
        edbajeras = view.findViewById(R.id.item_bajera1);
        edencimeras = view.findViewById(R.id.item_encimeras1);
        edfundalomohada = view.findViewById(R.id.item_FundaA1);
        edprotectora = view.findViewById(R.id.item_ProtectorA1);
        ednordica = view.findViewById(R.id.item_Nordicas1);
        edcolchav = view.findViewById(R.id.item_ColchaVerano1);
        edtoallaD = view.findViewById(R.id.item_ToallaDucha1);
        edtoallaL = view.findViewById(R.id.item_ToallaLavabo1);
        edalfombrim = view.findViewById(R.id.item_Alfombrin1);
        edRellenoN = view.findViewById(R.id.item_RellenoN1);
        edprotectC = view.findViewById(R.id.item_ProtectorColchon1);

        // Inicializar EditTexts y Botones
        edfechainicial = view.findViewById(R.id.edfechainicial);
        edfechafinal = view.findViewById(R.id.edfechafinal);
        btnbuscar = view.findViewById(R.id.btnbuscar);
        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);

        // Configurar listener para el botón buscar
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarRegistros();
            }
        });

        // Configurar listener para cerrar el fragment
        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarFragment();
            }
        });

        // Configurar listener para los EditTexts de fechas
        edfechainicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario(edfechainicial);
            }
        });

        edfechafinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario(edfechafinal);
            }
        });

        return view;
    }

    private void buscarRegistros() {
        String fechaInicio = edfechainicial.getText().toString();
        String fechaFin = edfechafinal.getText().toString();

        if (!fechaInicio.isEmpty() && !fechaFin.isEmpty()) {
            // Llamar al método consultarRecuentoPorRangoDeFecha de ListarRegistros1
            ConteoRegistros conteoregistros = ListarRegistros1.consultarRecuentoPorRangoDeFecha(fechaInicio, fechaFin);

            if (conteoregistros != null) {
                Log.d("Datos conteoregistros", conteoregistros.toString());
                actualizarCampos(conteoregistros);
            } else {
                Log.e("Error", "No se encontraron registros para el rango de fechas proporcionado.");
                mostrarMensaje("No se encontraron registros para el rango de fechas proporcionado.");
            }
        } else {
            mostrarMensaje("Por favor, ingrese ambas fechas.");
        }
    }

    private void mostrarCalendario(EditText editText) {
        Calendario.mostrarCalendario(getActivity(), editText);
    }

    private void cerrarFragment() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().remove(ConsultaPorFechasFragment.this).commit();
    }

    private void actualizarCampos(ConteoRegistros conteoregistro) {
        edbajeras.setText(String.valueOf(conteoregistro.getCountBajeras()));
        edencimeras.setText(String.valueOf(conteoregistro.getCountEncimeras()));
        edfundalomohada.setText(String.valueOf(conteoregistro.getCountFundaAlmohada()));
        edprotectora.setText(String.valueOf(conteoregistro.getCountProtectorAlmohada()));
        ednordica.setText(String.valueOf(conteoregistro.getCountNordica()));
        edcolchav.setText(String.valueOf(conteoregistro.getCountColchaVerano()));
        edtoallaD.setText(String.valueOf(conteoregistro.getCountToallaDucha()));
        edtoallaL.setText(String.valueOf(conteoregistro.getCountToallaLavabo()));
        edalfombrim.setText(String.valueOf(conteoregistro.getCountAlfombrin()));
        edRellenoN.setText(String.valueOf(conteoregistro.getCountRellenoNordico()));
        edprotectC.setText(String.valueOf(conteoregistro.getCountProtectorColchon()));
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }

    public static ConsultaPorFechasFragment newInstance() {
        ConsultaPorFechasFragment fragment = new ConsultaPorFechasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
