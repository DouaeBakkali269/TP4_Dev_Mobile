package com.example.exo4;


public class Etudiant {
    private String nom;
    private String code;
    private int niveau;


    public Etudiant(String nom, String code, int niveau) {
        this.nom = nom;
        this.code = code;
        this.niveau = niveau;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    // Méthodes pour accéder et modifier le niveau
    public int getNiveau() { return niveau; }
    public void setNiveau(int niveau) { this.niveau = niveau; }
}