package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuEmpleadoControlador {

    private Farmacia farmacia;
   

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ImageView logo;

    private Empleado empleado;
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    @FXML
    void CancelarBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CancelarVenta.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Agregando usuario");
        stage.setScene(scene);
        stage.show();
        CancelarVentaControlador cancelarVentaControlador = fxmlLoader.getController();
        cancelarVentaControlador.setFarmacia(farmacia);
        cancelarVentaControlador.setEmpleado(empleado);
    }

    @FXML
    void CrearVentaBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CrearVenta.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Agregando usuario");
        stage.setScene(scene);
        stage.show();
        CrearVentaControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
    }

    @FXML
    void MotrarVentasBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MostrarVentas.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Agregando usuario");
        stage.setScene(scene);
        stage.show();
        MostrarVentasControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
        fxmlLoaderController.setEmpleado(empleado);
        fxmlLoaderController.mostrarVentas();
    }

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio de sesion");
        stage.setScene(scene);
        stage.show();
        IniciarSesionController iniciarSesionController = fxmlLoader.getController();
        iniciarSesionController.setStage(stage);
        iniciarSesionController.setFarmacia(farmacia);
        int auxiliarDeAyuda = 0;
        for (Empleado empleado1: farmacia.getListaEmpleado()){
            if (empleado1.getMombreUsuario().equals(empleado.getMombreUsuario())&&empleado1.getContrasena().equals(empleado.getContrasena())){
                farmacia.getListaEmpleado().set(auxiliarDeAyuda,empleado);
            }
            auxiliarDeAyuda++;
        }
        iniciarSesionController.setFarmacia(farmacia);
    }

   
}
