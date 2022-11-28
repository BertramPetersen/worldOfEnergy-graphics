package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryController{

    private DataService game;
    private Room room;
    private Stage stage;
    @FXML
    private Label coins;
    @FXML
    private Label sunPot;
    @FXML
    private Label hydroPot;
    @FXML
    private Label windPot;
    @FXML
    private Label geoPot;
    @FXML
    private Label wAmount;
    @FXML
    private Label hAmount;
    @FXML
    private Label sAmount;
    @FXML
    private Label gAmount;



    public void setGame(DataService obj){
        game = obj;
        room = game.getCurrentRoom();

        setPot(room);
        setBuilt(room);
        coins.setText(""+game.getCoins()+" Coins");
    }

    private void setBuilt(Room room) {
        wAmount.setText(""+room.getWindmillCount());
        hAmount.setText(""+room.getWaterplantCount());
        sAmount.setText(""+room.getSolarPanelCount());
        gAmount.setText(""+room.getGeoplantCount());
    }

    private void setPot(Room room){
        windPot.setText("Wind: "+room.getWindPot());
        hydroPot.setText("Hydro: "+room.getWaterPot());
        geoPot.setText("Geo: "+room.getGeoPot());
        sunPot.setText("Sun: "+room.getSunPot());
    }

    public void exitCountry(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        game.setCurrentRoom("AIRPORT");
        HelloApplication.showMainView(game, stage);

    }

    public void buildEnergySource(ActionEvent e){
        Button btn = (Button)e.getSource();
        String energyType = btn.getText();
        EnergySource eType = stringToEnergySource(energyType);
        boolean construct = game.construct(energyType);
        if(construct){
            setBuilt(game.getCurrentRoom());
            coins.setText(""+game.getCoins()+" Coins");
        }
        else if (!room.ValidateFunds(eType)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient funds");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough funds for construction of "+energyType);
            alert.showAndWait();
        }
    }

    public EnergySource stringToEnergySource(String s){
        switch(s){
            case "Windmill": return new WindMill();
            case "Hydro Power": return new HydroPowerplant();
            case "Geo Power": return new GeothermalPowerplant();
            case "Solar Panel": return new SolarPanel();
        }
        return null;
    }
}
