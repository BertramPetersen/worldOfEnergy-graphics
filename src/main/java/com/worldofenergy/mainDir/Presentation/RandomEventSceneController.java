package com.worldofenergy.mainDir.Presentation;
import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import com.worldofenergy.mainDir.QuizSystem.RandomEvent;
import com.worldofenergy.mainDir.Wallet;
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
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class RandomEventSceneController implements Initializable  {
    @FXML
    private Button buttonClose;
    @FXML
    private Label Description;
    @FXML
    private ImageView background;



    private final Stage stage;
    private final DataService game;

    public RandomEventSceneController(DataService game, Stage stage) {
        this.game = game;
        this.stage = stage;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pair<String, String> randomEvent = game.getRandomEvent();
        Description.setText(randomEvent.getKey());
        File file = new File("src\\main\\resources\\com\\worldofenergy\\mainDir\\Presentation\\EventBackgrounds\\" + randomEvent.getValue());
        Image image = new Image(file.toURI().toString());
        background.setImage(image);
    }

    @FXML
    private void closeEvent(ActionEvent e){
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    }

