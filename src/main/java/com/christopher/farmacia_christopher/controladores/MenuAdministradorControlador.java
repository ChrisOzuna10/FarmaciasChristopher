package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuAdministradorControlador {

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ImageView logo;

    @FXML
    void empleadosBoton(MouseEvent event) {

    }

    @FXML
    void informesBoton(MouseEvent event) {

    }

    @FXML
    void inventarioBoton(MouseEvent event) {

    }

}
