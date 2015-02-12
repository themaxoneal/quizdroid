package edu.washington.maxoneal.quizdroid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class AnswerSummary extends Fragment {
    public AnswerSummary() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_answer_summary, container, false);

        final Intent intent = getActivity().getIntent();
        final String topic = intent.getStringExtra("topic");
        String answer = intent.getStringExtra("answer");
        final int count = intent.getIntExtra("count", 0);
        int num = intent.getIntExtra("num", 0);

        TextView summary = (TextView) rootView.findViewById(R.id.summary);
        TextView chosenAnswer = (TextView) rootView.findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) rootView.findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) rootView.findViewById(R.id.numCorrect);

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

        Button next = (Button) rootView.findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(getActivity(), TopicsList.class);
                    startActivity(restart);
                    getActivity().finish();
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("topic", topic);
                    intent.putExtra("count", count);
                    intent.putExtra("num", number);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, new TopicQuiz())
                            .commit();
                }
            });
        }
        return rootView;
    }
}
