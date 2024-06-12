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
import com.example.apphostal.Fragments.ConsultaPorFechasFragment;
import com.example.apphostal.Fragments.ExtrasFragment;
import com.example.apphostal.Logica.Registros.ListarRegistros1;
import com.example.apphostal.Fragments.ModificarFragment;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.ArrayList;
import java.util.List;

public class RegistrosActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerView;
    private DetallesAdapter adapter;
    private List<Registro> dataList;
    private ListarRegistros1 listarRegistros1;
    private Button btnMenu, btnNuevo, btnBuscar, btnModificar,btnExtras,btnRopaSucia;
    private EditText editTextFechaConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        editTextFechaConsulta = findViewById(R.id.editTextFechaConsulta);
        btnMenu = findViewById(R.id.btnMenu);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnModificar = findViewById(R.id.btnModificar);
        btnExtras = findViewById(R.id.btnExtras);
        btnRopaSucia = findViewById(R.id.btnRopaSucia);

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

        btnNuevo.setOnClickListener(v -> {
            AdicionarFragment fragment = AdicionarFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


        editTextFechaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });

        btnBuscar.setOnClickListener(v -> consultarPorFecha());

        btnModificar.setOnClickListener(v -> {

                // Obtener el ID del registro seleccionado del adaptador
                int selectedId = adapter.getSelectedId();
                Log.d("ItemId", String.valueOf(selectedId));

                // Crear un nuevo fragmento para modificar el registro
                ModificarFragment fragment = ModificarFragment.newInstance(selectedId);

                // Reemplazar el fragmento actual con el fragmento de modificación
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();

        });

        btnExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el ID del registro seleccionado del adaptador
                int selectedId = adapter.getSelectedId();

                // Crear una instancia del Fragment con el valor de edRegistro
                ExtrasFragment fragment = ExtrasFragment.newInstance(String.valueOf(selectedId));

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

        btnRopaSucia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del Fragment con el valor de edRegistro
                ConsultaPorFechasFragment fragment = ConsultaPorFechasFragment.newInstance();

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


    }

    public void mostrarCalendario() {

        Calendario.mostrarCalendario(this, editTextFechaConsulta);
    }

    private void consultarPorFecha() {
        String fecha = editTextFechaConsulta.getText().toString().trim();
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
    public void onItemClick(int id) {
        // Puedes utilizar id y fecha aquí según sea necesario
    //    Log.d("Bajera", String.valueOf(bajera));
        Log.d("Id", String.valueOf(id));

    }
}
