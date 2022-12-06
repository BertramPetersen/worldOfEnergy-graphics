package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.EnergySource;

public class Position {
    private int x,y;
    private EnergySource energySource;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EnergySource getEnergySource() {
        return energySource;
    }

    public Position(int x, int y, EnergySource energySource){
        this.x = x;
        this.y = y;
        this.energySource = energySource;
    }
}
