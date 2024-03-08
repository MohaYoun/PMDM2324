package com.example.pmdm2324.ut08.MVVM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u8aNumeroAleatorio extends AppCompatActivity {
    TextView tvNumero;
    Button btGenerar;
    ProgressBar pbCargando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a_numero_aleatorio);

        tvNumero = findViewById(R.id.u8aNAtvNumero);
        btGenerar = findViewById(R.id.u8aNAbtGen);
        pbCargando = findViewById(R.id.u8aNApbCargando);

        u8aNumAleatorioViewModel vm = new ViewModelProvider(this).get(u8aNumAleatorioViewModel.class);

        vm.getNumero().observe(this, integer -> {
            // Actualizar la interfaz
            if(integer == u8aNumAleatorioViewModel.FAIL){
                tvNumero.setText("Error en el acceso a los datos");
            }else{
                tvNumero.setText(""+integer);
            }

            pbCargando.setVisibility(View.INVISIBLE);
            tvNumero.setVisibility(View.VISIBLE);
            btGenerar.setEnabled(true);
        });
        btGenerar.setEnabled(false);

        btGenerar.setOnClickListener((v)->{

            pbCargando.setVisibility(View.VISIBLE);
            tvNumero.setVisibility(View.INVISIBLE);
            btGenerar.setEnabled(false);
            vm.cargaNumero();
        });

    }
}