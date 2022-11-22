package com.worldofenergy.mainDir;

public abstract class EnergySource {
    int price;
    double output;
    String name;
    int passiveIncome; // Passive income from built energy sources


    public int getPrice(){
        return this.price;
    }

    public String getName() {
        return name;
    }
    //    abstract void upgradeOutput();
}

