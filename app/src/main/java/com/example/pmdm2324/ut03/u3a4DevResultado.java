package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;

public class u3a4DevResultado extends AppCompatActivity {
    public static final String CLAVE_NOMBRE = "NombreQueRecibimos";
    Button btAceptar;
    Button btLimpiar;
    Button btCancelar;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_resultado);

        btAceptar = findViewById(R.id.u3a4btAceptar);
        btCancelar = findViewById(R.id.u3a4btCancelar);
        btLimpiar = findViewById(R.id.u3a4btLimpiar);
        etNombre = findViewById(R.id.u3a4etNombre);

        btAceptar.setOnClickListener(view ->{
            Intent dato = new Intent();
            dato.putExtra(CLAVE_NOMBRE, etNombre.getText().toString());
            setResult(Activity.RESULT_OK, dato);
            finish();
        });

        btCancelar.setOnClickListener(view ->{
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
        btLimpiar.setOnClickListener(view ->{
            Intent dato = new Intent();
            dato.getBundleExtra(CLAVE_NOMBRE);
            dato.putExtra(CLAVE_NOMBRE, "");
            setResult(Activity.RESULT_FIRST_USER, dato);
            finish();
        });

    }
}