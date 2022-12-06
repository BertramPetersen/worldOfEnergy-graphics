package com.worldofenergy.mainDir.PredictionService;

/**
 * The PredictionService interface is used to group related methods of {@link EnergyBalance} and {@link Forecast}.
 * This interface serves as a security measure to hide certain details from {@link EnergyBalance} and {@link Forecast} and only show the important details.
 *
 * @see EnergyBalance
 * @see Forecast
 */
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
