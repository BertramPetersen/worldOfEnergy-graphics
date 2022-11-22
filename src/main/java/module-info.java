module com.worldofenergy.worldofenergygraphics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.worldofenergy.worldofenergygraphics to javafx.fxml;
    exports com.worldofenergy.worldofenergygraphics;
    exports com.worldofenergy.worldofenergygraphics.Presentation;
    opens com.worldofenergy.worldofenergygraphics.Presentation to javafx.fxml;
}