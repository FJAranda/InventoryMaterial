package com.example.inventoryMVP.ui.dependency;

import android.app.Activity;
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

public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {
    public static final String TAG = "listdependency";
    ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    interface ListDependencyListener{
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " debe implementar ListDependencyListener");
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
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
