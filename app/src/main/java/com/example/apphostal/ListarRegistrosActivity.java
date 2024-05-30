package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.ListarRegistros;
import java.util.List;

public class ListarRegistrosActivity extends AppCompatActivity {
    private EditText editTextFecha;
    private ListView listViewRegistros;
    private ListarRegistros listarRegistros;
    private List<String> registros;
    private Button btnMenu, btnBuscar, btnExtras;
    private static final String TAG = "ListarRegistrosActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registros);

        editTextFecha = findViewById(R.id.editTextFecha);
        listViewRegistros = findViewById(R.id.listViewRegistros);
        btnMenu = findViewById(R.id.btnMenu);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnExtras = findViewById(R.id.btnExtras);
        
        listarRegistros = new ListarRegistros(this);
        registros = listarRegistros.obtenerRegistros();
        String registroId= "";
        // Log the initial registros data
        for (String registro : registros) {
            Log.d(TAG, "Registro inicial: " + registro);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registros);
        listViewRegistros.setAdapter(adapter);

        listViewRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String registroSeleccionado = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(ListarRegistrosActivity.this, DetalleRegistroActivity.class);
                intent.putExtra("registro", registroSeleccionado);
                startActivity(intent);
            }
        });

        btnExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del Fragment con el valor de edRegistro
                ExtrasActivity fragment = ExtrasActivity.newInstance(registroId);

                // Obtener el FragmentManager y comenzar una transacción
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Reemplazar el contenido del contenedor de fragmentos con este nuevo Fragment
                fragmentTransaction.replace(R.id.fragment_container, fragment);

                // Añadir la transacción al back stack (opcional)
                fragmentTransaction.addToBackStack(null);

                // Commit de la transacción
                fragmentTransaction.commit();

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarRegistro();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarRegistrosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendario.mostrarCalendario(ListarRegistrosActivity.this, editTextFecha);
            }
        });
    }

    private void buscarRegistro() {
        String fecha = editTextFecha.getText().toString();
        registros = listarRegistros.obtenerRegistrosPorFecha(fecha);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registros);
        listViewRegistros.setAdapter(adapter);
    }

    private Registro convertirACadenaARegistro(String cadena) {
        Log.d(TAG, "Convirtiendo cadena a registro: " + cadena);
        String[] partes = cadena.split(",");
        Log.d(TAG, "Número de partes: " + partes.length);

        if (partes.length == 13) { // Verificamos que tenemos exactamente 13 partes
            for (int i = 0; i < partes.length; i++) {
                Log.d(TAG, "Parte " + i + ": " + partes[i]);
            }
            try {
                return new Registro(
                        partes[0], // fecha
                        partes[1], // habitacion
                        partes[2], // estado
                        partes[3], // bajera
                        partes[4], // encimera
                        partes[5], // fundaA
                        partes[6], // protectorA
                        partes[7], // nordica
                        partes[8], // toallaD
                        partes[9], // toallaL
                        partes[10], // alfombrin
                        partes[11], // paid
                        partes[12]  // protectorC
                );
            } catch (Exception e) {
                Log.e(TAG, "Error al crear el objeto Registro: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Error: se esperaban 13 partes pero se encontraron " + partes.length);
        }
        return null;
    }
}
