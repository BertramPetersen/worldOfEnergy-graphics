package com.worldofenergy.mainDir;

import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
import com.worldofenergy.mainDir.PredictionService.Forecast;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import com.worldofenergy.mainDir.QuizSystem.Quiz;
import com.worldofenergy.mainDir.QuizSystem.QuizService;
import com.worldofenergy.mainDir.QuizSystem.RandomEvent;
import com.worldofenergy.mainDir.util.Colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * The class Game implements the interface {@link DataService}, by which it implements multiple methods.
 * The class merges and creates cooperation between many of the classes in the game.
 * It is within the game class the logic that essentially runs the game lie.
 * <p>
 * This class' main purpose is to use the methods and tools created by the other classes to create a functioning game.
 * Within this class is also where many of the necessary classes is instantiated.
 *
 * It also holds all the built energy sources in an {@link EnergySource} ArrayList.
 * </p>
 * <p>
 *     The game class uses {@link Room}, {@link CommandWords}, {@link EnergySource}, {@link QuizService} and {@link PredictionService} interfaces and classes.
 * </p>
 * @see Room
 * @see CommandWords
 * @see EnergySource
 * @see QuizService
 * @see PredictionService
 */
public class Game implements DataService {

    /**
     * Responsible for keeping track of what turn the player is on. Always starts at 0. Increases by 1 every turn.
     */
    int turnCounter;
    /**
     * location is the room the player is currently in.
     */
    private Room location;
    /**
     * All the created rooms in the game.
     */
    ArrayList<Room> createdRooms;
    /**
     * Map responsible for player navigation. Limits the player, so he does not have free movement between every room.
     * E.g. player can go Airport -> Asia, but not Asia -> Southern Europe.
     */
    HashMap<String, Room> roomMap;
    private boolean timeToQuiz;
    private boolean initRandomEvent;
    /**
     * The available commands in the game.
     */
    private CommandWords commands;
    /**
     * Array of the energy sources. Used to list the price of each one in the help menu.
     */
    public EnergySource[] EnergyPrice = {new WindMill(), new HydroPowerplant(), new SolarPanel(), new GeothermalPowerplant()};

    /**
     * Instance of QuizService
     */
    QuizService quiz;
    /**
     * Instance of QuizService
     */
    QuizService randomEvent;
    /**
     * Instance of PredictionService
     */
    PredictionService prediction;
    /**
     * Instance of PredictionService
     */
    PredictionService energyBalance;
    /**
     * Instance of PredictionService
     */
    PredictionService forecast;
    /**
     * Calls our newly instantiated classes and our created variables.
     *
     * <p>
     *  In this constructor we determine the start terms of the game. We set the {@link #turnCounter} equal to 0, give the player 500 coins to start with and
     *  sets the start location to "Airport".
     * </p>
     */
    public Game() {
        this.turnCounter = 0;
        this.timeToQuiz = false;
        createdRooms = new ArrayList<>();
        this.quiz = new Quiz();
        this.commands = new CommandWordsImplementation();
        Wallet.setCoins(500);
        createRooms();
        this.location = roomMap.get("Airport");
        this.randomEvent = new RandomEvent();
        this.energyBalance = new EnergyBalance();
        this.forecast = new Forecast();
        }

