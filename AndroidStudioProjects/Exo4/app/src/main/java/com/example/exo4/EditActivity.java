package com.example.exo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class EditActivity extends Activity {
    private int position = -1;
    private EditText nomEdit;
    private EditText codeEdit;
    private RatingBar ratingBar; // Nouveau RatingBar
    private EtudiantsApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        nomEdit = findViewById(R.id.nom_edit);
        codeEdit = findViewById(R.id.code_edit);
        ratingBar = findViewById(R.id.ratingBar); // Initialiser le RatingBar

        app = (EtudiantsApplication) getApplication();
        Intent intent = getIntent();

        if (intent != null) {
            position = intent.getIntExtra("position", -1);
            if (position != -1) {
                Etudiant etudiant = app.getEtudiants().get(position);
                nomEdit.setText(etudiant.getNom());
                codeEdit.setText(etudiant.getCode());
                ratingBar.setRating(etudiant.getNiveau()); // Afficher le niveau
            }
        }
    }

    public void onValider(View view) {
        String nom = nomEdit.getText().toString().trim();
        String code = codeEdit.getText().toString().trim();
        float niveau = ratingBar.getRating(); // Récupérer la valeur du RatingBar

        if (!nom.isEmpty() && !code.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nom", nom);
            resultIntent.putExtra("code", code);
            resultIntent.putExtra("niveau", niveau); // Ajouter la valeur du RatingBar
            resultIntent.putExtra("position", position);
            setResult(RESULT_OK, resultIntent);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }

    public void onAnnuler(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}