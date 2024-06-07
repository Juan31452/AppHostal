package com.example.apphostal.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.DetallesAdapter;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Fragments.AdicionarFragment;
import com.example.apphostal.Fragments.ConsultaPorFechasFragment;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.ArrayList;
import java.util.List;

public class RegistrosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DetallesAdapter adapter;
    private List<Registro> dataList;
    private ListarRegistros1 listarRegistros1;
    private Button btnMenu, btnNuevo,btnBuscar;
    private EditText editTextFecha;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        editTextFecha = findViewById(R.id.editTextFecha);
        btnMenu = findViewById(R.id.btnMenu);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnBuscar = findViewById(R.id.btnBuscar);

        // Vincula el RecyclerView con el ID definido en el archivo de diseño
        recyclerView = findViewById(R.id.recyclerView);

        if (recyclerView == null) {
            throw new NullPointerException("RecyclerView is null. Check the XML layout file.");
        }
        // Configura el RecyclerView con un LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configura el RecyclerView con un LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear una instancia de ListarRegistros1
        listarRegistros1 = new ListarRegistros1(this);

        // Consultar los registros
        listarRegistros1.consultarRegistros();

        // Obtener la lista de registros
        dataList = listarRegistros1.getRegistros();

        // Configura el Adapter con la lista de objetos Registro
        adapter = new DetallesAdapter(dataList);

        // Vincula el Adapter al RecyclerView
        recyclerView.setAdapter(adapter);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrosActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del Fragment con el valor de edRegistro
                AdicionarFragment fragment = AdicionarFragment.newInstance();

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
                consultarPorFecha();
            }
        });
    }
    public void mostrarCalendario(View view) {
        Calendario.mostrarCalendario(this, editTextFecha);
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

        // Obtener la lista de registros
        dataList = listarRegistros1.getRegistros();

        // Configura el Adapter con la lista de objetos Registro
        adapter = new DetallesAdapter(dataList);

        // Vincula el Adapter al RecyclerView
        recyclerView.setAdapter(adapter);
        }
    }


