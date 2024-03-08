package com.example.pmdm2324.ut09.practicaAPIPeliActor.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm2324.ut09.practicaAPIPeliActor.data.Peliculas;
import com.example.pmdm2324.ut09.practicaAPIPeliActor.data.ServicePelicula;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaModelView extends ViewModel {
    private static final double DELAY = 2000;
    private MutableLiveData<Peliculas> peliculasLiveData = new MutableLiveData<>();
    private ServicePelicula servicePelicula = ServicePelicula.getPeliculas();
    public LiveData<Peliculas> getPeliculas() {
        return peliculasLiveData;
    }

    public void cargaPelicula(int id) {
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) (DELAY));
                        Call<Peliculas> llamada = servicePelicula
                                .getRepoPeliculas()
                                .getPelicula(id);
                        llamada.enqueue(new Callback<Peliculas>() {

                            @Override
                            public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
                                if (response.isSuccessful()) {
                                    Peliculas pelis = response.body();
                                    peliculasLiveData.postValue(pelis);
                                }
                            }

                            @Override
                            public void onFailure(Call<Peliculas> call, Throwable t) {
                                peliculasLiveData.setValue(null);
                            }
                        });

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        ).start();
    }
}