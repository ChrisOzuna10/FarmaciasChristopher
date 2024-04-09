package com.christopher.farmacia_christopher.models;

import java.util.ArrayList;

public class Usuario {
    protected String mombreUsuario;
    protected String Contrasena;

    public String getMombreUsuario() {
        return mombreUsuario;
    }

    public void setMombreUsuario(String mombreUsuario) {
        this.mombreUsuario = mombreUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
}
