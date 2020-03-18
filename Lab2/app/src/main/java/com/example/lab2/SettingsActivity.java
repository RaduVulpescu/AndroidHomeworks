package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.setTitle("Settings");

        final Switch darkModeSwitch = findViewById(R.id.darkModeSwitch);
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    darkModeSwitch.getRootView().setBackgroundColor(getResources().getColor(android.R.color.background_dark));
                    darkModeSwitch.setTextColor(Color.WHITE);
                } else {
                    darkModeSwitch.getRootView().setBackgroundColor(getResources().getColor(android.R.color.background_light));
                    darkModeSwitch.setTextColor(Color.BLACK);
                }
            }
        });
    }
}