    /**
     * Creates all the rooms in the game and simultaneously add them to the {@link #createdRooms} ArrayList and the {@link #roomMap} HashMap. Sets possible exits for each room.
     *
     * <p>
     * This method is responsible for the creation of all the rooms in the game. Each room has a name, windPot, sunPot, waterPot, geoPot. E.g.
     * "Southern Europe", 25, 80, 30, 40.
     * </p>
     * <p>
     * After each room has been created there is 2 loops. The first loop sets all the rooms exits except airport to the room airport.
     * The second loop sets all the other rooms' exit to airport.
     * </p>
     */
    private void createRooms() {
        roomMap = new HashMap<>();
        Room southAfrica = new Room("South Africa",50,70,30,40 );
        createdRooms.add(southAfrica);
        roomMap.put("South Africa", southAfrica);

        Room  NorthAfrica = new Room("North Africa",40,80,20,40 );
        createdRooms.add(NorthAfrica);
        roomMap.put("North Africa", NorthAfrica);

        Room southernEurope = new Room("Southern Europe", 25, 80, 30, 40);
        createdRooms.add(southernEurope);
        roomMap.put("Southern Europe", southernEurope);
        Room centralEurope = new Room("Central Europe", 40, 40, 55, 40);
        createdRooms.add(centralEurope);
        roomMap.put("Central Europe", centralEurope);
        Room easternEurope = new Room("Eastern Europe", 60, 15, 37, 53);
        createdRooms.add(easternEurope);
        roomMap.put("Eastern Europe", easternEurope);
        Room scandinavia = new Room("Scandinavia", 90, 20, 40, 60);
        createdRooms.add(scandinavia);
        roomMap.put("Scandinavia", scandinavia);
        Room asia = new Room("Asia", 67, 56, 40, 20);
        createdRooms.add(asia);
        roomMap.put("Asia", asia);
        Room southAmerica = new Room("South America", 10, 75, 55, 66);
        createdRooms.add(southAmerica);
        roomMap.put("South America", southAmerica);
        Room centralAmerica = new Room("Central America", 20, 78, 5, 68);
        createdRooms.add(centralAmerica);
        roomMap.put("Central America", centralAmerica);
        Room australia = new Room("Australia", 20, 75, 5, 6);
        createdRooms.add(australia);
        roomMap.put("Australia", australia);
        Room airport = new Room();
        createdRooms.add(airport);
        roomMap.put("Airport", airport);


        for (Room room : createdRooms) {
            if (!room.getName().equalsIgnoreCase("airport")) {
                room.setExit("AIRPORT", airport);
            }
        }
        for (Room room : createdRooms) {
            if (!room.getName().equals("Airport")) {
                airport.setExit(room.getName().toUpperCase(), room);
            }
        }
    }

    /**
     * Given a valid command, lets the player travel between rooms
     * <p>
     * This method first checks if the player has typed a room after his 'go to' command. Returning false if the player hasn't.
     * It then checks if the new room is a valid exit for the current room, if not returning false, else
     * setting current location to the new room and returning true.
     * </p>
     * @param command the 'go to' command the player inputs.
     * @return false if player doesn't type destination room or types invalid room, return true if player type valid room
     */
    @Override
    public boolean goRoom(Command command) {
        if (!command.hasCommandValue()) {
            // No destination on command.
            // Can't continue with GO_TO command.
            return false;
        }
        String destination = command.getCommandValue().toUpperCase();
        Room destinationRoom = this.location.getExit(destination);

        if (destinationRoom == null) {
            return false;
        } else {
            this.location = destinationRoom;
            return true;
        }
    }


    /**
     * IS NOT USED SHOULD POSSIBLY BE REMOVED.
     * @return the available commands to the player
     */
    public CommandWords getCommands() {
        return commands;
    }

    // Return Command with String-input given by Parser.
    @Override
    public Command getCommand(String word1, String word2) {
        return new CommandImplementation(commands.getCommand(word1), word2);
    }
    @Override
    public void getRoomDescription() {
        if (this.location.getName().equals("Airport")) {
            System.out.println("You are now at the airport, and can go to any region in World of Energy");
            System.out.println("You can go to any of these destination by typing 'go to' " +
                    "plus any of the below destinations");
            // Prints all rooms except Airport as it is the last index
            for (int i = 0; i < createdRooms.size() - 2; i = i + 2) {
                System.out.printf("%-24s %s\n", createdRooms.get(i).getName(), createdRooms.get(i + 1).getName());
            }
        } else {
            location.getLongDescription();
        }
    }

    @Override
    public List<String> getCommandDescription(){
        System.out.println(this.location.getName());
        return commands.getCommandWords();
    }
    @Override
    public void updateTurn(){
        turnCounter++;
        energyBalance.incrementYear();
        energyBalance.updateEnergy(getTotalPowerOutput());
        forecast.update((EnergyBalance) energyBalance);
        System.out.println();
        updatePassiveIncome();
        energyBalance.show();
//        promptEnterKey();
        switch(playQuizOrRandomEvent()){
            case 1: timeToQuiz = true;
            case -1: initRandomEvent = true;
            default: break;
        }

    }

