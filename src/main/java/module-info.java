module com.christopher.farmacia_christopher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.christopher.farmacia_christopher to javafx.fxml;
    exports com.christopher.farmacia_christopher;
    exports com.christopher.farmacia_christopher.controller;
    opens com.christopher.farmacia_christopher.controller to javafx.fxml;
}