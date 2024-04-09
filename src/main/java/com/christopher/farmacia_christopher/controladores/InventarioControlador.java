package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Farmacia;
import com.christopher.farmacia_christopher.models.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InventarioControlador {

    private Farmacia farmacia;

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
    }

    @FXML
    private ListView<String> ListaDeProductos = new ListView<>();

    @FXML
    private ImageView logo;

    @FXML
    private TextField nombreDeProducto;

    @FXML
    private TextField precioDeProducto;

    @FXML
    void AgregarBoton(MouseEvent event) {
        Producto producto = new Producto();
        producto.setNombre(nombreDeProducto.getText());
        producto.setPrecio(Double.parseDouble(precioDeProducto.getText()));
        farmacia.getInventario().agregarProductosInvent(producto);
        actualizarListaProductos();
    }

    @FXML
    void EliminarBoton(MouseEvent event) {
        int indiceSeleccionado = ListaDeProductos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            // Remover el producto de la lista de productos del inventario
            farmacia.getInventario().getListaProductosInvent().remove(indiceSeleccionado);

            // Limpiar los campos de texto
            nombreDeProducto.clear();
            precioDeProducto.clear();

            // Actualizar la lista en la interfaz gráfica
            actualizarListaProductos();
        }
    }

    public void actualizarListaProductos() {
        ListaDeProductos.getItems().clear();
        for (Producto producto : farmacia.getInventario().getListaProductosInvent()) {
            ListaDeProductos.getItems().add(producto.toString());
        }
    }

    @FXML
    void ModificarBoton(MouseEvent event) {
        int indiceSeleccionado = ListaDeProductos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Producto productoSeleccionado = farmacia.getInventario().getListaProductosInvent().get(indiceSeleccionado);
            productoSeleccionado.setPrecio(Double.parseDouble(precioDeProducto.getText()));
            productoSeleccionado.setNombre(nombreDeProducto.getText());
            farmacia.getInventario().getListaProductosInvent().set(indiceSeleccionado,productoSeleccionado);
            actualizarListaProductos();
        }
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

