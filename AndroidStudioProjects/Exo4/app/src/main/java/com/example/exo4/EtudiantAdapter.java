package com.example.exo4;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class EtudiantAdapter extends BaseAdapter {
    private final ArrayList<Etudiant> etudiants;
    private final Context context;

    public EtudiantAdapter(Context context, ArrayList<Etudiant> etudiants) {
        this.context = context;
        this.etudiants = etudiants;
    }

    @Override
    public int getCount() { return etudiants.size(); }

    @Override
    public Object getItem(int position) { return etudiants.get(position); }

    @Override
    public long getItemId(int position) { return position; }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        EtudiantView view = (convertView == null) ? EtudiantView.create(context) : (EtudiantView) convertView;
//        view.setItem(etudiants.get(position));
//        return view;
//    }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_etudiant, parent, false);
    }

    Etudiant etudiant = etudiants.get(position);

    // Récupérer les vues
    TextView tvNom = convertView.findViewById(R.id.nom);
    TextView tvCode = convertView.findViewById(R.id.code);
    RatingBar ratingBar = convertView.findViewById(R.id.ratingBar); // Nouveau RatingBar

    // Afficher les données
    tvNom.setText(etudiant.getNom());
    tvCode.setText(etudiant.getCode());
    ratingBar.setRating(etudiant.getNiveau()); // Afficher le niveau

    // Changer la couleur de fond des lignes alternées
    if (position % 2 == 0) {
        convertView.setBackgroundColor(Color.LTGRAY); // Lignes paires
    } else {
        convertView.setBackgroundColor(Color.WHITE); // Lignes impaires
    }

    return convertView;
}
}
