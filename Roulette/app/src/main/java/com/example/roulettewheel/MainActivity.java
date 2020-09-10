package com.example.roulettewheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int amountWon= 0;
    int wallettAmount = 1000;

    TextView txt_cashAvailable, txt_winningPot;
    ImageView img_wheel;
    Button btn_NewGame, btn_spin;
    EditText blueBet, purpleBet, redBet, orangeBet, yellowBet, greenBet, oneTenBet, twoThreeBet, fourBet, fiveSixBet, sevenBet, eightNineBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //setContentView( R.layout.activity_main );

        txt_cashAvailable = (TextView) findViewById(R.id.txt_cashAvailable);
        txt_winningPot = (TextView) findViewById(R.id.txt_winningPot);
        btn_NewGame = (Button) findViewById(R.id.btn_NewGame);
        btn_spin = (Button) findViewById(R.id.btn_spin);
        blueBet = (EditText) findViewById(R.id.blueBet);
        purpleBet = (EditText) findViewById(R.id.purpleBet);
        redBet = (EditText) findViewById(R.id.redBet);
        orangeBet = (EditText) findViewById(R.id.orangeBet);
        yellowBet = (EditText) findViewById(R.id.yellowBet);
        greenBet = (EditText) findViewById(R.id.greenBet);
        oneTenBet = (EditText) findViewById(R.id.oneTenBet);
        twoThreeBet = (EditText) findViewById(R.id.twoThreeBet);
        fourBet = (EditText) findViewById(R.id.fourBet);
        fiveSixBet = (EditText) findViewById(R.id.fiveSixBet);
        sevenBet = (EditText) findViewById(R.id.sevenBet);
        eightNineBet = (EditText) findViewById(R.id.eightNineBet);
        img_wheel = (ImageView) findViewById(R.id.img_wheel);

        btn_NewGame.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountWon = 0;
                wallettAmount = 1000;
                txt_winningPot.setText("You won: $" + amountWon);
                txt_cashAvailable.setText("" + wallettAmount);
                btn_spin.setEnabled(true);

                oneTenBet.getText().clear();
                twoThreeBet.getText().clear();
                fourBet.getText().clear();
                fiveSixBet.getText().clear();
                sevenBet.getText().clear();
                eightNineBet.getText().clear();
                blueBet.getText().clear();
                purpleBet.getText().clear();
                redBet.getText().clear();
                orangeBet.getText().clear();
                yellowBet.getText().clear();
                greenBet.getText().clear();
            }
        } );

        btn_spin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(blueBet.getText().toString())){
                    blueBet.setText("0");
                }
                if(TextUtils.isEmpty(purpleBet.getText().toString())){
                    purpleBet.setText("0");
                }
                if(TextUtils.isEmpty(redBet.getText().toString())){
                    redBet.setText("0");
                }
                if(TextUtils.isEmpty(orangeBet.getText().toString())){
                    orangeBet.setText("0");
                }
                if(TextUtils.isEmpty(yellowBet.getText().toString())){
                    yellowBet.setText("0");
                }
                if(TextUtils.isEmpty(greenBet.getText().toString())){
                    greenBet.setText("0");
                }
                if(TextUtils.isEmpty(oneTenBet.getText().toString())){
                    oneTenBet.setText("0");
                }
                if(TextUtils.isEmpty(twoThreeBet.getText().toString())){
                    twoThreeBet.setText("0");
                }
                if(TextUtils.isEmpty(fourBet.getText().toString())){
                    fourBet.setText("0");
                }
                if(TextUtils.isEmpty(fiveSixBet.getText().toString())){
                    fiveSixBet.setText("0");
                }
                if(TextUtils.isEmpty(sevenBet.getText().toString())){
                    sevenBet.setText("0");
                }
                if(TextUtils.isEmpty(eightNineBet.getText().toString())){
                    eightNineBet.setText("0");
                }

                final int spinDegrees;
                Random r = new Random();

                spinDegrees = r.nextInt(3300) + 30;

                RotateAnimation rotateWheel = new RotateAnimation(0, spinDegrees, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateWheel.setDuration(2000);
                rotateWheel.setFillAfter(true);

                rotateWheel.setInterpolator(new AccelerateDecelerateInterpolator());

                rotateWheel.setAnimationListener( new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(spinDegrees % 360 <= 72){
                            if(Integer.parseInt(oneTenBet.getText().toString()) != 0 && Integer.parseInt(blueBet.getText().toString()) != 0){
                                int num = Integer.parseInt(oneTenBet.getText().toString());
                                int col = Integer.parseInt(blueBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "1 or 10 and blue", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(oneTenBet.getText().toString()) != 0){
                                int num = Integer.parseInt(oneTenBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "1 or 10 and blue", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(blueBet.getText().toString()) != 0){
                                int col = Integer.parseInt(blueBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "1 or 10 and blue", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                        else if(spinDegrees % 360 > 72 && spinDegrees % 360 <= 144){
                            if(Integer.parseInt(twoThreeBet.getText().toString()) != 0 && Integer.parseInt(purpleBet.getText().toString()) != 0){
                                int num = Integer.parseInt(twoThreeBet.getText().toString());
                                int col = Integer.parseInt(purpleBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "2 or 3 and purple", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(twoThreeBet.getText().toString()) != 0){
                                int num = Integer.parseInt(twoThreeBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "2 or 3 and purple", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(purpleBet.getText().toString()) != 0){
                                int col = Integer.parseInt(purpleBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "2 or 3 and purple", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        else if(spinDegrees % 360 > 144 && spinDegrees % 360 <= 180){
                            if(Integer.parseInt(fourBet.getText().toString()) != 0 && Integer.parseInt(redBet.getText().toString()) != 0){
                                int num = Integer.parseInt(fourBet.getText().toString());
                                int col = Integer.parseInt(redBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "4 red", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(fourBet.getText().toString()) != 0){
                                int num = Integer.parseInt(fourBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "4 red", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(redBet.getText().toString()) != 0){
                                int col = Integer.parseInt(redBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "4 red", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        else if(spinDegrees % 360 > 180 && spinDegrees % 360 <= 252){
                            if(Integer.parseInt(fiveSixBet.getText().toString()) != 0 && Integer.parseInt(orangeBet.getText().toString()) != 0){
                                int num = Integer.parseInt(fiveSixBet.getText().toString());
                                int col = Integer.parseInt(orangeBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "5 or 6 orange", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(fiveSixBet.getText().toString()) != 0){
                                int num = Integer.parseInt(fiveSixBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "5 or 6 orange", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(orangeBet.getText().toString()) != 0){
                                int col = Integer.parseInt(orangeBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "5 or 6 orange", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        else if(spinDegrees % 360 > 252 && spinDegrees % 360 <= 288){
                            if(Integer.parseInt(sevenBet.getText().toString()) != 0 && Integer.parseInt(yellowBet.getText().toString()) != 0){
                                int num = Integer.parseInt(sevenBet.getText().toString());
                                int col = Integer.parseInt(yellowBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "7 yellow", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(sevenBet.getText().toString()) != 0){
                                int num = Integer.parseInt(sevenBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "7 yellow", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(yellowBet.getText().toString()) != 0){
                                int col = Integer.parseInt(yellowBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "7 yellow", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        else if(spinDegrees % 360 > 288 && spinDegrees % 360 <= 360){
                            if(Integer.parseInt(eightNineBet.getText().toString()) != 0 && Integer.parseInt(greenBet.getText().toString()) != 0){
                                int num = Integer.parseInt(eightNineBet.getText().toString());
                                int col = Integer.parseInt(greenBet.getText().toString());
                                amountWon  += (num + col);
                                wallettAmount += (num + col);
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "8 or 9 green", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(eightNineBet.getText().toString()) != 0){
                                int num = Integer.parseInt(eightNineBet.getText().toString());
                                amountWon += num;
                                wallettAmount += num;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "8 or 9 green", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(greenBet.getText().toString()) != 0){
                                int col = Integer.parseInt(greenBet.getText().toString());
                                amountWon += col;
                                wallettAmount += col;
                                txt_winningPot.setText("You won: $" + amountWon);
                                txt_cashAvailable.setText("" + wallettAmount);
                                Toast.makeText(getApplicationContext(), "8 or 9 green", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                amountWon -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                wallettAmount -= loss(Integer.parseInt(blueBet.getText().toString()), Integer.parseInt(purpleBet.getText().toString()),
                                        Integer.parseInt(redBet.getText().toString()), Integer.parseInt(orangeBet.getText().toString()),
                                        Integer.parseInt(yellowBet.getText().toString()), Integer.parseInt(greenBet.getText().toString()),
                                        Integer.parseInt(oneTenBet.getText().toString()), Integer.parseInt(twoThreeBet.getText().toString()),
                                        Integer.parseInt(fourBet.getText().toString()), Integer.parseInt(fiveSixBet.getText().toString()),
                                        Integer.parseInt(sevenBet.getText().toString()), Integer.parseInt(eightNineBet.getText().toString()));
                                txt_cashAvailable.setText("" + wallettAmount);
                                txt_winningPot.setText("You won: $" + amountWon);
                                Toast.makeText(getApplicationContext(), "You lost money!", Toast.LENGTH_SHORT).show();

                                if(Integer.parseInt(txt_cashAvailable.getText().toString()) <= 0){
                                    btn_spin.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "YOU LOST", Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        else{

                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                } );
                img_wheel.startAnimation(rotateWheel);
            }
        } );
    }
    public int loss (int blue, int purple, int red, int orange, int yellow, int green,
                     int oneTen, int twoThree, int four, int fiveSix, int seven, int eightNine){
        return (blue + purple + red + orange + yellow + green + oneTen + twoThree + four + fiveSix + seven + eightNine);
    }
}
