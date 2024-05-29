// Extras.java
package com.example.apphostal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.apphostal.Clases.EditTextFocusHelper;

public class Extras extends Fragment {
    private EditText edRegistro,edagua, edpapleh, edcafen, edcafec, idleche, edtem, edtenegro, edgalletas, edzucar, edsacarinas, edmaquillaje, eddulceextra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este Fragment
        View view = inflater.inflate(R.layout.fragment_extras, container, false);

        // Recuperar el valor de registroId del Bundle de argumentos
        String registroId = getArguments().getString("registroId");
        // Imprimir el valor en el Log
        Log.d("Valor de edRegistro", registroId);

        // Inicializar los EditText utilizando la vista inflada
        edRegistro = view.findViewById(R.id.edRegistro);
        edagua = view.findViewById(R.id.edagua);
        edpapleh = view.findViewById(R.id.edpapleh);
        edcafen = view.findViewById(R.id.edcafen);
        edcafec = view.findViewById(R.id.edcafec);
        idleche = view.findViewById(R.id.idleche);
        edtem = view.findViewById(R.id.edtem);
        edtenegro = view.findViewById(R.id.edtenegro);
        edgalletas = view.findViewById(R.id.edgalletas);
        edzucar = view.findViewById(R.id.edzucar);
        edsacarinas = view.findViewById(R.id.edsacarinas);
        edmaquillaje = view.findViewById(R.id.edmaquillaje);
        eddulceextra = view.findViewById(R.id.eddulceextra);

        // Encontrar el botón y establecer el listener de clic
        Button btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);

        edRegistro.setText(registroId); // Establecer el texto en el EditText
        // Llama a EditTextFocusHelper.setupEditTextFocus() para configurar el comportamiento del EditText deseado
        EditTextFocusHelper.setupEditTextFocus(edagua);
        EditTextFocusHelper.setupEditTextFocus(edpapleh);
        EditTextFocusHelper.setupEditTextFocus(edcafen);
        EditTextFocusHelper.setupEditTextFocus(edcafec);
        EditTextFocusHelper.setupEditTextFocus(idleche);
        EditTextFocusHelper.setupEditTextFocus(edtem);
        EditTextFocusHelper.setupEditTextFocus(edtenegro);
        EditTextFocusHelper.setupEditTextFocus(edgalletas);
        EditTextFocusHelper.setupEditTextFocus(edzucar);
        EditTextFocusHelper.setupEditTextFocus(edsacarinas);
        EditTextFocusHelper.setupEditTextFocus(edmaquillaje);
        EditTextFocusHelper.setupEditTextFocus(eddulceextra);
        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el FragmentManager y quitar el fragment actual
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(Extras.this).commit();
            }
        });

        return view;
    }
    public static Extras newInstance(String registroId) {
        Extras fragment = new Extras();
        Bundle args = new Bundle();
        args.putString("registroId", registroId);
        fragment.setArguments(args);
        return fragment;
    }
}
