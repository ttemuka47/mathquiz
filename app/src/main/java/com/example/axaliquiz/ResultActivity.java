package com.example.axaliquiz;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TextView nameView= (TextView) findViewById(R.id.result_txt);
        nameView.setText(getIntent().getExtras().getString("Username"));

        Button homePage = findViewById(R.id.homePage);
        Button tryAgain= findViewById(R.id.tryAgain);

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryAgain();
            }
        });
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeP();
            }
        });


    }
    private void tryAgain() {
        Intent intentTry= new Intent(ResultActivity.this, QuizzActivity.class);
        startActivity(intentTry);
    };
    private void homeP(){

        Intent intentHome= new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intentHome);

    };





}


