package com.example.pmdm2324.ut09.ConsumoAPIjorje.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyRepo {
    @GET("/api/character/{id}")
    Call<Personaje> getCharacter(@Path("id") int id);

}
