package com.example.inventoryMVP.repository;

import com.example.inventoryMVP.pojo.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class SectorRepository {
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;

    /*Inicializar todos los atributos static*/
    static {
        sectorRepository = new SectorRepository();
    }

    private SectorRepository(){
        this.sectors = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        addsector(new Sector(0, "UltraArmario", "UA!",
                "A Chimo bayo le gusta este armario.",0, true, false));
        addsector(new Sector(1, "Armario del Parlament", "España ens roba!",
                "Armario donde se ha aplicado el 155.",1, true, true));
    }

    public static SectorRepository getInstance(){
        if (sectorRepository == null){
            sectorRepository = new SectorRepository();
        }
        return sectorRepository;
    }

    /**
     * Metodo que añade una dependencia
     * @param sector
     */
    public void addsector(Sector sector){
        sectors.add(sector);
    }

    public ArrayList<Sector> getsectors(){
        return sectors;
    }
}
