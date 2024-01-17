package com.example.pmdm2324.examen1.ex1;

import java.io.Serializable;

public class Viaje implements Serializable {
    public static final String CLAVE_VIAJE = "viaje";
    private String origen;
    private String destino;
    private String fechaIda;
    private String fechaVuelta;

    public Viaje(String origen, String destino, String fechaIda) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
    }

    public Viaje(String origen, String destino, String fechaIda, String fechaVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
    }

    @Override
    public String toString() {
        return origen.toString() + '-' + destino.toString() +"\n"+ fechaIda.toString() +"\n"+ fechaVuelta.toString();
    }
}
