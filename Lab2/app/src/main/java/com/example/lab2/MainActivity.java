package com.example.lab2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<Component> components = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Lab3", "OnCreate has been called and content view has been set");

        ListView listView = findViewById(R.id.listView);

        components.add(new Component("RTX 2080", 3000, "Nvidia", "Great video card"));
        components.add(new Component("Ryzen 5 3600X", 1000, "AMD", "Great cpu"));
        components.add(new Component("PRIME B450M-A", 450, "ASUS", "Great motherboard"));
        components.add(new Component("Vengeance LPX Black 16GB", 600, "Corsair", "Great memory"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getTitles(components));
        listView.setAdapter(adapter);

        final TextView textView = findViewById(R.id.textView3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(formatDescription(components.get(position)));
                //Toast.makeText(MainActivity.this, formatDescription(components.get(position)), Toast.LENGTH_SHORT).show();
            }
        });

        Log.i("Lab3", "OnCreate has been terminated");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("Lab3", "onRestoreInstanceState has been terminated");
        Log.i("Lab3", "onRestoreInstanceState has been terminated");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Lab3", "onStart has been terminated");
        Log.i("Lab3", "onStart has been terminated");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lab3", "onResume has been terminated");
        Log.i("Lab3", "onResume has been terminated");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Lab3", "onPause has been terminated");
        Log.i("Lab3", "onPause has been terminated");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Lab3", "onStop has been terminated");
        Log.i("Lab3", "onStop has been terminated");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("Lab3", "onSaveInstanceState has been terminated");
        Log.i("Lab3", "onSaveInstanceState has been terminated");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Lab3", "onDestroy has been terminated");
        Log.i("Lab3", "onDestroy has been terminated");
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
