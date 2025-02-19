package com.example.exo3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    // creating  a String type array (fruitNames)
    // which contains names of different fruits' images
    String AppNames[]
            = { "word", "excel", "power_point", "outlook" };

    // add appDescriptions array
    String AppDescriptions[]
            = { "Editeur de texte", "Excel", "Logiciel de présentation", "Client de courrier électronique" };

    // creating an Integer type array (fruitImageIds) which
    // contains IDs of different fruits' images
    int AppImages[]
            = { R.drawable.word, R.drawable.excel, R.drawable.power_point, R.drawable.outlook };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list1);

        // Create the header view
        TextView header = new TextView(this);
        header.setText("My application");
        header.setTextSize(20);
        header.setTextColor(getResources().getColor(R.color.white));

        header.setPadding(22, 90, 22, 40);
        header.setBackgroundResource(R.color.blue);


        // Add the header to the ListView
        listView.addHeaderView(header);

        // creating an ArrayList of HashMap.The kEY of the
        // HashMap is a String and VALUE is of any
        // datatype(Object)
        ArrayList<HashMap<String, Object> > list
                = new ArrayList<>();

        // By a for loop, entering different types of data
        // in HashMap, and adding this map including it's
        // datas into the ArrayList as list item and this
        // list is the second parameter of the SimpleAdapter
        for (int i = 0; i < AppNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("appName", AppNames[i]);
            map.put("appImage", AppImages[i]);
            map.put("appDescription", AppDescriptions[i]);

            // adding the HashMap to the ArrayList
            list.add(map);
        }

        // creating A string type array(from) which contains
        // column names for each View in each row of the
        // list and this array(form) is the fourth parameter
        // of the SimpleAdapter
        String[] from = { "appName", "appImage", "appDescription" };

        // creating an integer type array(to) which contains
        // id of each View in each row of the list
        // and this array(form) is the fifth parameter of
        // the SimpleAdapter
        int to[] = { R.id.titre, R.id.img };

        // creating an Object of SimpleAdapter class and
        // passing all the required parameters
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getApplicationContext(), list,
                R.layout.montexte, from, to);

        // now setting the simpleAdapter to the ListView
        listView.setAdapter(simpleAdapter);

        //Ajouter le code source suivant pour mettre un écouteur sur la listview : Ajouter le code source suivant pour mettre un écouteur sur la listview :
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Adjust position if you have a header view
                int position = i - listView.getHeaderViewsCount();
                if (position >= 0) { // Prevent clicking on header
                    HashMap<String, Object> map = (HashMap<String, Object>) listView.getItemAtPosition(i);

                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Sélection Item");
                    adb.setMessage("Nom: " + map.get("appName") + "\nDescription: " + map.get("appDescription"));
                    adb.setPositiveButton("OK", null);
                    adb.show();
                }
            }
        });

    }
}
