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
        if (correoTexto.getText().equals("administrador") && contraseñaTexto.getText().equals("1234")) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuAdministrador.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Inicio de sesión");
            stage.setScene(scene);
            stage.show();
            MenuAdministradorControlador menuAdministradorControlador = fxmlLoader.getController();
            menuAdministradorControlador.setFarmacia(farmacia);
        } else {
            if (farmacia.getListaEmpleado() != null) { // Verifica que la lista de empleados no sea null
                for (Empleado empleado : farmacia.getListaEmpleado()) {
                    if (empleado != null && empleado.getContrasena() != null && empleado.getMombreUsuario().equals(correoTexto.getText()) && empleado.getContrasena().equals(contraseñaTexto.getText())) {
                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuEmpleado.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        stage.setTitle("Inicio de sesión");
                        stage.setScene(scene);
                        stage.show();
                        MenuEmpleadoControlador menuEmpleadoControlador = fxmlLoader.getController();
                        menuEmpleadoControlador.setFarmacia(farmacia);
                        menuEmpleadoControlador.setEmpleado(empleado);
                        return; // Importante: salimos del bucle si encontramos un empleado válido
                    }
                }
            }
            // Si no se encuentra un empleado válido, aquí puedes mostrar un mensaje de error, por ejemplo:
            System.out.println("Credenciales incorrectas");
    }
}
}
