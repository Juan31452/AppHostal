package com.example.apphostal.Clases;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.apphostal.R;

public class OpcionesFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        builder.setTitle("Opciones")
                .setItems(new String[]{"Extras", "Modificar"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                mostrarExtras();
                                break;
                            case 1:
                                modificarRegistro();
                                break;
                        }
                    }
                });
        AlertDialog dialog = builder.create();

        // Mueve el diálogo a la izquierda de la ventana principal
        dialog.getWindow().setGravity(Gravity.START | Gravity.TOP);

        return dialog;
    }

    private void mostrarExtras() {
        // Implementa la lógica para mostrar Extras
    }

    private void modificarRegistro() {
        // Implementa la lógica para modificar el registro
    }
}
