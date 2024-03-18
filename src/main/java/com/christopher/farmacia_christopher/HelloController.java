package com.christopher.farmacia_christopher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
//hola
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}