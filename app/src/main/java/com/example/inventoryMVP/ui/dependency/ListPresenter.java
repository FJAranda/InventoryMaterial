package com.example.inventoryMVP.ui.dependency;

import android.util.Log;

import com.example.inventoryMVP.pojo.Dependency;

/**
 * Created by usuario on 23/11/17.
 */

class ListPresenter implements ListDependencyContract.Presenter {
    ListDependencyContract.View view;
    private ListDependencyInteractor interactor;

    public ListPresenter(ListDependencyContract.View view){
        this.view = view;
        interactor = new ListDependencyInteractorImpl();
    }

    @Override
    public void loadDependency() {
        view.updateAdapter();
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        interactor.deleteDependency(dependency);
        loadDependency();
        view.showDeleteMessage();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

}
