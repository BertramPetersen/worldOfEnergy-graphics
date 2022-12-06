package com.worldofenergy.mainDir;

import javafx.scene.paint.Color;
import javafx.util.Pair;

/**
 * The WindMill class extends the abstract class {@link EnergySource}. The class utilizes EnergySource's variables by using the "super" keyword.
 */
public class WindMill extends EnergySource {
    /**
     * The windmill is one of the four energy sources of the game. The windmill is a medium low tier energy source.
     * It is mediocre in terms of {@link #price} (100 coins), but it also does not generate a significant energy {@link #output} (0.4) or {@link #passiveIncome} (40).
     */
    public WindMill() {
        super.price = 100;
        super.output = 0.4;
        super.name = "Windmill";
        super.passiveIncome = 20;
        super.colorStrokePair = new Pair<>(new Color(1,1,1,1), Color.BLACK);
    }
}