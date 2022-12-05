package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    DataService game;
    Stage stage;
    private final int year = Year.now().getValue();
    private final int endYear = this.year + 20;

    @FXML
    private Label Forecast;
    @FXML
    private Label co2Forecast;
    @FXML
    private Label co2Increase;
    @FXML
    private Label tempForecast;
    @FXML
    private Label tempIncrease;
    @FXML
    private Label seaForecast;
    @FXML
    private Label seaIncrease;
    @FXML
    private Label coins;
    @FXML
    private Label balanceLabel;
    @FXML
    private ProgressBar balanceBar;
    @FXML
    private Label turnCounter;
    @FXML
    private Pane Anchor;

    public HelloController(DataService game, Stage stage){
        this.game = game;
        this.stage = stage;
    }
    public HelloController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setForecast();
        setCoins();
        turnCounter.setText(String.valueOf(20 + (-game.getTurnCount()) + " years"));
        setBalance();

    }


    public void enterCountry(ActionEvent e) throws IOException{
        Button btn = (Button)e.getSource();
        String destination = btn.getText().toUpperCase();
        game.setCurrentRoom(destination);
        HelloApplication.showCountryView(game, stage);

    }
    public void enterCountry1(MouseEvent e) throws IOException{
        SVGPath svg = (SVGPath)e.getSource();
        String destination = svg.getId().toUpperCase();
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
        HelloApplication.ShowRandomEvent(game);
    }
    public void init(DataService obj) throws IOException{
        this.game = obj;
        setForecast();
        setCoins();
        setBalance();
        turnCounter.setText(String.valueOf(20 + (-game.getTurnCount()) + " years"));
        showWelcome();
    }

    public void setCoins() {
        coins.setText("" + game.getCoins() + " Coins");
    }

    public void setForecast() {
        Forecast.setText(""+endYear+" Forecast");
        co2Forecast.setText("Yearly CO2 emission: %.2f Tonnes".formatted(game.getCO2()));
        tempForecast.setText("Temperature: %.2f \u2103 ".formatted(game.getTemp())); // Unicode: degrees celcius
        seaForecast.setText("Sea Level: %.2f cm".formatted(game.getSea()));

        if (!game.isDecreasing()){
            co2Increase.setText("CO2 emissions will increase by %.2f%% each year".formatted(game.getCO2Inc()));
            tempIncrease.setText("CO2 emissions will increase by %.2f%% each year".formatted(game.getTempInc()));
            seaIncrease.setText("Sea levels will increase by %.2f%% each year".formatted(game.getSeaInc()));
        }else{
            co2Increase.setText("CO2 emissions will decrease by %.2f%% each year".formatted(game.getCO2Inc()));
            tempIncrease.setText("Temperatures will decrease by %.2f%% each year".formatted(game.getTempInc()));
            seaIncrease.setText("Sea levels will decrease by %.2f%% each year".formatted(game.getSeaInc()));
        }
    }

    public void setBalance() {
        PredictionService energyBalance = game.getEnergyBalance();
        PredictionService forecast = game.getForecast();
        energyBalance.updateEnergy(game.getTotalPowerOutput());
        forecast.update((EnergyBalance) energyBalance);
        String balance;
        if (energyBalance.getGreenPercent() >= 100 ) {
            balance = "100% / 0%";
        }
            else {
                balance = String.format("%.0f%% / %.0f%%", energyBalance.getGreenPercent(), energyBalance.getFossilPercent());
            }
        balanceLabel.setText(balance);
        balanceBar.setProgress(energyBalance.getGreenPercent() / 100);
    }

    public void endTurn(ActionEvent e) throws IOException, InterruptedException {
        game.getInitRandomEvent();
        if(!winLoseCondition()) {
            game.updateTurn();
            if (game.getTimeToQuiz()) {
                showQuiz();
            } else if (game.getInitRandomEvent()) {
                initRandomEvent();
            }
            game.resetQuizSystem();
            setCoins();
            turnCounter.setText(String.valueOf(20 + (-game.getTurnCount()) + " years"));
            setForecast();
            setBalance();

        }
    }
    public static void showLoseStage() throws IOException {
        Stage loseStage = new Stage();
        loseStage.setTitle("Defeat");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("lose-view.fxml"));
        Scene scene = new Scene(loader.load());
        loseStage.setScene(scene);
        loseStage.showAndWait();

    }
    public static void showWinStage() throws IOException {
        Stage winStage = new Stage();
        winStage.setTitle("Victory");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Win-view.fxml"));
        Scene scene = new Scene(loader.load());
        winStage.setScene(scene);
        winStage.showAndWait();
    }
    public boolean winLoseCondition() throws IOException {
        PredictionService energyBalance = game.getEnergyBalance();
        // if (energy.balance.getGreenPercent() >= 50 {
            // showProgressIndicator()
            // "Keep building you are doing a phenomenal job!
        // if (game.getTurnCount() >= 10) {
            // showHalfwayPoint()
            // You are halfway through the game. Build strategic with your sources, or else you might lose!

        if (energyBalance.getGreenPercent() >= 100) {
            showWinStage();
            return true;
        }
        else if (game.getTurnCount() >= 20 ) {
            showLoseStage();
            return true;
        } else {
            return false;
        }
    }
    public void setHelpButton(ActionEvent e) throws IOException {
        Stage stage1 = new Stage();
        TilePane tilePane = new TilePane();

        Label label = new Label("\n \nTo build " +
                "energy sources, go to one of the areas on the map.\n" +
                "Press the button 'Windmill' or one of the four energy sources you want to build.\n" +
                "You will then be able to build as many sources you want, and see how many different \n" +
                "sources you have built. \n \nClose this window to continue the game.\n");
        // label.setPadding(new Insets(100));
        // Dette kan ikke gøres. Når det implementeres, kan vinduet ikke lukkes ned.
        // Derfor sætter jeg 2 tomme linjer ind.
        Popup popup = new Popup();
        popup.getContent().add(label);

        Scene scene = new Scene(tilePane, 550, 130);
        stage1.setScene(scene);
        if (!popup.isShowing()) {
            stage1.show();
            popup.show(stage1);
        }
    }
}

