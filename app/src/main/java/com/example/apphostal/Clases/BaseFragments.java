package com.example.apphostal.Clases;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Logica.Lavanderia.AdicionarLavanderia;
import com.example.apphostal.R;
import android.view.ViewGroup;
import android.view.LayoutInflater;


public abstract class BaseFragments<T> extends Fragment {
    protected EditText editTextFecha, edbajeras, edencimeras, edfundalomohada, edprotectora,
            ednordica, edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC, edrellenoN;

    protected Button btnMenu, btnEnviarDatos;
    protected AdicionarLavanderia adicionarLavanderia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        btnMenu = view.findViewById(R.id.btnMenu);
        btnEnviarDatos = view.findViewById(R.id.btnEnviarDatos);

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

        //adicionarLavanderia = new AdicionarLavanderia(getContext());

        editTextFecha.setOnClickListener(this::mostrarCalendario);

        btnMenu.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().finish();
                startActivity(new Intent(getActivity(), getActivityClass()));
            }
        });

        btnEnviarDatos.setOnClickListener(v -> {
            if (EditTextFocusHelper.isAnyEditTextEmpty(editTextFecha, edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica, edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC, edrellenoN)) {
                Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            } else {
                enviarDatos();
            }
        });

        setupEditTextFocus();

        return view;
    }

    private void setupEditTextFocus() {
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
    }

    public void mostrarCalendario(View view) {
        Calendario.mostrarCalendario(requireContext(), editTextFecha);
    }

    private void enviarDatos() {
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

        T entity = createEntity(fecha, bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC, rellenoN);

        insertEntity(entity);

        limpiarCampos();
    }

    private void limpiarCampos() {
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

    protected abstract int getLayoutId();

    protected abstract Class<?> getActivityClass();

    protected abstract T createEntity(String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav, int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN);

    protected abstract void insertEntity(T entity);


}
