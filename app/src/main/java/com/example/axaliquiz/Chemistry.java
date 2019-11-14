package com.example.axaliquiz;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;
public class Chemistry extends AppCompatActivity{

    private TextView mScoreView;
    private TextView mQuestion;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button next;
    private Button finish;
    private InterstitialAd mInterstitialAd;
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
        timer = (TextView) findViewById(R.id.timer);
        reverseTimer(1800, timer);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);

        next = (Button) findViewById(R.id.next);
        finish = (Button) findViewById(R.id.finish);
        timer = (TextView) findViewById(R.id.timer);
        final TextView score = (TextView) findViewById(R.id.score);
        score.setText(mScore + "/30");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/8691691433");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                /* startQuizz(); */
                mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
            }

        });

        mQuestionNumber = 0;

        updateQuestion();


        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice1.setClickable(false);
                mButtonChoice2.setClickable(false);
                mButtonChoice3.setClickable(false);
                mButtonChoice4.setClickable(false);
                next.setClickable(false);

                if (mButtonChoice1.getText().equals(mAnswer)) {
                    mButtonChoice1.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Chemistry.this, "სწორია!", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText(mScore + "/30");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            updateQuestion();
                            mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));




                        }
                    },1500);


                } else {

                    mButtonChoice1.setBackgroundColor(Color.RED);


                    Toast.makeText(Chemistry.this, "არასწორია!", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
                            updateQuestion();

                        }
                    },1500);


                }


            }
        });




        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice1.setClickable(false);
                mButtonChoice2.setClickable(false);
                mButtonChoice3.setClickable(false);
                mButtonChoice4.setClickable(false);
                next.setClickable(false);
                if (mButtonChoice2.getText().equals(mAnswer)) {
                    mButtonChoice2.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Chemistry.this, "სწორია!", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText(mScore + "/30");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            updateQuestion();
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));


                        }
                    },1500);


                } else {

                    mButtonChoice2.setBackgroundColor(Color.RED);


                    Toast.makeText(Chemistry.this, "არასწორია!", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
                            updateQuestion();

                        }
                    },1500);


                }


            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice1.setClickable(false);
                mButtonChoice2.setClickable(false);
                mButtonChoice3.setClickable(false);
                mButtonChoice4.setClickable(false);
                next.setClickable(false);
                if (mButtonChoice3.getText().equals(mAnswer)) {
                    mButtonChoice3.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Chemistry.this, "სწორია!", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText(mScore + "/30");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            updateQuestion();
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));


                        }
                    },1500);


                } else {

                    mButtonChoice3.setBackgroundColor(Color.RED);


                    Toast.makeText(Chemistry.this, "არასწორია!", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
                            updateQuestion();

                        }
                    },1500);


                }


            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice1.setClickable(false);
                mButtonChoice2.setClickable(false);
                mButtonChoice3.setClickable(false);
                mButtonChoice4.setClickable(false);
                next.setClickable(false);
                if (mButtonChoice4.getText().equals(mAnswer)) {
                    mButtonChoice4.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Chemistry.this, "სწორია!", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText(mScore + "/30");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            updateQuestion();
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#0091EA"));


                        }
                    },1500);


                } else {

                    mButtonChoice4.setBackgroundColor(Color.RED);


                    Toast.makeText(Chemistry.this, "არასწორია!", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#0091EA"));
                            updateQuestion();

                        }
                    },1500);


                }


            }
        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOver();



                /*Intent myIntent = new Intent(QuizzActivity.this, ResultActivity.class);
                myIntent.putExtra("Username", score.getText().toString());

                startActivity(myIntent);*/

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateQuestion();


            }
        });



    }


    private void updateQuestion() {
        mQuestionRef = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimiaq");
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


        mAnswerRef = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimiaanswer");
        mAnswerRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mchoice1Ref = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimia1");
        mchoice1Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice1 = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice1);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice2Ref = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimia2");
        mchoice2Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice2 = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice2);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice3Ref = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimia3");
        mchoice3Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice3 = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice3);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mchoice4Ref = new Firebase("https://fir-a8505.firebaseio.com/"+ mQuestionNumber +"/qimia4");
        mchoice4Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice4 = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice4);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mButtonChoice1.setClickable(true);
        mButtonChoice2.setClickable(true);
        mButtonChoice3.setClickable(true);
        mButtonChoice4.setClickable(true);
        next.setClickable(true);
        /* mQuestionNumber++;*/
        if (mQuestionNumber < 10) {

            mQuestionNumber++;

        } else {
            gameOver();
        }
    }

    private void quitFunction() {

        Intent myIntent = new Intent(Chemistry.this, ResultActivity.class);
        startActivity(myIntent);

    }


    public void reverseTimer(int Seconds, final TextView tv) {

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("დრო ამოიწურა");
                gameOver();
            }
        }.start();

    }



    private void gameOver() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Chemistry.this);
        alertDialogBuilder
                .setMessage("თქვენ დააგროვეთ " + mScore + " სწორი პასუხი")
                .setCancelable(false)
                .setPositiveButton("ცადეთ თავიდან",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Chemistry.class));

                            }
                        })
                .setNegativeButton("მთავარზე დაბრუნება",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }

                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}















