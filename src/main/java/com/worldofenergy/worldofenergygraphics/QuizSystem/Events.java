package com.worldofenergy.worldofenergygraphics.QuizSystem;

public class Events {
    String description;
    double impact; // The impact value is a factor. An impact value of 1.5 is equal to 50% increase

    public Events (String description, double impact) {
        this.description = description;
        this.impact = impact;
    }

}
