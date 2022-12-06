package com.worldofenergy.mainDir.PredictionService;

import com.worldofenergy.mainDir.util.Colors;

/**
 * The class EnergyBalance implements the interface {@link PredictionService}, by which it implements multiple methods.
 * The class consist of the logic behind the energy balance in the game.
 * It's main purpose is to display the energy balance bar which visualizes the ratio between green and fossil energy.
 *
 * @see PredictionService
 */
public class EnergyBalance implements PredictionService {
    /**
     * Amount of green energy the player has at the beginning. 0 means the world only has fossil energy at the start.
     */
    protected double greenEnergy = 0;
    /**
     * Amount of total energy. Determines the difficulty of the game.
     */
    protected final double totalEnergy = 3000;
    /**
     * Amount of fossil energy. Is determined by the amount of {@link #greenEnergy}.
     */
    protected double fossilEnergy = totalEnergy - greenEnergy;
    /**
     * Amount of {@link #greenEnergy} in percentage relative to {@link #totalEnergy}.
     */
    protected double greenPercent; // Amount of green energy in percentage relative to total energy.
    /**
     * Amount of {@link #fossilEnergy} in percentage. Is equal to "100 - {@link #greenPercent}".
     */
    protected double fossilPercent; // Amount of fossil energy in percentage. Is equal to "100 - greenPercent".

    /**
     * Updates the variables {@link #greenEnergy} and {@link #fossilEnergy}. The greenEnergy argument must be a double between 0 and {@link #totalEnergy}
     * <p>
     * This method updates green and fossil energy simultaneously by equaling the parameter greenEnergy to the variable {@link #greenEnergy},
     * and setting {@link #fossilEnergy} equal to {@link #totalEnergy} - {@link #greenEnergy}.
     * </p>
     *
     * @param greenEnergy a double responsible for updating the greenEnergy variable
     * @see #updatePercentage
     */
    public void updateEnergy(double greenEnergy) {
        this.greenEnergy = greenEnergy;
        this.fossilEnergy = totalEnergy - greenEnergy;
    }

    /**
     * Updates the variables {@link #greenPercent} and {@link #fossilPercent}.
     * <p>
     * This method updates {@link #greenPercent} and {@link #fossilPercent} simultaneously by calculating the amount of {@link #greenEnergy} relative to the {@link #totalEnergy} in percentage,
     * and setting {@link #fossilPercent} equal to 100 - {@link #greenPercent}.
     * This method should generally be called after the {@link #updateEnergy} method
     * </p>
     *
     * @see #updateEnergy
     */
    public void updatePercentage() {
        greenPercent = (greenEnergy / totalEnergy) * 100;
        fossilPercent = 100 - greenPercent;
    }

    /**
     * Prints out the energy balance in the form of a bar. The energy balance visualizes the ratio between green and fossil energy.
     * {@link #greenEnergy} and {@link #fossilEnergy} is represented relative to their percentage of the {@link #totalEnergy}.
     * {@link #greenEnergy} is represented by the color green. {@link #fossilEnergy} is represented by the color red.
     * <p>
     * <p>
     * The method converts {@link #greenPercent} and {@link #fossilPercent} to an int then prints out "|" equal to the green and fossil percentage.
     * E.g. if the {@link #greenPercent} and {@link #fossilPercent} is respectively 67.20% and 32,80%, it would print out 67 green "|" and 33 red "|".
     *
     * </p>
     */
    public void show() {
        updatePercentage();
        System.out.printf("The Energy balance (Green/Fossil) is: %.2f / %.2f\n", greenPercent, fossilPercent);
        System.out.print("[" + Colors.GREEN);
        for (int i = 0; i <= (int) greenPercent; i++) {
            System.out.print("|");
        }
        for (int i = 0; i < (100 - (int) greenPercent); i++) {
            System.out.print(Colors.RED + "|");
        }
        System.out.print(Colors.RESET + "]\n");
        System.out.println("Press Enter to continue");
    }

    /**
     * @return the amount of {@link #greenEnergy} as a double.
     */
    public double getGreenEnergy() {
        return greenEnergy;
    }

    /**
     * @return the amount of {@link #fossilEnergy} as a double.
     */
    public double getFossilEnergy() {
        return fossilEnergy;
    }

    /**
     * @return the percentage of {@link #greenEnergy} as a double.
     */
    @Override
    public double getGreenPercent() {
        return greenPercent;
    }

    @Override
    public boolean isDecreasing() {
        return false;
    }

    /**
     * @return the percentage of {@link #fossilEnergy} as a double.
     */
    @Override
    public double getFossilPercent() {
        return fossilPercent;
    }

    @Override
    public void incrementYear() {
    }

    @Override
    public void update(EnergyBalance energyBalance) {
    }

    @Override
    public int getCurrentYear() {
        return 0;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public double getTempInc() {
        return 0;
    }

    @Override
    public double getCO2() {
        return 0;
    }

    @Override
    public double getCO2Inc() {
        return 0;
    }

    @Override
    public double getSeaLevel() {
        return 0;
    }

    @Override
    public double getSeaInc() {
        return 0;
    }

    @Override
    public void updateIncrease(EnergyBalance energyBalance) {
        
    }
}




