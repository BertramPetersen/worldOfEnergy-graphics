package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
import com.worldofenergy.mainDir.PredictionService.Forecast;
import com.worldofenergy.mainDir.Presentation.CountryController;
import com.worldofenergy.mainDir.Presentation.Position;
import com.worldofenergy.mainDir.Room;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class RandomEvent implements QuizService{


    /**
     * An int i. Used in {@link #initiateRandomEvent(Forecast)} to be able to prompt a new event and impact each time. Runs through the {@link #events} ArrayList.
     * Placed outside of {@link #initiateRandomEvent(Forecast)} to prevent it from continuously being sat to 0.
     *
     * @see #initiateRandomEvent(Forecast)
     * @see #events
     */
    private int i;

    private String url;
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
        events.add(new Events("A south american country's government just announced an almost complete halt and removal of their project to build solar panels. Instead getting energy from burning trees in the Amazon Rainforest. Now all the forest’s carbon storage capacity will be lost to the atmosphere", 1.5, "AmazonDeforestation.jpg", "Solar Panel"));
        events.add(new Events("Japan has just been hit by a tsunami which unfortunately caused a nuclear reactor meltdown. This meltdown has caused a nuclear cloud being released into the sky blocking your solar panel. This will result in a decrease in green energy",1.4, "original.jpg", "Solar Panel"));
        events.add(new Events("A volcano on South Africa has erupted. Which has resulted in a big cloud of ash limiting the use of your solar panels. Your green energy will therefore decrease", 1.4, "Volcano.jpg", "Solar Panel"));
        events.add(new Events("There has just been an earthquake in Nepal. Your geothermal power plants in south asia have been damaged, this will result in a decrease in green energy", 1.3, "NepalEarthquake.jpg", "Geo Powerplant"));
        events.add(new Events("The river Nile in Egypt has been flooded, and your hydropower plants have been damaged. This will cause an increase of fossil energy", 1.5, "NileFlooding.jpg", "Hydro Powerplant" ));
        events.add(new Events("A super typhoon hit Australia and your solar panels are damaged. This is causing green energy levels to decrease.", 1.6, "PhilippinesTyphoon.jpg", "Solar Panel"));
        events.add(new Events("A complete breakdown of the energy infrastructure in Scandinavia has resulted in a severe decrease of their windmill energy output. This will undoubtedly affect the forecast and energy balance", 1.6, "ScandinaviaBreakdown.jpg", "Windmill"));
        events.add(new Events("A small undetonated nuclear bomb has randomly detonated in North America, resulting in all geothermal power plants becoming defect. This has caused a significant negative effect in the energybalance and forecast", 1.7, "NuclearBombNorthAmerica.jpeg", "Geothermal Powerplant"));

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
        if (i >= events.size()) i=0; Collections.shuffle(events);
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

    public void takeQuiz(){}

    Pair<String, String> descriptionAndImage;

    /* public Pair<String, String> getDescriptionAndImage() {
        return descriptionAndImage;
    }

    public void setDescriptionAndImage(Pair<String, String>) {
        this.descriptionAndImage = descriptionAndImage;
    }
     */
    @Override
    public Pair<String, String> getEventDescription(Forecast forecast, Game game) {
        if (i >= events.size()) i=0;
        forecast.increase(events.get(i).impact);
        String description = events.get(i).description;
        String fileName = events.get(i).fileName;

        String energySourceDestroyed = events.get(i).energySourceDestroyed;
        for (Map.Entry<String, List<Position>> entry : CountryController.positions.entrySet()){
            List<Position> newPositions = entry.getValue().stream().filter(position -> !position.getEnergySource().getName().equals(energySourceDestroyed)).collect(Collectors.toList());
            entry.setValue(newPositions);
        }
        if (energySourceDestroyed.equals("Solar Panel")){
            for (Room room : game.getCreatedRooms()) {
                room.removeSolarPanel();
                room.updateOutput();
            }
        } else if (energySourceDestroyed.equals("Windmill")){
            for (Room room : game.getCreatedRooms()) {
                room.removeWindmill();
                room.updateOutput();

            }
        } else if (energySourceDestroyed.equals("Hydro Powerplant")){
            for (Room room : game.getCreatedRooms()) {
                room.removeHydroPowerplant();
                room.updateOutput();
            }
        } else if (energySourceDestroyed.equals("Geo Powerplant")){
            for (Room room : game.getCreatedRooms()) {
                room.removeGeothermalPowerplant();
                room.updateOutput();
            }
        }
        descriptionAndImage = new Pair<>(description, fileName);
        i++;
        return descriptionAndImage;

    }
}

