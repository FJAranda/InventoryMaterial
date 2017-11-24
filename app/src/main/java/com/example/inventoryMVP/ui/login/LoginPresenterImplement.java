package com.example.inventoryMVP.ui.login;

import android.content.Intent;

import com.example.inventoryMVP.DashboardActivity;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImplement implements LoginPresenter,LoginInteractor.OnLoginFinishedListener  {

    private LoginView loginView;
    private LoginInteractorImplements loginInteractor;

    public LoginPresenterImplement(LoginView loginView){
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImplements();
    }

    @Override
    public void validateCredentials(String user, String Password) {
        loginInteractor.validateCredentials(user, Password, this);
        loginView.navigateToHome();

    }

    @Override
    public void onUserEmptyError() {
        loginView.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }

    public void onDestroy(){
        loginView = null;
        loginInteractor = null;
    }
}
