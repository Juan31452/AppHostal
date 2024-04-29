package com.example.apphostal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.Estado;
import com.example.apphostal.Clases.Habitacion;

public class AdicionarActivity extends AppCompatActivity {
    private EditText editTextFecha;
    private EditText edhabitacion;
    private EditText edestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar);

        // Inicializar los EditText
        editTextFecha = findViewById(R.id.editTextFecha);
        edhabitacion = findViewById(R.id.edhabitacion);
        edestado = findViewById(R.id.edestado);

        // Obtiene una referencia al botón btnMenu
        Button btnMenu = findViewById(R.id.btnMenu);

        edhabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListaHabitaciones();
            }
        });

        edestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListaEstado();
            }
        });

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

    // Método para mostrar la lista de habitaciones en un diálogo de selección
    private void mostrarListaHabitaciones() {
        // Obtén la lista de habitaciones desde la clase Habitacion
        String[] habitaciones = Habitacion.obtenerHabitaciones();

        // Crea un diálogo de selección con la lista de habitaciones
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lista de Habitaciones")
                .setItems(habitaciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de una habitación (puedes hacer lo que necesites con ella)
                        String habitacionSeleccionada = habitaciones[which];
                        // Por ejemplo, puedes establecer la habitación seleccionada en el EditText
                        edhabitacion.setText(habitacionSeleccionada);
                    }
                });
        builder.create().show();
    }

    // Método para mostrar la lista de estados
    private void mostrarListaEstado() {
        // Obtén la lista de estados desde la clase Estado
        String[] estado = Estado.obtenerEstado();

        // Crea un diálogo de selección con la lista de estado
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lista de Estados")
                .setItems(Estado.obtenerEstado(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Maneja la selección de un estado (puedes hacer lo que necesites con él)
                        String estadoSeleccionado = Estado.obtenerEstado()[which];
                        // Por ejemplo, puedes establecer el estado seleccionado en el EditText
                        edestado.setText(estadoSeleccionado);
                    }
                });

        builder.create().show();
    }

}

