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
public class RandomEventSceneController implements Initializable  {
    @FXML
    private Button buttonClose;
    @FXML
    private Label Description;



    private final Stage stage;
    private final DataService game;

    public RandomEventSceneController(DataService game, Stage stage) {
        this.game = game;
        this.stage = stage;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Description.setText(game.getRandomEvent());
    }

    @FXML
    private void closeEvent(ActionEvent e){
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    }

