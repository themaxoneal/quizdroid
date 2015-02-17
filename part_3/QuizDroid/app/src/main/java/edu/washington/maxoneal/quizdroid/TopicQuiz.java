package edu.washington.maxoneal.quizdroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class TopicQuiz extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_topic_quiz, container, false);
        final Intent intent = getActivity().getIntent();
        final String topic = intent.getStringExtra("topic");
        final int count = intent.getIntExtra("count", 0);
        final int num = intent.getIntExtra("num", 0);

        ArrayList<Topic> tp = QuizAppSingleton.getInstance().getElements();
        TextView question = (TextView) rootView.findViewById(R.id.question);
        TextView answer1 = (TextView) rootView.findViewById(R.id.answer1);
        TextView answer2 = (TextView) rootView.findViewById(R.id.answer2);
        TextView answer3 = (TextView) rootView.findViewById(R.id.answer3);
        TextView answer4 = (TextView) rootView.findViewById(R.id.answer4);

        if (topic.equals("Math")) {
            ArrayList<Quiz> qz = tp.get(0).getQuestions();
            String q = qz.get(count).getQuestion();
            String ans1 = qz.get(count).getAns1();
            String ans2 = qz.get(count).getAns2();
            String ans3 = qz.get(count).getAns3();
            String ans4 = qz.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        } else if (topic.equals("Physics")) {
            ArrayList<Quiz> qz = tp.get(1).getQuestions();
            String q = qz.get(count).getQuestion();
            String ans1 = qz.get(count).getAns1();
            String ans2 = qz.get(count).getAns2();
            String ans3 = qz.get(count).getAns3();
            String ans4 = qz.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        } else if (topic.equals("Marvel Super Heroes")) {
            ArrayList<Quiz> qz = tp.get(2).getQuestions();
            String q = qz.get(count).getQuestion();
            String ans1 = qz.get(count).getAns1();
            String ans2 = qz.get(count).getAns2();
            String ans3 = qz.get(count).getAns3();
            String ans4 = qz.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        }

        Button submit = (Button) rootView.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) rootView.findViewById(R.id.answers);
                int radioId = radio.getCheckedRadioButtonId();
                int id = 0;

                switch (radioId) {
                    case R.id.answer1:
                        id = 1;
                        break;
                    case R.id.answer2:
                        id = 2;
                        break;
                    case R.id.answer3:
                        id = 3;
                        break;
                    case R.id.answer4:
                        id = 4;
                        break;
                }

                if (radioId != -1) {
                    TextView checkedButton = (TextView) rootView.findViewById(radioId);
                    intent.putExtra("topic", topic);
                    intent.putExtra("answer", checkedButton.getText());
                    intent.putExtra("answerID", id);
                    intent.putExtra("count", count + 1);
                    intent.putExtra("num", num);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, new AnswerSummary())
                            .commit();
                }
            }
        });
        return rootView;
    }
}
