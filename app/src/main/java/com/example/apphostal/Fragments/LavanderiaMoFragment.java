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

import com.example.apphostal.Activitys.LavanderiaActivity;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia;
import com.example.apphostal.R;

import java.util.List;


public class LavanderiaMoFragment extends Fragment {

    private EditText  edfecha,edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro,edrellenoN;
    private Button btnFragmentCerrar,btnEliminar, btnModificar;
    private ListarLavanderia listaLavanderia;
    private List<Lavanderia> dataList;

    // Constante para la clave del argumento
    private static final String ARG_SELECTED_ID = "selectedId";

    // Variable para almacenar el ID seleccionado
    private int selectedId;
    public static LavanderiaMoFragment newInstance(int selectedId) {
        LavanderiaMoFragment fragment = new LavanderiaMoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED_ID, selectedId);
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedId = getArguments().getInt(ARG_SELECTED_ID);
            Log.d("ModificarFragment", "selectedId: " + selectedId); // Imprimir selectedId en el logcat
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utilidades_mo, container, false);

        edRegistro = view.findViewById(R.id.edRegistro);
        edfecha = view.findViewById(R.id.editTextFecha); // Agregado
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

        // Obtener el ID seleccionado del argumento
        selectedId = getArguments().getInt(ARG_SELECTED_ID);

        edRegistro = view.findViewById(R.id.edRegistro);
        edfecha = view.findViewById(R.id.editTextFecha);
        edbajeras = view.findViewById(R.id.edbajeras);
        // Otros EditTexts y Buttons...

        // Inhabilitar  y edfecha
        edfecha.setEnabled(false);

        // Crear una instancia de ListarLavanderia si no se ha creado aún
        if (listaLavanderia == null) {
            listaLavanderia = new ListarLavanderia(getActivity());
        }

        // Consultar el registro por ID
        dataList = listaLavanderia.consultarRegistroPorId(selectedId);

        if (dataList != null && !dataList.isEmpty()) {
            // Obtener el primer registro de dataList
            Lavanderia lavanderia = dataList.get(0);
            if (lavanderia != null) {
                // Actualizar los campos de los EditText con los datos del registro
                actualizarCampos(lavanderia);
            } else {
                // Manejar el caso donde lavanderia es null
                Log.e("UtilidadesMoFragment", "El objeto Lavanderia obtenido es null");
            }
        } else {
            // Manejar el caso donde dataList es null o está vacío
            Log.e("UtilidadesMoFragment", "La lista de Lavanderia está vacía o es null");
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarRegistro();
            }
        });

      btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getActivity().finish();
              startActivity(new Intent(getActivity(), LavanderiaActivity.class));
          }
      });

        // Llama a EditTextFocusHelper.setupEditTextFocus() para configurar el comportamiento del EditText deseado
        EditTextFocusHelper.setupEditTextFocus(edbajeras);
        EditTextFocusHelper.setupEditTextFocus(edencimeras);
        EditTextFocusHelper.setupEditTextFocus(edfundalomohada);
        EditTextFocusHelper.setupEditTextFocus(edprotectora);
        EditTextFocusHelper.setupEditTextFocus(ednordica);
        EditTextFocusHelper.setupEditTextFocus(edcolchav);
        EditTextFocusHelper.setupEditTextFocus(edtoallaD);
        EditTextFocusHelper.setupEditTextFocus(edtoallaL);
        EditTextFocusHelper.setupEditTextFocus(edalfombrim);
        EditTextFocusHelper.setupEditTextFocus(edpaid);
        EditTextFocusHelper.setupEditTextFocus(edprotectC);
        EditTextFocusHelper.setupEditTextFocus(edrellenoN);

        return view;
    }

    private void actualizarCampos(Lavanderia lavanderia) {
        edRegistro.setText(String.valueOf(lavanderia.getId()));
        edfecha.setText(lavanderia.getFecha());
        edbajeras.setText(String.valueOf(lavanderia.getBajera()));
        edencimeras.setText(String.valueOf(lavanderia.getEncimera()));
        edfundalomohada.setText(String.valueOf(lavanderia.getFundaA()));
        edprotectora.setText(String.valueOf(lavanderia.getProtectorA()));
        ednordica.setText(String.valueOf(lavanderia.getNordica()));
        edcolchav.setText(String.valueOf(lavanderia.getColchav()));
        edtoallaD.setText(String.valueOf(lavanderia.getToallaD()));
        edtoallaL.setText(String.valueOf(lavanderia.getToallaL()));
        edalfombrim.setText(String.valueOf(lavanderia.getAlfombrin()));
        edpaid.setText(String.valueOf(lavanderia.getPaid()));
        edprotectC.setText(String.valueOf(lavanderia.getProtectorC()));
        edrellenoN.setText(String.valueOf(lavanderia.getRellenoN()));
    }

    private void modificarRegistro() {
        // Obtener los valores de los EditText
        int bajera = Integer.parseInt(edbajeras.getText().toString());
        int encimera = Integer.parseInt(edencimeras.getText().toString());
        int fundalomohada = Integer.parseInt(edfundalomohada.getText().toString());
        int protectora = Integer.parseInt(edprotectora.getText().toString());
        int nordica = Integer.parseInt(ednordica.getText().toString());
        int colchav = Integer.parseInt(edcolchav.getText().toString());
        int toallaD = Integer.parseInt(edtoallaD.getText().toString());
        int toallaL = Integer.parseInt(edtoallaL.getText().toString());
        int alfombrim = Integer.parseInt(edalfombrim.getText().toString());
        int paid = Integer.parseInt(edpaid.getText().toString());
        int protectorC = Integer.parseInt(edprotectC.getText().toString());
        int rellenoN = Integer.parseInt(edrellenoN.getText().toString());

        // Crear una instancia de Lavanderia con los valores obtenidos
        Lavanderia lavanderia = new Lavanderia(selectedId, edfecha.getText().toString(), bajera, encimera, fundalomohada, protectora, nordica, colchav, toallaD, toallaL, alfombrim, paid, protectorC, rellenoN);
        Log.d("ModificarFragment", "Lavanderia: " + lavanderia);
/*
        // Actualizar el registro en la base de datos
        listaLavanderia.modificarRegistro(lavanderia);

        // Mostrar un mensaje de éxito
        Toast.makeText(getActivity(), "Registro actualizado correctamente", Toast.LENGTH_SHORT).show();

        // Opcional: Volver a la actividad anterior o cerrar el fragmento
        getActivity().getSupportFragmentManager().popBackStack();

 */
    }


}