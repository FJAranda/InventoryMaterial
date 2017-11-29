package com.example.inventoryMVP.ui.dependency;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.inventoryMVP.R;
import com.example.inventoryMVP.adapter.DependencyAdapter;
import com.example.inventoryMVP.adapter.DependencyAdapterBueno;
import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.ui.base.BasePresenter;

import java.util.List;

public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View, AddEditDependencyFragment.AddNewDependencyClickListener {
    public static final String TAG = "listdependency";
    DependencyAdapterBueno adapterBueno;
    ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    @Override
    public void showDependency(List<Dependency> list) {
        adapterBueno.clear();
        adapterBueno.addAll(list);
    }

    @Override
    public void returnToDependencyList() {
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    interface ListDependencyListener{
        void addNewDependency();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapterBueno = new DependencyAdapterBueno(getActivity());
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.getLocalClassName() + " debe implementar ListDependencyListener");
        }
    }

    public static Fragment newInstance(Bundle arguments){
        ListDependencyFragment listDependency = new ListDependencyFragment();
        if (arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_dependency, container, false);
        FloatingActionButton floatingActionButton = (FloatingActionButton)rootView.findViewById(R.id.fabAddDependency);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewDependency();
            }
        });
        presenter.loadDependency();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapterBueno);;
    }

}
