package com.example.inventoryMVP.ui.dependency;

import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.repository.DependencyRepository;

/**
 * Created by usuario on 1/12/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {
    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().tryDeleteDependency(dependency);
    }

    @Override
    public void loadDependency() {

    }
}
