package kr.ac.hs.biggernumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private int points;

    private void roll() {

        Random r = new Random();
        num1 = r.nextInt(10);
        num2 = r.nextInt(10);
        while (num2 == num1) {
            num2 = r.nextInt(10);
        }


        Button left = (Button) findViewById(R.id.buttonLeft);
        left.setText("" + num1);

        Button right = (Button) findViewById(R.id.buttonRight);
        right.setText("" + num2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll();
    }

    public void clickButton1(View view) {

        if(num1 > num2){
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
            points = points+1;
        }
        else{
            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            points = points-1;
        }

        roll();
    }

    public void clickButton2(View view) {
        if(num1 < num2){
            Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT).show();
            points = points+1;
        }
        else{
            Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
            points = points-1;
        }

        roll();
    }
}