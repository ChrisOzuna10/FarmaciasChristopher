package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class IniciarSesionController {



    @FXML
    private TextField contraseñaTexto;

    @FXML
    private TextField correoTexto;

    @FXML
    private ImageView logo;

    private Farmacia farmacia;

    private Stage stage;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    public void setStage (Stage stage){
        this.stage = stage;
    }
    @FXML
    void iniciarSesionBoton(MouseEvent event) throws IOException {
        if (correoTexto.getText().equals("administrador") && contraseñaTexto.getText().equals("contraseña")){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioSesion.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Inicio de sesion");
            stage.setScene(scene);
            stage.show();
            IniciarSesionController iniciarSesionController = fxmlLoader.getController();
            iniciarSesionController.setFarmacia(farmacia);
        } else {
            //Foreach para buscar a los empleados
        }
    }

}
