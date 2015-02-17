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
        final String desc = intent.getStringExtra("desc");
        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView description = (TextView) rootView.findViewById(R.id.desc);
        TextView q = (TextView) rootView.findViewById(R.id.questions);

        title.setText(topic);
        description.setText(desc);
        q.setText("# of questions: 3");


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
