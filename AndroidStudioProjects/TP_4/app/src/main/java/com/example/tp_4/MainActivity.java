package com.example.tp_4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define an array of strings
        String[] tableau = new String[]{
                "Un", "Deux", "Trois", "Quatre", "Cinq",
                "Six", "Sept", "Huit", "Neuf", "Dix",
                "Onze", "Douze", "Treize", "Quatorze", "Quinze",
                "Seize", "Dix-sept", "Dix-huit", "Dix-neuf", "Vingt"
        };

        // Create an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, tableau);

        // Find ListView and set the adapter
        ListView lv = findViewById(R.id.liste1);
        lv.setAdapter(adapter);
    }
}

