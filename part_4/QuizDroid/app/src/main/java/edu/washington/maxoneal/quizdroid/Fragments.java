package edu.washington.maxoneal.quizdroid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class Fragments extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new TopicOverview())
                    .commit();
        }
    }
}
