package com.example.apphostal.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apphostal.Activitys.LavanderiaActivity;
import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Entity.Registro;
import com.example.apphostal.Logica.Lavanderia.AdicionarLavanderia;
import com.example.apphostal.R;

public class LavanderiaFragment extends Fragment {
    private EditText editTextFecha,edbajeras,edencimeras,edfundalomohada,edprotectora,
            ednordica,edcolchav,edtoallaD,edtoallaL,edalfombrim,edpaid,edprotectC,edrellenoN;

   private Button btnMenu, btnEnviarDatos;
   private AdicionarLavanderia adicionarLavanderia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lavanderia, container, false);
        // Inicializar EditTexts y Botones
        btnMenu = view.findViewById(R.id.btnMenu);
        btnEnviarDatos = view.findViewById(R.id.btnEnviarDatos);

        // Inicializar los EditText

        editTextFecha = view.findViewById(R.id.editTextFecha);
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

        // Inicializar la clase AdicionarLavanderia
        adicionarLavanderia = new AdicionarLavanderia(getContext());

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario(v);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad actual y volver a abrirla
                getActivity().finish();
                startActivity(new Intent(getActivity(), LavanderiaActivity.class));
            }
        });

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si algún EditText está vacío
                if (EditTextFocusHelper.isAnyEditTextEmpty(editTextFecha,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edtoallaD,edtoallaL,
                        edalfombrim,edpaid,edprotectC,edrellenoN)) {
                    // Mostrar mensaje de error
                    Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();


                } else {
                    enviarDatos();
                }

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

    public void mostrarCalendario(View view) {
        Calendario.mostrarCalendario(requireContext(), editTextFecha);
    }

    public static LavanderiaFragment newInstance() {
        LavanderiaFragment fragment = new LavanderiaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    // Método para enviar los datos ingresados
    private void enviarDatos() {
        // Manejar valores nulos o vacíos para convertir a 0
        int bajera = parseIntOrDefault(edbajeras.getText().toString(), 0);
        int encimera = parseIntOrDefault(edencimeras.getText().toString(), 0);
        int fundaA = parseIntOrDefault(edfundalomohada.getText().toString(), 0);
        int protectorA = parseIntOrDefault(edprotectora.getText().toString(), 0);
        int nordica = parseIntOrDefault(ednordica.getText().toString(), 0);
        int colchav = parseIntOrDefault(edcolchav.getText().toString(), 0);
        int toallaD = parseIntOrDefault(edtoallaD.getText().toString(), 0);
        int toallaL = parseIntOrDefault(edtoallaL.getText().toString(), 0);
        int alfombrin = parseIntOrDefault(edalfombrim.getText().toString(), 0);
        int paid = parseIntOrDefault(edpaid.getText().toString(), 0);
        int protectorC = parseIntOrDefault(edprotectC.getText().toString(), 0);
        int rellenoN = parseIntOrDefault(edrellenoN.getText().toString(), 0);

        String fecha = editTextFecha.getText().toString();


        Lavanderia lavanderia = new Lavanderia(fecha,bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC, rellenoN);

        adicionarLavanderia.insertarLavanderia(lavanderia);

        // Limpiar los campos después de guardar
        editTextFecha.setText("");
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
    private int parseIntOrDefault(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}