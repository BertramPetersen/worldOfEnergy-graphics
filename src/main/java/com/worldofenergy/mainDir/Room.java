package com.worldofenergy.mainDir;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class, Room, implements the interface {@link EnergySourceConstructor}, by which it implements multiple methods.
 * The class consists of all the logic behind the room or "regions" as they are called in the game.
 * <p>
 * This class' main purpose is to create the requirements/variables needed to be able to create the rooms/"Regions" and navigate between them.
 * The class also contains the logic behind how you build energy sources in a room. As well as how the energy sources affect the energy balance, forecast, and wallet.
 * It also holds all the built energy sources in an {@link EnergySource} ArrayList.
 * </p>
 * <p>
 * The rooms/"regions" are generated/instantiated in the {@link Game} class.
 * </p>
 *
 * @see EnergySourceConstructor
 * @see EnergySource
 * @see Game
 */
public class Room implements EnergySourceConstructor {
    /**
     * The energy potential of a room. Must be between 0 and 100. E.g. 80.
     * Used in the {@link Room} constructor
     */
    private int windPot, sunPot, waterPot, geoPot;
    /**
     * The name of a room. E.g. Southern America. Used in the {@link Room} constructor
     */
    private String name;
    /**
     * An Arraylist of the abstract class {@link EnergySource}. Each built energy source is added to the builtEnergySource ArrayList.
     */
    private ArrayList<EnergySource> builtEnergySource = new ArrayList<>();
    /**
     * Determines how the player can move between room in the game by setting each room's possible exits.
     */
    private final HashMap<String, Room> exits = new HashMap<>();
    /**
     * The total amount of green energy generated by all the energy sources built.
     */
    private double totalGreenPowerOutput;
    /**
     * The total amount of passive income generated by all the energy sources built.
     */
    private int accumulativePassiveIncome;

    /**
     * Constructor that sets the {@link #totalGreenPowerOutput} to 0 and enables the creation of rooms. E.g. "Asia, 40, 30, 80, 20"
     *
     * @param name     name of the room
     * @param windPot  wind potential of the room
     * @param sunPot   solar potential of the room
     * @param waterPot hydro potential of the room
     * @param geoPot   geothermal potential of the room
     */
    public Room(String name, int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
        this.name = name;
        this.totalGreenPowerOutput = 0;
    }

    /**
     * Creates a room called "Airport". Airport is the game's default room therefore it does not have energy potential.
     */
    public Room() {
        this.name = "Airport";
    }

    /**
     * @return the room's wind potential
     */
    public int getWindPot() {
        return windPot;
    }

    /**
     * @return the room's solar potential
     */
    public int getSunPot() {
        return sunPot;
    }

    /**
     * @return the room's hydro potential
     */
    public int getWaterPot() {
        return waterPot;
    }

    /**
     * @return the room's geothermal potential
     */
    public int getGeoPot() {
        return geoPot;
    }

    /**
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the exits for a room. Thereby restricting free flowing movement for the player.
     *
     * @param neighborName the string name of the neighboring room. E.g. "Southern Europe"
     * @param neighbor     the instance name of the neighboring room. E.g. southernEurope
     */
    public void setExit(String neighborName, Room neighbor) {
        exits.put(neighborName, neighbor);
    }

    /**
     * Used in the Game class to determine if the player is travelling to a valid room.
     * <p>
     * This method indirectly checks if the player's destination room is valid. It does this by trying the destination as an exit for
     * the current room. If the current room has the destination as an exit it returns the destination else it returns null.
     * </p>
     * E.g. If the player wants to travel "Southern America" -> "Asia". "Asia" is the String parameter destination. The method then returns "Asia" if the
     * current room has "Asia" as an exit else it returns null.
     *
     * @param destination the room the player want to travel to. E.g. "Asia"
     * @return the new destination room e.g. "Asia". Returns null if destination room isn't a valid room.
     */
    public Room getExit(String destination) {
        return this.exits.get(destination);
    }

    /**
     * IS NEVER USED SHOULD POSSIBLY BE DELETED
     *
     * @return the ArrayList {@link #builtEnergySource}
     */
    // public ArrayList<EnergySource> getBuiltEnergySource() {
    //  return builtEnergySource;
    //}

