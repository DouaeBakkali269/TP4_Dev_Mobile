package com.example.exo4;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EtudiantView extends RelativeLayout {
    private TextView nomView;
    private TextView codeView;

    public EtudiantView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_etudiant, this);
        findViews();
    }

    private void findViews() {
        nomView = findViewById(R.id.nom);
        codeView = findViewById(R.id.code);
    }

    public void setItem(Etudiant etudiant) {
        nomView.setText(etudiant.getNom());
        codeView.setText(etudiant.getCode());
    }

    public static EtudiantView create(Context context) {
        return new EtudiantView(context);
    }
}

