package com.example.pmdm2324.ut09.practicaAPIPeliActor.data;

import com.google.gson.annotations.SerializedName;

public class Actores{
    @SerializedName("url")
    private String url;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("pelicula")
    private String pelicula;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPelicula() {
        return pelicula;
    }
}
