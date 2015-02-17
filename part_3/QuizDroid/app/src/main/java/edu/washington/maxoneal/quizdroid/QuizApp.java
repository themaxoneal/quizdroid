package edu.washington.maxoneal.quizdroid;

import android.app.Application;
import android.util.Log;


public class QuizApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("QuizApp", "I know it's hard to believe, but this App is running");
        initializeSingletons();
    }

    protected void initializeSingletons() {
        QuizAppSingleton.initInstance();
    }

    public void customAppMethod() {
    }
}