    /**
     * Updates the passive income of all rooms.
     * <p>
     * This method updates the passive income generated by each room created in the game.
     * </p>
     */
    public void updatePassiveIncome() {
        for (Room room : createdRooms){
            room.PassiveIncome();
        }
    }
    public void playQuizOrRandomEvent1() { // 1. version of play quiz or random event
        double x = Math.random();
        if (turnCounter % 2 == 0) { // takeQuiz is run every other turn
            quiz.takeQuiz();
        }
        else if (x >= 0.7) { // There is a 30% chance of a random event when quiz is not being run
            randomEvent.initiateRandomEvent((Forecast) forecast);
        }
    }
    public int playQuizOrRandomEvent() { // 2. version of play quiz or random event
        double x = Math.random();
        if (x >= 0.8 && turnCounter >= 3) { // RandomEvent has a 20% chance of being run after the 3rd round
            // randomEvent.initiateRandomEvent((Forecast) forecast);
            return -1;
        } else if (x <= 0.7 || turnCounter < 3) { // takeQuiz has a 70% chance of being run. But is always run in the 2 first rounds
            // quiz.takeQuiz();   // This implies to things: 1. Quiz and Random Event cannot happen in the same round. 2. There is a 10% chance neither is run.
            return 1;
        }
        return 0;
    }

    /**
     * @return the accumulative green power generated by each room combined
     * @see Room#updateOutput()
     */
    // Collects PowerOutput for each room in the game. Look at Room.updateOutput()
    public double getTotalPowerOutput() {
        double p = 0;
        for (Room room : createdRooms) {
            p += room.getTotalGreenPowerOutput();
        }
        return p;
    }

