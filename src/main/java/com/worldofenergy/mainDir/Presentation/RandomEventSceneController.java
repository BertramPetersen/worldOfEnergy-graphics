package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.DataService;
import javafx.stage.Stage;

public class RandomEventSceneController {

    private final Stage stage;
    private final DataService game;

    public RandomEventSceneController(DataService game, Stage stage) {
        this.game = game;
        this.stage = stage;

    }
}