    /**
     * Boolean method that checks if player's input is equal to one of the possible energy sources. If the input is equal to an energy source
     * it returns a methods that construct that energy source if the player has available funds. Should the player input not equal an energy source,
     * then the method instructs the player about the 4 available energy sources. It simultaneously returns the boolean method false, confirming no
     * energy source has been built.
     *
     * @param type the {@link EnergySource}. E.g. "Windmill"
     * @return method that constructs energy source if player has available funds
     * @see #constructHydro()
     * @see #constructGeoTherm()
     * @see #constructSolar()
     * @see #constructWind()
     */
    public boolean constructEnergy(String type) {
        if (type.equalsIgnoreCase("Windmill")) {
            return constructWind();
        } else if (type.equalsIgnoreCase("Hydro Power")) {
            return constructHydro();
        } else if (type.equalsIgnoreCase("Solar Panel")) {
            return constructSolar();
        } else if (type.equalsIgnoreCase("Geo Power")) {
            return constructGeoTherm();
        }
        System.out.println("I'm not sure what you mean. Did you type a valid energy source to build?");
        System.out.println("You can build any of these energy sources: ");
        for (int i = 0; i < 2; i++) {
            System.out.printf("%-16s %s\n", types[i], types[i + 1]);
        }
        return false; // Returns false to confirm that no energy source has been built
    }

    /**
     * This boolean method creates a new instance of {@link WindMill} using the {@link EnergySourceConstructor} interface.
     * It then checks if the player has the available funds for constructing a windmill. If so, it adds the new instance of windmill to the
     * {@link #builtEnergySource} ArrayList, updates the energy output, prints an ASCII windmill and returns true. If no available funds, tells the player this
     * and returns false.
     *
     * @return true if the player has available funds for construction of a windmill else returns false
     */
    public boolean constructWind() {
        WindMill windMill = (WindMill) EnergySourceConstructor.constructWind();
        if (ValidateFunds(windMill)) {
            builtEnergySource.add(windMill);
            updateOutput();
            EnergySourceConstructor.printWindmill();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of WindMill");
            return false; // returns false to tell that player has insufficient funds
        }

    }

