package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.ui.base.BasePresenter;
import com.example.inventoryMVP.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView {

        void showDependency(List<Dependency> list);
    }

    interface Presenter extends BasePresenter{
        void loadDependency();
    }
}