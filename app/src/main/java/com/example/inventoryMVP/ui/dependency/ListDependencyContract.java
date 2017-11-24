package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView {

        void setPresenter(ListDependencyContract.Presenter presenter);
    }

    interface Presenter{

    }
}