    /**
     * This boolean method creates a new instance of {@link HydroPowerplant} using the {@link EnergySourceConstructor} interface.
     * It then checks if the player has the available funds for constructing a hydropower plant. If so, it adds the new instance of hydropower plant to the
     * {@link #builtEnergySource} ArrayList, updates the energy output, prints an ASCII hydropower plant and returns true. If no available funds, tells the player this
     * and returns false.
     *
     * @return true if the player has available funds for construction of a hydropower plant else returns false
     */
    public boolean constructHydro() {
        HydroPowerplant source = (HydroPowerplant) EnergySourceConstructor.constructHydro();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printWaterPump();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Hydro Powerplant");
            return false;
        }
    }

    /**
     * This boolean method creates a new instance of {@link SolarPanel} using the {@link EnergySourceConstructor} interface.
     * It then checks if the player has the available funds for constructing a solar panel. If so, it adds the new instance of solar panel to the
     * {@link #builtEnergySource} ArrayList, updates the energy output, prints an ASCII solar panel and returns true. If no available funds, tells the player this
     * and returns false.
     *
     * @return true if the player has available funds for construction of a solar panel else returns false
     */
    public boolean constructSolar() {
        SolarPanel source = (SolarPanel) EnergySourceConstructor.constructSolar();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printSolarPanel();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Solar Panel");
            return false;
        }
    }

    /**
     * This boolean method creates a new instance of {@link GeothermalPowerplant} using the {@link EnergySourceConstructor} interface.
     * It then checks if the player has the available funds for constructing a geothermal power plant. If so, it adds the new instance of geothermal power plant to the
     * {@link #builtEnergySource} ArrayList, updates the energy output, prints an ASCII geothermal power plant and returns true. If no available funds, tells the player this
     * and returns false.
     *
     * @return true if the player has available funds for construction of a geothermal power plant else returns false
     */
    public boolean constructGeoTherm() {
        GeothermalPowerplant source = (GeothermalPowerplant) EnergySourceConstructor.constructGeo();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printGeoThermal();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Geothermal Power Plant");
            return false;
        }
    }

    /**
     * Boolean method that checks if the player has available funds for purchase of energy source.
     *
     * @param e the energy source. E.g. WindMill
     * @return true if player has enough fund to buy the energy source, false if the player does not.
     */
    @Override
    public boolean ValidateFunds(EnergySource e) {
        if (Wallet.getCoins() >= e.getPrice()) {
            Wallet.subtractCoins(e.getPrice());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the total power output of all the energy sources combined.
     * <p>
     * This method sets the {@link #totalGreenPowerOutput} equal to 0. It then loops through every instance of {@link EnergySource} in the {@link #builtEnergySource} ArrayList.
     * For every instance it multiplies the energy source's output with the room's potential energy (E.g. for every windmill built in the room: 0.4 * 67).
     * It then adds the result to {@link #totalGreenPowerOutput}
     * </p>
     *
     * @see #PassiveIncome()
     */
    public void updateOutput() {
        this.totalGreenPowerOutput = 0;
        for (EnergySource source : builtEnergySource) {
            if (source instanceof WindMill) {
                this.totalGreenPowerOutput += source.output * this.windPot;
            } else if (source instanceof HydroPowerplant) {
                this.totalGreenPowerOutput += source.output * this.waterPot;
            } else if (source instanceof SolarPanel) {
                this.totalGreenPowerOutput += source.output * this.sunPot;
            } else if (source instanceof GeothermalPowerplant) {
                this.totalGreenPowerOutput += source.output * this.geoPot;
            }
        }
    }

    /**
     * Generates a passive income from the energy sources built by the player
     * <p>
     * This method sets the {@link #accumulativePassiveIncome} equal to 0. It then loops through every instance of {@link EnergySource} in the {@link #builtEnergySource} ArrayList.
     * For every instance it adds the energy source's passive income (eg. 40 coins) to {@link #accumulativePassiveIncome}.
     * </p>
     *
     * @see #updateOutput()
     */
    public void PassiveIncome() { // Generates a passive income from the energy sources built by the player
        this.accumulativePassiveIncome = 0;
        for (EnergySource source : builtEnergySource)
            if (source instanceof WindMill) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof HydroPowerplant) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof SolarPanel) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof GeothermalPowerplant) {
                this.accumulativePassiveIncome += source.passiveIncome;

            }
        Wallet.addCoins(accumulativePassiveIncome);
    }

    /**
     * @return the total green power output for the room
     */
    public double getTotalGreenPowerOutput() {
        return this.totalGreenPowerOutput;
    }


    /**
     * Displays a description of the room. Tells the player the energy source potential as well as how many of each energy has been built.
     * <p>
     * This method is called everytime the player enters a new room.
     * </p>
     */
    public void getLongDescription() {
        System.out.printf("Welcome to %s\n", this.name);
        System.out.printf("%-44s %s\n", "This room has potential for: ", " This room currently have:");
        System.out.printf("%-40s %-4s %s %d \n", "Potential for wind energy: " + this.windPot, "|", "Windmills: ", getWindmillCount());
        System.out.printf("%-40s %-4s %s %d \n", "Potential for Geothermal energy: " + this.geoPot, "|", "Geothermal powerplants: ", getGeoplantCount());
        System.out.printf("%-40s %-4s %s %d \n", "Potential for Solar energy: " + this.sunPot, "|", "Solar Panels: ", getSolarPanelCount());
        System.out.printf("%-40s %-4s %s %d \n", "Potential for Hydropowered energy: " + this.waterPot, "|", "Hydro powerplants: ", getWaterplantCount());
        System.out.println();
        System.out.println("You currently have " + Wallet.getCoins() + " in your wallet. To build type \"build\" + either:");
        System.out.println("""
                Windmill
                Geo Powerplant
                Solar Panel
                Hydro Powerplant""");
    }

    /**
     * Sets the windMillCounter to 0. Then adds every 1 to the counter for every instance of {@link WindMill}.
     *
     * @return the amount of windmills in the room
     */
    public int getWindmillCount() {
        int windMillCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof WindMill) {
                windMillCounter++;
            }
        }
        return windMillCounter;
    }

    /**
     * Sets the geoPlantCounter to 0. Then adds every 1 to the counter for every instance of {@link GeothermalPowerplant}.
     *
     * @return the amount geothermal power plants in the room
     */
    public int getGeoplantCount() {
        int geoPlantCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof GeothermalPowerplant) {
                geoPlantCounter++;
            }
        }
        return geoPlantCounter;
    }

    /**
     * Sets the solarPanelCounter to 0. Then adds every 1 to the counter for every instance of {@link SolarPanel}.
     *
     * @return the amount of solar panels in the room
     */
    public int getSolarPanelCount() {
        int solarPanelCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof SolarPanel) {
                solarPanelCounter++;
            }
        }
        return solarPanelCounter;
    }

    /**
     * Sets the WaterPlantCounter to 0. Then adds every 1 to the counter for every instance of {@link HydroPowerplant}.
     *
     * @return the amount of hydropower plant in the room
     */
    public int getWaterplantCount() {
        int WaterplantCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof HydroPowerplant) {
                WaterplantCounter++;
            }
        }
        return WaterplantCounter;
    }

}