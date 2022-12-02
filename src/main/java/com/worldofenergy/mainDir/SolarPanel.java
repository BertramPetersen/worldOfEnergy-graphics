package com.worldofenergy.mainDir;
/**
 * The SolarPanel class extends the abstract class {@link EnergySource}. The class utilizes EnergySource's variables by using the "super" keyword.
 */
public class SolarPanel extends EnergySource {
    /**
     * The solar panel is one of the four energy sources of the game. The solar panel is a low tier energy source.
     * It is cheap in terms of {@link #price} (50 coins), but it also does not generate a significant energy {@link #output} (0.4) or {@link #passiveIncome} (20).
     */
    public SolarPanel() {
        super.price = 50;
        super.output = 0.2;
        super.name = "Solar Panel";
        super.passiveIncome = 20;
    }
}
