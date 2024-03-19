package com.christopher.farmacia_christopher.models;

import com.christopher.farmacia_christopher.controladores.Ventas;

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

    /*public String buscarVenta(Ventas venta,int id){
        for (Ventas actual:listaVentas){
            if (venta.getIdVenta()==id) {


            }
        }
    }*/
    
}
