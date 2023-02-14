package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class CountingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_screen);
        Button check_button = findViewById(R.id.check_button);
        EditText answer = findViewById(R.id.input_box);
        ImageView[] images = new ImageView[19];
        images[0] = findViewById(R.id.one);
        images[1] = findViewById(R.id.two);
        images[2] = findViewById(R.id.three);
        images[3] = findViewById(R.id.four);
        images[4] = findViewById(R.id.five);
        images[5] = findViewById(R.id.six);
        images[6] = findViewById(R.id.seven);
        images[7] = findViewById(R.id.eight);
        images[8] = findViewById(R.id.nine);
        images[9] = findViewById(R.id.ten);
        images[10] = findViewById(R.id.eleven);
        images[11] = findViewById(R.id.twelve);
        images[12] = findViewById(R.id.thirteen);
        images[13] = findViewById(R.id.fourteen);
        images[14] = findViewById(R.id.fifteen);
        images[15] = findViewById(R.id.sixteen);
        images[16] = findViewById(R.id.seventeen);
        images[17] = findViewById(R.id.eighteen);
        images[18] = findViewById(R.id.nineteen);
        int number = generateNumber();
        setImages(images, number);
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int ans = Integer.parseInt(answer.getText().toString());
//                if(ans == number){
//                    Boolean success = true;
//                }
                answer.setText("");
                clearImages(images);
                int randomNumber = generateNumber();
                setImages(images,randomNumber);
            }
        });
    }

    public int generateNumber(){
        Random random = new Random();
        int number = random.nextInt(19);
        number = number==0? 1: number;
        return number;
    }

    public void setImages(ImageView[] images, int number){
        TextView question = findViewById(R.id.question);
        Random random = new Random();
        int randomNumber, toggleFLag;
        toggleFLag = random.nextInt(4);
        if(toggleFLag == 0){
            for(int count = 0; count < number; count++){
                randomNumber = random.nextInt(19);
                images[randomNumber].setImageResource(R.drawable.watermelon);
            }
            question.setText("Enter number of watermelons");
        }
        else if(toggleFLag == 1){
            for(int count = 0; count < number; count++){
                randomNumber = random.nextInt(19);
                images[randomNumber].setImageResource(R.drawable.cheese);
            }
            question.setText("Enter number of cheese pieces");
        }
        else if(toggleFLag == 2){
            for(int count = 0; count < number; count++){
                randomNumber = random.nextInt(19);
                images[randomNumber].setImageResource(R.drawable.pizza);
            }
            question.setText("Enter number of pizza slices");
        }
        else{
            for(int count = 0; count < number; count++){
                randomNumber = random.nextInt(19);
                images[randomNumber].setImageResource(R.drawable.cookie);
            }
            question.setText("Enter number of cookies");
        }
    }

    public void clearImages(ImageView[] images){
        for(int i = 0; i < 19; i++){
            images[i].setImageDrawable(null);
        }
    }
}