package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.Main;
import com.christopher.farmacia_christopher.models.Empleado;
import com.christopher.farmacia_christopher.models.Farmacia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EmpleadosControlador {

    @FXML
    private ListView<String> ListaDeEmpleados;

    @FXML
    private TextField contraseñaDeEmpleado;

    @FXML
    private ImageView logo;

    @FXML
    private TextField nombreDeEmpleado;

    private Farmacia farmacia;

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
        // Cargar la lista de empleados al inicio
        actualizarListaEmpleados();
    }

    @FXML
    void AgregarBoton(MouseEvent event) {
        String nombre = nombreDeEmpleado.getText();
        String contraseña = contraseñaDeEmpleado.getText();

        // Verificar si el nombre y la contraseña están vacíos
        if (nombre.isEmpty() || contraseña.isEmpty()) {
            mostrarAlerta("Error", "Nombre y contraseña son requeridos.");
            return;
        }

        // Crear un nuevo empleado y agregarlo a la lista
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setMombreUsuario(nombreDeEmpleado.getText());
        nuevoEmpleado.setContrasena(contraseñaDeEmpleado.getText());
        farmacia.getListaEmpleado().add(nuevoEmpleado);

        // Actualizar la lista de empleados en la interfaz
        actualizarListaEmpleados();

        // Limpiar los campos de texto
        nombreDeEmpleado.clear();
        contraseñaDeEmpleado.clear();
    }

    @FXML
    void EliminarBoton(MouseEvent event) {
        int empleadoSeleccionado = ListaDeEmpleados.getSelectionModel().getSelectedIndex();

        // Verificar si se ha seleccionado un empleado
        if (empleadoSeleccionado <= -1) {
            mostrarAlerta("Error", "Por favor, selecciona un empleado para eliminar.");
            return;
        }

        // Eliminar el empleado seleccionado de la lista
        farmacia.getListaEmpleado().remove(empleadoSeleccionado);

        // Actualizar la lista de empleados en la interfaz
        actualizarListaEmpleados();
    }

    @FXML
    void ModificarBoton(MouseEvent event) {
        int empleadoSeleccionado = ListaDeEmpleados.getSelectionModel().getSelectedIndex();

        // Verificar si se ha seleccionado un empleado
        if (empleadoSeleccionado <= -1) {
            mostrarAlerta("Error", "Por favor, selecciona un empleado para modificar.");
            return;
        }

        // Obtener el nuevo nombre y contraseña del empleado
        String nuevoNombre = nombreDeEmpleado.getText();
        String nuevaContraseña = contraseñaDeEmpleado.getText();

        // Verificar si el nombre y la contraseña están vacíos
        if (nuevoNombre.isEmpty() || nuevaContraseña.isEmpty()) {
            mostrarAlerta("Error", "Nombre y contraseña son requeridos.");
            return;
        }

        // Modificar el nombre y la contraseña del empleado seleccionado
        farmacia.getListaEmpleado().get(empleadoSeleccionado).setMombreUsuario(nuevoNombre);
        farmacia.getListaEmpleado().get(empleadoSeleccionado).setContrasena(nuevaContraseña);

        // Actualizar la lista de empleados en la interfaz
        actualizarListaEmpleados();

        // Limpiar los campos de texto
        nombreDeEmpleado.clear();
        contraseñaDeEmpleado.clear();
    }

    @FXML
    void SalirBoton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuAdministrador.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu de administrador");
        stage.setScene(scene);
        stage.show();
        MenuAdministradorControlador menuAdministradorControlador = fxmlLoader.getController();
        menuAdministradorControlador.setFarmacia(farmacia);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    private void actualizarListaEmpleados() {
        ListaDeEmpleados.getItems().clear();
        for (Empleado empleado : farmacia.getListaEmpleado()){
            ListaDeEmpleados.getItems().add(empleado.toString());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void seleccionadoClick(MouseEvent mouseEvent) {
    }
}
