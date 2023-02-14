package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button count_button = findViewById(R.id.count_button);
        Button comparison_button = findViewById(R.id.comparison_button);
        Button addition_button = findViewById(R.id.addition_button);
        Button learn_tables_button = findViewById(R.id.learn_tables_button);
        count_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), CountingScreen.class);
                startActivity(mintent);
            }
        });

        comparison_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), ComparisonScreen.class);
                startActivity(mintent);
            }
        });

        addition_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), AdditionScreen.class);
                startActivity(mintent);
            }
        });

        learn_tables_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), LearnTablesScreen.class);
                startActivity(mintent);
            }
        });
    }
}