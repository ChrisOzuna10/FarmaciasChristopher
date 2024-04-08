package com.christopher.farmacia_christopher.models;

import java.util.ArrayList;

public class Farmacia {
    ArrayList<Empleado> listaEmpleado = new ArrayList<>();

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }


}
