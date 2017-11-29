package com.example.inventoryMVP.ui.dependency;

import android.os.Debug;
import android.util.Log;

/**
 * Created by usuario on 23/11/17.
 */

class AddEditPresenter implements AddDependencyContract.Presenter, AddDependencyInteractor.OnAddDependencyFinishedListener {
    private final AddDependencyContract.View view;
    private AddDependencyInteractorImplement addInteractor;

    public AddEditPresenter(AddDependencyContract.View view){
        this.view = view;
    }

    public void validateDependency(String nombre, String nombreCorto, String descripcion, AddDependencyInteractor.OnAddDependencyFinishedListener listener) {

    }

    @Override
    public void showDescriptionError() {

    }

    @Override
    public void showNameError() {

    }

    @Override
    public void showDependencyExistsError() {

    }

    @Override
    public void OnSuccess() {

    }

    @Override
    public void showShortNameError() {

    }

    @Override
    public void validateDependency(String s, String toString, String string) {
        Log.d("entra", "es mentira que entre...");
        addInteractor.validateDependency(nombre, nombreCorto, descripcion, listener);
    }
}
