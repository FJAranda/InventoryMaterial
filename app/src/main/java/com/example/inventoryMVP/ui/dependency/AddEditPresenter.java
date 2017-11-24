package com.example.inventoryMVP.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

class AddEditPresenter implements AddDependencyContract.Presenter {
    private final AddDependencyContract.View view;

    public AddEditPresenter(AddDependencyContract.View view){
        this.view = view;
    }

    @Override
    public void validateDependency(String s, String toString, String string) {

    }

    @Override
    public void showListDependency() {

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
    public void onSuccess() {

    }
}
