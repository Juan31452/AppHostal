package com.example.apphostal.Fragments.Lavanderia;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.apphostal.Logica.Lavanderia.EliminarLavanderia;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia1;
import com.example.apphostal.Logica.Lavanderia.ModificarLavanderia;
import com.example.apphostal.R;

import java.util.List;


public class LavanderiaMoFragment extends Fragment {

    private EditText  edfecha,edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro,edrellenoN;
    private Button btnFragmentCerrar,btnEliminar, btnModificar;
    private ListarLavanderia listaLavanderia;
    private ListarLavanderia1 listaLavanderia1;
    private List<Lavanderia> dataList;
    private List<Lavanderia> dataList1;


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
        Log.d("Id", "selectedId: " + selectedId);
        Log.d("Id", "selectedId: " + edRegistro);

        edfecha = view.findViewById(R.id.editTextFecha);
        edbajeras = view.findViewById(R.id.edbajeras);
        // Otros EditTexts y Buttons...

        // Inhabilitar  y edfecha
        edfecha.setEnabled(false);

        // Crear una instancia de ListarLavanderia si no se ha creado aún
        //if (listaLavanderia == null) {
       //     listaLavanderia = new ListarLavanderia(getActivity());
     //   }

        // Crear una instancia de ListarLavanderia si no se ha creado aún
        if (listaLavanderia1 == null) {
            listaLavanderia1 = new ListarLavanderia1(getActivity());
        }

        // Consultar el registro por ID
        //dataList = listaLavanderia.consultarRegistroPorId(selectedId);
        dataList1 = listaLavanderia1.consultarRegistroPorId(selectedId);

        if (dataList1 != null && !dataList1.isEmpty()) {
            // Obtener el primer registro de dataList
            Lavanderia lavanderia = dataList1.get(0);
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

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarEliminarRegistro();
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
        try {
            String fecha = edfecha.getText().toString();
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


            Lavanderia lavanderia = new Lavanderia(selectedId, fecha, bajera, encimera, fundalomohada, protectora, nordica, colchav, toallaD, toallaL, alfombrim, paid, protectorC, rellenoN);
            Log.d("ModificarFragment", "LavanderiaID: " + lavanderia.toString());

            ModificarLavanderia modificarLavanderia = new ModificarLavanderia(getActivity());
            Log.d("DESDELavanderiaFragment", "Id Lavanderia: " + lavanderia.getId());

            modificarLavanderia.modificarRegistro(lavanderia);
        } catch (Exception e) {
            Log.d("ModificarFragmentID", "Error al modificar el registro: " + e.getMessage());
        }
        // Opcional: Volver a la actividad anterior o cerrar el fragmento
        getActivity().getSupportFragmentManager().popBackStack();

   }

    private void confirmarEliminarRegistro() {

        new AlertDialog.Builder(getContext())
                .setTitle("Confirmar Eliminación")
                .setMessage("¿Está seguro de que desea eliminar este registro?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eliminarRegistro();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    private void eliminarRegistro() {
        try {
            int id = Integer.parseInt(edRegistro.getText().toString().trim());
                EliminarLavanderia eliminarLavanderia = new EliminarLavanderia(getContext());
                eliminarLavanderia.eliminarRegistro(id);


                    //Toast.makeText(getContext(), "Registro eliminado con éxito", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("EliminarID", "Error al modificar el registro: " + e.getMessage());
        }
        // Cerrar la actividad actual y volver a abrirla
        getActivity().finish();
        startActivity(new Intent(getActivity(), LavanderiaActivity.class));

    }

}