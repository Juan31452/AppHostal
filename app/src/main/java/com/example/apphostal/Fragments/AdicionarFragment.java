package com.example.apphostal.Fragments;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Clases.Estado;
import com.example.apphostal.Clases.Habitacion;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.Registros.AdicionarRegistros;
import com.example.apphostal.R;

public class AdicionarFragment extends Fragment {

    private Button btnSalir,btnGuardar;
    private EditText editTextFecha,edhabitacion,edestado,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edcolchav,edtoallaD,edtoallaL,edalfombrim,edpaid,edprotectC;
    // Declara la variable
    private AdicionarRegistros adicionarRegistros;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adicionar, container, false);

        btnGuardar = view.findViewById(R.id.btnGuardar);
        btnSalir = view.findViewById(R.id.btnSalir);

        // Inicializar los EditText
        editTextFecha = view.findViewById(R.id.editTextFecha);
        edhabitacion = view.findViewById(R.id.edhabitacion);
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

        // Inicializar la clase AdicionarRegistros
        adicionarRegistros = new AdicionarRegistros(requireContext());
        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarCalendario(v);
            }
        });

        edhabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListaHabitaciones();
            }
        });

        edestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListaEstado();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad actual y volver a abrirla
                getActivity().finish();
                startActivity(new Intent(getActivity(), RegistrosActivity.class));
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

        return view;

    }
    public static AdicionarFragment newInstance() {
        AdicionarFragment fragment = new AdicionarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public void mostrarCalendario(View view) {
        Calendario.mostrarCalendario(requireContext(), editTextFecha);
    }

    // Método para mostrar la lista de habitaciones en un diálogo de selección
    private void mostrarListaHabitaciones() {
        // Obtén la lista de habitaciones desde la clase Habitacion
        String[] habitaciones = Habitacion.obtenerHabitaciones();

        // Crea un diálogo de selección con la lista de habitaciones
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Lista de Habitaciones")
                .setItems(habitaciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de una habitación (puedes hacer lo que necesites con ella)
                        String habitacionSeleccionada = habitaciones[which];
                        // Por ejemplo, puedes establecer la habitación seleccionada en el EditText
                        edhabitacion.setText(habitacionSeleccionada);
                    }
                });
        builder.create().show();
    }

    // Método para mostrar la lista de estados
    private void mostrarListaEstado() {
        // Obtén la lista de estados desde la clase Estado
        String[] estado = Estado.obtenerEstado();

        // Crea un diálogo de selección con la lista de estado
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Lista de Estados")
                .setItems(Estado.obtenerEstado(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de un estado (puedes hacer lo que necesites con él)
                        String estadoSeleccionado = Estado.obtenerEstado()[which];
                        // Por ejemplo, puedes establecer el estado seleccionado en el EditText
                        edestado.setText(estadoSeleccionado);
                    }
                });

        builder.create().show();
    }

    // Método para enviar los datos ingresados
    private void enviarDatos() {
        String fecha = editTextFecha.getText().toString();
        String habitacion = edhabitacion.getText().toString();
        String estado = edestado.getText().toString();
        String bajera = edbajeras.getText().toString();
        String encimera = edencimeras.getText().toString();
        String fundaA = edfundalomohada.getText().toString();
        String protectorA = edprotectora.getText().toString();
        String nordica = ednordica.getText().toString();
        String colchav = edcolchav.getText().toString();
        String toallaD = edtoallaD.getText().toString();
        String toallaL = edtoallaL.getText().toString();
        String alfombrin = edalfombrim.getText().toString();
        String paid = edpaid.getText().toString();
        String protectorC = edprotectC.getText().toString();


        Registro registro = new Registro(fecha, habitacion, estado, bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC);

        adicionarRegistros.insertarRegistro(registro);

        // Limpiar los campos después de guardar
        editTextFecha.setText("");
        edhabitacion.setText("");
        edestado.setText("");
        edbajeras.setText("");
        edencimeras.setText("");
        edfundalomohada.setText("");
        edprotectora.setText("");
        ednordica.setText("");
        edcolchav.setText("");
        edtoallaD.setText("");
        edtoallaL.setText("");
        edalfombrim.setText("");
        edpaid.setText("");
        edprotectC.setText("");
    }

}