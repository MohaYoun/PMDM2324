package com.example.pmdm2324.ut03.a1Lanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;

public class u3aLanza extends AppCompatActivity {
    public static final String INFO_NOMBRE = "CLAVE_NOMBRE";
    Button tvLanza;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_lanza);
        tvLanza = findViewById(R.id.u3aLanzabtSaludar);
        etNombre = findViewById(R.id.u3aLaLanzaetNombre);
        tvLanza.setOnClickListener(view ->{
            Intent i = new Intent(this, u3aLaLanzada.class);
            i.putExtra(INFO_NOMBRE, etNombre.getText().toString());
            startActivity(i);
        });
    }
}