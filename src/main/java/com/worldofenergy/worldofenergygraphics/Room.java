package com.worldofenergy.worldofenergygraphics;

import java.util.ArrayList;
import java.util.HashMap;

public class Room implements EnergySourceConstructor {
    int windPot, sunPot, waterPot, geoPot;
    String name;

    ArrayList<EnergySource> builtEnergySource = new ArrayList<>();
    private HashMap<String, Room> exits = new HashMap<>();

    double realPowerOutput;
    int accumulativePassiveIncome;

    public Room(String name, int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
        this.name = name;
        this.realPowerOutput = 0;
    }

    public Room() {
        this.name = "Airport";
    }

    public int getWindPot() {
        return windPot;
    }

    public int getSunPot() {
        return sunPot;
    }

    public int getWaterPot() {
        return waterPot;
    }

    public int getGeoPot() {
        return geoPot;
    }

    public String getName() {
        return name;
    }

    public void setExit(String neighborName, Room neighbor) {
        exits.put(neighborName, neighbor);
    }

    public Room getExit(String destination) {
        return this.exits.get(destination);
    }

    public ArrayList<EnergySource> getBuiltEnergySource() {
        return builtEnergySource;
    }

    // constructEnergy checks which energySource the player wants to build
    // and calls the method that constructs that energySource
    public boolean constructEnergy(String type){
        if (type.equalsIgnoreCase("Windmill")){
            return constructWind();
        }else if (type.equalsIgnoreCase("Hydro Powerplant")){
            return constructHydro();
        }else if (type.equalsIgnoreCase("Solar Panel")){
            return constructSolar();
        }else if (type.equalsIgnoreCase("Geo Powerplant")) {
            return constructGeoTherm();
        }
        System.out.println("I'm not sure what you mean. Did you type a valid Power Source to build?");
        System.out.println("You can build any of these energy sources: ");
        for (int i = 0; i < 2; i++) {
            System.out.printf("%-16s %s\n", types[i], types[i + 1]);
        }
        return false; // Returns false to confirm that no energy source has been built
    }
    public boolean constructWind() {
        WindMill windMill = (WindMill) EnergySourceConstructor.constructWind();
        if (ValidateFunds(windMill)) {
            builtEnergySource.add(windMill);
            updateOutput();
            EnergySourceConstructor.printWindmill();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of WindMill");
            return false; // returns false to tell that player has insufficient funds
        }

    }

    public boolean constructHydro() {
        HydroPowerplant source = (HydroPowerplant) EnergySourceConstructor.constructHydro();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printWaterPump();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Hydro Powerplant");
            return false; // returns false to tell that player has insufficient funds
        }


    }

    public boolean constructSolar() {
        SolarPanel source = (SolarPanel) EnergySourceConstructor.constructSolar();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printSolarPanel();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Solar Panel");
            return false; // returns false to tell that player has insufficient funds
        }
    }

    public boolean constructGeoTherm() {
        GeothermalPowerplant source = (GeothermalPowerplant) EnergySourceConstructor.constructGeo();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            EnergySourceConstructor.printGeoThermal();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Geothermal Power Plant");
            return false; // returns false to tell that player has insufficient funds
        }
    }

    @Override
    public boolean ValidateFunds(EnergySource e) {
        if (Wallet.getCoins() >= e.getPrice()) {
            Wallet.subtractCoins(e.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void updateOutput() {
        this.realPowerOutput = 0;
        for (EnergySource source : builtEnergySource) {
            if (source instanceof WindMill) {
                this.realPowerOutput += source.output * this.windPot;
            } else if (source instanceof HydroPowerplant) {
                this.realPowerOutput += source.output * this.waterPot;
            } else if (source instanceof SolarPanel) {
                this.realPowerOutput += source.output * this.sunPot;
            } else if (source instanceof GeothermalPowerplant) {
                this.realPowerOutput += source.output * this.geoPot;
            }
        }
    }
    public void PassiveIncome() { // Generates a passive income from the energy sources built by the player
        this.accumulativePassiveIncome = 0;
        for (EnergySource source : builtEnergySource)
            if (source instanceof WindMill) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof HydroPowerplant) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof SolarPanel) {
                this.accumulativePassiveIncome += source.passiveIncome;
            } else if (source instanceof GeothermalPowerplant) {
                this.accumulativePassiveIncome += source.passiveIncome;

        }
        Wallet.addCoins(accumulativePassiveIncome);
    }

    public double getRealPowerOutput() {
        return this.realPowerOutput;
    }


    public void getLongDescription() {
        System.out.printf("Welcome to %s\n",this.name);
        System.out.printf("%-44s %s\n","This room has potential for: ", " This room currently have:");
        System.out.printf("%-40s %-4s %s %d \n", "Potential for wind energy: "+ this.windPot, "|", "Windmills: ",getWindmillCount());
        System.out.printf("%-40s %-4s %s %d \n","Potential for Geothermal energy: "+ this.geoPot, "|", "Geothermal powerplants: ",getGeoplantCount());
        System.out.printf("%-40s %-4s %s %d \n","Potential for Solar energy: " +this.sunPot, "|", "Solar Panels: ",getSolarPanelCount());
        System.out.printf("%-40s %-4s %s %d \n", "Potential for Hydropowered energy: "+ this.waterPot, "|", "Hydro powerplants: ",getWaterplantCount());
        System.out.println();
        System.out.println("You currently have " + Wallet.getCoins() + " in your wallet. To build type \"build\" + either:");
        System.out.println("Windmill\n" +
                "Geo Powerplant\n" +
                "Solar Panel\n" +
                "Hydro Powerplant");
    }

    public int getWindmillCount() {
        int windMillCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof WindMill) {
                windMillCounter++;
            }
        }
        return windMillCounter;
    }

    public int getGeoplantCount() {
        int GeoplantConter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof GeothermalPowerplant) {
                GeoplantConter++;
            }
        }
        return GeoplantConter;
    }


    public int getSolarPanelCount() {
        int solarPanelCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof SolarPanel) {
                solarPanelCounter++;
            }
        }
        return solarPanelCounter;
    }

    public int getWaterplantCount() {
        int WaterplantCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof HydroPowerplant) {
                WaterplantCounter++;
            }
        }
        return WaterplantCounter;
    }

}