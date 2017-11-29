package com.example.inventoryMVP.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.inventoryMVP.R;
import com.example.inventoryMVP.ui.base.BaseActivity;

public class DependencyActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener {

    private ListDependencyFragment listDependency;
    private ListDependencyContract.Presenter listPresenter;
    private AddEditDependencyFragment addEditDependency;
    private AddDependencyContract.Presenter addEditPresenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        setSupportActionBar(toolbar);

        listDependency = (ListDependencyFragment)fragmentManager.findFragmentByTag(ListDependencyFragment.TAG);
        if (listDependency  == null){
            listDependency = (ListDependencyFragment)ListDependencyFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependencyFragment.TAG);
            fragmentTransaction.commit();
        }

        listPresenter = new ListPresenter(listDependency);

        listDependency.setPresenter(listPresenter);
    }

    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addEditDependency = (AddEditDependencyFragment) fragmentManager.findFragmentByTag(AddEditDependencyFragment.TAG);
        if (addEditDependency  == null){
            addEditDependency = AddEditDependencyFragment.newInstance(null);
            fragmentTransaction.replace(android.R.id.content, addEditDependency, AddEditDependencyFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        addEditPresenter = new AddEditPresenter(addEditDependency);

        addEditDependency.setPresenter(addEditPresenter);
    }
}
