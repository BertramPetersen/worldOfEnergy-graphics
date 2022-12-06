package com.worldofenergy.mainDir.Presentation.InfoPages;

import com.worldofenergy.mainDir.Presentation.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpController{

    Stage stage;


    public HelpController(Stage stage){
        this.stage = stage;
    }

    @FXML
    public void showEnergyHelp(ActionEvent e) throws IOException {
        String energyType = ((Button)e.getSource()).getId();
        HelloApplication.displayHelp(energyType, stage);
    }

}
