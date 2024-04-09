package com.christopher.farmacia_christopher;

import com.christopher.farmacia_christopher.controladores.IniciarSesionController;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio de sesion");
        stage.setScene(scene);
        stage.show();
        Farmacia farmacia = new Farmacia();
        IniciarSesionController iniciarSesionController = fxmlLoader.getController();
        iniciarSesionController.setStage(stage);
        iniciarSesionController.setFarmacia(farmacia);
    }

    public static void main(String[] args) {
        launch();
    }
}