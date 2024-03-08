package com.example.pmdm2324.ut09.practicaAPIPeliActor.data;

import com.google.gson.annotations.SerializedName;

public class Peliculas {
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("estrellas")
    private String estrellas;
    @SerializedName("actores")
    private Actores[] actores;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public Actores[] getActores() {
        return actores;
    }
}
