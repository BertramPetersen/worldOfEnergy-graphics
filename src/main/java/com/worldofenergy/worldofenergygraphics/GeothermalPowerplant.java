package com.worldofenergy.worldofenergygraphics;

public class GeothermalPowerplant extends EnergySource {

    public GeothermalPowerplant(){
        super.price = 800;
        super.output = 0.9;
        super.name = "Geo Powerplant";
        super.passiveIncome = 390;
    }
    public int showPrice() {
        return price;
    }
}
