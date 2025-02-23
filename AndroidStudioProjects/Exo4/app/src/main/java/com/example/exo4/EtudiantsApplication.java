package com.example.exo4;


import android.app.Application;

import java.util.ArrayList;
public class EtudiantsApplication extends Application {
    private final ArrayList<Etudiant> etudiants = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public ArrayList<Etudiant> getEtudiants() { return etudiants; }

    public void init() {
        etudiants.clear();
        // Ajout des étudiants avec leur niveau
        etudiants.add(new Etudiant("Ali", "001", 3)); // Niveau 3
        etudiants.add(new Etudiant("Sara", "002", 5)); // Niveau 5
    }
}