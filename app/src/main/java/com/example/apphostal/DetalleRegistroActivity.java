package com.example.apphostal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRegistroActivity extends AppCompatActivity {
    private EditText edfecha;
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
    private Button btnEliminar, btnModificar;
    private static final String TAG = "DetalleRegistroActivity"; // Definir el TAG

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);
        edfecha = findViewById(R.id.editTextFecha);
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
        btnModificar = findViewById(R.id.btnModificar);

        // Obtener el registro pasado desde ListarRegistrosActivity
        String registro = getIntent().getStringExtra("registro");
        Log.d(TAG, "Registro recibido: " + registro); // Uso del TAG

        if (registro != null) {
            String[] partes = registro.split(",");
            edfecha.setText(partes[0]);
            edhabitacion.setText(partes[1]);
            edestado.setText(partes[2]);
            edbajeras.setText(partes[3]);
            edencimeras.setText(partes[4]);
            edfundalomohada.setText(partes[5]);
            edprotectora.setText(partes[6]);
            ednordica.setText(partes[7]);
            edtoallaD.setText(partes[8]);
            edtoallaL.setText(partes[9]);
            edalfombrim.setText(partes[10]);
            edpaid.setText(partes[11]);
            edprotectC.setText(partes[12]);
        }
    }
}
