package com.example.inventoryMVP.repository;

import android.database.Cursor;

import com.example.inventoryMVP.data.db.DependencyDAO;
import com.example.inventoryMVP.pojo.Dependency;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by usuario on 26/10/17.
 * Clase que maneja dependencias usando el patron singleton
 */

public class DependencyRepository {
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;
    private DependencyDAO dependencyDao;

    /*Inicializar todos los atributos static*/
    static {
        dependencyRepository = new DependencyRepository();
    }

    private DependencyRepository(){
        this.dependencies = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        addDependency(new Dependency(0,"1º Ciclo Formativo de Grado Superior", "1º CFGS",
                "1CFGS Desarrollo de Aplicaciones Multiplataforma", ""));
        addDependency(new Dependency(1,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(2,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(3,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(4,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(5,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(6,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(7,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));
        addDependency(new Dependency(8,"2º Ciclo Formativo de Grado Superior", "2º CFGS",
                "2CFGS Desarrollo de Aplicaciones Multiplataforma", "" ));


    }

    public static DependencyRepository getInstance(){
        if (dependencyRepository == null){
            dependencyRepository = new DependencyRepository();
        }
        return dependencyRepository;
    }

    /**
     * Metodo que añade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency){
        dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies(){
        return dependencies;
    }

    public ArrayList<Dependency> getDependenciesDB(){
        Cursor cursor = getDependenciesCursor();
        if (cursor.moveToFirst()){
            do{
                Dependency dependency = new Dependency(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4));
                dependencies.add(dependency);
            }while (cursor.moveToNext());
        }
        return dependencies;
    }

    public Cursor getDependenciesCursor(){
        return dependencyDao.loadAll();

    }

    public boolean tryAddDependency(String nombre, String shortName, String descripcion){
        int id = getDependencies().get(getDependencies().size() - 1).get_ID();
        Dependency dependency = new Dependency(id +1, nombre, shortName, descripcion, "");
        addDependency(dependency);
        return false;
    }

    public boolean repeatedDependency(String nombre, String shortName, String descripcion) {
        int id = getDependencies().get(getDependencies().size() - 1).get_ID();
        Dependency dependency = new Dependency(id +1, nombre, shortName, descripcion, "");
        if (getDependencies().contains(dependency)){
            return true;
        }
        return false;
    }

    public boolean tryModifyDependency(String nombre, String nombreCorto, String descripcion, int id) {
        int posicion = -1;
        for (int i = 0; i < dependencies.size(); i++) {
            if (dependencies.get(i).get_ID() == id){
                posicion = i;
            }
        }


        if (posicion >= 0){
            Dependency d = new Dependency(id, nombre, nombreCorto, descripcion, "");
            dependencies.set(posicion, d);
            return false;
        }
        return true;
    }

    public void tryDeleteDependency(Dependency d) {
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;
        while (iterator.hasNext()){
            dependency = iterator.next();
            if (dependency.get_ID() == d.get_ID()){
                iterator.remove();
                break;
            }
        }
    }

    /*
    public void deleteDependency(Dependency d){
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;
        while (iterator.hasNext()){
            dependency = iterator.next();
            if (dependency.get_ID() == d.get_ID()){
                iterator.remove();
            }
        }
    }*/
}
