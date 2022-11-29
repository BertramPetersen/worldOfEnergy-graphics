package com.worldofenergy.mainDir;

public class WindMill extends EnergySource {
    public WindMill() {
        super.price = 100;
        super.output = 0.4;
        super.name = "Windmill";
        super.passiveIncome = 40;
    }
}
