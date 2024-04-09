package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import com.christopher.farmacia_christopher.models.Producto;
import com.christopher.farmacia_christopher.models.Ventas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CrearVentaControlador {

    @FXML
    private ListView<Producto> ListaDeProductos;

    @FXML
    private ListView<Producto> ListaDeProductosVendidos;

    @FXML
    private TextField cantidadDeProducto;
    @FXML
    private Label TotalGeneral;

    @FXML
    private ImageView logo;
    private ArrayList<Producto> auxListaProductos=new ArrayList<>();
    private Farmacia farmacia;
    private Empleado empleado;
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFarmacia (Farmacia farmacia){
        this.farmacia = farmacia;
        cargarProductosEnLista();
    }
   public void cargarProductosEnLista() {
        ListaDeProductos.getItems().addAll(farmacia.getInventario().getListaProductosInvent());
    }
    public double calcularTotal(){
        double totalVenta = 0.0;
        for (Producto producto : auxListaProductos) {
            totalVenta += producto.calcularPrecioCantida();
        }
        return totalVenta;
    }
    public void actualizarTotal() {
        double totalVenta = calcularTotal();
        TotalGeneral.setText("Total: " + String.valueOf(totalVenta));
    }


    @FXML
    void AgregarBoton(MouseEvent event) {
        int indiceSeleccionado = ListaDeProductos.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado != -1) {
            Producto productoSeleccionado = ListaDeProductos.getItems().get(indiceSeleccionado);
            try {
                int cantidad = Integer.parseInt(cantidadDeProducto.getText());

                if (cantidad > 0) {
                    if (!auxListaProductos.contains(productoSeleccionado)) {
                        productoSeleccionado.setCantidad(cantidad);
                        auxListaProductos.add(productoSeleccionado);
                        ListaDeProductosVendidos.getItems().clear();
                        ListaDeProductosVendidos.getItems().addAll(auxListaProductos);
                        actualizarTotal();
                    } else {
                        System.out.println("El producto ya está en la lista.");
                    }
                } else {
                    System.out.println("La cantidad debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese una cantidad válida.");
            }
        } else {
            System.out.println("Por favor, seleccione un producto.");
        }
    }

    @FXML
    void ConfirmarVentaBoton(MouseEvent event) {
        double total=calcularTotal();
        Ventas ventas=new Ventas(auxListaProductos,total);
       // farmacia.getListaEmpleado().get().agregar(ventas);
    }

    @FXML
    void EliminarBoton(MouseEvent event) {
        int indiceSeleccionado = ListaDeProductosVendidos.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado != -1) {
            Producto productoSeleccionado = ListaDeProductosVendidos.getItems().get(indiceSeleccionado);
            auxListaProductos.remove(productoSeleccionado);
            ListaDeProductosVendidos.getItems().remove(indiceSeleccionado);
            actualizarTotal();
        } else {
            System.out.println("Por favor, seleccione un producto para eliminar.");
        }
    }

    @FXML
    void ModificarBoton(MouseEvent event) {
        int indiceSeleccionado = ListaDeProductosVendidos.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado != -1) {
            Producto productoSeleccionado = ListaDeProductosVendidos.getItems().get(indiceSeleccionado);
            int nuevaCantidad;
            try {
                nuevaCantidad = Integer.parseInt(cantidadDeProducto.getText());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese una cantidad válida.");
                return;
            }
            if (nuevaCantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                return;
            }
            productoSeleccionado.setCantidad(nuevaCantidad);
            ListaDeProductosVendidos.getItems().set(indiceSeleccionado, productoSeleccionado);
            actualizarTotal();
        } else {
            System.out.println("Por favor, seleccione un producto para modificar su cantidad.");
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

    @FXML
    void seleccionadoClick(MouseEvent event) {

    }
    @FXML
    void initialize() {

    }

}
