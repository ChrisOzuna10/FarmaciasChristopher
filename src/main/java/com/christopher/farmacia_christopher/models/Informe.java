package com.christopher.farmacia_christopher.models;

import com.christopher.farmacia_christopher.controladores.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Informe {
    private double totaInforme;
    private LocalDateTime fechaInforme=LocalDateTime.now();
    private ArrayList<Ventas>listaInforme=new ArrayList<>();

    public void agregarInforme(Ventas venta){
        listaInforme.add(venta);
    }
    public double obtenerTotalInfome(){
        for (Ventas ventas: listaInforme) {
            this.totaInforme=this.totaInforme+ventas.getTotalVenta();
        }
        return this.totaInforme;
    }

    public String mostrarInformeVentas() {
        String imprimir = "Fecha del Informe: " + fechaInforme + "\n";
        imprimir += "Total del Informe: " + totaInforme + "\n\n";
        for (Ventas venta : listaInforme) {
            imprimir += "ID de Venta: " + venta.getIdVenta() + "\n";
            imprimir += "Productos vendidos:\n";
            for (Producto producto : venta.getListaProductoVenta()) {
                imprimir += "-Nombre: " + producto.getNombre() + "\n";
                imprimir += "-Cantidad: " +producto.getCantidad()+"\n";
                imprimir += "-precio: "+producto.getPrecio()+"\n";
            }
            imprimir += "Total de la Venta: " + venta.getTotalVenta() + "\n";
            imprimir += "Fecha de la Venta: " + venta.getFechaVenta() + "\n\n";
        }
        return imprimir;
    }
}
