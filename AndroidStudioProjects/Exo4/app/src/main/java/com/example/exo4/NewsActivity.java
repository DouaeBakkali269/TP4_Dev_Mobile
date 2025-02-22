package com.example.exo4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {
    private EtudiantAdapter adapter;
    private ListView listView;
    private EtudiantsApplication app;
    private TextView emptyView;

    // ActivityResultLauncher for EditActivity
    private final ActivityResultLauncher<Intent> editActivityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    int position = data.getIntExtra("position", -1);

                    if (position != -1) {
                        String newNom = data.getStringExtra("nom");
                        String newCode = data.getStringExtra("code");

                        // Update student details
                        app.getEtudiants().get(position).setNom(newNom);
                        app.getEtudiants().get(position).setCode(newCode);
                        adapter.notifyDataSetChanged();
                        updateEmptyViewVisibility();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        app = (EtudiantsApplication) getApplicationContext();

        listView = findViewById(android.R.id.list);
        emptyView = findViewById(android.R.id.empty);

        // Link the ListView with the empty TextView
        listView.setEmptyView(emptyView);

        adapter = new EtudiantAdapter(this, app.getEtudiants());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(NewsActivity.this, EditActivity.class);
            intent.putExtra("nom", app.getEtudiants().get(position).getNom());
            intent.putExtra("code", app.getEtudiants().get(position).getCode());
            intent.putExtra("position", position);
            editActivityLauncher.launch(intent);
        });

        updateEmptyViewVisibility(); // Handle initial empty state
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        updateEmptyViewVisibility();
    }

    private void updateEmptyViewVisibility() {
        // Show "Liste vide" if list is empty; otherwise hide it
        if (app.getEtudiants().isEmpty()) {
            emptyView.setVisibility(TextView.VISIBLE);
        } else {
            emptyView.setVisibility(TextView.GONE);
        }
    }
}
