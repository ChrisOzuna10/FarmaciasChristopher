package com.christopher.farmacia_christopher.controladores;

import com.christopher.farmacia_christopher.models.Producto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ventas {
    private ArrayList<Producto>listaProductoVenta=new ArrayList<>();
    private double totalVenta;
    private LocalDateTime fechaVenta;
    private int idVenta;
    private static int ultimoId = 0;

    public Ventas(ArrayList<Producto> listaProductoVenta) {
        this.listaProductoVenta = listaProductoVenta;
        this.totalVenta =totalTodasLasVenta();
        this.fechaVenta =LocalDateTime.now() ;
        this.idVenta=++ultimoId;
    }

    public void agregarProductoVentas(Producto producto){
        listaProductoVenta.add(producto);
    }
    public Double totalTodasLasVenta(){
        this.totalVenta=0;
        for (Producto producto:listaProductoVenta){
            this.totalVenta=this.totalVenta+producto.getPrecio();
        }
        return this.totalVenta;
    }
}
