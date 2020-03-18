package com.example.lab2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.lab2.MESSAGE";
    ArrayList<Component> components = new ArrayList<>();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Lab3OnCreate", "OnCreate has been called and content view has been set");

        components.add(new Component("RTX 2080", 3000, "Nvidia", "Great video card", ComponentType.VideoCard));
        components.add(new Component("Ryzen 5 3600X", 1000, "AMD", "Great cpu", ComponentType.CPU));
        components.add(new Component("PRIME B450M-A", 450, "ASUS", "Great motherboard", ComponentType.Motherboard));
        components.add(new Component("Vengeance LPX Black 16GB", 600, "Corsair", "Great memory", ComponentType.Memory));

        AlertDialog dialog = (AlertDialog) onCreateDialog(savedInstanceState);
        dialog.show();

        Log.i("Lab3OnCreate", "OnCreate has been terminated");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ArrayList<Integer> selectedItems = new ArrayList<>();  // Where we track the selected items
        String[] componentTypes = new String[] { "Video Cards", "CPUs", "Motherboards", "Memories" };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Filter")
                .setMultiChoiceItems(componentTypes, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    selectedItems.add(which);
                                } else if (selectedItems.contains(which)) {
                                    selectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        GenerateListView(selectedItems);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }

    public void GenerateListView(ArrayList<Integer> selectedItems) {
        ListView listView = findViewById(R.id.listView);
        ArrayList<Component> selectedComponents = new ArrayList<>();

        for (Component component: components) {
            if (selectedItems.contains(component.getType().ordinal())) {
                selectedComponents.add(component);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getTitles(selectedComponents));
        listView.setAdapter(adapter);

        textView = findViewById(R.id.textView3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(formatDescription(components.get(position)));
                //Toast.makeText(MainActivity.this, formatDescription(components.get(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("Lab3OnRestore", "onRestoreInstanceState has been started");

        if (savedInstanceState.containsKey("ComponentDescription")) {
            textView.setText(savedInstanceState.getString("ComponentDescription"));
            Log.i("Lab3OnRestore", "TextView has been restored");
        } else {
            Log.i("Lab3OnRestore", "No TextView to restore");
        }

        Log.i("Lab3OnRestore", "onRestoreInstanceState has been terminated");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Lab3OnSave", "onSaveInstanceState has been started");

        outState.putString("ComponentDescription", textView.getText().toString());
        Log.i("Lab3OnSave", "TextView state has been saved");

        Log.i("Lab3OnSave", "onSaveInstanceState has been terminated");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Lab3OnStart", "onStart has been started");
        Log.i("Lab3OnStart", "onStart has been terminated");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lab3OnResume", "onResume has been started");
        Log.i("Lab3OnResume", "onResume has been terminated");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Lab3OnPause", "onPause has been started");
        Log.i("Lab3OnPause", "onPause has been terminated");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Lab3OnStop", "onStop has been started");
        Log.i("Lab3OnStop", "onStop has been terminated");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Lab3OnDestroy", "onDestroy has been started");
        Log.i("Lab3OnDestroy", "onDestroy has been terminated");
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
