package com.android.dwealthapp.utils;

import android.util.Patterns;

public class Validations {
    public static boolean isFieldEmpty(String text) {
        if (text.trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(String text){
        return Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }
}
