package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ComparisonScreen extends AppCompatActivity {

    Random random = new Random();
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_screen);
        TextView[] text = new TextView[3];
        text[0] = findViewById(R.id.number_one);
        text[1] = findViewById(R.id.number_two);
        text[2] = findViewById(R.id.score);
        Button greater = findViewById(R.id.greater);
        Button equalto = findViewById(R.id.equalto);
        Button less = findViewById(R.id.less);
        setQuestion(text);
        greater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(0, text);
                setQuestion(text);
            }
        });
        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(1, text);
                setQuestion(text);
            }
        });
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(2, text);
                setQuestion(text);
            }
        });
    }

    public void setQuestion(TextView[] text){
        text[0].setText(String.valueOf(random.nextInt(101)));
        text[1].setText(String.valueOf(random.nextInt(101)));
    }

    public void validate(int status, TextView[] text){
        int num_one = Integer.parseInt(text[0].getText().toString());
        int num_two = Integer.parseInt(text[1].getText().toString());
        text[0].setText("");
        text[1].setText("");
        switch (status) {
            case 0:
                if (num_one > num_two) {
                    score += 1;
                }
                else{
                    score-=1;
                }
                break;
            case 1:
                if (num_one == num_two) {
                    score += 1;
                }
                else{
                    score-=1;
                }
                break;
            case 2:
                if (num_one < num_two){
                    score += 1;
                }
                else{
                    score-=1;
                }
                break;
            default:
                break;
        }
        text[2].setText(String.valueOf(score));
    }
}