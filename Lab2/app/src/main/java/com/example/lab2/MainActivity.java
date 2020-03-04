package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<Component> components = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        components.add(new Component("RTX 2080", 3000, "Nvidia", "Great video card"));
        components.add(new Component("Ryzen 5 3600X", 1000, "AMD", "Great cpu"));
        components.add(new Component("PRIME B450M-A", 450, "ASUS", "Great motherboard"));
        components.add(new Component("Vengeance LPX Black 16GB", 600, "Corsair", "Great memory"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getTitles(components));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, formatDescription(components.get(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static ArrayList<String> getTitles(ArrayList<Component> components) {
        ArrayList<String> titles = new ArrayList<>();

        for (Component component: components) {
            titles.add(component.getTitle());
        }

        return titles;
    }

    private static String formatDescription(Component component) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(Locale.getDefault(), "Price: %d\n", component.getPrice()));
        sb.append(String.format(Locale.getDefault(), "Manufacturer: %s\n", component.getManufacturer()));
        sb.append(String.format(Locale.getDefault(), "Description: %s\n", component.getDescription()));

        return sb.toString();
    }
}
