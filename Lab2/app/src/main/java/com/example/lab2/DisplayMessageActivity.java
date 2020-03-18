package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView);

        if (message.equals(getResources().getString(R.string.filter_description)) ||
            message.equals(getResources().getString(R.string.select_description))) {
            textView.setText("From the last activity, you have not selected a component");
        } else {
            textView.setText(String.format("The last selected component had the next description:\n\n%s", message));
        }
    }
}
