package com.worldofenergy.mainDir.Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Welcome {

    @FXML
    private Button startGame;

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
