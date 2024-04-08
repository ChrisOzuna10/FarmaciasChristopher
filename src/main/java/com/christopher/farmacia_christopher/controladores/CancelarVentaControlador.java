package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CancelarVentaControlador {

    @FXML
    private TextField cantidadDeProducto;

    @FXML
    private ImageView logo;
    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    void ConfirmarBoton(MouseEvent event) {

    }

    @FXML
    void SalirBoton(MouseEvent event) {

    }
}