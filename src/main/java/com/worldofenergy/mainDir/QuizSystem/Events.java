package com.worldofenergy.mainDir.QuizSystem;

/**
 * This class' purpose is to create the requirements/variables needed for the events that can randomly occur in the game.
 * It's mainly used in {@link RandomEvent} to create an ArrayList of Events.
 * @see RandomEvent
 */
public class Events {
    /**
     * Description of the random event.
     */
    String description;
    /**
     * The impact value is a factor. An impact value of 1.5 is equal to 50% increase.
     */
    double impact;
    String fileName;

    /**
     * Constructor that creates events. An event has a description and an impact.
     * @param description a String description of the random event.
     * @param impact a double determining the impact value. An impact value of 1.5 is equal to 50% increase
     */
    public Events (String description, double impact, String fileName) {
        this.description = description;
        this.impact = impact;
        this.fileName = fileName;
    }
}