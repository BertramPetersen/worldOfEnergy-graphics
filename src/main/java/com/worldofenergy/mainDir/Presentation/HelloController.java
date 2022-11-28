package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
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
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    DataService game;
    Stage stage;
    @FXML
    private Label co2Forecast;
    @FXML
    private Label tempForecast;
    @FXML
    private Label seaForecast;
    @FXML
    private Label coins;
    @FXML
    private Label balanceLabel;
    @FXML
    private ProgressBar balanceBar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void enterCountry(ActionEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Button btn = (Button)e.getSource();
        String destination = btn.getText().toUpperCase();
        game.setCurrentRoom(destination);
        HelloApplication.showCountryView(game, stage);

    }
    public void init(DataService obj){
        this.game = obj;
        setForecast();
        setCoins();
        setBalance();

    }

    public void setCoins(){
        coins.setText(""+ game.getCoins()+" Coins");
    }
    public void setForecast(){
        co2Forecast.setText("CO2 increase: %.2f Tonnes".formatted(game.getCO2()));
        tempForecast.setText("Temperature: %.2f \u2103 ".formatted(game.getTemp())); // Unicode: degrees celcius
        seaForecast.setText("Sea Level: %.2f cm".formatted(game.getSea()));
    }
    public void setBalance(){
        PredictionService energyBalance = game.getEnergyBalance();
        PredictionService forecast = game.getForecast();
        energyBalance.UpdateGreenEnergy(game.getTotalPowerOutput());
        forecast.update((EnergyBalance) energyBalance);
        String balance = String.format("%.0f%% / %.0f%%",energyBalance.getGreenPercent(), energyBalance.getFossilPercent());
        balanceLabel.setText(balance);
        balanceBar.setProgress(energyBalance.getGreenPercent() / 100);
    }

    public void endTurn(ActionEvent e){
        game.updateTurn();
        setCoins();
    }
}