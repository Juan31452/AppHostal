package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apphostal.Clases.Calendario;

public class AdicionarActivity extends AppCompatActivity {
    private EditText editTextFecha;
    private EditText edhabitacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar);

        // Inicializar los EditText
        editTextFecha = findViewById(R.id.editTextFecha);

        // Obtiene una referencia al botón btnMenu
        Button btnMenu = findViewById(R.id.btnMenu);



        // Configura un OnClickListener para el botón btnMenu
        btnMenu.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                // Este método se ejecutará cuando se haga clic en el botón btnMenu

                Intent intent = new Intent(AdicionarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void mostrarCalendario(View view) {
        Calendario.mostrarCalendario(this, editTextFecha);
    }
}