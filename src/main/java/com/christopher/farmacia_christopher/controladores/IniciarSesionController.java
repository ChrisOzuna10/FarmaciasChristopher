package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class IniciarSesionController {

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private TextField contraseñaTexto;

    @FXML
    private TextField correoTexto;

    @FXML
    private ImageView logo;

    @FXML
    void iniciarSesionBoton(MouseEvent event) {

    }

}
