package com.example.apphostal.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphostal.Clases.DetallesAdapter;
import com.example.apphostal.Clases.Registro;
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
    private Button btnMenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        btnMenu = findViewById(R.id.btnMenu);

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
    }


}
