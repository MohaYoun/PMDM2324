package com.example.pmdm2324.ut04.fragmentsComplejo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u4aFragComplej extends AppCompatActivity {
    ImageView estrella;
    u4aFC_holamundo fragment;
    TextView color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a_fragcomplej);

        estrella = findViewById(R.id.u4aFragComplejIVestrella);
        color = findViewById(R.id.u4aFCtvcolor);

        //getFragmentManager().getFragments() // Esto devuelve list
        fragment = (u4aFC_holamundo) getSupportFragmentManager().findFragmentById(R.id.u4aFragComplejFC1);

        estrella.setOnClickListener((View)->{
            fragment.setColor(0x77, 0xFF, 00, 0xFF);
            fragment.setText("Truco de magia con esta cadena mágica");
        });

        fragment.setColorChangeListener(
                (int c)-> color.setText("Funciona asqueroso" + String.valueOf(c))
        );
    }
}