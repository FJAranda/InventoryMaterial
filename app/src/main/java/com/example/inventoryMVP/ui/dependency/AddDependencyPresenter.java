package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.pojo.Dependency;

/**
 * Created by usuario on 23/11/17.
 */

public class AddDependencyPresenter implements AddDependencyContract.Presenter {

    private final AddDependencyContract.View view;

    public AddDependencyPresenter(AddDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validateDependency(String s, String toString, String string) {

    }

    @Override
    public void validateDependency(String nombre, String nombreCorto, String descripcion, int id) {

    }

    @Override
    public void onDestroy() {

    }
}
