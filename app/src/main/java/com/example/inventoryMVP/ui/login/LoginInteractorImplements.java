package com.example.inventoryMVP.ui.login;

import com.example.inventoryMVP.repository.UserRepository;
import com.example.inventoryMVP.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImplements {
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener){
        //Realiza todas las comprobaciones
        if (password.isEmpty()){
            listener.onPasswordEmptyError();
        } else if(user.isEmpty()) {
            listener.onUserEmptyError();
        }else if(!CommonUtils.isPasswordValid(password)) {
            listener.onPasswordError();
        }else if (UserRepository.getInstance().validateCredentials(user, password)){
            listener.onSuccess();
        }
    }
}
