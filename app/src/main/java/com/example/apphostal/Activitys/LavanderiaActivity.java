package com.example.apphostal.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Fragments.LavanderiaFragment;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

import java.util.Base64;


public class LavanderiaActivity extends AppCompatActivity {
    private Button btnMenu,btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lavanderia);

        btnMenu = findViewById(R.id.btnMenu);
        btnNuevo = findViewById(R.id.btnNuevo);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LavanderiaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
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