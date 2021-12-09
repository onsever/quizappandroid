package com.onurcansever.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizGame {

    public QuizGame() {}

    private final Question[] questions = {
            new Question("Who founded Apple Computer?",
                    new Answer[] {
                            new Answer("Stephen Fry", false),
                            new Answer("Bill Gates", false),
                            new Answer("Steve Jobs", true),
                            new Answer("Stephen Hawking", false),
                    }),

            new Question("Which of these is not a peripheral, in computer terms?",
                    new Answer[] {
                            new Answer("Keyboard", false),
                            new Answer("Monitor", false),
                            new Answer("Mouse", false),
                            new Answer("Motherboard", true),
                    }),

            new Question("Which of the following is not one of the early “protocols,” or ways to use the Internet?",
                    new Answer[] {
                            new Answer("Blogging", true),
                            new Answer("Telnet", false),
                            new Answer("Gopher", false),
                            new Answer("FTP", false),
                    }),

            new Question("What does the Internet prefix WWW stand for?",
                    new Answer[] {
                            new Answer("Wide Width Wickets", false),
                            new Answer("World Wide Web", true),
                            new Answer("Worldwide Weather", false),
                            new Answer("Western Washington World", false),
                    }),

            new Question("What is the name for a computer pointing device?",
                    new Answer[] {
                            new Answer("A Mouse", true),
                            new Answer("Sound Card", false),
                            new Answer("RAM", false),
                            new Answer("Monitor", false),
                    }),

            new Question("Which of these is a file format for digital images?",
                    new Answer[] {
                            new Answer("CIA", false),
                            new Answer("JPG", true),
                            new Answer("ICBM", false),
                            new Answer("IBM", false),
                    }),

            new Question("To which of these devices is the cellular telephone most closely related?",
                    new Answer[] {
                            new Answer("Telegraph", false),
                            new Answer("Radio", true),
                            new Answer("Lightbulb", false),
                            new Answer("Telescope", false),
                    }),

            new Question("Which of these is an the generic term for a collection of private computer networks within an organization?",
                    new Answer[] {
                            new Answer("Intranet", true),
                            new Answer("Extranet", false),
                            new Answer("Internet", false),
                            new Answer("Network", false),
                    }),

            new Question("What is a Codec most commonly used for?",
                    new Answer[] {
                            new Answer("Decoding Passwords", false),
                            new Answer("Decoding Audio/Video Stream", true),
                            new Answer("Encrypting Data", false),
                            new Answer("Saving Contact Information", false),
                    }),

            new Question("What Does RAID Stand for?",
                    new Answer[] {
                            new Answer("Random Access Inside Disks", false),
                            new Answer("Reload Advanced Intel Device", false),
                            new Answer("Relocate Array Inside Drive", false),
                            new Answer("Redundant Array of Inexpensive Disks", true),
                    }),

    };

    public Question[] getQuestions() {
        return randomQuestionGenerator(questions);
    }

    public Result returnResult(int scoreCounter) {
        switch (scoreCounter) {
            case 0:
            case 1:
            case 2:
                return new Result(R.drawable.fail, "Please try again!");
            case 3:
                return new Result(R.drawable.trophy, "Good job!");
            case 4:
                return new Result(R.drawable.trophy, "Excellent work!");
            case 5:
                return new Result(R.drawable.trophy, "You are a genius!");
            default:
                return null;
        }
    }

    private Question[] randomQuestionGenerator(Question[] questions) {
        List<Question> questionList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionList.add(questions[i]);
        }

        Collections.shuffle(questionList);

        for (int i = 0; i < questionList.size(); i++) {
            questions[i] = questionList.get(i);
        }

        return questions;
    }
}
