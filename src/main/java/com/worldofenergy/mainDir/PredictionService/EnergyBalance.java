package com.worldofenergy.mainDir.PredictionService;

import com.worldofenergy.mainDir.util.Colors;

public class EnergyBalance implements PredictionService {
    protected double greenEnergy = 0;
    protected final double totalEnergy = 1125;
    protected double fossilEnergy =  totalEnergy - greenEnergy;
    protected double greenPercent;
    protected double fossilPercent;
    public void UpdateGreenEnergy(double greenEnergy) {

        this.greenEnergy = greenEnergy;
        this.fossilEnergy = totalEnergy - greenEnergy;
    }
    public void updatePercentage() {
        greenPercent = (greenEnergy / totalEnergy) * 100;
        fossilPercent = 100 - greenPercent;
    }
    public void show(){
        updatePercentage();
        System.out.printf("The Energy balance (Green/Fossil) is: %.2f / %.2f\n", greenPercent, fossilPercent);
        System.out.print("["+ Colors.GREEN);
        for (int i = 0; i <= (int) greenPercent; i++) {
            System.out.print("|");
        }
        for (int i = 0; i < (100 - (int) greenPercent); i++) {
            System.out.print(Colors.RED+"|");
        }
        System.out.print(Colors.RESET+"]\n");
        System.out.println("Press Enter to continue");


    }
    public double getGreenEnergy() {
        return greenEnergy;
    }
    public double getFossilEnergy() {
        return fossilEnergy;
    }
    public double getTotalEnergy() {
        return totalEnergy;
    }

    @Override
    public double getGreenPercent() {
        return greenPercent;
    }

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
    public double getCO2() {
        return 0;
    }

    @Override
    public double getSeaLevel() {
        return 0;
    }
}



