package com.example.pmdm2324.ut03.a5Fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a5Dev extends AppCompatActivity {
    public static final String CLAVE_NUMERO = "SiguiteNumero";
    TextView tvNumFinal;
    Button btAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_dev);

        tvNumFinal = findViewById(R.id.u3a5tvNumeroFinal);
        btAceptar = findViewById(R.id.u3a5btAceptar);

        String numero1 = getIntent().getStringExtra(u3a5Fibonacci.CLAVE_NUMERO1);
        String numero2 = getIntent().getStringExtra(u3a5Fibonacci.CLAVE_NUMERO2);
        int n1 = Integer.parseInt(numero1);
        int n2 = Integer.parseInt(numero2);
        int suma = n1 + n2;
        String sumafinal = String.valueOf(suma);
        tvNumFinal.setText(sumafinal);


        btAceptar.setOnClickListener(view ->{
            Intent dato = new Intent();
            String numero = tvNumFinal.getText().toString();

            dato.putExtra(u3a5Dev.CLAVE_NUMERO, numero);
            setResult(Activity.RESULT_OK, dato);
            finish();
        });
    }
}