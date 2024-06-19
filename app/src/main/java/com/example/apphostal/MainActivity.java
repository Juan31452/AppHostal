package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Activitys.AdicionarActivity;
import com.example.apphostal.Activitys.LavanderiaActivity;
import com.example.apphostal.Activitys.RegistrosActivity;
import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Fragments.UtilidadesFragment;


public class MainActivity extends AppCompatActivity {
   private Button btnUtilidades,btnAdicionar,btnListar, btnLavanderia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Obtiene una referencia al botón btnAdicionar
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnListar = findViewById(R.id.btnListar);
        btnUtilidades = findViewById(R.id.btnUtilidades);
        btnLavanderia =findViewById(R.id.btnLavanderia);

        // Crear una instancia de DatabaseHotel para llamar al método borrarBaseDatos

        //DatabaseHotel databaseHotel = new DatabaseHotel(this);
        //databaseHotel.borrarBaseDatos(this);

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
                Intent intent = new Intent(MainActivity.this, RegistrosActivity.class);
                startActivity(intent);
            }
        });

        btnUtilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del Fragment con el valor de edRegistro
                UtilidadesFragment fragment = UtilidadesFragment.newInstance();

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
                Intent intent = new Intent(MainActivity.this, LavanderiaActivity.class);
                startActivity(intent);
            }
        });



    }

}