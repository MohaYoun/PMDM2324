package com.example.pmdm2324.ut09.practicaAPIPeliActor.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicePelicula {
    private static ServicePelicula instancia;
    private static RepoPeliculas repoPeliculas;

    private ServicePelicula(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repoPeliculas=retrofit.create(RepoPeliculas.class);
    }

    public static RepoPeliculas getRepoPeliculas() {
        return repoPeliculas;
    }

    public static ServicePelicula getPeliculas() {
        if(instancia == null){
            instancia = new ServicePelicula();
        }
        return instancia;
    }
}
