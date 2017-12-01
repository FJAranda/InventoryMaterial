package com.example.inventoryMVP.ui.dependency;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.inventoryMVP.R;
import com.example.inventoryMVP.adapter.DependencyAdapterBueno;
import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.repository.DependencyRepository;
import com.example.inventoryMVP.ui.base.BasePresenter;
import com.example.inventoryMVP.utils.CommonDialog;

import java.util.List;

public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View, AddEditDependencyFragment.AddNewDependencyClickListener,
        AddEditDependencyFragment.EditDependencyClickListener, AdapterView.OnItemClickListener {

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
    public void updateAdapter() {
        adapterBueno.notifyDataSetChanged();
    }

    @Override
    public void showDeleteMessage() {

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Snackbar.make(view, "Pulsado el elemento "+i, Snackbar.LENGTH_LONG).show();
        callback.editDependency((Dependency)adapterView.getItemAtPosition(i));
    }

    interface ListDependencyListener{
        void addNewDependency();

        void editDependency(Dependency itemAtPosition);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapterBueno = new DependencyAdapterBueno(getActivity());
        setRetainInstance(true);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones lista dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_context_listdependencyfragment, menu);
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
        //presenter.loadDependency();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapterBueno);
        getListView().setOnItemClickListener(this);
        registerForContextMenu(getListView());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dependency dependency = (Dependency) getListView().getItemAtPosition(adapterContextMenuInfo.position);

        switch (item.getItemId()) {
            case R.id.listdependencyfragment_context_delete:
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.MESSAGE, "Eliminar dependencia?");
                bundle.putString(CommonDialog.TITLE, "Eliminar dependencia");
                bundle.putParcelable("dependencia", dependency);
                Dialog d = CommonDialog.showConfirmDialog(bundle, getActivity(),presenter);
                d.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
