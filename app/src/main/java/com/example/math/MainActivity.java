package com.example.math;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String test = "";
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
                if(email_box.getText().toString().trim().length() == 0 || password_box.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"Please enter credentials !", Toast.LENGTH_LONG).show();
                }
                else{
                    Cursor check_email = db.rawQuery("select email from users where email='"+email_box.getText()+"'",null);
                    if (check_email.getCount() == 0){
                        Toast.makeText(getApplicationContext(),"No user found, Please register!", Toast.LENGTH_LONG).show();
                        check_email.close();
                    }
                    else{
                        Cursor c = db.rawQuery("select password from users where email='"+email_box.getText()+"'",null);
                        while(c.moveToNext()){
                            test = c.getString(0);
                        }
                        c.close();
                        if((password_box.getText().toString().equals(test))){
                            Intent mintent = new Intent(getApplicationContext(), HomeScreen.class);
                            startActivity(mintent);
                        }
                        else{
                            showAlert();
                            email_box.setText("");
                            password_box.setText("");
                        }
                    }
                }
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

    public void showAlert() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Invalid Credentials");
        builder.setMessage("Please enter correct credentials");
        // add the buttons
        builder.setPositiveButton("Ok", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}