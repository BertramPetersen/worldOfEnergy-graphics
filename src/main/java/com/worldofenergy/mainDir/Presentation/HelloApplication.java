package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import com.worldofenergy.mainDir.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DataService game = new Game();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("En verden af Skrald");
//        alert.setHeaderText(null);
//        alert.setContentText("Welcome to World of Energy \nThe Game where YOU have the responsibility for preventing" +
//                " global warming from destroying the planet." +
//                "\nPress help if you don't know what to do");
        stage.setTitle("World Of Energy");
        stage.setMinWidth(905.0);
        stage.setMinHeight(620.0);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        HelloController controller = loader.getController();
        controller.init(game);
//        alert.showAndWait();
    }

    public static void showCountryView(DataService game, Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("country-view.fxml"));
        Scene scene = new Scene(loader.load());

        CountryController cc = loader.getController();

        stage.setScene(scene);
        stage.show();
        cc.setGame(game);
    }

    public static void showMainView(DataService game, Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        HelloController controller = loader.getController();
        stage.setScene(scene);
        stage.show();
        controller.init(game);
    }

    public static void main(String[] args) {
        launch();
    }
}