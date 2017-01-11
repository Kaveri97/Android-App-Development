package com.example.user.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int user_overall;
    private static int user_turn;
    private static int comp_overall;
    private static int comp_turn;

    Button Roll,Hold,Reset;
    TextView userScore, compScore;
    ImageView dice;
    final int[] image_dice = new int[]{0,R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    int i=0;
    final Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll = (Button) findViewById(R.id.Roll);
        Hold = (Button) findViewById(R.id.Hold);
        Reset = (Button) findViewById(R.id.Reset);
        userScore = (TextView) findViewById(R.id.userScore);
        compScore = (TextView) findViewById(R.id.compScore);
        dice = (ImageView) findViewById(R.id.image_dice);
        Roll.setEnabled(true);
        Hold.setEnabled(true);
        Reset.setEnabled(false);
        userScore.setText("0");
        compScore.setText("0");

        Reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dice.setImageResource(image_dice[1]);
                user_overall = 0;
                user_turn = 0;
                comp_overall = 0;
                comp_turn = 0;
                userScore.setText("0");
                compScore.setText("0");
                Roll.setEnabled(true);
                Hold.setEnabled(true);
            }
        } );

        Roll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                user_turn = r.nextInt(image_dice.length);
                if(user_turn==0);
                else if(user_turn == 1){
                    userScore.setText(Integer.toString(user_overall));
                    i=1;
                    compRoll();
                }
                else{
                    user_overall += user_turn;
                    dice.setImageResource(image_dice[user_turn]);
                }
            }
        });



        Hold.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                userScore.setText(Integer.toString(user_overall));
                i=1;
            }
        });
    }

    public void compRoll(){
        userScore.setText("hello");
        Roll.setEnabled(false);
        Hold.setEnabled(false);
        comp_turn = r.nextInt(image_dice.length);

        while(2>1) {
            if (comp_turn == 0) ;
            else if (comp_turn == 1) {
                compScore.setText(Integer.toString(comp_overall));
                i=0;
                Roll.setEnabled(true);
                Hold.setEnabled(true);
                break;
            }
            else {
                comp_overall += comp_turn;
            }
        }
    }


}
