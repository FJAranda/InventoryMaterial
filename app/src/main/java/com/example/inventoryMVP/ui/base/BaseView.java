package com.example.inventoryMVP.ui.base;

import com.example.inventoryMVP.ui.dependency.AddDependencyContract;

/**
 * Created by usuario on 24/11/17.
 */

public interface BaseView {

    interface Presenter{
        void setPresenter(AddDependencyContract.Presenter presenter);
    }
}