    @Override
    public void welcome(){
        System.out.println("Welcome to World of Energy\n" +
                "Press \"ENTER\" to continue...");
        promptEnterKey();
        System.out.println("Do you want an introduction to World of Energy?\n" +
                "Y/N");
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.next().equalsIgnoreCase("n")){
            System.out.println("A turn-based game where you have to save the world from global warming...");
            promptEnterKey();
            System.out.println("Your job is to build sustainable energy sources in different countries around the world, to prevent global warming from escalating...");
            promptEnterKey();
            System.out.println("You can go to different countries and view their potential for different energy sources and build energy sources...");
            promptEnterKey();
            System.out.println("There is 4 energy sources each of which have their own “construction” you can build to take advantage of their respective energy potential:");
            System.out.printf("%-32s %s\n", "Wind = Windmill", "Solar = Solar Panel");
            System.out.printf("%-32s %s\n", "Water = Hydro Powerplant", "Geothermal = Geo Powerplant");
            promptEnterKey();
            System.out.print("The more sustainable energy sources you build, the more favorable the energy balance will become...");
            System.out.println();
            System.out.println("But what is this so called energy balance?");
            promptEnterKey();
            System.out.println("Throughout the game you'll see an energy balance. If the cumulative amount of fossil energy is greater than the cumulative amount of green energy,\n" +
                    "then the sea level, temperature and CO2 levels will rise...");
            promptEnterKey();
            System.out.println("But!");
            promptEnterKey();
            System.out.println("If the cumulative amount of green energy is greater than the cumulative amount of fossil energy, then the sea level, temperature and CO2 levels will decrease...");
            System.out.println();
            System.out.println("So what is the catch you think?");
            promptEnterKey();
            System.out.println("Energy sources cost money to build!");
            promptEnterKey();
            System.out.println("There are different ways to earn money...");
            System.out.println();
            System.out.println("You can build energy source to passively earn you money:");
            System.out.printf("%-32s %s\n", "Windmill = 40 coins", "Solar Panel = 20 coins");
            System.out.printf("%-32s %s\n", "Hydro Power-plant = 140 coins", "Geo Power-plant = 390 coins");
            promptEnterKey();
            System.out.println("You can also earn additional money by correctly answering the quiz questions, which will appear after you have finished your turn.");
            promptEnterKey();
            System.out.println(Colors.GREEN + "Now that you know the premise of the game, you can begin to populate World of Energy with renewable energy sources to tilt the energy balance in your favor.");
            promptEnterKey();
            System.out.println("Hello... The year is " + forecast.getCurrentYear() + ". The C02 emission is currently " + forecast.getCO2() + " billion ton a year...");
            System.out.println("The average temperature has already increased with " + forecast.getTemperature() + "\u2103, and the world's sea level has risen with " + forecast.getSeaLevel() + "cm...");
            promptEnterKey();
            System.out.println("Hurry! Tilt the energy balance towards green energy to stop the stats from increasing further...\n" +
                    "Good luck!" + Colors.RESET);
            promptEnterKey();
            System.out.println();
            getRoomDescription();
        }
    }

    public void promptEnterKey() {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    @Override
    public boolean construct(String type){
        return this.location.constructEnergy(type);
    }
    @Override
    public String whereAmI(){return location.getName();}
    @Override
    public boolean quit(Command command) {
        return !command.hasCommandValue();
    }

    /**
     * IS NEVER USED SHOULD POSSILBY BE DELETED
     * @return all the created rooms in the game
     */
    public ArrayList<Room> getCreatedRooms() {
        return createdRooms;
    }
    @Override
    public void getPrices() {
        System.out.println("Windmills cost:                 " + this.EnergyPrice[0].getPrice());
        System.out.println("Hydro power plants cost:        " + this.EnergyPrice[1].getPrice());
        System.out.println("Solar Panels cost:              " + this.EnergyPrice[2].getPrice());
        System.out.println("Geothermal power plants cost:   " + this.EnergyPrice[3].getPrice());

    }

    @Override
    public int getCoins(){
        return Wallet.getCoins();
    }

    @Override
    public double getTemp(){
        return forecast.getTemperature();
    }
    @Override
    public double getCO2(){
        return forecast.getCO2();
    }
    @Override
    public double getSea(){
        return forecast.getSeaLevel();
    }

    @Override
    public Room getCurrentRoom(){
        return this.location;
    }

    @Override
    public boolean setCurrentRoom(String destination){
        Room destinationRoom = this.location.getExit(destination);

        if (destinationRoom == null) {
            return false;
        } else {
            this.location = destinationRoom;
            return true;
        }
    }

    @Override
    public PredictionService getEnergyBalance(){
        return energyBalance;
    }
    @Override
    public PredictionService getForecast(){
        return forecast;
    }

    @Override
    public EnergySource stringToEnergySource(String s){
        switch(s){
            case "Windmill": return new WindMill();
            case "Hydro Power": return new HydroPowerplant();
            case "Geo Power": return new GeothermalPowerplant();
            case "Solar Panel": return new SolarPanel();
        }
        return null;
    }

    @Override
    public boolean getTimeToQuiz() {
        return timeToQuiz;
    }

    @Override
    public boolean getInitRandomEvent() {
        return initRandomEvent;
    }

    @Override
    public void resetQuizSystem() {
        timeToQuiz = false;
        initRandomEvent = false;
    }

    @Override
    public ArrayList<Object> getQuiz() {
        String question = quiz.getNextQuestion();
        String[] options = quiz.getNextOptions();
        String answer = quiz.getNextAnswer();
        ArrayList<Object> list = new ArrayList<>();
        list.add(question);
        list.add(options);
        list.add(answer);
        quiz.incrementQuiz();
        return list;
    }
    @Override
    public int[] getBuiltEnergy(){
        int[] builtEnergy = new int[4];
        builtEnergy[0] = this.location.getWindmillCount();
        builtEnergy[1] = this.location.getWaterplantCount();
        builtEnergy[2] = this.location.getSolarPanelCount();
        builtEnergy[3] = this.location.getGeoplantCount();
        return builtEnergy;
    }

    @Override
    public int getTurnCount(){
        return turnCounter;
    }
}
