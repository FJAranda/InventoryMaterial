package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.repository.DependencyRepository;
import com.example.inventoryMVP.repository.UserRepository;
import com.example.inventoryMVP.ui.login.LoginInteractor;
import com.example.inventoryMVP.utils.CommonUtils;

/**
 * Created by usuario on 24/11/17.
 */

public class AddDependencyInteractorImplement implements AddDependencyInteractor {

    @Override
    public void validateDependency(String nombre, String nombreCorto, String descripcion, OnAddDependencyFinishedListener listener) {
        //Realiza todas las comprobaciones
        /*if (DependencyRepository.getInstance().repeatedDependency(nombre, nombreCorto, descripcion)){
            listener.showDependencyExistsError();
        } else if(descripcion.isEmpty()) {
            listener.showDescriptionError();
        }else if(nombre.isEmpty()) {
            listener.showNameError();
        }else if(nombreCorto.isEmpty()){
            listener.showShortNameError();
        }else if (DependencyRepository.getInstance().tryAddDependency(nombre, nombreCorto, descripcion)){
            listener.OnSuccess();
        }*/
        DependencyRepository.getInstance().tryAddDependency(nombre, nombreCorto, descripcion);
    }
}
