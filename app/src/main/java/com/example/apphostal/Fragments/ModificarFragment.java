package com.example.apphostal.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.Registros.EliminarRegistros;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.Logica.Registros.ModificarRegistros;
import com.example.apphostal.R;

import java.util.List;

public class ModificarFragment extends Fragment {
    private ListarRegistros1 listarRegistros1;
    private Registro registro;
    private List<Registro> dataList;
    private EditText edhabitacion, edfecha, edestado, edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro;
    private Button btnMenu,btnEliminar, btnModificar, btnExtras;


    // Constante para la clave del argumento
    private static final String ARG_SELECTED_ID = "selectedId";

    // Variable para almacenar el ID seleccionado
    private int selectedId;

    // Método estático para crear una nueva instancia del fragmento con el ID seleccionado como argumento
    public static ModificarFragment newInstance(int selectedId) {
        ModificarFragment fragment = new ModificarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED_ID, selectedId);
        fragment.setArguments(args);
        return fragment;
    }

    // Método onCreate donde se obtiene el ID seleccionado del argumento
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedId = getArguments().getInt(ARG_SELECTED_ID);
            Log.d("ModificarFragment", "selectedId: " + selectedId); // Imprimir selectedId en el logcat
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modificar, container, false);
        edRegistro = view.findViewById(R.id.edRegistro);
        edhabitacion = view.findViewById(R.id.edhabitacion);
        edfecha = view.findViewById(R.id.editTextFecha); // Agregado
        edestado = view.findViewById(R.id.edestado);
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
        btnEliminar = view.findViewById(R.id.btnEliminar);
        btnModificar = view.findViewById(R.id.btnModificar);
        btnMenu = view.findViewById(R.id.btnMenu);
        btnExtras = view.findViewById(R.id.btnExtras);

        // Crear una instancia de ListarRegistros1
        listarRegistros1 = new ListarRegistros1(getContext());
        listarRegistros1.consultarRegistroPorId(selectedId);
        dataList = listarRegistros1.getRegistros();

        // Verificar si dataList no es nulo y si contiene al menos un elemento
        if (dataList != null && !dataList.isEmpty()) {
            // Obtener el primer registro de dataList
            Registro registro = dataList.get(0);
            Log.d("lista Fragment", dataList.get(0).toString());
            // Verificar si se obtuvo el registro
            if (registro != null) {
                // Actualizar los campos de los EditText con los datos del registro
                actualizarCampos(registro);
                // Imprimir los valores de registro en la consola para depurar
                Log.d("Registro", "ID: " + registro.getId());
                Log.d("Registro", "Habitación: " + registro.getHabitacion());
                Log.d("Registro", "Fecha: " + registro.getFecha());
                edRegistro.setText(String.valueOf(registro.getId()));
                edhabitacion.setText(registro.getHabitacion());
            } else {
                // Manejar el caso donde no se encontró el registro
            }
        } else {
            // Manejar el caso donde dataList está vacía
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarRegistro();
            }
        });

        // Configurar el evento onClick para el botón de eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarEliminarRegistro();
            }
        });

        return view;
    }

    private void actualizarCampos(Registro registro) {
        edRegistro.setText(String.valueOf(registro.getId()));
        edhabitacion.setText(registro.getHabitacion());
        edfecha.setText(registro.getFecha());
        edestado.setText(registro.getEstado());
        edbajeras.setText(registro.getBajera());
        edencimeras.setText(registro.getEncimera());
        edfundalomohada.setText(registro.getFundaA());
        edprotectora.setText(registro.getProtectorA());
        ednordica.setText(registro.getNordica());
        edcolchav.setText(registro.getColchav());
        edtoallaD.setText(registro.getToallaD());
        edtoallaL.setText(registro.getToallaL());
        edalfombrim.setText(registro.getAlfombrin());
        edpaid.setText(registro.getPaid());
        edprotectC.setText(registro.getProtectorC());
    }

    private void modificarRegistro() {
        int id = Integer.parseInt(edRegistro.getText().toString().trim());

        String estado = edestado.getText().toString().trim();
        String bajeras = edbajeras.getText().toString().trim();
        String encimeras = edencimeras.getText().toString().trim();
        String fundaAlmohada = edfundalomohada.getText().toString().trim();
        String protectorAlmohada = edprotectora.getText().toString().trim();
        String nordica = ednordica.getText().toString().trim();
        String colchav = edcolchav.getText().toString().trim();
        String toallaDucha = edtoallaD.getText().toString().trim();
        String toallaLavabo = edtoallaL.getText().toString().trim();
        String alfombrin = edalfombrim.getText().toString().trim();
        String paid = edpaid.getText().toString().trim();
        String protectorColchon = edprotectC.getText().toString().trim();

        // Crear una instancia de ModificarRegistros
        ModificarRegistros modificarRegistros = new ModificarRegistros(getContext());

        // Llamar al método modificarRegistro
        boolean resultado = modificarRegistros.modificarRegistro(id, estado, bajeras, encimeras, fundaAlmohada, protectorAlmohada, nordica,colchav, toallaDucha, toallaLavabo, alfombrin, paid, protectorColchon);

        // Mostrar un mensaje según el resultado
        if (resultado) {
            Toast.makeText(getContext(), "Registro modificado con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error al modificar el registro", Toast.LENGTH_SHORT).show();
        }


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
        String fecha = edfecha.getText().toString().trim();
        String habitacion = edhabitacion.getText().toString().trim();

        if (!fecha.isEmpty() && !habitacion.isEmpty()) {
            EliminarRegistros eliminarRegistros = new EliminarRegistros(getContext());
            boolean resultado = eliminarRegistros.eliminarRegistro(fecha, habitacion);

            if (resultado) {
                Toast.makeText(getContext(), "Registro eliminado con éxito", Toast.LENGTH_SHORT).show();
                // Obtener la actividad asociada al fragmento y finalizarla
                if (getActivity() != null) {
                    getActivity().finish();
                }
            } else {
                Toast.makeText(getContext(), "Error al eliminar el registro", Toast.LENGTH_SHORT).show();
            }

        }
}
}