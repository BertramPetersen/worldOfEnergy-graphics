package com.worldofenergy.mainDir.QuizSystem;

public class Question {
    /**
     * Question and it's respective answer possibilities. E.g. "What color is the sun? (a) yellow (b) blue (c) green (d) black"
     */
    String prompt;
    /**
     * The correct answer to the question. E.g. "a"
     */
    String answer;

    /**
     * @param prompt a string containing a question, and it's answer possibilities. E.g. "question (a) answer1 (b) answer2 (c) answer3 (d) answer4".
     * @param answer the answer to the question. E.g. "a"
     */
    public Question (String prompt, String answer) {
        this.prompt = prompt;
        this.answer = answer;
    }

}
