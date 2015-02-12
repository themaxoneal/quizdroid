package edu.washington.maxoneal.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class TopicQuiz extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_quiz);

        ArrayList<String> mQuestion = new ArrayList<String>();
        mQuestion.add("What are the first three digits of pi?");
        mQuestion.add("What does 0-0 equal?");
        mQuestion.add("What does 4x4 equal?");

        ArrayList<String> pQuestion = new ArrayList<String>();
        pQuestion.add("An airplane accelerates down a runway at 3.20 m/s2 for 32.8 s until it" +
                " finally lifts off the ground. The distance traveled before takeoff is: ");
        pQuestion.add("A feather is dropped on the moon from a height of 1.40 meters. The" +
                " acceleration of gravity on the moon is 1.67 m/s2. The time for the feather to" +
                " fall to the surface of the moon is:");
        pQuestion.add("A kangaroo is capable of jumping to a height of 2.62 m. The takeoff speed" +
                " of the kangaroo is:");

        ArrayList<String> mshQuestion = new ArrayList<String>();
        mshQuestion.add("Which villain killed Gwen Stacy, Spiderman's true love?");
        mshQuestion.add("Who founded the X-Men?");
        mshQuestion.add("What team included Thor, the Hulk, Giant-man, the Wasp and Iron Man as the" +
                " founding members?");

        ArrayList<String> mAnswers = new ArrayList<>();
        mAnswers.add("Raspberry");
        mAnswers.add("3.41");
        mAnswers.add("3.14"); // correct
        mAnswers.add("3.15");
        mAnswers.add("-1");
        mAnswers.add("Castle Kingside");
        mAnswers.add("1");
        mAnswers.add("0"); // correct
        mAnswers.add("Another name for SUV");
        mAnswers.add("16"); // correct
        mAnswers.add("12");
        mAnswers.add("44");

        ArrayList<String> pAnswer = new ArrayList<>();
        pAnswer.add("1720 meters"); // correct
        pAnswer.add("1620 meters");
        pAnswer.add("1910 meters");
        pAnswer.add("1750 meters");
        pAnswer.add("1.85 seconds");
        pAnswer.add("1.29 seconds"); // correct
        pAnswer.add("1.31 seconds");
        pAnswer.add("1.17 seconds");
        pAnswer.add("71.7 m/s");
        pAnswer.add("1.77 m/s");
        pAnswer.add("7.71 m/s");
        pAnswer.add("7.17 m/s"); // correct

        ArrayList<String> mshAnswer = new ArrayList<>();
        mshAnswer.add("Sandman");
        mshAnswer.add("Lex Luther");
        mshAnswer.add("Rhino");
        mshAnswer.add("Green Goblin"); //correct
        mshAnswer.add("Wolverine");
        mshAnswer.add("Magneto");
        mshAnswer.add("Professor X"); //correct
        mshAnswer.add("Mr. Fantastic");
        mshAnswer.add("The Avengers"); // correct
        mshAnswer.add("The Fabulous Five");
        mshAnswer.add("The X-Men");
        mshAnswer.add("The Avenging Team");


        Intent intent = getIntent();
        final String topic = intent.getStringExtra("topic");
        final int count = intent.getIntExtra("count", 0);
        final int num = intent.getIntExtra("num", 0);
        TextView question = (TextView) findViewById(R.id.question);
        TextView ans1 = (TextView) findViewById(R.id.answer1);
        TextView ans2 = (TextView) findViewById(R.id.answer2);
        TextView ans3 = (TextView) findViewById(R.id.answer3);
        TextView ans4 = (TextView) findViewById(R.id.answer4);

        if (topic.equals("Math")) {
            question.setText(mQuestion.get(count));
            ans1.setText(mAnswers.get(4 * count));
            ans2.setText(mAnswers.get(4 * count + 1));
            ans3.setText(mAnswers.get(4 * count + 2));
            ans4.setText(mAnswers.get(4 * count + 3));
        } else if (topic.equals("Physics")) {
            question.setText(pQuestion.get(count));
            ans1.setText(pAnswer.get(4 * count));
            ans2.setText(pAnswer.get(4 * count + 1));
            ans3.setText(pAnswer.get(4 * count + 2));
            ans4.setText(pAnswer.get(4 * count + 3));
        } else if (topic.equals("Marvel Super Heroes")) {
            question.setText(mshQuestion.get(count));
            ans1.setText(mshAnswer.get(4 * count));
            ans2.setText(mshAnswer.get(4 * count + 1));
            ans3.setText(mshAnswer.get(4 * count + 2));
            ans4.setText(mshAnswer.get(4 * count + 3));
        }

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) findViewById(R.id.answers);
                int radioId = radio.getCheckedRadioButtonId();
                if (radioId != -1) {
                    Intent intent = new Intent(TopicQuiz.this, AnswerSummary.class);
                    TextView checkedButton = (TextView) findViewById(radioId);
                    intent.putExtra("topic", topic);
                    intent.putExtra("answer", checkedButton.getText());
                    intent.putExtra("count", count + 1);
                    intent.putExtra("num", num);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_quiz, menu);
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
