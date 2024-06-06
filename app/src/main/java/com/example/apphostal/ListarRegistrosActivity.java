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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.Registros.ListarRegistros;
import com.example.apphostal.Logica.Registros.ListarRegistros1;

import java.util.List;

public class ListarRegistrosActivity extends AppCompatActivity {
    private EditText editTextFecha;
    private ListView listViewRegistros;
    private ListarRegistros listarRegistros;
    private ListarRegistros1 listarRegistros1;
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


        listarRegistros = new ListarRegistros(this);
        registros = listarRegistros.obtenerRegistros();
        // Crear una instancia de ListarRegistros1
        listarRegistros1 = new ListarRegistros1(this);

        // Consultar los registros
        listarRegistros1.consultarRegistros();

        // Obtener la lista de registros
        List<Registro> registros = listarRegistros1.getRegistros();


        String registroId= "";
        // Log the initial registros data
        for (Registro registro : registros) {
            Log.d(TAG, "Registro inicial: " + registro);
        }

        // Crear un adaptador para mostrar los registros en el ListView
        ArrayAdapter<Registro> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, registros);
        listViewRegistros.setAdapter(adapter);

        listViewRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el objeto Registro en la posición seleccionada
                Registro registroSeleccionado = registros.get(position);

                Intent intent = new Intent(ListarRegistrosActivity.this, DetalleRegistroActivity.class);
                intent.putExtra("registro", registroSeleccionado);
                startActivity(intent);
            }
        });


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                consultarPorFecha();
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

    private void consultarPorFecha() {
        String fecha = editTextFecha.getText().toString().trim();
        if (fecha.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese una fecha.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Consultar los registros por fecha
        listarRegistros1.consultarRegistrosPorFecha(fecha);

        // Obtener la lista de registros filtrados por fecha
        List<Registro> registros = listarRegistros1.getRegistros();

        // Mostrar los registros en el ListView
        if (!registros.isEmpty()) {
            ArrayAdapter<Registro> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registros);
            listViewRegistros.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No se encontraron registros para la fecha: " + fecha, Toast.LENGTH_SHORT).show();
            listViewRegistros.setAdapter(null); // Limpiar el ListView si no hay resultados
        }
    }
}
