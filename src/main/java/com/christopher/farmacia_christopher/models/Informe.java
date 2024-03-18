package com.christopher.farmacia_christopher.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Informe {
    private double totaInforme;
    private LocalDateTime fechaInforme=LocalDateTime.now();
    private ArrayList<Ventas>listaInforme=new ArrayList<>();

    public void agregarInforme(Ventas venta){
        listaInforme.add(venta);
    }
    public void mostrarInformeVenta(Ventas venta){

    }

}
