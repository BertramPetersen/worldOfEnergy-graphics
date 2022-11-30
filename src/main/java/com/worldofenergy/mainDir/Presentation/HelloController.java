package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

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
    @FXML
    private Label turnCounter;

    public HelloController(DataService game, Stage stage){
        this.game = game;
        this.stage = stage;
    }
    public HelloController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setForecast();
        setCoins();
        setBalance();
    }


    public void enterCountry(ActionEvent e) throws IOException{
        Button btn = (Button)e.getSource();
        String destination = btn.getText().toUpperCase();
        game.setCurrentRoom(destination);
        HelloApplication.showCountryView(game, stage);

    }


    public void showWelcome() throws IOException{
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome to World Of Energy");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("welcome.fxml"));
        Scene scene = new Scene(loader.load());
        welcomeStage.setScene(scene);
        welcomeStage.show();
    }

    public void showQuiz() throws IOException, InterruptedException {
        HelloApplication.showQuiz(this.game);
        setCoins();
    }

    public void initRandomEvent() throws IOException{

    }
    public void init(DataService obj) throws IOException{
        this.game = obj;
        setForecast();
        setCoins();
        setBalance();
        showWelcome();
    }

    public void setCoins() {
        coins.setText("" + game.getCoins() + " Coins");
    }

    public void setForecast() {
        co2Forecast.setText("CO2 increase: %.2f Tonnes".formatted(game.getCO2()));
        tempForecast.setText("Temperature: %.2f \u2103 ".formatted(game.getTemp())); // Unicode: degrees celcius
        seaForecast.setText("Sea Level: %.2f cm".formatted(game.getSea()));
    }

    public void setBalance() {
        PredictionService energyBalance = game.getEnergyBalance();
        PredictionService forecast = game.getForecast();
        energyBalance.updateEnergy(game.getTotalPowerOutput());
        forecast.update((EnergyBalance) energyBalance);
        String balance = String.format("%.0f%% / %.0f%%", energyBalance.getGreenPercent(), energyBalance.getFossilPercent());
        balanceLabel.setText(balance);
        balanceBar.setProgress(energyBalance.getGreenPercent() / 100);
    }

    public void endTurn(ActionEvent e) throws IOException, InterruptedException {
        game.updateTurn();
        if (game.getTimeToQuiz()){
            showQuiz();
        } else if (game.getInitRandomEvent()){
            initRandomEvent();
        }
        game.resetQuizSystem();
        setCoins();
        turnCounter.setText("turn: "+game.getTurnCount());
        setForecast();
    }

    public void setHelpButton(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene1 = new Scene(loader.load());

        Stage stage1 = new Stage();
        TilePane tilePane = new TilePane();

        Label label = new Label("\n \nTo build " +
                "energy sources, go to one of the areas on he map.\n" +
                "Press the button 'Windmill' or one of the four energy sources you want to build.\n" +
                "You will then be able to build as many sources you want, and see how many different \n" +
                "sources you have built. \n \nClose this window to continue the game.\n");
        // label.setPadding(new Insets(100));
        // Dette kan ikke gøres. Når det implementeres, kan vinduet ikke lukkes ned.
        // Derfor sætter jeg 2 tomme linjer ind.
        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.getContent().add(label);

        Scene scene = new Scene(tilePane, 550, 130);
        stage1.setScene(scene);
        if (!popup.isShowing()) {
            stage1.show();
            popup.show(stage1);

        }
    }
}

