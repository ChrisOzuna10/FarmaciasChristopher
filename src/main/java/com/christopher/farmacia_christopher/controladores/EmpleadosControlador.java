package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class EmpleadosControlador {

    @FXML
    private ListView<?> ListaDeEmpleados;

    @FXML
    private TextField contraseñaDeEmpleado;

    @FXML
    private ImageView logo;

    @FXML
    private TextField nombreDeEmpleado;

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    void AgregarBoton(MouseEvent event) {

    }

    @FXML
    void EliminarBoton(MouseEvent event) {

    }

    @FXML
    void ModificarBoton(MouseEvent event) {

    }

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuAdministrador.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio de sesión");
        stage.setScene(scene);
        stage.show();
        MenuAdministradorControlador menuAdministradorControlador = fxmlLoader.getController();
        menuAdministradorControlador.setFarmacia(farmacia);
    }

    @FXML
    void seleccionadoClick(MouseEvent event) {

    }

}
