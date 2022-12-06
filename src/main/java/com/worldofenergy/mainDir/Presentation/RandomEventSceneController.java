package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class RandomEventSceneController implements Initializable {
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
        File file = new File("src/main/resources/com/worldofenergy/mainDir/Presentation/EventBackgrounds/" + randomEvent.getValue());
        Image image = new Image( file.toURI().toString());
        background.setImage(image);
    }

    @FXML
    private void closeEvent(ActionEvent e) {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }
}

