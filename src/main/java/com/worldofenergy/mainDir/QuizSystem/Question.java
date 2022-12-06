package com.worldofenergy.mainDir.QuizSystem;

/**
 * This class' purpose is to create the requirements/variables needed for the questions that the player will be prompted in the game.
 * It's mainly used in {@link Quiz} to create an ArrayList of Questions.
 *
 * @see Quiz
 */
public class Question {
    /**
     * Question and it's respective answer possibilities. E.g. "What color is the sun? (a) yellow (b) blue (c) green (d) black"
     */
    protected String prompt;
    /**
     * The correct answer to the question. E.g. "a"
     */
    protected String answer;
    protected String question;

    protected String[] options;

    /**
     * @param prompt a string containing a question, and it's answer possibilities. E.g. "question (a) answer1 (b) answer2 (c) answer3 (d) answer4".
     * @param answer the answer to the question. E.g. "a"
     */
    public Question(String prompt, String answer) {
        this.prompt = prompt;
        options = new String[4];
        promptSplitter(prompt);
        this.answer = answer;
    }

    private void promptSplitter(String prompt) {
        String[] split = prompt.split("\n", 5);
        question = split[0];
        for (int i = 1; i < split.length; i++) {
            options[i - 1] = split[i];
        }
    }
}
