package com.example.apphostal.Clases;

import android.widget.EditText;


public class ValorPredeterminado {

    public static void actualizarCampos(String estado, EditText edbajeras, EditText edencimeras,
                                        EditText edfundalomohada, EditText edprotectora, EditText ednordica,
                                        EditText edcolchav, EditText edtoallaD, EditText edtoallaL,
                                        EditText edalfombrim, EditText edpaid, EditText edprotectC) {
        switch (estado) {
            case "Salida":
            case "SalidaEntrada":
                edbajeras.setText("1");
                edencimeras.setText("1");
                edfundalomohada.setText("2");
                edprotectora.setText("0");
                ednordica.setText("0");
                edcolchav.setText("0");
                edtoallaD.setText("2");
                edtoallaL.setText("2");
                edalfombrim.setText("1");
                edpaid.setText("0");
                edprotectC.setText("0");
                break;

            case "NoMolestar":
            case "Estancia":
                edbajeras.setText("0");
                edencimeras.setText("0");
                edfundalomohada.setText("0");
                edprotectora.setText("0");
                ednordica.setText("0");
                edcolchav.setText("0");
                edtoallaD.setText("0");
                edtoallaL.setText("0");
                edalfombrim.setText("0");
                edpaid.setText("0");
                edprotectC.setText("0");
                break;

            default:
                // Resetea los valores para evitar confusión si el estado no coincide con ninguno de los casos
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
                break;
        }
    }
}
