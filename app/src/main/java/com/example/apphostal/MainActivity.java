package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Obtiene una referencia al botón btnAdicionar
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnListar = findViewById(R.id.btnListar);
        Button btnExtras = findViewById(R.id.btnExtras);

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

        btnExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del Fragment
                Extras fragment = new Extras();

                // Obtener el FragmentManager y comenzar una transacción
                FragmentManager fragmentManager  = getSupportFragmentManager();
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