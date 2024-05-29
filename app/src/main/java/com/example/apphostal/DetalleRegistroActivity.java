package com.example.apphostal;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apphostal.Logica.EliminarRegistros;
import com.example.apphostal.Logica.ModificarRegistros;

public class DetalleRegistroActivity extends AppCompatActivity {

    private EditText edhabitacion, edfecha, edestado, edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro;
    private Button btnMenu,btnEliminar, btnModificar, btnExtras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);
        edRegistro = findViewById(R.id.edRegistro);
        edhabitacion = findViewById(R.id.edhabitacion);
        edfecha = findViewById(R.id.editTextFecha); // Agregado
        edestado = findViewById(R.id.edestado);
        edbajeras = findViewById(R.id.edbajeras);
        edencimeras = findViewById(R.id.edencimeras);
        edfundalomohada = findViewById(R.id.edfundalomohada);
        edprotectora = findViewById(R.id.edprotectora);
        ednordica = findViewById(R.id.ednordica);
        edtoallaD = findViewById(R.id.edtoallaD);
        edtoallaL = findViewById(R.id.edtoallaL);
        edalfombrim = findViewById(R.id.edalfombrim);
        edpaid = findViewById(R.id.paid);
        edprotectC = findViewById(R.id.protectC);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnModificar = findViewById(R.id.btnModificar);
        btnMenu = findViewById(R.id.btnMenu);
        btnExtras = findViewById(R.id.btnExtras);

        // Inhabilitar edhabitacion y edfecha
        edhabitacion.setEnabled(false);
        edfecha.setEnabled(false);


        // Obtener el registro pasado desde ListarRegistrosActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("registro")) {
            String registro = intent.getStringExtra("registro");

            // Verificar y mostrar los valores en el Log
            Log.d("DetalleRegistroActivity", "Registro recibido: " + registro);

            // Parsear el registro y establecer los valores en los EditText
            if (registro != null) {
                // Dividir el registro por comas
                String[] partes = registro.split(",");
                Log.d("DetalleRegistroActivity", "Número de partes: " + partes.length);
                for (int i = 0; i < partes.length; i++) {
                    Log.d("DetalleRegistroActivity", "Parte [" + i + "]: " + partes[i]);
                }

                // Comprobar que hay 14 partes antes de asignarlas
                if (partes.length == 14) {
                    // Asignar los valores a los EditText correspondientes
                    edRegistro.setText(partes[0].trim());
                    edfecha.setText(partes[1].trim());
                    edhabitacion.setText(partes[2].trim());
                    edestado.setText(partes[3].trim());
                    edbajeras.setText(partes[4].trim());
                    edencimeras.setText(partes[5].trim());
                    edfundalomohada.setText(partes[6].trim());
                    edprotectora.setText(partes[7].trim());
                    ednordica.setText(partes[8].trim());
                    edtoallaD.setText(partes[9].trim());
                    edtoallaL.setText(partes[10].trim());
                    edalfombrim.setText(partes[11].trim());
                    edpaid.setText(partes[12].trim());
                    edprotectC.setText(partes[13].trim());
                } else {
                    Log.e("DetalleRegistroActivity", "El número de campos no es el esperado.");
                }
            } else {
                Log.e("DetalleRegistroActivity", "Registro recibido es null");
            }
        } else {
            Log.e("DetalleRegistroActivity", "Intent no contiene 'registro'");
        }

        // Configurar el botón de modificar
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarRegistro();
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleRegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Configurar el evento onClick para el botón de eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarEliminarRegistro();
            }
        });

        btnExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el valor de edRegistro
                String registroId = edRegistro.getText().toString().trim();

                // Imprimir el valor en el Log
                Log.d("Valor de edRegistro", registroId);

                // Crear una instancia del Fragment con el valor de edRegistro
                Extras fragment = Extras.newInstance(registroId);

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

    private void modificarRegistro() {
        String fecha = edfecha.getText().toString().trim(); // Agregado
        String habitacion = edhabitacion.getText().toString().trim();
        String estado = edestado.getText().toString().trim();
        String bajeras = edbajeras.getText().toString().trim();
        String encimeras = edencimeras.getText().toString().trim();
        String fundaAlmohada = edfundalomohada.getText().toString().trim();
        String protectorAlmohada = edprotectora.getText().toString().trim();
        String nordica = ednordica.getText().toString().trim();
        String toallaDucha = edtoallaD.getText().toString().trim();
        String toallaLavabo = edtoallaL.getText().toString().trim();
        String alfombrin = edalfombrim.getText().toString().trim();
        String paid = edpaid.getText().toString().trim();
        String protectorColchon = edprotectC.getText().toString().trim();

        // Crear una instancia de ModificarRegistros
        ModificarRegistros modificarRegistros = new ModificarRegistros(this);

        // Llamar al método modificarRegistro
        boolean resultado = modificarRegistros.modificarRegistro(habitacion, estado, bajeras, encimeras, fundaAlmohada, protectorAlmohada, nordica, toallaDucha, toallaLavabo, alfombrin, paid, protectorColchon);

        // Mostrar un mensaje según el resultado
        if (resultado) {
            Toast.makeText(this, "Registro modificado con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al modificar el registro", Toast.LENGTH_SHORT).show();
        }
    }

    private void confirmarEliminarRegistro() {

        new AlertDialog.Builder(this)
                .setTitle("Confirmar Eliminación")
                .setMessage("¿Está seguro de que desea eliminar este registro?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eliminarRegistro();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    private void eliminarRegistro() {
        String fecha = edfecha.getText().toString().trim();
        String habitacion = edhabitacion.getText().toString().trim();

        if (!fecha.isEmpty() && !habitacion.isEmpty()) {
            EliminarRegistros eliminarRegistros = new EliminarRegistros(this);
            boolean resultado = eliminarRegistros.eliminarRegistro(fecha, habitacion);

            if (resultado) {
                Toast.makeText(this, "Registro eliminado con éxito", Toast.LENGTH_SHORT).show();
                finish(); // Finalizar la actividad y volver a la anterior
            } else {
                Toast.makeText(this, "Error al eliminar el registro", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No se puede eliminar un registro con datos vacíos", Toast.LENGTH_SHORT).show();
        }
    }


}
