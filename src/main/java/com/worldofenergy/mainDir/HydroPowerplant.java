package com.worldofenergy.mainDir;

import javafx.scene.paint.Color;
import javafx.util.Pair;

/**
 * The HydroPowerplant class extends the abstract class {@link EnergySource}. The class utilizes EnergySource's variables by using the "super" keyword.
 */
public class HydroPowerplant extends EnergySource {
    /**
     * The hydro power-plant is one of the four energy sources of the game. The hydro power-plant is a medium high tier energy source.
     * It is relatively expensive in terms of {@link #price} (300 coins), but it also generates a significant energy {@link #output} (0.6) and {@link #passiveIncome} (140).
     */
    public HydroPowerplant() {
        super.price = 300;
        super.output = 0.6;
        super.name = "Hydro Powerplant";
        super.passiveIncome = 120;
    }
}
