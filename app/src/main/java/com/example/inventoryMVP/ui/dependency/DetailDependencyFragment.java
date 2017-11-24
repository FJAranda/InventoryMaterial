package com.example.inventoryMVP.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class DetailDependencyFragment extends Fragment {
    public static final String TAG = "detaildependency";

    public static Fragment newInstance(Bundle arguments){
        DetailDependencyFragment detailDependencyFragment = new DetailDependencyFragment();
        if (arguments != null){
            detailDependencyFragment.setArguments(arguments);
        }
        return detailDependencyFragment;
    }

}
