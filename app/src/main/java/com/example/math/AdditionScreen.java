package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class AdditionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_screen);
        Random random = new Random();
        TextView[] question = new TextView[2];
        question[0] = findViewById(R.id.textView9);
        question[1] = findViewById(R.id.textView6);
        Button check_button = findViewById(R.id.button);
        EditText answer = findViewById(R.id.answer);
        setQuestion(question, random);
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                setQuestion(question, random);
            }
        });
    }

    public void setQuestion(TextView[] question, Random random){
        question[0].setText(String.valueOf(random.nextInt(101)));
        question[1].setText(String.valueOf(random.nextInt(101)));
    }
}