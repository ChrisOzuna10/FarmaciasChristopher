package com.christopher.farmacia_christopher.models;

public class Producto {
    private String nombre;
    private double precio;
    private int id;
    private int cantidad;
    private int ultimoId = 0;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = ++ultimoId;
        this.cantidad = cantidad;
    }
    public int restar (int cantidadRestar){
        this.cantidad=this.cantidad-cantidadRestar;
        return this.cantidad;
    }
    public void generarId (){
        this.id = ++ultimoId;
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

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }
}
