package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InformesControlador {
    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ListView<?> ListaDeProductos;

    @FXML
    private ImageView logo;

    @FXML
    void SalirBoton(MouseEvent event) {

    }

}
