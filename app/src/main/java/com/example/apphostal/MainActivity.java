package com.example.apphostal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Database.DatabaseHotel;
import com.example.apphostal.Logica.ConsultaPorFechas;

public class MainActivity extends AppCompatActivity {
   private Button btnropasucia,btnAdicionar,btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Obtiene una referencia al botón btnAdicionar
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnListar = findViewById(R.id.btnListar);
        Button btnropasucia = findViewById(R.id.btnropasucia);

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
                
            }
        });


    }

}