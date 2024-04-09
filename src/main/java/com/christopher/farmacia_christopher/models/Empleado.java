package com.christopher.farmacia_christopher.models;

import com.christopher.farmacia_christopher.controladores.*;

import java.util.ArrayList;

public class Empleado extends Usuario{
    protected ArrayList<Ventas>listaVentas=new ArrayList<>();

    public void agregar(Ventas venta){
        listaVentas.add(venta);
    }

    public void cancelarVenta(Ventas venta,int id){
        for (Ventas actual:listaVentas){
            if (venta.getIdVenta()==id) {
                listaVentas.remove(venta);
            }
        }
    }
    public String buscarVenta(int id){
        String imprimir="";
        for (Ventas actual:listaVentas){
            if (actual.getIdVenta()==id) {
                imprimir= " id: "+actual.getIdVenta()+" fecha: "+actual.getFechaVenta()+" total: "+actual.getTotalVenta();
            }
        }
        return imprimir;
    }

    public ArrayList<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void añadirVenta(Ventas ventas){
        listaVentas.add(ventas);
    }

    @Override
    public String toString() {
        return mombreUsuario +
                ", Contraseña= " + Contrasena;
    }
}
