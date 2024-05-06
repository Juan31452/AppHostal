package com.example.apphostal;

import static com.example.apphostal.R.layout.activity_listar_registros;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apphostal.Logica.ListarRegistros;

import java.util.List;

public class ListarRegistrosActivity extends AppCompatActivity {
    private ListView listViewRegistros;
    private ListarRegistros listarRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_listar_registros);

        // Inicializar la instancia de ListarRegistros
        listarRegistros = new ListarRegistros(this);

        // Obtener la referencia del ListView desde el layout
        listViewRegistros = findViewById(R.id.listViewRegistros);

        // Obtener la lista de registros
        List<String> listaRegistros = listarRegistros.obtenerRegistros();

        // Configurar el adaptador del ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaRegistros);
        listViewRegistros.setAdapter(adapter);
    }
}
