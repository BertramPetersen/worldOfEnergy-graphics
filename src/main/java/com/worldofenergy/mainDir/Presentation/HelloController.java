package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    DataService game;
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Label co2Forecast;
    @FXML
    private Label tempForecast;
    @FXML
    private Label seaForecast;

    @FXML
    private Label coins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new Game();
        coins.setText(""+game.getCoins()+" Coins");
        co2Forecast.setText("CO2 increase: "+game.getCO2()+" Tonnes");
        tempForecast.setText("Temperature: "+game.getTemp()+" degrees");
        seaForecast.setText("Sea Level: "+game.getSea()+" cm");
    }

    public void enterCountry(ActionEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Button btn = (Button)e.getSource();
        String destination = btn.getText().toUpperCase();
        game.setCurrentRoom(destination);
        HelloApplication.showCountryView(game, stage);

    }

    public void setGame(DataService obj){
        game = obj;
    }
}