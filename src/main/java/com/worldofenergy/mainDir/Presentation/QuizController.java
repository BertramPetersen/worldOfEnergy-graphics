package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import com.worldofenergy.mainDir.QuizSystem.Quiz;
import com.worldofenergy.mainDir.Wallet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    DataService game;
    Stage stage;
    private String answer;
    @FXML
    private Label question;
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
    @FXML
    private ToggleGroup group;

    public QuizController (DataService game, Stage stage)  {
        this.game = game;
        this.stage = stage;
    }

    public void init(DataService game, Stage stage){
        ArrayList<Object> quiz = game.getQuiz();
        String question = (String)quiz.get(0);
        String[] options = (String[])quiz.get(1);
        answer = (String)quiz.get(2);

        this.question.setText(question);
        answerA.setText(options[0]);
        answerB.setText(options[1]);
        answerC.setText(options[2]);
        answerD.setText(options[3]);
    }

    public void submitQuiz(ActionEvent e) throws IOException{
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        RadioButton selectedBtn = (RadioButton) group.getSelectedToggle();
        if (answer.equalsIgnoreCase(selectedBtn.getText())){
            Wallet.addCoins(50);

            showCorrect(stage);
        } else showIncorrect(stage);
    }

    private void showIncorrect(Stage stage) {
        Label failure = new Label("Oh no! Your answer was incorrect. The correct answer was "+answer+
                "You unfortunately get 0 coins. Better luck next time!");
        failure.setWrapText(true);

        failure.prefWidth(150.0);
        failure.prefHeight(300.0);
        failure.setAlignment(Pos.CENTER);
        TilePane tilePane = new TilePane(failure);
        tilePane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(tilePane, 600, 400);
        stage.setScene(scene);
    }

    private void showCorrect(Stage stage) throws IOException{
        Label succes = new Label("Congratulations! \n Your Answer Was Correct You just got 50 coins added to your wallet!");
        succes.setWrapText(true);
        succes.prefWidth(150.0);
        succes.prefHeight(300.0);
        succes.setAlignment(Pos.CENTER);
        TilePane tilePane = new TilePane(succes);
        tilePane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(tilePane, 600, 400);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init(game, stage);
    }
}

