package com.worldofenergy.mainDir.Presentation.quizPages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class IncorrectController implements Initializable {

    @FXML
    private Label failure;

    private final Stage stage;
    private final String answer;

    public IncorrectController(Stage stage, String answer) {
        this.stage = stage;
        this.answer = answer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        failure.setText("Oh noo!! Your answer was unfortunately incorrect. The correct answer was " + answer + " You get 0 coins added to you wallet");
    }

    public void Close() {
        stage.close();
    }
}
