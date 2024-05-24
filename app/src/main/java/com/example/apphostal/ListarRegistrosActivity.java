package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Logica.ListarRegistros;
import java.util.List;

public class ListarRegistrosActivity extends AppCompatActivity {
    private EditText editTextFecha;
    private ListView listViewRegistros;
    private ListarRegistros listarRegistros;
    private List<String> registros;
    private Button btnMenu, btnBuscar;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registros);
        listViewRegistros.setAdapter(adapter);

        listViewRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String registroSeleccionado = registros.get(position);
                Intent intent = new Intent(ListarRegistrosActivity.this, DetalleRegistroActivity.class);
                intent.putExtra("registro", registroSeleccionado);
                startActivity(intent);
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
}
