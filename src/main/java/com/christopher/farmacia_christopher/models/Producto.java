package com.christopher.farmacia_christopher.models;

public class Producto {
    private String nombre;
    private double precio;
    private int idProducto;
    private int cantidad;
    private static int ultimoId = 0;


    public int restar (int cantidadRestar){
        this.cantidad=this.cantidad-cantidadRestar;
        return this.cantidad;
    }

    @Override
    public String toString() {
        return nombre + " ,Precio: " + precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
