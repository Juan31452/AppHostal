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
import com.example.apphostal.Clases.Estado;
import com.example.apphostal.Clases.Registro;
import com.example.apphostal.Fragments.ExtrasFragment;
import com.example.apphostal.Logica.Registros.EliminarRegistros;
;
import com.example.apphostal.Logica.Registros.ModificarRegistros;

public class DetalleRegistroActivity extends AppCompatActivity {

    private EditText edhabitacion, edfecha, edestado, edbajeras, edencimeras, edfundalomohada, edprotectora, ednordica,edcolchav, edtoallaD, edtoallaL, edalfombrim, edpaid, edprotectC,edRegistro;
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
        edcolchav = findViewById(R.id.edcolchav);
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
            Registro registro = (Registro) intent.getSerializableExtra("registro");

            //String registro = intent.getStringExtra("registro");

            // Verificar y mostrar los valores en el Log
            Log.d("DetalleRegistroActivity", "Registro recibido: " + registro);


            // Asignar los valores a los EditText correspondientes
            edRegistro.setText(String.valueOf(registro.getId()));
            edfecha.setText(registro.getFecha());
            edhabitacion.setText(registro.getHabitacion());
            edestado.setText(registro.getEstado());
            edbajeras.setText(registro.getBajera());
            edencimeras.setText(registro.getEncimera());
            edfundalomohada.setText(registro.getFundaA());
            edprotectora.setText(registro.getProtectorA());
            ednordica.setText(registro.getNordica());
            edcolchav.setText(registro.getColchav());
            edtoallaD.setText(registro.getToallaD());
            edtoallaL.setText(registro.getToallaL());
            edalfombrim.setText(registro.getAlfombrin());
            edpaid.setText(registro.getPaid());
            edprotectC.setText(registro.getProtectorC());


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

                // Crear una instancia del Fragment con el valor de edRegistro
                ExtrasFragment fragment = ExtrasFragment.newInstance(registroId);

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
    public void mostrarListaEstado(View view) {

        Estado.mostrarListaEstado(this, edestado);
    }

    private void modificarRegistro() {
        int id = Integer.parseInt(edRegistro.getText().toString().trim());
        String fecha = edfecha.getText().toString().trim(); // Agregado
       // String habitacion = edhabitacion.getText().toString().trim();
        String estado = edestado.getText().toString().trim();
        String bajeras = edbajeras.getText().toString().trim();
        String encimeras = edencimeras.getText().toString().trim();
        String fundaAlmohada = edfundalomohada.getText().toString().trim();
        String protectorAlmohada = edprotectora.getText().toString().trim();
        String nordica = ednordica.getText().toString().trim();
        String colchav = edcolchav.getText().toString().trim();
        String toallaDucha = edtoallaD.getText().toString().trim();
        String toallaLavabo = edtoallaL.getText().toString().trim();
        String alfombrin = edalfombrim.getText().toString().trim();
        String paid = edpaid.getText().toString().trim();
        String protectorColchon = edprotectC.getText().toString().trim();

        // Crear una instancia de ModificarRegistros
        ModificarRegistros modificarRegistros = new ModificarRegistros(this);

        // Llamar al método modificarRegistro
        boolean resultado = modificarRegistros.modificarRegistro(id, estado, bajeras, encimeras, fundaAlmohada, protectorAlmohada, nordica,colchav, toallaDucha, toallaLavabo, alfombrin, paid, protectorColchon);

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
