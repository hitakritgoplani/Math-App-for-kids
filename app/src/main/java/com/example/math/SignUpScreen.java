package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);


        SQLiteDatabase db;
        db = openOrCreateDatabase("AuthDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(nickname VARCHAR, email VARCHAR, password VARCHAR);");
        Button signup = findViewById(R.id.signup_button);
        EditText email = findViewById(R.id.email_sigup);
        EditText nickname = findViewById(R.id.nickname_signup);
        EditText password = findViewById(R.id.password_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO users VALUES('"+nickname.getText()+"', '"+email.getText()+"','"+password.getText()+"');");
                Toast.makeText(getApplicationContext(),"You are registered successfully", Toast.LENGTH_LONG).show();
                Intent mintent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(mintent);
            }
        });
    }
}