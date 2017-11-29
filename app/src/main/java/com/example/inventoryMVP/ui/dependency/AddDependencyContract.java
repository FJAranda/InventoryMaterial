package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.ui.base.BasePresenter;
import com.example.inventoryMVP.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddDependencyContract {
    interface View extends BaseView{
        void showListDependency();
        void showDescriptionError();
        void showNameError();
        void showDependencyExistsError();
        void onSuccess();
    }

    interface Presenter extends BasePresenter{
        void validateDependency(String s, String toString, String string);
    }
}
