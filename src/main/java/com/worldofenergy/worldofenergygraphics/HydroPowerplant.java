package com.worldofenergy.worldofenergygraphics;

public class HydroPowerplant extends EnergySource {
    public HydroPowerplant() {
        super.price = 300;
        super.output = 0.6;
        super.name = "Hydro Powerplant";
        super.passiveIncome = 140;
    }

    public int showPrice() {
        return price;
    }
}
