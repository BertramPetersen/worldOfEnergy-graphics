package com.worldofenergy.mainDir.Presentation.quizPages;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Wallet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    private final DataService game;
    private final Stage stage;
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

    public QuizController(DataService game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    public void init(DataService game, Stage stage) {
        ArrayList<Object> quiz = game.getQuiz();
        String question = (String) quiz.get(0);
        String[] options = (String[]) quiz.get(1);
        answer = (String) quiz.get(2);

        this.question.setText(question);
        answerA.setText(options[0]);
        answerB.setText(options[1]);
        answerC.setText(options[2]);
        answerD.setText(options[3]);
    }

    @FXML
    public void submitQuiz(MouseEvent e) throws IOException {
        String text;
        if (e.getSource() instanceof SVGPath) {
            text = ((SVGPath) e.getSource()).getId();
        } else {
            text = ((Label) e.getSource()).getId();
        }

        if (answer.equalsIgnoreCase(text)) {
            Wallet.addCoins(50);

            showCorrect(stage);
        } else showIncorrect(stage);
    }

    private void showIncorrect(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(QuizController.class.getResource("incorrect.fxml"));
        loader.setControllerFactory(c -> new IncorrectController(stage, answer));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();
    }

    private void showCorrect(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(QuizController.class.getResource("correct.fxml"));
        loader.setControllerFactory(c -> new CorrectController(stage));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (url.sameFile(QuizController.class.getResource("quiz.fxml"))) {
            init(game, stage);
        }
    }
}


