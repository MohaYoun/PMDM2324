package com.example.pmdm2324.ut09.practicaAPIPeliActor.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoPeliculas {
    @GET("api/peliculas_related/{id}")
    Call<Peliculas> getPelicula(@Path("id") int id);
}
