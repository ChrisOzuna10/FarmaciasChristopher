package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import com.christopher.farmacia_christopher.models.Ventas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InformesControlador {
    private Farmacia farmacia;
    private Empleado empleado;
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ListView<String> ListaDeProductos;

    @FXML
    private ImageView logo;

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuAdministrador.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu de administrador");
        stage.setScene(scene);
        stage.show();
        MenuAdministradorControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    public void mostrarInforme (){
        for (Empleado empleado1 : farmacia.getListaEmpleado()){
            for (Ventas ventas: empleado1.getListaVentas()){
                ListaDeProductos.getItems().add(ventas.toString());
            }
        }

    }
}
