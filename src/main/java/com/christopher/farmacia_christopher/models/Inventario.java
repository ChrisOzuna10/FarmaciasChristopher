package com.christopher.farmacia_christopher.models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> listaProductosInvent =new ArrayList<>();

    public void agregarProductosInvent(Producto producto){
        listaProductosInvent.add(producto);
    }
    public void eliminarProductoInvent(Producto producto){
        listaProductosInvent.remove(producto);
    }

    public String mostrarProductoInvent(Producto producto) {
        String imprimir= "Nombre: " + producto.getNombre() + "\n"
                + "Precio: " + producto.getPrecio() + "\n"
                + "ID: " + producto.getIdProducto() + "\n"
                + "Cantidad: " + producto.getCantidad() + "\n";
        return imprimir;
    }

    public void modificarProductoInvent(Producto producto,int id,String nuevoNombre,double nuevoPrecio,int nuevaCantida){
        for (Producto encontrado: listaProductosInvent){
            if (encontrado.getIdProducto()==id){
                encontrado.setNombre(nuevoNombre);
                encontrado.setCantidad(nuevaCantida);
                encontrado.setPrecio(nuevoPrecio);
            }
        }
    }

    public ArrayList<Producto> getListaProductosInvent() {
        return listaProductosInvent;
    }

    public void setListaProductosInvent(ArrayList<Producto> listaProductosInvent) {
        this.listaProductosInvent = listaProductosInvent;
    }
}
