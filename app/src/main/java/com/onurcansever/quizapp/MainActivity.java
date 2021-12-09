package com.onurcansever.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.onurcansever.quizapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    private final QuizGame quizGame = new QuizGame();
    private Question[] questions;

    private int currentQuestion = 0;
    private int scoreCounter = 0;
    private boolean currentAnswer = false;
    private boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        
        questions = quizGame.getQuestions();
        setLayout();

        binding.answerOne.setOnClickListener(this);
        binding.answerTwo.setOnClickListener(this);
        binding.answerThree.setOnClickListener(this);
        binding.answerFour.setOnClickListener(this);
        binding.nextButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        questions = quizGame.getQuestions();
        setLayout();
    }

    private void setLayout() {
        Question question = questions[currentQuestion];
        unSelectedAnswer();

        binding.questionProgressBar.setProgress(currentQuestion);
        binding.questionNameText.setText(question.getQuestionName());
        binding.answerOne.setText(question.getAnswers()[0].getAnswer());
        binding.answerTwo.setText(question.getAnswers()[1].getAnswer());
        binding.answerThree.setText(question.getAnswers()[2].getAnswer());
        binding.answerFour.setText(question.getAnswers()[3].getAnswer());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.answerOne:
                selectedAnswer(binding.answerOne);
                isSelected = true;
                currentAnswer = questions[currentQuestion].getAnswers()[0].isCorrect();
                break;

            case R.id.answerTwo:
                selectedAnswer(binding.answerTwo);
                isSelected = true;
                currentAnswer = questions[currentQuestion].getAnswers()[1].isCorrect();
                break;

            case R.id.answerThree:
                selectedAnswer(binding.answerThree);
                isSelected = true;
                currentAnswer = questions[currentQuestion].getAnswers()[2].isCorrect();
                break;

            case R.id.answerFour:
                selectedAnswer(binding.answerFour);
                isSelected = true;
                currentAnswer = questions[currentQuestion].getAnswers()[3].isCorrect();
                break;

            case R.id.nextButton:
                if (!isSelected) break;
                if (currentAnswer) scoreCounter++;
                if (currentQuestion == 3) binding.nextButton.setText("Finish");

                if (currentQuestion == 4) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("score", scoreCounter);
                    startActivity(intent);
                    finish();
                }
                else {
                    currentQuestion++;
                    setLayout();
                    isSelected = false;
                }
                
                break;
        }
    }

    private void selectedAnswer(TextView textView) {
        unSelectedAnswer();

        int left = binding.answerOne.getPaddingLeft();
        int top = binding.answerOne.getPaddingTop();
        int right = binding.answerOne.getPaddingRight();
        int bottom = binding.answerOne.getPaddingBottom();

        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_row));
        textView.setPadding(left, top, right, bottom);
    }

    private void unSelectedAnswer() {
        ArrayList<TextView> answers = new ArrayList<>();
        answers.add(0, binding.answerOne);
        answers.add(1, binding.answerTwo);
        answers.add(2, binding.answerThree);
        answers.add(3, binding.answerFour);

        int left = binding.answerOne.getPaddingLeft();
        int top = binding.answerOne.getPaddingTop();
        int right = binding.answerOne.getPaddingRight();
        int bottom = binding.answerOne.getPaddingBottom();

        for (TextView textView: answers) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.answer_row_design));
            textView.setPadding(left, top, right, bottom);
        }
    }

}
