package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DTOs.ForecastDTO;
import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("src/main/resources/com/worldofenergy/mainDir/Presentation/imagProject.jpg");
        Image image;
        image = new Image(new FileInputStream(file));

        stage.getIcons().add(image);

        DataService game = new Game();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        loader.setControllerFactory(c -> new HelloController(game, stage));
        Scene scene = new Scene(loader.load());



        stage.setTitle("World Of Energy");
        stage.setMinWidth(905.0);
        stage.setMinHeight(620.0);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
        showWelcome();
    }

    public static void showWelcome() throws IOException {
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome to World Of Energy");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("welcome.fxml"));
        Scene scene = new Scene(loader.load());
        welcomeStage.setScene(scene);
        welcomeStage.showAndWait();
    }

    public static void showCountryView(DataService game, Stage stage) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("country-view.fxml"));
        loader.setControllerFactory(c -> new CountryController(game));
        Scene scene = new Scene(loader.load());

        CountryController cc = loader.getController();

        stage.setScene(scene);
        stage.show();
    }

    public static void displayHelp(String energyType, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        InputStream i = HelloApplication.class.getResourceAsStream("energy-help.fxml");
        loader.setControllerFactory(c -> new EnergyInfoController(energyType));
        Scene scene = new Scene(loader.load(i));

        stage.setScene(scene);
        stage.show();
    }

    public static void showMainView(DataService game, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        loader.setControllerFactory(c -> new HelloController(game, stage));
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

    public static void ShowRandomEvent(DataService game) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("RandomEventScene1.fxml"));
        loader.setControllerFactory(c -> new RandomEventSceneController(game, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
    }


    public static void ShowHelp() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("help-view.fxml"));
        loader.setControllerFactory(c -> new HelpController(stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void closeWindow(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }


    public static void main(String[] args) {
        launch();
    }
}
