package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        final int [] diceImages = {R.mipmap.dice1, R.mipmap.dice2, R.mipmap.dice3, R.mipmap.dice4, R.mipmap.dice5, R.mipmap.dice6};

        //diceImages[2]

        int myBox = 10;

        float myFloatBox = 4.2f;

        double myDOubleBox = 3.34578923;

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Log.i("MyDiceApp", "btnRoll is Tapped now!");

                Random rndObject = new Random();

                int myRandomNumber = rndObject.nextInt(6); // generate nr from 0 to 5

                Log.i("MyDiceApp", "The generated random number is " + myRandomNumber);

                diceImage1.setImageResource(diceImages[myRandomNumber]);

                myRandomNumber = rndObject.nextInt(6);
                diceImage2.setImageResource(diceImages[myRandomNumber]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);

                mp.start();
            }
        });



    }
}