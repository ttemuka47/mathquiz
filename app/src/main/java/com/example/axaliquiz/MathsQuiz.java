package com.example.axaliquiz;

import android.app.Application;

import com.firebase.client.Firebase;

public class MathsQuiz extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
