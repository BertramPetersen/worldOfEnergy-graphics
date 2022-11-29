package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.PredictionService.Forecast;
import com.worldofenergy.mainDir.Wallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz implements QuizService {
    /**
     * An int i. Used in {@link #takeQuiz()} to be able to prompt new question and answer each time. Runs through the {@link #questions} ArrayList.
     * Placed outside of {@link #takeQuiz()} to prevent it from continuously being sat to 0.
     * @see #takeQuiz()
     * @see #questions
     */
    private int i;
    /**
     * An ArrayList of the class {@link Question}. Each item in the ArrayList contains a String "prompt" and a String "answer".
     */
    private final ArrayList<Question> questions = new ArrayList<>();

    /**
     * Ensures the {@link #createQuestions()} method is called whenever a new instance of {@link Quiz} is created.
     * Shuffles the questions in {@link #createQuestions()}. Ensuring a new sequence everytime the game is played.
     */
    public Quiz(){
        createQuestions();
        Collections.shuffle(questions);
    }

    /**
     * Contains all the created questions and their respective answers of the quiz. Adds them all to the {@link #questions} Arraylist.
     */
    public void createQuestions () {
        questions.add(new Question("""
                Which of these is not a type of renewable energy?
                (a) Solar
                (b) Wind
                (c) Hydropower
                (d) Natural gas
                """, "d"));
        questions.add(new Question("""
                By which year does FN want to substantially increase the share of renewable energy in the global energy mix?
                (a) 2025
                (b) 2030
                (c) 2040
                (d) 2050
                """,
                "b"));
        questions.add(new Question("""
                What is sustainable energy?
                (a) Green energy
                (b) Black energy
                (c) Blue energy
                (d) Red energy
                """, "a"));
        questions.add(new Question("""
                What is conventional energy?
                (a) White energy
                (b) Energy which is reusable
                (c) Energy which is not reusable
                (d) Green energy
                """, "c"));
        questions.add(new Question("""
                Why is sustainable energy good?
                (a) Just because
                (b) The energy source can be reused again and again
                (c) The energy source can not be reused again and again
                (d) It is not good
                """,
                "b"));
        questions.add(new Question("""
                Where is it best to place a windmill?
                (a) Where there is wind
                (b) Where there is sun
                (c) Where there is water flow
                (d) Where there is warm soil
                """,
                "a"));
        questions.add(new Question("""
                Where is it best to place a solar panels?
                (a) Where there is wind
                (b) Where there is sun
                (c) Where there is water flow
                (d) Where there is warm soil
                """,
                "b"));
        questions.add(new Question("""
                Where is it best to place a hydropower plant?
                (a) Where there is wind
                (b) Where there is sun
                (c) Where there is water flow
                (d) Where there is warm soil
                """,
                "c"));
        questions.add(new Question("""
                Where is it best to place a geothermal power plant?
                (a) Where there is wind
                (b) Where there is sun
                (c) Where there is water flow
                (d) Where there is warm soil
                """,
                "d"));
        questions.add(new Question("""
                Why is it good to place windmills away from population?
                (a) Because they are loud
                (b) Because they are silent
                (c) Because they are small
                (d) It's good to place them close to population
                """,
                "a"));
        questions.add(new Question("""
                When does solar panels produce the most energy?
                (a) At night
                (b) During the day
                """,
                "b"));
        questions.add(new Question("""
                Why does solar panels have to be placed at a open place?
                (a) They don't have to
                (b) Because there shouldn't be shadows
                (c) Just because
                (d) It's up to the individual
                """,
                "b"));
        questions.add(new Question("""
                Why are solar panels a sustainable energy source?
                (a) Because it is durable and can be used for many years
                (b) Because it is not durable and can not be used for many years
                """,
                "a"));
        questions.add(new Question("""
                What is the percentage og sustainable energy in the world?
                (a) 34%
                (b) 26%
                (c) 11%
                (d) 9%
                """,
                "c"));
        questions.add(new Question("""
                In which way is a geothermal power plant good?
                (a) It produces sustainable energy, through heat in the soil
                (b) It produces conventional energy, through cold in the soil
                (c) It produces sustainable energy, through cold in the soil
                (d) It produces conventional energy, through heat in the soil
                """,
                "a"));
        questions.add(new Question("""
                 What is World Goal number 7?
                (a) is about giving everyone access to reliable, sustainable and modern energy
                (b) is about giving everyone access to school and education
                (c) is not exists
                (d) None of the above
                """,
                "a"));
        questions.add(new Question("""
                Where does green energy come from?
                (a) Fossil fuels
                (b) Most wind power, solar energy
                (c) it is just exist
                """,
                "b"));
        questions.add(new Question("""
                Is Denmark self-sufficient in electricity?
                (a) Yes
                (b) No
                (c) I don't Know
                (D) I don't Care
                \s""",
                "a"));
        questions.add(new Question("""
                What percentage is green energy in Denmark?
                (a) 34
                (b) 40
                (c) 60
                (D) 20
                """,
                "a"));
    }


    /**
     * Prompts the user a quiz containing a question and its answer possibilities. Allows the user to try and guess the correct answer and win money to their wallet
     * <p>
     *
     * </p>
     * <p>
     * This method is called when a new turn has been initiated. It first gives the user an introduction to the quiz.
     * It then prints out the questions and answer possibilities.
     * If the user input is equal to the answer e.g. user input = "a" and answer = "a". Then 50 coins is added to {@link Wallet}.
     * If the user input is not equal to the answer e.g. user input = "a" and answer = "b". Then no coins is added to {@link Wallet}
     * After each valid guess {@link #i} is increased by 1 ensuring a new question next time takeQuiz() is called.
     * </p>
     * <p>
     * Should the user input not equal one of the answer possibilities a, b, c or d
     * then an error message is to be received explaining the answer possibilities. After which takeQuiz() is called so the user gets a new chance to answer the question.
     * </p>
     * <p> The method is wrapped in a try...catch statement to prevent an {@link IndexOutOfBoundsException}. In case of an {@link IndexOutOfBoundsException}
     * then {@link #i} is sat to 0, the {@link #questions} ArrayList is shuffled, and takeQuiz() is called. Thereby, restarting the quiz completely.
     * </p>
     * @exception IndexOutOfBoundsException when {@link #i} is greater than the ArrayList length
     */
    // Lets you play the quiz
    public void takeQuiz() {
        System.out.println("You now have the opportunity to earn money to build more energy sources by taking the following quiz:");
        System.out.println();
        try {
            Scanner keyboardInput = new Scanner(System.in);
            System.out.println(questions.get(i).prompt);
            String answer = keyboardInput.nextLine().toLowerCase();
            if (!(answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d"))) {
                System.out.println("Oh no, it looks like your input wasn't one of the answer possibilities!");
                System.out.println("Please type of one the four answer possibilities: a, b, c, or d");
                takeQuiz();
            } else if (answer.equals(questions.get(i).answer)) {
                System.out.println("Congratulations!");
                System.out.println("Your answer was correct");
                System.out.println("You just got 50 coins added to your wallet!");
                Wallet.addCoins(50);
                System.out.println("You now have " + Wallet.getCoins() + " coins in your wallet");
                i++; // Progresses to next prompt and answer in the "worldOfEnergy.mainDir.QuizSystem.Question[] questions" array
            } else {
                System.out.println("Oh no! Your answer was incorrect. The correct answer was " + questions.get(i).answer + ".");
                System.out.println("You unfortunately get 0 coins. Better luck next time!");
                i++; // Progresses to next prompt and answer in the "questions" arraylist
            }
        } catch (IndexOutOfBoundsException e) {
            i = 0;
            Collections.shuffle(questions);
            takeQuiz();
        }
    }
    @Override
    public void initiateRandomEvent(Forecast forecast){}
}

