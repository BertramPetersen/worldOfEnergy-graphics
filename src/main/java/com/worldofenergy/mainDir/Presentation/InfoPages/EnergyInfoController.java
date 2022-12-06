package com.worldofenergy.mainDir.Presentation.InfoPages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EnergyInfoController implements Initializable {

    private String energyType;
    private final String windMillDesc = "Windmill, a device for tapping the energy of the wind by means of sails mounted on a rotating shaft. The sails are mounted at an angle or are given a slight twist so that the force of wind against them is divided into two components, one of which, in the plane of the sails, imparts rotation.";
    private final String windMillHow = "Wind turbines work on a simple principle: instead of using electricity to make wind, like a fan, wind turbines use wind to make electricity. Wind turns the propeller-like blades of a turbine around a rotor, which spins a generator, which creates electricity.";
    private final String windMillWhere = "place where there is a lot of wind";

    private final String solarDesc = "Solar panels are those devices which are used to absorb the sun's rays and convert them into electricity";
    private final String solarHow = "When the sun shines onto a solar panel, energy from the sunlight is absorbed by the PV cells in the panel. This energy creates electrical charges that move in response to an internal electrical field in the cell, causing electricity to flow";
    private final String solarWhere = "place where there is a lot of sunlight";

    private final String hydroDesc = "At hydropower plants water flows through a pipe, or penstock, then pushes against and turns blades in a turbine to spin a generator to produce electricity. Conventional hydroelectric facilities include: Run-of-the-river systems, where the force of the river's current applies pressure on a turbine.";
    private final String hydroHow = "A conventional dam holds water in a man-made lake, or reservoir, behind it. When water is released through the dam, it spins a turbine connected to a generator that produces electricity. The water returns to the river on the downstream side of the dam";
    private final String hydroWhere = "place where there is whater flow";

    private final String geoDesc = "Geothermal power plants use steam to produce electricity. The steam comes from reservoirs of hot water found a few miles or more below the earth's surface. The steam rotates a turbine that activates a generator, which produces electricity.";
    private final String geoHow = "To tap into this stable underground temperature, a geothermal system uses a loop of pipes buried in the ground. A solution of water and an environmentally safe antifreeze is pumped through this loop of pipes. This ground loop forms a large heat exchanger that is used by the geothermal system to heat and cool your home.";
    private final String geoWhere = "place where the soil is hot";

    private final String[] windMillHelp = { windMillDesc, windMillHow, windMillWhere };
    private final String[] SolarPanelHelp = { solarDesc, solarHow, solarWhere };
    private final String[] HydroPowerHelp = { hydroDesc, hydroHow, hydroWhere };
    private final String[] GeoPowerHelp = { geoDesc, geoHow, geoWhere };

    @FXML
    private Label title;
    @FXML
    private Label description;

    @FXML
    private Label howItWorks;
    @FXML
    private Label whereToPlace;
    public EnergyInfoController(String energyType){
        this.energyType = energyType;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText(energyType);
        if (energyType.equalsIgnoreCase("Windmill")){
            setInfo(windMillHelp);
        } else if(energyType.equalsIgnoreCase("Solar Panel")){
            setInfo(SolarPanelHelp);
        } else if(energyType.equalsIgnoreCase("Hydro Power")){
            setInfo(HydroPowerHelp);
        } else {
            setInfo(GeoPowerHelp);
        }
    }

    private void setInfo(String[] info) {
        description.setText(info[0]);
        howItWorks.setText(info[1]);
        whereToPlace.setText(info[2]);
    }
}
