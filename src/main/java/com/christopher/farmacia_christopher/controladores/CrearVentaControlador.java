package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CrearVentaControlador {

    @FXML
    private ListView<?> ListaDeProductos;

    @FXML
    private ListView<?> ListaDeProductosVendidos;

    @FXML
    private TextField cantidadDeProducto;

    @FXML
    private ImageView logo;

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    void AgregarBoton(MouseEvent event) {

    }

    @FXML
    void ConfirmarVentaBoton(MouseEvent event) {

    }

    @FXML
    void EliminarBoton(MouseEvent event) {

    }

    @FXML
    void ModificarBoton(MouseEvent event) {

    }

    @FXML
    void SalirBoton(MouseEvent event) {

    }

    @FXML
    void seleccionadoClick(MouseEvent event) {

    }

}
