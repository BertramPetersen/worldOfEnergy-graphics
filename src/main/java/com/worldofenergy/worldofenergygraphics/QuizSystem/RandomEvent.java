package com.worldofenergy.worldofenergygraphics.QuizSystem;

import mainDir.PredictionService.Forecast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RandomEvent implements QuizService{
    private int i;

    Forecast forecast = new Forecast();

    public ArrayList<Events> events = new ArrayList<>();

    public RandomEvent() {
        createEvents();
        Collections.shuffle(events);
    }

    public void createEvents() {
        events.add(new Events("The brazilian government just announced an almost complete deforestation of the Amazon Rainforest. " +
                "Now all the forest’s carbon storage capacity will be lost to the atmosphere", 1.5));
    }

    private void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

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
            initiateRandomEvent((Forecast) forecast);
        }
        i++;
    }
    @Override
    public void takeQuiz(){}
}

