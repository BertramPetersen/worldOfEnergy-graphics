package com.worldofenergy.mainDir.PredictionService;

public interface PredictionService {


    void show();

    void UpdateGreenEnergy(double greenEnergy);

    void update(EnergyBalance energyBalance);

    int getCurrentYear();

    double getTemperature();

    double getCO2();

    double getSeaLevel();

    double getGreenEnergy();
    double getTotalEnergy();

    double getFossilEnergy();

    double getGreenPercent();
    double getFossilPercent();

    void incrementYear();
}
