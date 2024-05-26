package com.example.apphostal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRegistroActivity extends AppCompatActivity {

    private EditText edhabitacion;
    private EditText edestado;
    private EditText edbajeras;
    private EditText edencimeras;
    private EditText edfundalomohada;
    private EditText edprotectora;
    private EditText ednordica;
    private EditText edtoallaD;
    private EditText edtoallaL;
    private EditText edalfombrim;
    private EditText edpaid;
    private EditText edprotectC;
    private Button btnMenu,btnEliminar, btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);
        btnMenu = findViewById(R.id.btnMenu);
        edhabitacion = findViewById(R.id.edhabitacion);
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
        //btnEliminar = findViewById(R.id.btnEliminar);
        btnModificar = findViewById(R.id.btnModificar);

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

                // Comprobar que hay 13 partes antes de asignarlas
                if (partes.length == 13) {
                    // Asignar los valores a los EditText correspondientes
                    edhabitacion.setText(partes[1].trim());
                    edestado.setText(partes[2].trim());
                    edbajeras.setText(partes[3].trim());
                    edencimeras.setText(partes[4].trim());
                    edfundalomohada.setText(partes[5].trim());
                    edprotectora.setText(partes[6].trim());
                    ednordica.setText(partes[7].trim());
                    edtoallaD.setText(partes[8].trim());
                    edtoallaL.setText(partes[9].trim());
                    edalfombrim.setText(partes[10].trim());
                    edpaid.setText(partes[11].trim());
                    edprotectC.setText(partes[12].trim());
                } else {
                    Log.e("DetalleRegistroActivity", "El número de campos no es el esperado.");
                }
            } else {
                Log.e("DetalleRegistroActivity", "Registro recibido es null");
            }
        } else {
            Log.e("DetalleRegistroActivity", "Intent no contiene 'registro'");
        }
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleRegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
