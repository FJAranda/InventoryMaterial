package com.example.inventoryMVP.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMVP.R;
import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.ui.base.BasePresenter;

public class AddEditDependencyFragment extends Fragment implements AddDependencyContract.View, AddDependencyInteractor.OnAddDependencyFinishedListener {
    public static final String TAG = "addeditdependency";
    private AddDependencyContract.Presenter presenter;
    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;

    public static AddEditDependencyFragment newInstance(Bundle arguments) {
        AddEditDependencyFragment editDependency = new AddEditDependencyFragment();
        if (arguments != null){
            editDependency.setArguments(arguments);
        }
        return editDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        FloatingActionButton fabSaveDependency = rootView.findViewById(R.id.fabSaveDependency);
        tilName = rootView.findViewById(R.id.tilName);
        tilShortName = rootView.findViewById(R.id.tilShortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);
        fabSaveDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateDependency(tilName.getEditText().getText().toString(), tilShortName.getEditText().getText().toString(), tilDescription.getEditText().getText().toString());
            }
        });
        if (getArguments() != null){
            Dependency d = (Dependency)getArguments().getParcelable("dependencia");
            tilName.getEditText().setText(d.getName());
            tilShortName.getEditText().setText(d.getShortname());
            tilDescription.getEditText().setText(d.getDescription());
            presenter.validateDependency(tilName.getEditText().getText().toString(), tilShortName.getEditText().getText().toString(), tilDescription.getEditText().getText().toString());
        }
        return rootView;
    }

    @Override
    public void showListDependency() {

    }

    @Override
    public void showDescriptionError() {
        tilDescription.setError("Cadena de descripcion de error de descripcion");
    }

    @Override
    public void showNameError() {
        tilName.setError("Cadena de descripcion de error de descripcion");
    }

    @Override
    public void showDependencyExistsError() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void OnSuccess() {

    }

    @Override
    public void showShortNameError() {
        tilShortName.setError("Cadena de descripcion de error de descripcion");
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddDependencyContract.Presenter) presenter;
    }

    interface AddNewDependencyClickListener{
        void returnToDependencyList();
    }

    interface EditDependencyClickListener{
        void returnToDependencyList();
    }
}
