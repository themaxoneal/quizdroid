package edu.washington.maxoneal.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AnswerSummary extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_summary);

        Intent intent = getIntent();
        final String topic = intent.getStringExtra("topic");
        String answer = intent.getStringExtra("answer");
        final int count = intent.getIntExtra("count", 0);
        int num = intent.getIntExtra("num", 0);

        TextView summary = (TextView) findViewById(R.id.summary);
        TextView chosenAnswer = (TextView) findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) findViewById(R.id.numCorrect);

        summary.setText(topic);
        chosenAnswer.setText("Your answer was: " + answer);

        if (topic.equals("Math")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: 3.14");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: 0");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: 16");
            }

            if (answer.equals("3.14") || answer.equals("0") || answer.equals("16")) {
                num++;
            }
        } else if (topic.equals("Physics")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: 1720 meters");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: 1.29 seconds");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: 7.17 m/s");
            }

            if (answer.equals("1720 meters") || answer.equals("1.29 seconds") ||
                    answer.equals("7.17 m/s")) {
                num++;
            }
        } else if (topic.equals("Marvel Super Heroes")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: Green Goblin");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: Professor X");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: The Avengers");
            }

            if (answer.equals("Green Goblin") || answer.equals("Professor X") ||
                    answer.equals("The Avengers")) {
                num++;
            }
        }

        numCorrect.setText("You have " + num + " out of " + count + " correct");
        final int number = num;

        Button next = (Button) findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(AnswerSummary.this, TopicsList.class);
                    startActivity(restart);
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent next = new Intent(AnswerSummary.this, TopicQuiz.class);
                    next.putExtra("topic", topic);
                    next.putExtra("count", count);
                    next.putExtra("num", number);
                    startActivity(next);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_answer_summary, menu);
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
