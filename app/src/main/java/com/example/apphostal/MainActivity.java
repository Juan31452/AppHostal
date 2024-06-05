package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Fragments.ConsultaPorFechasFragment;
import com.example.apphostal.Fragments.LavanderiaFragment;

public class MainActivity extends AppCompatActivity {
   private Button btnropasucia,btnAdicionar,btnListar, btnLavanderia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Obtiene una referencia al botón btnAdicionar
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnListar = findViewById(R.id.btnListar);
        btnropasucia = findViewById(R.id.btnropasucia);
        btnLavanderia =findViewById(R.id.btnLavanderia);

        // Crear una instancia de DatabaseHotel para llamar al método borrarBaseDatos

        //DatabaseHotel databaseHotel = new DatabaseHotel(this);
        //atabaseHotel.borrarBaseDatos(this);

        // Configura un OnClickListener para el botón btnAdicionar
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Este método se ejecutará cuando se haga clic en el botón btnAdicionar
                Intent intent = new Intent(MainActivity.this, AdicionarActivity.class);
                startActivity(intent);
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Este método se ejecutará cuando se haga clic en el botón btnlistnar
                Intent intent = new Intent(MainActivity.this, ListarRegistrosActivity.class);
                startActivity(intent);
            }
        });

        btnropasucia.setOnClickListener(new View.OnClickListener() {
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

        btnLavanderia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });



    }

}