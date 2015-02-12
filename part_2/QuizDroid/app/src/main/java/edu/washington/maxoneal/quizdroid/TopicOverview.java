package edu.washington.maxoneal.quizdroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class TopicOverview extends Fragment {
    public TopicOverview() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_topic_overview, container, false);

        final Intent intent = getActivity().getIntent();
        final String topic = intent.getStringExtra("topic");
        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView desc = (TextView) rootView.findViewById(R.id.desc);
        TextView q = (TextView) rootView.findViewById(R.id.questions);

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

        Button begin = (Button) rootView.findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("topic", topic);
                intent.putExtra("count", 0);
                intent.putExtra("num", 0);
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new TopicQuiz())
                        .commit();
            }
        });

        return rootView;
    }
}
