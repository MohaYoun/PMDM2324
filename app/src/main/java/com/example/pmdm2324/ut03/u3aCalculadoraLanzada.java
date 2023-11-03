package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3aCalculadoraLanzada extends AppCompatActivity {
    TextView tvSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_calculadora_lanzada);

        tvSalida = findViewById(R.id.u3aCalculadoraLanzadatvSalida);

        Bundle info = getIntent().getExtras();
        if (info != null) {
            String reslt = info.getString(u3aCalculadoraLanza.SOLUCION);
            tvSalida.setText(String.valueOf(reslt));
        }
    }
}
