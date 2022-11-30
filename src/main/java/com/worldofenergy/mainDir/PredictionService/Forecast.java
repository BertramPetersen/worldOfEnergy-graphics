package com.worldofenergy.mainDir.PredictionService;

import java.time.Year;

public class  Forecast implements PredictionService {

    EnergyBalance energyBalance = new EnergyBalance();
    /**
     * unit cm e.g. 5 cm.
     */
    public double seaLevel = 5;
    /**
     * Unit celsius e.g. 2°C.
     */
    public double temperature = 2;
    /**
     * Unit billion ton e.g. 15 billion ton.
     */
    public double CO2 = 15;
    /**
     * Unit year e.g. 2022
     */
    int currentYear = Year.now().getValue();

    /**
     * @return the current year in the game as an int.
     */
    public int getCurrentYear() {
        return currentYear;
    }

    /**
     * @return the current temperature in the game as a double.
     */
    public double getTemperature() {
        return temperature;
    }
    /**
     * @return the current CO2 concentration in the game as a double.
     */
    public double getCO2() {
        return CO2;
    }

    /**
     * @return the current sea level in the game as a double.
     */
    public double getSeaLevel() {
        return seaLevel;
    }
    /**
     * Increases the forecast ({@link #seaLevel}, {@link #temperature}, {@link #CO2}) then prints what the forecast has increased to.
     * <p>
     * The method takes a parameter {@param increaseFactor}. The value of the argument is then multiplied with forecast variables.
     * The {@param increaseFactor} argument must be between 1 < increaseFactor < ∞. E.g. an argument input of 1.5 is equal to 50% increase in the forecast.
     * </p>
     * @param increaseFactor dictates the amount forecast(Sea level, Temperature, C02) is increased e.g. 1.5
     * @see #decrease
     */
    public void increase(double increaseFactor) {

        seaLevel = seaLevel * increaseFactor;
        temperature = temperature * increaseFactor;
        CO2 = CO2 * increaseFactor;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Current Stats:");
        System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton.");
        System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm.");
        System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103.");
        System.out.println("---------------------------------------------------------------------------------------");
    }
    /**
     * Decreases the forecast ({@link #seaLevel}, {@link #temperature}, {@link #CO2}) then prints what the forecast has decreased to.
     * <p>
     * The method takes a parameter {@param decrease}. The value of the argument is then multiplied with forecast variables.
     * The {@param decrease} argument must be between 0 < decrease < 1. E.g. an argument input of 0.1 is equal to 90% decrease in the forecast.
     * </p>
     * @param decrease dictates by how much forecast(Sea level, Temperature, C02) is decreased e.g. 0.6.
     * @see #increase
     */
    public void decrease(double decrease) {
        seaLevel = seaLevel * decrease;
        temperature = temperature * decrease;
        CO2 = CO2 * decrease;

        System.out.printf("the sea level has decreased to:  %.2f cm.\n", seaLevel);
        System.out.printf("the temperature has decreased to:  %.2f degrees \n", temperature);
        System.out.printf("the CO2 emission has decreased to:  %.2f billion ton \n", CO2);

    }
    /**
     * Prints out a forecast that shows how much the {@link #seaLevel}, {@link #temperature} and {@link #CO2} has increased/decreased, and by how much it will increase/decrease per year.
     * <p>
     * This method is used when a new turn has been initiated. It first progresses a year (e.g. 2022 -> 2023). It then calls the {@link EnergyBalance#updatePercentage()}.
     * The forecast variables increases if fossil energy > green energy. The forecast variables decreases if fossil energy < green energy.
     * The increase and decrease value is determined by respectively {@link EnergyBalance#fossilPercent} and {@link EnergyBalance#greenPercent}.
     * The {@link #seaLevel} increases with 30% of the value of fossilPercent, {@link #temperature} with 20% and {@link #CO2} with 50%.
     * The {@link #seaLevel} decreases with 60% of the value of greenPercent, {@link #temperature} with 40% and {@link #CO2} with 100%.
     * </p>
     * @param energyBalance the instance of EnergyBalance that is to be updated
     * @see EnergyBalance#getGreenEnergy()
     * @see EnergyBalance#getFossilEnergy()
     * @see EnergyBalance#updatePercentage()
     * @see EnergyBalance#getGreenPercent()
     * @see EnergyBalance#getFossilPercent()
     */
    public void update(EnergyBalance energyBalance) {
//        currentYear++;
        energyBalance.updatePercentage();
        if (energyBalance.getGreenEnergy() <= energyBalance.getFossilEnergy()) {
            double increase = energyBalance.getFossilPercent(); // unit  %
            double seaLevelIncrease = (0.3*(increase));
            double temperatureIncrease = (0.2*(increase));
            double C02Increase = (0.5*(increase));
            seaLevel *= (1 + seaLevelIncrease/100);
            temperature *=  (1 + temperatureIncrease/100);
            CO2 *= (1 + C02Increase/100);
//            System.out.println();
//            System.out.println("Oh no! The year is now " + currentYear + " and the world's C02 output is still increasing!");
//            System.out.println("---------------------------------------------------------------------------------------");
//            System.out.println("Current Stats:");
//            System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton. Increase per year " + String.format("%.2f",C02Increase) + "%");
//            System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm. Increase per year " + String.format("%.2f",seaLevelIncrease) + "%");
//            System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103. Increase per year " + String.format("%.2f",temperatureIncrease)+ "%");
//            System.out.println("---------------------------------------------------------------------------------------");

        } else {
            double decrease = energyBalance.getGreenPercent();// unit %
            double seaLevelDecrease = (0.6 *(decrease));
            double temperatureDecrease = (0.4 *(decrease));
            double C02Decrease = (1 * (decrease));

            seaLevel *= (0.6 * decrease/100);
            temperature *= (0.4 * decrease/100);
            CO2 *= (1 * decrease/100);

//            System.out.println();
//            System.out.println("Good job! The year is now " + currentYear + " and the world's C02 output is finally falling");
//            System.out.println("---------------------------------------------------------------------------------------");
//            System.out.println("Current Stats:");
//            System.out.println("The C02 emission has decreased to " + String.format("%.2f",CO2) + ". Decrease per year " + String.format("%.2f",C02Decrease) + "%");
//            System.out.println("The sea level has fallen with " + String.format("%.2f",seaLevel) + ". Decrease per year " + String.format("%.2f",seaLevelDecrease) + "%");
//            System.out.println("The average temperature has fallen to " + String.format("%.2f",temperature) + ". Decrease per year " + String.format("%.2f",temperatureDecrease) + "%");
//            System.out.println("---------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void updateEnergy(double greenEnergy) {

    }
    @Override
    public double getGreenEnergy() {
        return 0;
    }

    @Override
    public double getTotalEnergy() {
        return 0;
    }

    @Override
    public double getFossilEnergy() {
        return 0;
    }

    @Override
    public double getGreenPercent() {
        return energyBalance.greenPercent;
    }

    @Override
    public double getFossilPercent() {
        return energyBalance.fossilPercent;
    }
    @Override
    public void incrementYear(){
        this.currentYear++;
    }
}

