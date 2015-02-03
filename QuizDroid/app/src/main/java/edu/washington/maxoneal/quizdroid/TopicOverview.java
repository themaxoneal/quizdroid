package edu.washington.maxoneal.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class TopicOverview extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);

        Intent intent = getIntent();
        final String topic = intent.getStringExtra("topic");
        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        TextView q = (TextView) findViewById(R.id.questions);

        if (topic.equals("Math")) {
            title.setText("Math");
            desc.setText("This is a quiz on mathematics, the study of the measurement," +
                    " relationships, and properties of quantities and sets, using numbers" +
                    " and symbols.");
            q.setText("# of questions: 3");
        } else if (topic.equals("Physics")) {
            title.setText("Physics");
            desc.setText("This is a quiz on physics, the science that deals with matter, " +
                    "energy, motion, and force.");
            q.setText("# of questions: 3");
        } else if (topic.equals("Marvel Super Heroes")) {
            title.setText("Marvel Super Heroes");
            desc.setText("This is a quiz on Marvel Super Heroes, the heroes that have" +
                    " taken your money via comics, action figures, and movies for as long" +
                    " as you can remember.");
            q.setText("# of questions: 3");
        }

        Button begin = (Button) findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz = new Intent(TopicOverview.this, TopicQuiz.class);
                quiz.putExtra("topic", topic);
                quiz.putExtra("count", 0);
                quiz.putExtra("num", 0);
                startActivity(quiz);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
