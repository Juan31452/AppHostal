package com.example.apphostal.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia;
import com.example.apphostal.R;

import java.util.List;


public class UtilidadesMoFragment extends Fragment {

    private EditText  edfecha,edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro,edrellenoN;
    private Button btnFragmentCerrar,btnEliminar, btnModificar;
    private ListarLavanderia listaLavanderia;
    private List<Lavanderia> dataList;

    // Constante para la clave del argumento
    private static final String ARG_SELECTED_ID = "selectedId";

    // Variable para almacenar el ID seleccionado
    private int selectedId;
    public static UtilidadesMoFragment newInstance(int selectedId) {
        UtilidadesMoFragment fragment = new UtilidadesMoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED_ID, selectedId);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utilidades_mo, container, false);

        edRegistro = view.findViewById(R.id.edRegistro);
        edfecha = view.findViewById(R.id.editTextFecha);
        edbajeras = view.findViewById(R.id.edbajeras);
        edencimeras = view.findViewById(R.id.edencimeras);
        edfundalomohada = view.findViewById(R.id.edfundalomohada);
        edprotectora = view.findViewById(R.id.edprotectora);
        ednordica = view.findViewById(R.id.ednordica);
        edcolchav = view.findViewById(R.id.edcolchav);
        edtoallaD = view.findViewById(R.id.edtoallaD);
        edtoallaL = view.findViewById(R.id.edtoallaL);
        edalfombrim = view.findViewById(R.id.edalfombrim);
        edpaid = view.findViewById(R.id.paid);
        edprotectC = view.findViewById(R.id.protectC);
        edrellenoN = view.findViewById(R.id.edrellenoN);
        btnEliminar = view.findViewById(R.id.btnEliminar);
        btnModificar = view.findViewById(R.id.btnModificar);
        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);

        // Inhabilitar edhabitacion y edfecha
       // edhabitacion.setEnabled(false);
        edfecha.setEnabled(false);

        // Crear una instancia de ListarLavanderia
        listaLavanderia = new ListarLavanderia(getActivity());
        listaLavanderia.consultarRegistroPorId(selectedId);
        Log.d("Lista", "Elemento clicado: " + dataList.toString());

        // Obtener el primer registro de dataList
        Lavanderia lavanderia = dataList.get(0);
        if (lavanderia != null) {
            // Actualizar los campos de los EditText con los datos del registro
            actualizarCampos(lavanderia);
        }

        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cerrar la actividad actual y volver a abrirla
                getActivity().finish();
                startActivity(new Intent(getActivity(), RegistrosActivity.class));
            }
        });

        return view;
    }

    private void actualizarCampos(Lavanderia lavanderia) {
        edRegistro.setText(String.valueOf(lavanderia.getId()));
        edfecha.setText(lavanderia.getFecha());
        edbajeras.setText(lavanderia.getBajera());
        edencimeras.setText(lavanderia.getEncimera());
        edfundalomohada.setText(lavanderia.getFundaA());
        edprotectora.setText(lavanderia.getProtectorA());
        ednordica.setText(lavanderia.getNordica());
        edcolchav.setText(lavanderia.getColchav());
        edtoallaD.setText(lavanderia.getToallaD());
        edtoallaL.setText(lavanderia.getToallaL());
        edalfombrim.setText(lavanderia.getAlfombrin());
        edpaid.setText(lavanderia.getPaid());
        edprotectC.setText(lavanderia.getProtectorC());
        edrellenoN.setText(lavanderia.getRellenoN());
    }
}