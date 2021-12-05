package com.example.quizz544a;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_activity);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView I1=(ImageView)findViewById(R.id.imageView2);
        ImageView I2=(ImageView)findViewById(R.id.imageView3);
        ImageView I3=(ImageView)findViewById(R.id.imageView4);
        ImageView I4=(ImageView)findViewById(R.id.imageView5);







    }
}

