package com.example.axaliquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

public class QuizzActivity extends AppCompatActivity {
    private TextView mScoreView;
    private TextView mQuestion;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button next;
    private Button finish;

    private String mAnswer;
    private int mScore;
    private int mQuestionNumber;
    TextView timer;

    private Firebase mQuestionRef, mchoice1Ref, mchoice2Ref, mchoice3Ref, mchoice4Ref, mAnswerRef;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestion = (TextView) findViewById(R.id.question);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);

        next = (Button) findViewById(R.id.next);
        finish = (Button) findViewById(R.id.finish);
        timer = (TextView) findViewById(R.id.timer);
        final TextView score = (TextView) findViewById(R.id.score);

        mQuestionNumber = 12;

        updateQuestion();
    }

    private void updateQuestion() {
        mQuestionRef = new Firebase("https://fir-a8505.firebaseio.com/0/biq");
        mQuestionRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        if(mQuestionNumber > 10){

            mQuestionNumber--;



        }
        else {
            mQuestionNumber++;
        }
    }
}












