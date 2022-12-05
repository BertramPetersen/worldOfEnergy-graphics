package com.worldofenergy.mainDir;

import javafx.scene.paint.Color;
import javafx.util.Pair;

/**
 * The GeothermalPowerplant class extends the abstract class {@link EnergySource}. The class utilizes EnergySource's variables by using the "super" keyword.
 */
public class GeothermalPowerplant extends EnergySource {
    /**
     * The geothermal power-plant is one of the four energy sources of the game. The geothermal power-plant is a high tier energy source.
     * It is expensive in terms of {@link #price} (800 coins), but it also generates a significant energy {@link #output} (0.9) and {@link #passiveIncome} (390).
     */
    public GeothermalPowerplant(){
        super.price = 800;
        super.output = 0.9;
        super.name = "Geo Powerplant";
        super.passiveIncome = 390;
        super.colorStrokePair = new Pair<>(new Color(0.35,0.25,0.1,1), Color.BLACK);
    }
}
