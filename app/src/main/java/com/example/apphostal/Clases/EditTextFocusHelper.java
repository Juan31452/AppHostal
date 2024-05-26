package com.example.apphostal.Clases;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class EditTextFocusHelper {
    public static void setupEditTextFocus(final EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (editText.getText().toString().isEmpty()) {
                        editText.setText("0");
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editText.selectAll();
                        }
                    }, 200); // Ajusta el tiempo de retraso según sea necesario
                }
            }
        });
    }

    public static boolean isAnyEditTextEmpty(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getText().toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
