package com.example.inventoryMVP.ui.dependency;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddDependencyInteractor {

    void validateDependency(String nombre, String nombreCorto, String descripcion, OnAddDependencyFinishedListener listener);

    interface OnAddDependencyFinishedListener{
        void showDescriptionError();
        void showNameError();
        void showDependencyExistsError();
        void OnSuccess();
        void showShortNameError();
    }
}
