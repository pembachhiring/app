package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Button buttonSend = findViewById(R.id.buttonSend);
        Button buttonAlert = findViewById(R.id.buttonAlert);

        // Load fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer1, new FirstFragment());
        fragmentTransaction.add(R.id.fragmentContainer2, new SecondFragment());
        fragmentTransaction.commit();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentById(R.id.fragmentContainer1);
                SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragmentContainer2);

                if (firstFragment != null) {
                    firstFragment.updateText(text);
                }
                if (secondFragment != null) {
                    secondFragment.updateText(text);
                }
            }
        });

        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Alert")
                        .setMessage("Do you want to navigate to another activity?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });
    }

    public void displayData(String data) {
        textView.setText(data);
    }
}
