package com.christopher.farmacia_christopher.controller;

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