package com.example.inventoryMVP.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

class ListPresenter implements ListDependencyContract.Presenter {
    ListDependencyContract.View view;

    public ListPresenter(ListDependencyContract.View view){
        this.view = view;
    }

    @Override
    public void loadDependency() {

    }
}
