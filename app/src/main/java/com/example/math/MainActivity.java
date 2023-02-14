package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.signup_button);
        TextView signup = findViewById(R.id.sign);
        EditText email_box = findViewById(R.id.email_sigup);
        EditText password_box = findViewById(R.id.password_signup);
        SQLiteDatabase db;
        db = openOrCreateDatabase("AuthDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(niickname VARCHAR, email VARCHAR, password VARCHAR);");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(mintent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getApplicationContext(), SignUpScreen.class);
                startActivity(mintent);
            }
        });
    }
}