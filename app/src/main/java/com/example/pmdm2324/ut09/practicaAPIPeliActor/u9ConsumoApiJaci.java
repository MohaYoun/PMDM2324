package com.example.pmdm2324.ut09.practicaAPIPeliActor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut09.practicaAPIPeliActor.MVVM.PeliculaModelView;
import com.example.pmdm2324.ut09.practicaAPIPeliActor.RecyclerView.AdapterPeliculas;

public class u9ConsumoApiJaci extends AppCompatActivity {
    RecyclerView recyclePeliculas;
    Button generar;
    EditText introducirID;
    ProgressBar pbCarga;
    private AdapterPeliculas adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9_consumo_api_jaci);

        recyclePeliculas = findViewById(R.id.recyclePeliculas);
        generar = findViewById(R.id.botonGenRecycle);
        introducirID = findViewById(R.id.introducirID);
        pbCarga = findViewById(R.id.PeliculaRuleta);

        pbCarga.setVisibility(View.INVISIBLE);

        PeliculaModelView mvvm = new ViewModelProvider(this).get(PeliculaModelView.class);

        generar.setOnClickListener(v -> {
            int id = Integer.parseInt(introducirID.getText().toString());
            pbCarga.setVisibility(View.VISIBLE);
            recyclePeliculas.setVisibility(View.INVISIBLE);
            mvvm.cargaPelicula(id);
        });

        mvvm.getPeliculas().observe(this, peliculas -> {
            pbCarga.setVisibility(View.INVISIBLE);
            recyclePeliculas.setVisibility(View.VISIBLE);
            if (adapter == null) {
                adapter = new AdapterPeliculas(peliculas);
                recyclePeliculas.setAdapter(adapter);
                recyclePeliculas.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            } else {
                adapter.add(peliculas);
            }
        });
    }
}