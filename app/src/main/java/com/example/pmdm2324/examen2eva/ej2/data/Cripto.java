package com.example.pmdm2324.examen2eva.ej2.data;

import com.google.gson.annotations.SerializedName;

public class Cripto {
    @SerializedName("nombre")
    private String nombre;

    @SerializedName("euros")
    private double euros;

    @SerializedName("estafados")
    private Estafados[] estafado;

    public String getNombre() {
        return nombre;
    }

    public double getEuros() {
        return euros;
    }

    public Estafados[] getEstafado() {
        return estafado;
    }
}