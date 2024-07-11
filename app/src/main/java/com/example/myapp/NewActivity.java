package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class NewActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        layout = findViewById(R.id.activity_new_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                return true;
            case R.id.menu_green:
                layout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                return true;
            case R.id.menu_yellow:
                layout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
