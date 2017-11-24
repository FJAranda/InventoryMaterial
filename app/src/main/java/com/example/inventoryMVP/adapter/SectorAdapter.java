package com.example.inventoryMVP.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventoryMVP.R;
import com.example.inventoryMVP.pojo.Sector;
import com.example.inventoryMVP.repository.SectorRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {
    private ArrayList<Sector> sectors;
    private ArrayList<Sector> sectorsModified;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;


    public SectorAdapter() {
        sectors = SectorRepository.getInstance().getsectors();
        sectorsModified = new ArrayList<>();

    }

    public SectorAdapter(ArrayList<Sector> sector) {
        sectors = SectorRepository.getInstance().getsectors();
        this.sectorsModified = sector;
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (View)inflater.inflate(R.layout.item_sector, null);
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }


    public void onBindViewHolder(SectorViewHolder holder, int position) {
        holder.swEnabled.setChecked(sectors.get(position).isEnabled());
        holder.tvName.setText(sectors.get(position).getName());
        holder.swEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        if (sectors.get(position).isDefult()){
            holder.tvSectorDefault.setText(R.string.tvSectorDefault);
        }
    }

    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public ArrayList<Sector> getSectorsModified() {
        return sectorsModified;
    }

    public void setSectorsModified(ArrayList<Sector> sectorsModified) {
        this.sectorsModified = sectorsModified;
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder{

        private Switch swEnabled;
        private TextView tvName;
        private TextView tvSectorDefault;


        public SectorViewHolder(View itemView) {
            super(itemView);
            swEnabled = (Switch)itemView.findViewById(R.id.swSector);
            tvName = (TextView)itemView.findViewById(R.id.tvNombreSector);
            tvSectorDefault = (TextView)itemView.findViewById(R.id.tvDefaultSector);
        }
    }

    private class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            sectorsModified.add(b ? 1 : 0, (Sector)compoundButton.getParent());
        }
    }
}
