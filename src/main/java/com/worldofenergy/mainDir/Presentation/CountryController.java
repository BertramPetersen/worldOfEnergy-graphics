package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CountryController {

    private static DataService game;
    @FXML
    private Label coins;
    @FXML
    private static Label sunPot;
    @FXML
    private Label hydroPot;
    @FXML
    private Label windPot;
    @FXML
    private Label geoPot;

    public static void setGame(DataService obj){
        game = obj;
    }

    private static void setSunPot(int pot){
        sunPot.setText("Sun: "+pot);
    }

    public static void load(){
        Room currentRoom = game.getCurrentRoom();
        int sunPot = currentRoom.getSunPot();
        setSunPot(sunPot);

    }
}
