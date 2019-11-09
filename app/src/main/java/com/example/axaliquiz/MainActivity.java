package com.example.axaliquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button buttonStartQuizz, button2, button3, button4, button5, button6;

    Typeface tfc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStartQuizz= findViewById(R.id.button_start_quiz);
        Button button2= findViewById(R.id.button2);
        Button button3= findViewById(R.id.button3);
        Button button4= findViewById(R.id.button4);
        Button button5= findViewById(R.id.button5);
        Button button6= findViewById(R.id.button6);


        tfc1=Typeface.createFromAsset(getAssets(), "fonts/bpg_extrasquare_mtavruli_2009.ttf");
        buttonStartQuizz.setTypeface(tfc1);
        button2.setTypeface(tfc1);
        button3.setTypeface(tfc1);
        button4.setTypeface(tfc1);
        button5.setTypeface(tfc1);
        button6.setTypeface(tfc1);

        buttonStartQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizz();
            }
        });
    }
    private void startQuizz() {
        Intent intent= new Intent(MainActivity.this, QuizzActivity.class);
        startActivity(intent);
    };

}
