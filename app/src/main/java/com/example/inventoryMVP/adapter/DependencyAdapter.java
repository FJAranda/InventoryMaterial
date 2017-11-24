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

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view = convertView;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            dependencyHolder = new DependencyHolder();

            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.mliItemIcon);
            dependencyHolder.tvTitulo = (TextView) view.findViewById(R.id.tvItemDependencyTitulo);
            dependencyHolder.tvSubtitulo = (TextView) view.findViewById(R.id.tvItemDependencySubtitulo);
            view.setTag(dependencyHolder);
        }else{
            dependencyHolder = (DependencyHolder)view.getTag();
        }

        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0));
        dependencyHolder.tvTitulo.setText(getItem(position).getName());
        dependencyHolder.tvSubtitulo.setText(getItem(position).getShortname());
        return view;
    }

    class DependencyHolder{
        MaterialLetterIcon icon;
        TextView tvTitulo;
        TextView tvSubtitulo;
    }
}
