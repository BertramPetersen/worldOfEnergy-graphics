package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DTOs.PForecast;
import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("src/main/resources/com/worldofenergy/mainDir/Presentation/imagProject.jpg");
        Image image;
        image = new Image(new FileInputStream(file));

        stage.getIcons().add(image);

        DataService game = new Game();
        PForecast forecast = game.getPForecast();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        loader.setControllerFactory(c -> new HelloController(game, stage, forecast));
        Scene scene = new Scene(loader.load());



        stage.setTitle("World Of Energy");
        stage.setMinWidth(905.0);
        stage.setMinHeight(620.0);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
        showWelcome();
    }
    public static void showWelcome() throws IOException{
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome to World Of Energy");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("welcome.fxml"));
        Scene scene = new Scene(loader.load());
        welcomeStage.setScene(scene);
        welcomeStage.showAndWait();
    }

    public static void showCountryView(DataService game, Stage stage, PForecast forecast) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("country-view.fxml"));
        loader.setControllerFactory(c -> new CountryController(game, forecast));
        Scene scene = new Scene(loader.load());

        CountryController cc = loader.getController();

        stage.setScene(scene);
        stage.show();
    }

    public static void showMainView(DataService game, Stage stage, PForecast forecast) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        loader.setControllerFactory(c -> new HelloController(game, stage, forecast));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void showQuiz(DataService game) throws IOException, InterruptedException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("quiz.fxml"));
        loader.setControllerFactory(c -> new QuizController(game, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
//        controller.init(game, stage);

    }
    public static void ShowRandomEvent(DataService game) throws IOException{
        Random random = new Random();
        int x = random.nextInt(3)+1;
        if(x == 1){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("RandomEventScene1.fxml"));
            loader.setControllerFactory(c -> new RandomEventSceneController(game, stage));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.showAndWait();

        } else if (x == 2) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("RandomEventScene2.fxml"));
            loader.setControllerFactory(c -> new RandomEventSceneController(game, stage));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.showAndWait();
        } else if (x == 3) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("RandomEventScene3.fxml"));
            loader.setControllerFactory(c -> new RandomEventSceneController(game, stage));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.showAndWait();
        }

    }

    public static void closeWindow(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }



    public static void main(String[] args) {
        launch();
    }
}
