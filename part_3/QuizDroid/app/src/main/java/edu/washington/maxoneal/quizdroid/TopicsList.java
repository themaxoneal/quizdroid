package edu.washington.maxoneal.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;


public class TopicsList extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_list);

        String[] values = new String[] {"Math", "Physics", "Marvel Super Heroes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, values);
        final ListView listview = (ListView) findViewById(R.id.topicsList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(TopicsList.this, Fragments.class);
                String topic = QuizAppSingleton.getInstance().getElements().get(position).getTitle();
                String longDesc = QuizAppSingleton.getInstance().getElements().get(position).getLongDesc();
                intent.putExtra("topic", topic);
                intent.putExtra("desc", longDesc);
                startActivity(intent);
            }
        });
    }
}