package com.example.apphostal.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Adapters.DetallesAdapterLavanderia;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Fragments.LavanderiaFragment;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class LavanderiaActivity extends AppCompatActivity implements DetallesAdapterLavanderia.OnItemClickListener {

    private RecyclerView recyclerView;
    private DetallesAdapterLavanderia adapter;
    private ListarLavanderia listarlavanderia;
    private List<Lavanderia> dataList;
    private Button btnMenu, btnEntrega, btnBuscar;
    private EditText editTextFechaConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavanderia);

        editTextFechaConsulta = findViewById(R.id.editTextFechaConsulta);
        btnMenu = findViewById(R.id.btnMenu);
        btnEntrega = findViewById(R.id.btnEntrega);
        btnBuscar = findViewById(R.id.btnBuscar);

        // Instanciar la clase ListarLavanderia
        listarlavanderia = new ListarLavanderia(this);

        // Llamar al método consultarLavanderia()
        dataList = listarlavanderia.consultarLavanderia();
        Log.d("Lista", "Elemento clicado: " + dataList.toString());

        if (dataList != null && !dataList.isEmpty()) {
            adapter = new DetallesAdapterLavanderia(dataList, this);
            adapter.setOnItemClickListener(this);

            recyclerView = findViewById(R.id.recyclerView);
            if (recyclerView == null) {
                throw new NullPointerException("RecyclerView is null. Check the XML layout file.");
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        } else {
            Log.d("Lavanderia", "No se encontraron datos.");
        }

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(LavanderiaActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btnEntrega.setOnClickListener(v -> {
            LavanderiaFragment fragment = LavanderiaFragment.newInstance();

            // Obtener el FragmentManager y comenzar una transacción
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Reemplazar el contenido del contenedor de fragmentos con este nuevo Fragment
            fragmentTransaction.replace(R.id.fragment_container, fragment);

            // Añadir la transacción al back stack (opcional)
            fragmentTransaction.addToBackStack(null);

            // Commit de la transacción
            fragmentTransaction.commit();
        });
    }

    @Override
    public void onItemClick(int position) {
        // Manejar los clics en los ítems del RecyclerView
        Lavanderia lavanderia = dataList.get(position);
        // Realizar acciones con el objeto Lavanderia seleccionado
        Log.d("Lavanderia", "Elemento clicado: " + lavanderia.toString());
    }
}
