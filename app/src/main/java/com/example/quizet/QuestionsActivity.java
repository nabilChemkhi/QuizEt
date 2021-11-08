package com.example.quizet;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
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
    //attributes
    private List<Question> questionList;
    private  int curentQust;
    private CountDownTimer countDown;
    private  int score;

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

        score = 0;

    }

    private void getQuestionList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("quest1","A","B","C","O",2));
        questionList.add(new Question("quest2","E","G","C","D",2));
        questionList.add(new Question("quest3","X","B","Z","L",2));
        questionList.add(new Question("quest4","A","B","Z","D",2));
        questionList.add(new Question("quest5","A","J","C","K",2));
        questionList.add(new Question("quest6","W","B","S","D",2));
        questionList.add(new Question("quest7","X","B","Z","L",2));
        questionList.add(new Question("quest8","A","B","Z","D",2));
        questionList.add(new Question("quest9","A","J","C","K",2));
        questionList.add(new Question("quest10","W","B","S","D",2));

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
         countDown = new CountDownTimer(11000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished < 10000)
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
        countDown.cancel();
     checkAnswer(selectedOption , v);
    }

    private void checkAnswer(int selectedOption, View view) {
        if(selectedOption==questionList.get(curentQust).getCorrectAnswer()){
            //right answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score++ ;
        }
        else {
            //wrong answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            switch (questionList.get(curentQust).getCorrectAnswer()){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                default://
            }
        }
        //delais before changing quest
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();

            }
        },1000);

    }

    private void changeQuestion() {
        if(curentQust < questionList.size() - 1){
            curentQust ++ ;
            playAnimation(question,0,0);
            playAnimation(option1,0,1);
            playAnimation(option2,0,2);
            playAnimation(option3,0,3);
            playAnimation(option4,0,4);

            qustCount.setText(String.valueOf(curentQust + 1) + "/" + questionList.size());
            timer.setText(String.valueOf(10));
            startTimer();

        }
        else{
            //score activity
            Intent intent = new Intent(QuestionsActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE",String.valueOf(score + "/" + questionList.size()));
            startActivity(intent);
            QuestionsActivity.this.finish();
        }
    }

    private void playAnimation(View view, final int value, int numView) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (value==0){
                            switch (numView){
                                case 0:
                                    ((TextView) view).setText(questionList.get(curentQust).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionList.get(curentQust).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionList.get(curentQust).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionList.get(curentQust).getOptionC());
                                    break;
                                case 4:
                                    ((Button) view).setText(questionList.get(curentQust).getOptionD());
                                    break;
                            }
                            if(numView != 0)
                               // ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("0000FF")));
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                            playAnimation(view,1,numView);

                        }

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