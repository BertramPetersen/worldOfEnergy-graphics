package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import com.worldofenergy.mainDir.QuizSystem.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class QuizController {

    @FXML
    private Label answerA;

    @FXML
    private Label answerB;

    @FXML
    private Label answerC;

    @FXML
    private Label answerD;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton r4;

    @FXML
    private Button submitBtn;

    public void init(DataService game){

    }

}

