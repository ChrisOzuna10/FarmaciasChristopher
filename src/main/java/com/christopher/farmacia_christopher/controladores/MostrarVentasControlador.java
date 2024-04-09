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

public class MostrarVentasControlador {

    @FXML
    private ListView<String> ListaDeVentas;

    @FXML
    private ImageView logo;

    private Empleado empleado;

    private Farmacia farmacia;



    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuEmpleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        MenuEmpleadoControlador menuEmpleadoControlador = fxmlLoader.getController();
        menuEmpleadoControlador.setFarmacia(farmacia);
        menuEmpleadoControlador.setEmpleado(empleado);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void seleccionadoClick(MouseEvent event) {
    }

    public void mostrarVentas(){
        for (Ventas ventas: empleado.getListaVentas()){
            ListaDeVentas.getItems().add(ventas.toString());
        }
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
