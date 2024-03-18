package com.christopher.farmacia_christopher.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Informe {
    private double totalVentas;
    private LocalDateTime fecha=LocalDateTime.now();
    private ArrayList<Ventas>listaInforme=new ArrayList<>();

    public void agregarInforme(Ventas venta){
        listaInforme.add(venta);
    }
    public void mostrarVenta(Ventas venta){

    }

}
