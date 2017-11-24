package com.example.inventoryMVP.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventoryMVP.R;
import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapterBueno extends ArrayAdapter<Dependency> {

    public DependencyAdapterBueno(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView tvTitulo;
        TextView tvSubtitulo;
        View view;

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.item_dependency, null);
        icon =  (MaterialLetterIcon)view.findViewById(R.id.mliItemIcon);
        tvTitulo = (TextView) view.findViewById(R.id.tvItemDependencyTitulo);
        tvSubtitulo = (TextView) view.findViewById(R.id.tvItemDependencySubtitulo);

        icon.setLetter(getItem(position).getShortname().substring(0));
        tvTitulo.setText(getItem(position).getName());
        tvSubtitulo.setText(getItem(position).getShortname());
        return view;
    }
}
