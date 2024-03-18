package com.christopher.farmacia_christopher.models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto>listaProductos=new ArrayList<>();

    public void agregarProductos(Producto producto){
        listaProductos.add(producto);
    }
    public void eliminarProducto(Producto producto){
        listaProductos.remove(producto);
    }

    public String mostrarProducto(Producto producto) {
        String imprimir= "Nombre: " + producto.getNombre() + "\n"
                + "Precio: " + producto.getPrecio() + "\n"
                + "ID: " + producto.getId() + "\n"
                + "Cantidad: " + producto.getCantidad() + "\n";
        return imprimir;
    }

    public void modificarProducto(Producto producto,int id,String nuevoNombre,double nuevoPrecio,int nuevaCantida){
        for (Producto encontrado:listaProductos){
            if (encontrado.getId()==id){
                encontrado.setNombre(nuevoNombre);
                encontrado.setCantidad(nuevaCantida);
                encontrado.setPrecio(nuevoPrecio);
            }
        }
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
