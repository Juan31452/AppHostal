package com.example.apphostal.Clases;
import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class Calendario {

    public static void mostrarCalendario(Context context, final EditText editTextFecha) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Asegurarse de que el mes y el día tengan siempre dos dígitos
                        String month = String.format("%02d", monthOfYear + 1);
                        String day = String.format("%02d", dayOfMonth);
                        String date = year + "-" + month + "-" + day;
                        editTextFecha.setText(date);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

}