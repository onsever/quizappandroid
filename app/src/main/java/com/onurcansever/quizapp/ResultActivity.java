package com.onurcansever.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.onurcansever.quizapp.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private final QuizGame quizGame = new QuizGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        int currentScore = intent.getIntExtra("score", 0);

        binding.resultText.setText(quizGame.returnResult(currentScore).getResultText());
        binding.resultImage.setImageResource(quizGame.returnResult(currentScore).getResultImage());
        binding.scoreText.setText(String.valueOf(currentScore));

        if (currentScore < 3) {
            binding.congratulationsText.setText("PLEASE TRY AGAIN!");
            binding.playAgainButton.setText("Try Again");
        }
        else {
            binding.congratulationsText.setText("CONGRATULATIONS!");
            binding.playAgainButton.setText("Play Again");
        }
        
        binding.playAgainButton.setOnClickListener(view1 -> {
            Intent changeActivity = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(changeActivity);
            finish();
        });
    }
}