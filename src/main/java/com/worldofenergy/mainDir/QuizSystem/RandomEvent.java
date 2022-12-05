package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.PredictionService.Forecast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The class RandomEvent implements the interface {@link QuizService}, by which it implements multiple methods.
 * The class consists of the logic behind the randomly occurring events in the game. It also contains all the possible events in an {@link Events} ArrayList.
 * <p>
 * It's main purpose is to display the random event, affect the forecast negatively by accelerating the negative consequences, show and explain to the player the consequences of the random event.
 * </p>
 *
 * @see Events
 * @see QuizService
 */
public class RandomEvent implements QuizService {
    /**
     * An int i. Used in {@link #initiateRandomEvent(Forecast)} to be able to prompt a new event and impact each time. Runs through the {@link #events} ArrayList.
     * Placed outside of {@link #initiateRandomEvent(Forecast)} to prevent it from continuously being sat to 0.
     *
     * @see #initiateRandomEvent(Forecast)
     * @see #events
     */
    private int i;
    /**
     * An ArrayList of the class {@link Events}. Each item in the ArrayList contains a String "description" and an int "impact".
     */
    private final ArrayList<Events> events = new ArrayList<>();

    /**
     * Ensures the {@link #createEvents()} method is called whenever a new instance of {@link RandomEvent} is created.
     * Shuffles the events in {@link #createEvents()}. Ensuring a new sequence everytime the game is played.
     */
    public RandomEvent() {
        createEvents();
        Collections.shuffle(events);
    }

    /**
     * Contains all the created events and their respective descriptions and impacts. Adds them all to the {@link #events} Arraylist.
     */
    private void createEvents() {
        events.add(new Events("The brazilian government just announced an almost complete deforestation of the Amazon Rainforest. " +
                "Now all the forest’s carbon storage capacity will be lost to the atmosphere", 1.5));
    }

    /**
     * Requires the user to hit enter before anything can happen
     */
    private void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Alerts the player that something unusual has happened. Prompts a random event then displays how much the forecast has been impacted by the random event.
     * <p>
     * This method is called when a new turn has been initiated. It displays the event description. Then displays and visualizes by the new forecast
     * It then tells the player by how much forecast has increased in percentage. After each guess {@link #i} is increased by 1 ensuring a new event next time initiateRandomEvent() is called.
     * </p>
     * <p> The method is wrapped in a try...catch statement to prevent an {@link IndexOutOfBoundsException}. In case of an {@link IndexOutOfBoundsException}
     * then {@link #i} is sat to 0, the {@link #events} ArrayList is shuffled, and initiateRandomEvent() is called. Thereby, restarting the randomEvent completely.
     * </p>
     *
     * @param forecast the instance of forecast that is to be impacted by the random event.
     * @throws IndexOutOfBoundsException when {@link #i} is greater than the ArrayList length
     */
    public void initiateRandomEvent(Forecast forecast) {
        try {

            System.out.println("Wait...");
            promptEnterKey();
            System.out.println("Something is off...");
            promptEnterKey();
            System.out.println("Something happened as the new year commenced...");
            promptEnterKey();
            System.out.println("!ALERT! " + events.get(i).description + " !ALERT!");
            promptEnterKey();
            System.out.println("This will undoubtedly have consequences on the climate forecast and energy balance...");
            promptEnterKey();
            System.out.println("!ALERT!             !ALERT!             !ALERT!             !ALERT!             !ALERT!");
            forecast.increase(events.get(i).impact);
            System.out.println("!ALERT!             !ALERT!             !ALERT!             !ALERT!             !ALERT!");
            System.out.println("Oh no! These news have terrible consequences for our forecast. It has increased with " + (int) ((events.get(i).impact * 100) - 100) + "%!");
            System.out.println();
            promptEnterKey();
        } catch (IndexOutOfBoundsException e) {
            i = 0;
            Collections.shuffle(events);
            initiateRandomEvent(forecast);
        }
        i++;
    }

    @Override
    public String getNextQuestion() {
        return null;
    }

    @Override
    public String getNextAnswer() {
        return null;
    }

    @Override
    public String[] getNextOptions() {
        return new String[0];
    }

    @Override
    public void incrementQuiz() {
    }

    @Override
    public void takeQuiz() {
    }
}

