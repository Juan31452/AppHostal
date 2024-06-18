// ExtrasActivity.java
package com.example.apphostal.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Entity.Extras;
import com.example.apphostal.Logica.AdicionarExtras;
import com.example.apphostal.Logica.Extras.ModificarExtras;
import com.example.apphostal.Logica.ListarExtras;
import com.example.apphostal.R;

public class ExtrasFragment extends Fragment {
    private EditText edRegistro, edagua, edpapleh, edcafen, edcafec, idleche, edtem, edtenegro, edgalletas, edzucar, edsacarinas, edmaquillaje, eddulceextra;
    private Button btnFragmentCerrar, btnGuardar, btnConsultar,btnModificar;
    private AdicionarExtras adicionarExtras;
    private ListarExtras listarExtras;

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
        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        btnModificar = view.findViewById(R.id.btnModificar);


        edRegistro.setText(registroId); // Establecer el texto en el EditText

        // Inicializar AdicionarExtras con el contexto de la actividad
        Context context = getActivity();
        adicionarExtras = new AdicionarExtras(context);
        listarExtras = new ListarExtras(context);


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

        consultarDatosExtras();
        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el FragmentManager y quitar el fragment actual
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(ExtrasFragment.this).commit();
            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModificarRegistros();
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si algún EditText está vacío
                if (EditTextFocusHelper.isAnyEditTextEmpty(edRegistro, edagua, edpapleh, edcafen, edcafec, idleche, edtem, edtenegro, edgalletas, edzucar, edsacarinas, edmaquillaje, eddulceextra)) {
                    // Mostrar mensaje de error
                    Toast.makeText(getActivity().getApplicationContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Guardar los datos
                    enviarDatos();

                    // Obtener el FragmentManager y quitar el fragment actual
                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction().remove(ExtrasFragment.this).commit();
                }
            }
        });


        return view;
    }

    private void consultarDatosExtras() {
        // Obtener el registroId del EditText
        String registroId = String.valueOf(Integer.parseInt(edRegistro.getText().toString().trim()));

        // Llamar al método de consulta en AdicionarExtras
        Extras extras = listarExtras.consultarExtras(registroId);
        // Manejar el caso donde no se encontraron datos
        if (extras != null) {
            // Llenar los EditText con los datos obtenidos
            edagua.setText(String.valueOf(extras.getAgua()));
            edpapleh.setText(String.valueOf(extras.getPapleh()));
            edcafen.setText(String.valueOf(extras.getCafen()));
            edcafec.setText(String.valueOf(extras.getCafec()));
            idleche.setText(String.valueOf(extras.getLeche()));
            edtem.setText(String.valueOf(extras.getTem()));
            edtenegro.setText(String.valueOf(extras.getTenegro()));
            edgalletas.setText(String.valueOf(extras.getGalletas()));
            edzucar.setText(String.valueOf(extras.getAzucar()));
            edsacarinas.setText(String.valueOf(extras.getSacarinas()));
            edmaquillaje.setText(String.valueOf(extras.getMaquillaje()));
            eddulceextra.setText(String.valueOf(extras.getDulceextra()));
            btnGuardar.setEnabled(false);
            btnModificar.setEnabled(true);

        } else {
            mostrarMensaje("No se encontraron datos para el registroId: " + registroId);
            btnGuardar.setEnabled(true);
            btnModificar.setEnabled(false);
        }

    }

    private void mostrarMensaje(String mensaje) {
      //  Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
    public static ExtrasFragment newInstance(String registroId) {
        ExtrasFragment fragment = new ExtrasFragment();
        Bundle args = new Bundle();
        args.putString("registroId", registroId);
        fragment.setArguments(args);
        return fragment;
    }

    private void enviarDatos() {
        int registro = Integer.parseInt(edRegistro.getText().toString());
        int agua = Integer.parseInt(edagua.getText().toString());
        int papleh = Integer.parseInt(edpapleh.getText().toString());
        int cafen = Integer.parseInt(edcafen.getText().toString());
        int cafec = Integer.parseInt(edcafec.getText().toString());
        int leche = Integer.parseInt(idleche.getText().toString());
        int tem = Integer.parseInt(edtem.getText().toString());
        int tenegro = Integer.parseInt(edtenegro.getText().toString());
        int galletas = Integer.parseInt(edgalletas.getText().toString());
        int azucar = Integer.parseInt(edzucar.getText().toString());
        int sacarinas = Integer.parseInt(edsacarinas.getText().toString());
        int maquillaje = Integer.parseInt(edmaquillaje.getText().toString());
        int dulceextra = Integer.parseInt(eddulceextra.getText().toString());

        Extras extras = new Extras(registro, agua, papleh, cafen, cafec, leche, tem, tenegro, galletas, azucar, sacarinas, maquillaje, dulceextra);

        adicionarExtras.insertarExtras(extras);

        // Limpiar los campos después de guardar
        edRegistro.setText("");
        edagua.setText("");
        edpapleh.setText("");
        edcafen.setText("");
        edcafec.setText("");
        idleche.setText("");
        edtem.setText("");
        edtenegro.setText("");
        edgalletas.setText("");
        edzucar.setText("");
        edsacarinas.setText("");
        edmaquillaje.setText("");
        eddulceextra.setText("");
    }
    
    private void ModificarRegistros(){
        int registro = Integer.parseInt(edRegistro.getText().toString().trim());
        String agua = edagua.getText().toString().trim();
        String papelh = edpapleh.getText().toString().trim();
        String cafen = edcafen.getText().toString().trim();
        String cafec = edcafec.getText().toString().trim();
        String leche = idleche.getText().toString().trim();
        String temanzanilla = edtem.getText().toString().trim();
        String tenegro = edtenegro.getText().toString().trim();
        String galletas = edgalletas.getText().toString().trim();
        String azucar = edzucar.getText().toString().trim();
        String sacarinas = edsacarinas.getText().toString().trim();
        String maquillaje = edmaquillaje.getText().toString().trim();
        String dulceextra = eddulceextra.getText().toString().trim();

        Extras extras = new Extras(registro, Integer.parseInt(agua), Integer.parseInt(papelh),
                Integer.parseInt(cafen), Integer.parseInt(cafec), Integer.parseInt(leche),
                Integer.parseInt(temanzanilla), Integer.parseInt(tenegro), Integer.parseInt(galletas),
                Integer.parseInt(azucar), Integer.parseInt(sacarinas), Integer.parseInt(maquillaje),
                Integer.parseInt(dulceextra));

        // Crear una instancia de la clase Modificar
        Log.d("Datos Extras ", extras.toString());
        ModificarExtras modificarextras = new ModificarExtras(getActivity());

// Llamar al método para modificar y actualizar los datos, pasando el objeto extras
        boolean resultado = modificarextras.modificarDatos(extras);

        // Mostrar un mensaje según el resultado
        if (resultado) {
            Toast.makeText(getContext(), "Registro modificado con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error al modificar el registro", Toast.LENGTH_SHORT).show();
        }
    }
}
