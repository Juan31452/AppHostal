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
    private Button btnMenu, btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);

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
        btnMenu = findViewById(R.id.btnMenu);
        btnModificar = findViewById(R.id.btnModificar);

        String registro = getIntent().getStringExtra("registro");
        if (registro != null) {
            Log.d("DetalleRegistroActivity", "Registro recibido: " + registro);
            String[] datos = registro.split(", ");

            for (int i = 0; i < datos.length; i++) {
                Log.d("DetalleRegistroActivity", "Datos[" + i + "]: " + datos[i]);
            }

            if (datos.length == 13) { // Verificar que se han recibido todos los datos esperados
                edhabitacion.setText(datos[0].split(": ")[1]);
                edestado.setText(datos[1].split(": ")[1]);
                edbajeras.setText(datos[2].split(": ")[1]);
                edencimeras.setText(datos[3].split(": ")[1]);
                edfundalomohada.setText(datos[4].split(": ")[1]);
                edprotectora.setText(datos[5].split(": ")[1]);
                ednordica.setText(datos[6].split(": ")[1]);
                edtoallaD.setText(datos[7].split(": ")[1]);
                edtoallaL.setText(datos[8].split(": ")[1]);
                edalfombrim.setText(datos[9].split(": ")[1]);
                edpaid.setText(datos[10].split(": ")[1]);
                edprotectC.setText(datos[11].split(": ")[1]);
            } else {
                Log.e("DetalleRegistroActivity", "El número de campos no es el esperado.");
            }
        }
        // Configura un OnClickListener para el botón btnMenu
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Este método se ejecutará cuando se haga clic en el botón btnMenu

                Intent intent = new Intent(DetalleRegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
