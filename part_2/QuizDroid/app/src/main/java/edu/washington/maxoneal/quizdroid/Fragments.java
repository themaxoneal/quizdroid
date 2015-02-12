package edu.washington.maxoneal.quizdroid;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;



public class Fragments extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        if (savedInstanceState == null) { // if Application ever fired up before, is this the first time we're firing it up
            // r.id.container is where you want the fragment to be inserted
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new TopicOverview())
                    .commit();
        }
    }
}
