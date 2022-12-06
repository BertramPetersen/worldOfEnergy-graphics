package com.worldofenergy.mainDir.DTOs;

public class PForecast {
    double temp, CO2, seaLevel;
    double tempInc, CO2Inc, seaLevelInc;

    public PForecast(double temp, double CO2, double seaLevel, double tempInc, double CO2Inc, double getSeaLevel) {
        this.temp = temp;
        this.CO2 = CO2;
        this.seaLevel = seaLevel;
        this.tempInc = tempInc;
        this.CO2Inc = CO2Inc;
        this.seaLevelInc = getSeaLevel;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getCO2() {
        return CO2;
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getTempInc() {
        return tempInc;
    }

    public void setTempInc(double tempInc) {
        this.tempInc = tempInc;
    }

    public double getCO2Inc() {
        return CO2Inc;
    }

    public void setCO2Inc(double CO2Inc) {
        this.CO2Inc = CO2Inc;
    }

    public double getSeaLevelInc() {
        return seaLevelInc;
    }

    public void setSeaLevelInc(double seaLevelInc) {
        this.seaLevelInc = seaLevelInc;
    }

    public PForecast(){

    }
}
