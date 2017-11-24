package com.example.inventoryMVP.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Metodo que comprueba que la contraseña tenga los siguientes requisitos:
     * - Al menos un digito
     * - Al menos un caracter en Mayuscula
     * - Al menos un caracter en minuscula
     * - Longitud minima de 6 caracteres
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        pattern = Pattern.compile(PASSWORD_PATERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
