package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import com.christopher.farmacia_christopher.models.Ventas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelarVentaControlador {

    @FXML
    private TextField cantidadDeProducto;

    @FXML
    private ImageView logo;
    private Farmacia farmacia;
    private Empleado empleado;
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    void ConfirmarBoton(MouseEvent event) {
        int Auxiliar = 0;
        int AuxiliarEliminar = -1;
        for (Ventas ventas: empleado.getListaVentas()){
            if (ventas.getIdVenta()==Integer.parseInt(cantidadDeProducto.getText())){
                AuxiliarEliminar = Auxiliar;
            }
            Auxiliar++;
        }
        if (AuxiliarEliminar != -1){
            empleado.getListaVentas().remove(AuxiliarEliminar);
        }
    }

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuEmpleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio de sesion");
        stage.setScene(scene);
        stage.show();
        IniciarSesionController iniciarSesionController = fxmlLoader.getController();
        iniciarSesionController.setFarmacia(farmacia);
        int auxiliarDeAyuda = 0;
        for (Empleado empleado1: farmacia.getListaEmpleado()){
            if (empleado1.getMombreUsuario().equals(empleado.getMombreUsuario())&&empleado1.getContrasena().equals(empleado.getContrasena())){
                farmacia.getListaEmpleado().set(auxiliarDeAyuda,empleado);
            }
            auxiliarDeAyuda++;
        }
    }
}