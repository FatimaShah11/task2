package com.example.quizz544a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitB, quitB;
    RadioGroup radioG;
    RadioButton b1, b2;

    String questions[] = {
            "How many emission points of the letters are there?",
            "Which of the following is a list of halqiyah letters?",
            "Which letter is used to produce sound by touching base of Tongue(near Uvula),the mouth roof?",
            "Which letter is used to produce sound by touching portion of Tongue (near its base),the roof of mouth?",
            "Which letters are used to produce sound by touching tongue,the center of mouth roof?",
            "Which of the following is Shajariyah-Haafiyah?",
            "Which tarfiyah letter makes you touch your rounded tip of tongue,the base of frontal 8 teeth?",
            "Which of the following is a list of tarfiyah letters?",
            "Which letters are used to produce sound by touching tip of tongue,the base of front 2 teeth?",
            "Which of the following is a list of Lisaveyah letters?",
            "Which letters are used to produce sound from Mouth empty spaceَ?",
            "Which of the following is a list of Ghunna letters?"
    };
    String answers[] = {"17","أ ہ ع ح غ خ","ق","ک","ج ش ی","ض","ل","ن ر ل","ت د ط","ص ز س ظ ذ ث","ظ ذ ث","م ن ف ب م و"};
    String opt[] = {
            "29","17",
            "أ ہ ع ح غ خ","ن ر ل",
            "ق","م",
            "م","ک",
            "م ن ف ب م و","ج ش ی",
            "م","ض",
            "ل","م",
            "م ن ف ب م و","ن ر ل",
            "م ن ف ب م و","ت د ط",
            "م ن ف ب م و","ص ز س ظ ذ ث",
            "ظ ذ ث","م ن ف ب م و",
            "م ن ف ب م و","ظ ذ ث"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qestions);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitB =(Button)findViewById(R.id.button3);
        quitB =(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radioG =(RadioGroup)findViewById(R.id.answersgrp);
        b1 =(RadioButton)findViewById(R.id.radioButton);
        b2 =(RadioButton)findViewById(R.id.radioButton2);
        tv.setText(questions[flag]);
        b1.setText(opt[0]);
        b2.setText(opt[1]);
        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioG.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please enter one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radioG.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    b1.setText(opt[flag*2]);
                    b2.setText(opt[flag*2 +1]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radioG.clearCheck();
            }
        });

        quitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}