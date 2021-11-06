package com.example.quizet;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    //widgets
    private TextView question, qustCount, timer;
    private Button option1,option2,option3,option4;

    private List<Question> questionList;
    private  int curentQust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //binding
        question=findViewById(R.id.question);
        qustCount=findViewById(R.id.quest_nbr);
        timer=findViewById(R.id.timer);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        //listener
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionList();

    }

    private void getQuestionList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("quest1","A","B","C","O",2));
        questionList.add(new Question("quest2","E","G","C","D",2));
        questionList.add(new Question("quest3","X","B","Z","L",2));
        questionList.add(new Question("quest4","A","B","Z","D",2));
        questionList.add(new Question("quest5","A","J","C","K",2));
        questionList.add(new Question("quest6","W","B","S","D",2));

        setQuestion();
    }

    private void setQuestion() {
        timer.setText(String.valueOf(10));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());
        qustCount.setText(String.valueOf(1)+ "/" + String.valueOf(questionList.size()));
        
        startTimer();
        curentQust=0;
    }

    private void startTimer() {
        CountDownTimer countDown = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {
                changeQuestion();

            }
        };
        countDown.start();
    }

    @Override
    public void onClick(View v) {
        int selectedOption = 0;
        switch (v.getId()){
            case R.id.option1:
                selectedOption = 1;
                break;
            case R.id.option2:
                selectedOption = 2;
                break;
            case R.id.option3:
                selectedOption = 3;
                break;
            case R.id.option4:
                selectedOption = 4;
                break;
            default:
        }
     checkAnswer(selectedOption);
    }

    private void checkAnswer(int selectedOption) {
        if(selectedOption==questionList.get(curentQust).getCorrectAnswer()){
            //right answer
        }
        else {
            //wrong answer
        }
        changeQuestion();
    }

    private void changeQuestion() {
        if(curentQust < questionList.size() - 1){
            playAnimation(option1,0);
        }
        else{
            //score activity
            Intent intent = new Intent(QuestionsActivity.this, ScoreActivity.class);
            startActivity(intent);
            QuestionsActivity.this.finish();
        }
    }

    private void playAnimation(View view, final int value) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

}