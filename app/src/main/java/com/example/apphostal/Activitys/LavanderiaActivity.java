package com.example.apphostal.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Adapters.DetallesAdapterLavanderia;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Fragments.Lavanderia.LavanderiaFragment;
import com.example.apphostal.Fragments.Lavanderia.LavanderiaFragment1;
import com.example.apphostal.Fragments.Lavanderia.LavanderiaMoFragment;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia;
import com.example.apphostal.Logica.Lavanderia.ListarLavanderia1;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.List;

public class LavanderiaActivity extends AppCompatActivity implements DetallesAdapterLavanderia.OnItemClickListener {

    private RecyclerView recyclerView;
    private DetallesAdapterLavanderia adapter;
    private ListarLavanderia listarlavanderia;
    private ListarLavanderia1 listarlavanderia1;
    private List<Lavanderia> dataList;
    private List<Lavanderia> dataList1;
    private Button btnMenu, btnEntrega, btnBuscar,btnModificar;
    private EditText editTextFechaConsulta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavanderia);

        editTextFechaConsulta = findViewById(R.id.editTextFechaConsulta);
        btnMenu = findViewById(R.id.btnMenu);
        btnEntrega = findViewById(R.id.btnEntrega);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnModificar = findViewById(R.id.btnModificar);

        // Instanciar la clase ListarLavanderia
       // listarlavanderia = new ListarLavanderia(this);
        listarlavanderia1 = new ListarLavanderia1(this);

        // Llamar al método consultarLavanderia()
        //dataList = listarlavanderia.consultarLavanderia();
        dataList1 = listarlavanderia1.consultarLavanderia();

       // Log.d("Lista", "Elemento clicado: " + dataList.toString());
        Log.d("Lista1", "Elemento clicado: " + dataList1.toString());

        if (dataList1 != null && !dataList1.isEmpty()) {
            adapter = new DetallesAdapterLavanderia(dataList1, this);
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

        editTextFechaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });

        btnEntrega.setOnClickListener(v -> {
            // Crear una instancia del fragment
            Fragment lavanderiaFragment1 = LavanderiaFragment1.newInstance();

            // Añadir el fragment al contenedor
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, lavanderiaFragment1);
            fragmentTransaction.commit();
        });

        btnModificar.setOnClickListener(v -> {

            // Obtener el ID del registro seleccionado del adaptador
            int selectedId = adapter.getSelectedId();
            Log.d("ItemId", String.valueOf(selectedId));

            // Crear un nuevo fragmento para modificar el registro
           LavanderiaMoFragment fragment = LavanderiaMoFragment.newInstance(selectedId);

            // Reemplazar el fragmento actual con el fragmento de modificación
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

        });
    }

    public void mostrarCalendario() {

        Calendario.mostrarCalendario(this, editTextFechaConsulta);
    }

    @Override
    public void onItemClick(int position) {
        // Manejar los clics en los ítems del RecyclerView
        Lavanderia lavanderia = dataList1.get(position);
        // Realizar acciones con el objeto Lavanderia seleccionado
        Log.d("Lavanderia", "Elemento clicado: " + lavanderia.toString());
    }


}
