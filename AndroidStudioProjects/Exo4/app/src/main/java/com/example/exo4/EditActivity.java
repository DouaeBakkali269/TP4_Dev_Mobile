package com.example.exo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {
    private int position = -1;
    private EditText nomEdit;
    private EditText codeEdit;
    private EtudiantsApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        nomEdit = findViewById(R.id.nom_edit);
        codeEdit = findViewById(R.id.code_edit);

        app = (EtudiantsApplication) getApplication();
        Intent intent = getIntent();

        if (intent != null) {
            position = intent.getIntExtra("position", -1);
            if (position != -1) {
                Etudiant etudiant = app.getEtudiants().get(position);
                nomEdit.setText(etudiant.getNom());
                codeEdit.setText(etudiant.getCode());
            }
        }
    }

    public void onValider(View view) {
        String nom = nomEdit.getText().toString().trim();
        String code = codeEdit.getText().toString().trim();

        if (!nom.isEmpty() && !code.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nom", nom);
            resultIntent.putExtra("code", code);
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
