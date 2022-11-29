package com.worldofenergy.mainDir.QuizSystem;

import java.util.ArrayList;

public class Question {
    /**
     * Question and it's respective answer possibilities. E.g. "What color is the sun? (a) yellow (b) blue (c) green (d) black"
     */
    String prompt;
    /**
     * The correct answer to the question. E.g. "a"
     */
    String answer;
    String question;

    String[] options;

    /**
     * @param prompt a string containing a question, and it's answer possibilities. E.g. "question (a) answer1 (b) answer2 (c) answer3 (d) answer4".
     * @param answer the answer to the question. E.g. "a"
     */
    public Question (String prompt, String answer) {
        this.prompt = prompt;
        options = new String[3];
        promptSplitter(prompt);
        this.answer = answer;
    }


    private void promptSplitter(String prompt){
        String[] split = prompt.split("\n", 4);
        for (int i = 1; i < split.length; i++) {
            options[i-1] = split[i];
        }

    }

}
