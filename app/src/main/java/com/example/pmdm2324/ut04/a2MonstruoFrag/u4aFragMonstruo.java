package com.example.pmdm2324.ut04.a2MonstruoFrag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.a8Objetos.Monstruo;

public class u4aFragMonstruo extends AppCompatActivity {
    private static final String UP_LEFT = "Arriba Izquierda";
    private static final String UP_RIGHT = "Arriba Derecha";
    private static final String DOWN_LEFT = "Abajo Izquierda";
    private static final String DOWN_RIGHT = "Abajo Derecha";
    EditText etNombre, etMiembros, etColor;
    Spinner spEleccionFrag;
    Button btGenerar;
    u4a2Montruo_Fragment fgAD, fgAI, fgDD, fgDI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a_frag_monstruo);

        etNombre = findViewById(R.id.u4a2etNombre);
        etMiembros = findViewById(R.id.u4a2etNumMmbrs);
        etColor = findViewById(R.id.u4a2etColor);
        btGenerar = findViewById(R.id.u4a2btGenerar);
        spEleccionFrag = findViewById(R.id.u4a2spEleccion);

        fgDI = (u4a2Montruo_Fragment) getSupportFragmentManager().findFragmentById(R.id.u4a2fcDI);
        fgDD = (u4a2Montruo_Fragment) getSupportFragmentManager().findFragmentById(R.id.u4a2fcDD);
        fgAI = (u4a2Montruo_Fragment) getSupportFragmentManager().findFragmentById(R.id.u4a2fcAI);
        fgAD = (u4a2Montruo_Fragment) getSupportFragmentManager().findFragmentById(R.id.u4a2fcAD);

        String[] fragOpcion = {UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT};

        // Crear un ArrayAdapter utilizando una matriz de elementos y un diseño de spinner predeterminado
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fragOpcion);

        // Especificar el diseño para usar cuando la lista de opciones aparece
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar el adaptador al spinner
        spEleccionFrag.setAdapter(adp);

        btGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                String color = etColor.getText().toString();
                String  etExtrem = etMiembros.getText().toString();
                int extremidades = Integer.parseInt(etExtrem);
                Monstruo miMonstruo = new Monstruo(nombre, extremidades, color);
                if(spEleccionFrag.getSelectedItem().equals(UP_LEFT)){
                    fgAI.setMonstruo(miMonstruo);
                } else if (spEleccionFrag.getSelectedItem().equals(UP_RIGHT)) {
                    fgAD.setMonstruo(miMonstruo);
                } else if (spEleccionFrag.getSelectedItem().equals(DOWN_LEFT)) {
                    fgDI.setMonstruo(miMonstruo);
                } else if (spEleccionFrag.getSelectedItem().equals(DOWN_RIGHT)) {
                    fgDD.setMonstruo(miMonstruo);
                }
            }
        });
    }
}