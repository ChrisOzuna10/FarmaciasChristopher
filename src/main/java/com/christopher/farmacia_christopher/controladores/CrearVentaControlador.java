package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import com.christopher.farmacia_christopher.models.Producto;
import com.christopher.farmacia_christopher.models.Ventas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
                    if (productoSeleccionado.getCantidad() >= cantidad) {
                        boolean productoYaAgregado = false;
                        for (Producto producto : auxListaProductos) {
                            if (producto.getNombre().equals(productoSeleccionado.getNombre())) {
                                productoYaAgregado = true;
                                break;
                            }
                        }

                        if (!productoYaAgregado) {
                            productoSeleccionado.restar(cantidad);
                            Producto productoParaAgregar = new Producto();
                            productoParaAgregar.setNombre(productoSeleccionado.getNombre());
                            productoParaAgregar.setPrecio(productoSeleccionado.getPrecio());
                            productoParaAgregar.setCantidad(cantidad);
                            auxListaProductos.add(productoParaAgregar);
                            ListaDeProductosVendidos.getItems().clear();
                            ListaDeProductosVendidos.getItems().addAll(auxListaProductos);
                            actualizarTotal();
                        } else {
                            System.out.println("El producto ya está en la lista.");
                        }
                    } else {
                        System.out.println("No hay suficientes productos disponibles.");
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
    void ConfirmarVentaBoton(MouseEvent event) throws IOException {
        double total=calcularTotal();
        Ventas ventas = new Ventas(auxListaProductos,total);
        empleado.añadirVenta(ventas);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuEmpleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        MenuEmpleadoControlador fxmlLoaderController = fxmlLoader.getController();
        int auxiliarDeAyuda = 0;
        for (Empleado empleado1: farmacia.getListaEmpleado()){
            if (empleado1.getMombreUsuario().equals(empleado.getMombreUsuario())&&empleado1.getContrasena().equals(empleado.getContrasena())){
                farmacia.getListaEmpleado().set(auxiliarDeAyuda,empleado);
            }
            auxiliarDeAyuda++;
        }
        fxmlLoaderController.setFarmacia(farmacia);
        fxmlLoaderController.setEmpleado(empleado);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
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

            Producto productoInventario = null;
            for (Producto producto : farmacia.getInventario().getListaProductosInvent()) {
                if (producto.getNombre().equals(productoSeleccionado.getNombre())) {
                    productoInventario = producto;
                    break;
                }
            }

            if (productoInventario != null) {
                int cantidadRestar = nuevaCantidad - productoSeleccionado.getCantidad();
                if (cantidadRestar <= productoInventario.getCantidad()) {
                    productoSeleccionado.setCantidad(nuevaCantidad);
                    ListaDeProductosVendidos.getItems().set(indiceSeleccionado, productoSeleccionado);
                    actualizarTotal();
                    productoInventario.restar(cantidadRestar);
                } else {
                    System.out.println("No hay suficientes productos disponibles.");
                }
            } else {
                System.out.println("Error: Producto no encontrado en el inventario.");
            }
        } else {
            System.out.println("Por favor, seleccione un producto para modificar su cantidad.");
        }
    }

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuEmpleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        MenuEmpleadoControlador fxmlLoaderController = fxmlLoader.getController();
        int auxiliarDeAyuda = 0;
        for (Empleado empleado1: farmacia.getListaEmpleado()){
            if (empleado1.getMombreUsuario().equals(empleado.getMombreUsuario())&&empleado1.getContrasena().equals(empleado.getContrasena())){
                farmacia.getListaEmpleado().set(auxiliarDeAyuda,empleado);
            }
            auxiliarDeAyuda++;
        }
        fxmlLoaderController.setFarmacia(farmacia);
        fxmlLoaderController.setEmpleado(empleado);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void seleccionadoClick(MouseEvent event) {

    }
    @FXML
    void initialize() {

    }

}
