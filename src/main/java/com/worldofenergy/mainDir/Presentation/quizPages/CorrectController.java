package com.worldofenergy.mainDir.Presentation.quizPages;

import javafx.stage.Stage;

public class CorrectController {
    private Stage stage;

    public CorrectController(Stage stage){
        this.stage = stage;
    }


    public void Close() {
        stage.close();
    }
}
