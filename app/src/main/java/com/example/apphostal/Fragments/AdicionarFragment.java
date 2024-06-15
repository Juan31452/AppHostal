package com.example.apphostal.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Clases.Opciones;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Clases.ValorPredeterminado;
import com.example.apphostal.Logica.Registros.AdicionarRegistros;
import com.example.apphostal.R;

public class AdicionarFragment extends Fragment {

    private Button btnSalir,btnGuardar;
    private EditText editTextFecha,edhabitacion,edestado,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edcolchav,edtoallaD,edtoallaL,edalfombrim,edpaid,edprotectC,edrellenoN;
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
        edrellenoN = view.findViewById(R.id.edrellenoN);

        // Inicializar la clase AdicionarRegistros
        adicionarRegistros = new AdicionarRegistros(requireContext());
        // Crea una instancia de Opciones
        Opciones opciones = new Opciones(getContext(), edhabitacion, edestado);

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarCalendario(v);
            }
        });

        edhabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                opciones.mostrarListaHabitaciones();

            }
        });

        // Añadir un TextWatcher para actualizar los campos cuando cambia edestado
        edestado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita implementar este método para este caso
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Verificar y actualizar los campos cuando edestado cambia
                String estado = edestado.getText().toString();
                ValorPredeterminado.actualizarCampos(estado, edbajeras, edencimeras, edfundalomohada,
                        edprotectora, ednordica, edcolchav, edtoallaD, edtoallaL, edalfombrim,
                        edpaid, edprotectC,edrellenoN);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita implementar este método para este caso
            }
        });

        edestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opciones.mostrarListaEstado();
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
        EditTextFocusHelper.setupEditTextFocus(edrellenoN);

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
        String rellenoN = edrellenoN.getText().toString();


        Registro registro = new Registro(fecha, habitacion, estado, bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC, rellenoN);

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
        edrellenoN.setText("");
    }

}