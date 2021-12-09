package com.onurcansever.quizapp;

public class Result {
    private int resultImage;
    private String resultText;

    public Result(int resultImage, String resultText) {
        this.resultImage = resultImage;
        this.resultText = resultText;
    }

    public int getResultImage() {
        return resultImage;
    }

    public String getResultText() {
        return resultText;
    }
}
