package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.pojo.Dependency;

/**
 * Created by usuario on 1/12/17.
 */

public interface ListDependencyInteractor {
    public void deleteDependency(Dependency dependency);
    public void loadDependency();
}
