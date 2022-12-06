package com.worldofenergy.mainDir;

import javafx.scene.paint.Color;
import javafx.util.Pair;

/**
 * EnergySource is an abstract class. It is therefore not able to create objects. The objects are created by the subclasses: {@link WindMill}, {@link SolarPanel}, {@link HydroPowerplant} and {@link GeothermalPowerplant}.
 */
public abstract class EnergySource {
    /**
     * The price of the energy source. E.g. 50 coins
     */
    int price;
    /**
     * The power output of the energy source. Between 0 and 1 where 1 is the highest. E.g. 0.4
     */
    double output;
    /**
     * The name of the energy source. E.g. "Windmill"
     */
    String name;
    /**
     * The passive income generated by the energy source. Sat at (price/2) - 30. E.g. 40 coins
     */
    int passiveIncome; // Passive income from built energy sources

    Pair<Color, Color> colorStrokePair;
    public Pair<Color, Color> getColorStrokePair() {
        return colorStrokePair;
    }

    /**
     * Getter method that returns the price of the energy source. E.g. WindMill.getPrice() returns the price of a windmill
     * @return the price of the energy source
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Getter method that returns the name of the energy source. E.g. WindMill.getName() returns the name of a windmill
     * @return the name of the energy source
     */
    public String getName() {
        return name;
    }

    //    abstract void upgradeOutput();
}
