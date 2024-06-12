package com.example.apphostal.Activitys;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apphostal.Clases.Calendario;
import com.example.apphostal.Clases.EditTextFocusHelper;
import com.example.apphostal.Clases.Estado;
import com.example.apphostal.Clases.Habitacion;
import com.example.apphostal.Clases.Opciones;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Logica.Registros.AdicionarRegistros;
import com.example.apphostal.MainActivity;
import com.example.apphostal.R;

public class AdicionarActivity extends AppCompatActivity {
    private EditText editTextFecha,edhabitacion,edestado,edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edcolchav,edtoallaD,edtoallaL,edalfombrim,edpaid,edprotectC;
    private Button btnMenu;
    // Declara la variable adicionarRegistros aquí
    private AdicionarRegistros adicionarRegistros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar);

        // Inicializar los EditText

        editTextFecha = findViewById(R.id.editTextFecha);
        edhabitacion = findViewById(R.id.edhabitacion);
        edestado = findViewById(R.id.edestado);
        edbajeras = findViewById(R.id.edbajeras);
        edencimeras = findViewById(R.id.edencimeras);
        edfundalomohada = findViewById(R.id.edfundalomohada);
        edprotectora = findViewById(R.id.edprotectora);
        ednordica = findViewById(R.id.ednordica);
        edcolchav = findViewById(R.id.edcolchav);
        edtoallaD = findViewById(R.id.edtoallaD);
        edtoallaL = findViewById(R.id.edtoallaL);
        edalfombrim = findViewById(R.id.edalfombrim);
        edpaid = findViewById(R.id.paid);
        edprotectC = findViewById(R.id.protectC);

        // Obtiene una referencia al botón btnMenu
        Button btnMenu = findViewById(R.id.btnMenu);

        // Asignar acción al botón "Enviar Datos"
        Button btnEnviarDatos = findViewById(R.id.btnEnviarDatos);

        // Inicializar la clase AdicionarRegistros
        adicionarRegistros = new AdicionarRegistros(this);
        // Crea una instancia de Opciones
        Opciones opciones = new Opciones(this, edhabitacion, edestado);


        edhabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opciones.mostrarListaHabitaciones();
            }
        });

        edestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opciones.mostrarListaEstado();
            }
        });


        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Verificar si algún EditText está vacío
                if (EditTextFocusHelper.isAnyEditTextEmpty(editTextFecha,edhabitacion,edestado, edbajeras,edencimeras,edfundalomohada,edprotectora,ednordica,edtoallaD,edtoallaL, edalfombrim,edpaid,edprotectC/* otros EditText */)) {
                    // Mostrar mensaje de error
                    Toast.makeText(getApplicationContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                    // Guardar los datos
                } else {
                    enviarDatos();
                }
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


        // Llama a EditTextFocusHelper.setupEditTextFocus() para configurar el comportamiento del EditText deseado
        EditTextFocusHelper.setupEditTextFocus(edbajeras);
        EditTextFocusHelper.setupEditTextFocus(edencimeras);
        EditTextFocusHelper.setupEditTextFocus(edfundalomohada);
        EditTextFocusHelper.setupEditTextFocus(edprotectora);
        EditTextFocusHelper.setupEditTextFocus(ednordica);
        EditTextFocusHelper.setupEditTextFocus(edcolchav);
        EditTextFocusHelper.setupEditTextFocus(edtoallaD);
        EditTextFocusHelper.setupEditTextFocus(edtoallaL);
        EditTextFocusHelper.setupEditTextFocus(edalfombrim);
        EditTextFocusHelper.setupEditTextFocus(edpaid);
        EditTextFocusHelper.setupEditTextFocus(edprotectC);

    }

    public void mostrarCalendario(View view) {

        Calendario.mostrarCalendario(this, editTextFecha);
    }

    // Método para enviar los datos ingresados
    private void enviarDatos() {
        String fecha = editTextFecha.getText().toString();
        String habitacion = edhabitacion.getText().toString();
        String estado = edestado.getText().toString();
        String bajera = edbajeras.getText().toString();
        String encimera = edencimeras.getText().toString();
        String fundaA = edfundalomohada.getText().toString();
        String protectorA = edprotectora.getText().toString();
        String nordica = ednordica.getText().toString();
        String colchav = edcolchav.getText().toString();
        String toallaD = edtoallaD.getText().toString();
        String toallaL = edtoallaL.getText().toString();
        String alfombrin = edalfombrim.getText().toString();
        String paid = edpaid.getText().toString();
        String protectorC = edprotectC.getText().toString();


        Registro registro = new Registro(fecha, habitacion, estado, bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC);

        adicionarRegistros.insertarRegistro(registro);

        // Limpiar los campos después de guardar
        editTextFecha.setText("");
        edhabitacion.setText("");
        edestado.setText("");
        edbajeras.setText("");
        edencimeras.setText("");
        edfundalomohada.setText("");
        edprotectora.setText("");
        ednordica.setText("");
        edcolchav.setText("");
        edtoallaD.setText("");
        edtoallaL.setText("");
        edalfombrim.setText("");
        edpaid.setText("");
        edprotectC.setText("");
    }

}

