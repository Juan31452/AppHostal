package com.example.apphostal.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.OnItemClickListener;
import com.example.apphostal.Clases.DetallesAdapter;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Fragments.AdicionarFragment;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.Fragments.ModificarFragment;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class RegistrosActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerView;
    private DetallesAdapter adapter;
    private List<Registro> dataList;
    private ListarRegistros1 listarRegistros1;
    private Button btnMenu, btnNuevo, btnBuscar;
    private EditText editTextFecha;

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        editTextFecha = findViewById(R.id.editTextFecha);
        btnMenu = findViewById(R.id.btnMenu);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnBuscar = findViewById(R.id.btnBuscar);

        listarRegistros1 = new ListarRegistros1(this);
        listarRegistros1.consultarRegistros();
        dataList = listarRegistros1.getRegistros();


        adapter = new DetallesAdapter(dataList, this);
        adapter.setOnItemClickListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView == null) {
            throw new NullPointerException("RecyclerView is null. Check the XML layout file.");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrosActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdicionarFragment fragment = AdicionarFragment.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });
        btnBuscar.setOnClickListener(v -> consultarPorFecha());

    }

    public void mostrarCalendario() {

        Calendario.mostrarCalendario(this, editTextFecha);
    }

    private void consultarPorFecha() {
        String fecha = editTextFecha.getText().toString().trim();
        if (fecha.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese una fecha.", Toast.LENGTH_SHORT).show();
            return;
        }

        listarRegistros1.consultarRegistrosPorFecha(fecha);
        dataList = listarRegistros1.getRegistros();

        adapter = new DetallesAdapter(dataList, this);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int itemId) {
        ModificarFragment fragment = new ModificarFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("itemId", itemId);
        Log.d("Datos del registro", String.valueOf(itemId));
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
