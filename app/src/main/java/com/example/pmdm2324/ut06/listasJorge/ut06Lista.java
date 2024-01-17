package com.example.pmdm2324.ut06.listasJorge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut06.listasJorge.datos.ut06Partido;

public class ut06Lista extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button add;
    ut06PartidoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut06_listajava);

        reyclerViewUser = (RecyclerView) findViewById(R.id.u6rvListaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new ut06PartidoAdapter(ut06Partido.generatePartidos(ut06Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.u6btListaAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(ut06Partido.generatePartidos(ut06Partido.PARTIDOS_INICIALES));
            }
        });

        //adapter.notifyDataSetChanged();
    }
}