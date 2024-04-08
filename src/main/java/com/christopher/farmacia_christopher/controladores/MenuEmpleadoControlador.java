package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuEmpleadoControlador {

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ImageView logo;

    @FXML
    void CancelarBoton(MouseEvent event) {

    }

    @FXML
    void CrearVentaBoton(MouseEvent event) {

    }

    @FXML
    void MotrarVentasBoton(MouseEvent event) {

    }

    @FXML
    void SalirBoton(MouseEvent event) {

    }

}
