package com.example.inventoryMVP;

import android.os.PersistableBundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.inventoryMVP.adapter.SectorAdapter;
import com.example.inventoryMVP.pojo.Sector;

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSelector;
    private SectorAdapter sectorAdapter;
    private Toolbar toolbar;
    private CoordinatorLayout clSector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSelector = (RecyclerView)findViewById(R.id.recyclerSelector);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fabSector);
        clSector = (CoordinatorLayout)findViewById(R.id.clSector);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(clSector, "Funcion aun no implementada...", Snackbar.LENGTH_LONG).show();
            }
        });
        setSupportActionBar(toolbar);
        recyclerSelector.setHasFixedSize(true);
        //recyclerSelector.setLayoutManager(new LinearLayoutManager(this));
        recyclerSelector.setLayoutManager(new GridLayoutManager(this, 2));

        if (savedInstanceState != null){
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        }

        sectorAdapter = new SectorAdapter();
        recyclerSelector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        recyclerSelector.setAdapter(sectorAdapter);

    }
}
