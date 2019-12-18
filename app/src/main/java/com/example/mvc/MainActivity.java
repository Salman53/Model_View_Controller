package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button btntrue,btnfalse ,btnnext;

    private int currentIndex =0;

    private Question[] questionstxt = new Question[]
            {
                    new Question(R.string.question1,true),
                    new Question(R.string.question2, false),
                    new Question(R.string.question3, false)
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntrue = findViewById(R.id.btntrue);
        btnfalse = findViewById(R.id.btnfalse);
        tv =findViewById(R.id.q_text_view);
        btnnext = findViewById(R.id.btnnext);


        int question = questionstxt[currentIndex].getResid();//0
        tv.setText(question);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex +1 )% questionstxt.length;

                int question = questionstxt[currentIndex].getResid();//1
                tv.setText(question);

            }
        });


        btntrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        btnfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);
            }
        });
    }


    private void checkAnswer( boolean answercheck)
    {
        boolean answerIs = questionstxt[currentIndex].isAnswer();//true
        int messageId=0;

        if (answercheck == answerIs)
        {
            messageId= R.string.correct;
        }
        else
        {
            messageId=R.string.Incorrect;
        }

        Toast.makeText(MainActivity.this, messageId, Toast.LENGTH_SHORT).show();
    }
}
