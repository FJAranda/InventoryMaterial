package com.example.inventoryMVP.ui.login;

/**
 * Contiene los metodos necesarios/expuestos
 */

public interface LoginView {
    void navigateToHome();
    void setUserEmptyError();
    void setPasswordEmptyError();
    void setPasswordError();
}
