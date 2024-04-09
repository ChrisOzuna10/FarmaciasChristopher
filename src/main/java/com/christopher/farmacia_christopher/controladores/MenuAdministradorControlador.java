package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdministradorControlador {

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ImageView logo;

    @FXML
    void empleadosBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Empleados.fxml"));
        Pane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Agregando usuario");
        stage.setScene(scene);
        stage.show();
        EmpleadosControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void informesBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Informes.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Informe");
        stage.setScene(scene);
        stage.show();
        InformesControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
        fxmlLoaderController.mostrarInforme();
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void inventarioBoton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Inventario.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Inventario");
        stage.setScene(scene);
        stage.show();
        InventarioControlador fxmlLoaderController = fxmlLoader.getController();
        fxmlLoaderController.setFarmacia(farmacia);
        fxmlLoaderController.actualizarListaProductos();
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    public void SalirBoton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio de sesion");
        stage.setScene(scene);
        stage.show();
        IniciarSesionController iniciarSesionController = fxmlLoader.getController();
        iniciarSesionController.setStage(stage);
        iniciarSesionController.setFarmacia(farmacia);
        Node source = (Node) mouseEvent.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }
}
