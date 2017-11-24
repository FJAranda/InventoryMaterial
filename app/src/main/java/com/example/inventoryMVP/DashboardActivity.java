package com.example.inventoryMVP;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import com.example.inventoryMVP.ui.dependency.DependencyActivity;

/**
 * Dashboard
 *
 * @author Javier Aranda
 */
public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        //Vistas
        gridDashboard = (GridLayout)findViewById(R.id.gridDashboard);
        listenerDashboard = new ClickListenerDashboard();
        ImageView ivImagen;

        //Imagenes
        int[] icons = {R.mipmap.ic_inventario, R.mipmap.ic_productos, R.mipmap.ic_dependencias, R.mipmap.ic_secciones,
                R.mipmap.ic_preferencias };

        //Dimensiones de imagenes
        float widthDashboard = getResources().getDimension(R.dimen.imgDashboardWidth);
        float heightDashboard = getResources().getDimension(R.dimen.imgDashboardHeight);

        //Inicializar el imageview y anadirlo en el gridlayout
        for (int i = 0; i < icons.length; i++){
            ivImagen = new ImageView(this);
            ivImagen.setImageResource(icons[i]);
            ivImagen.setId(i);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.height = (int)heightDashboard;
            params.width = (int)widthDashboard;

            ivImagen.setLayoutParams(params);
            ivImagen.setOnClickListener(listenerDashboard);

            gridDashboard.addView(ivImagen);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_account_settings:
                startActivity(new Intent(DashboardActivity.this, AccountSettingsActivity.class));
                break;
            case R.id.action_general_settings:
                startActivity(new Intent(DashboardActivity.this, GeneralSettingsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case 0:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    break;
                case 1:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;
                case 2:
                    intent = new Intent(DashboardActivity.this, DependencyActivity.class);
                    break;
                case 3:
                    intent = new Intent(DashboardActivity.this, SectorActivity.class);
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    }

    /*
    private void generateid(int i, ImageView iv){
        switch (images[i]){
            case R.drawable.inventory:
                INVENTORY = View.generateViewId();
                iv.setId(INVENTORY);
                break;
        }
    }
    */
}
