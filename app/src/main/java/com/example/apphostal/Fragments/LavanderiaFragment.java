package com.example.apphostal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.R;

public class LavanderiaFragment extends Fragment {
    private EditText editTextFecha,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edcolchav,edtoallaD,edtoallaL,edalfombrim,edpaid,edprotectC;

   private Button btnMenu, btnEnviarDatos;

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

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //Obtener el FragmentManager y quitar el fragment actual
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(LavanderiaFragment.this).commit();
            }
        });

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si algún EditText está vacío
                if (EditTextFocusHelper.isAnyEditTextEmpty(editTextFecha,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edtoallaD,edtoallaL, edalfombrim,edpaid,edprotectC/* otros EditText */)) {
                    // Mostrar mensaje de error
                    Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();

                    // Guardar los datos
                } else {
                    //enviarDatos();
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

        return view;


    }

    public static LavanderiaFragment newInstance() {
        LavanderiaFragment fragment = new LavanderiaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}