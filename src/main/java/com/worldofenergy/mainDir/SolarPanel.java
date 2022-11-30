package com.worldofenergy.mainDir;

public class SolarPanel extends EnergySource {
    public SolarPanel() {
        super.price = 50;
        super.output = 0.2;
        super.name = "Solar Panel";
        super.passiveIncome = 20;
    }
}
