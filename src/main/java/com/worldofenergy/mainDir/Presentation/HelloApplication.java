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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("World Of Energy");
        stage.setMinWidth(905.0);
        stage.setMinHeight(620.0);
        stage.setScene(scene);
        stage.show();
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

    public static void showMainView(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}