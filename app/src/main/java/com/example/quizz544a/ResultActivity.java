package com.example.quizz544a;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
        btnShare= (Button) findViewById(R.id.share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3 = new Intent(Intent.ACTION_SEND);
                in3.setType("text/plain");
                String ShareBody="your body here";
                String ShareSub="your subject here";
                in3.putExtra(Intent.EXTRA_SUBJECT,ShareBody);
                in3.putExtra(Intent.EXTRA_TEXT,ShareBody);

                startActivity(Intent.createChooser(in3,"share using"));
            }
        });
    }

}

