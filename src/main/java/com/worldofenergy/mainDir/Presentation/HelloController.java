package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    DataService game = new Game();
    @FXML
    private Label welcomeText;
    @FXML
    private Label co2Forecast;
    @FXML
    private Label tempForecast;
    @FXML
    private Label seaForecast;

    @FXML
    private Label coins;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coins.setText(""+game.getCoins()+" Coins");
        co2Forecast.setText("CO2 increase: "+game.getCO2()+" Tonnes");
        tempForecast.setText("Temperature: "+game.getTemp()+" degrees");
        seaForecast.setText("Sea Level: "+game.getSea()+" cm");
    }
}