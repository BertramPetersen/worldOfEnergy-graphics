package com.worldofenergy.mainDir.PredictionService;

public interface PredictionService {


    void show();

    void updateEnergy(double greenEnergy);

    void update(EnergyBalance energyBalance);

    int getCurrentYear();

    double getTemperature();
    double getTempInc();

    double getCO2();
    double getCO2Inc();

    double getSeaLevel();
    double getSeaInc();

    double getGreenEnergy();
    double getTotalEnergy();

    double getFossilEnergy();

    double getGreenPercent();
    double getFossilPercent();

    void incrementYear();

    boolean isDeacreasing();
}
