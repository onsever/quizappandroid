package com.onurcansever.quizapp;

public class Question {
    private String questionName;
    private Answer[] answers;

    public Question(String questionName, Answer[] answers) {
        this.questionName = questionName;
        this.answers = answers;
    }

    public String getQuestionName() {
        return questionName;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}
