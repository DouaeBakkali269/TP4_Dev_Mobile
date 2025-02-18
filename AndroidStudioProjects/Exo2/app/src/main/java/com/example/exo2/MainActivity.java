package com.example.exo2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Récupérer la ListView
        ListView list = findViewById(R.id.list1);
        // Create the header view
        TextView header = new TextView(this);
        header.setText("My application");
        header.setTextSize(20);
        header.setTextColor(getResources().getColor(R.color.white));

        header.setPadding(22, 90, 22, 40);
        header.setBackgroundResource(R.color.blue);


        // Add the header to the ListView
        list.addHeaderView(header);

        // Créer un ArrayAdapter avec le layout personnalisé (montexte.xml)
        ArrayAdapter<String> tableau = new ArrayAdapter<>(this, R.layout.montexte,R.id.textViewItem);

        // Ajouter des éléments à l'adaptateur
        for (int i = 0; i < 40; i++) {
            tableau.add("Item " + i);
        }

        // Associer l'adaptateur à la ListView
        list.setAdapter(tableau);
    }
}

