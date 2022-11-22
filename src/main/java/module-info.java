module com.worldofenergy.worldofenergygraphics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.worldofenergy.mainDir to javafx.fxml;
    exports com.worldofenergy.mainDir;
    exports com.worldofenergy.mainDir.Presentation;
    opens com.worldofenergy.mainDir.Presentation to javafx.fxml;
}