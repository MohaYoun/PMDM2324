package com.example.pmdm2324.ut03.a8Objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a8Monstruo extends AppCompatActivity {
    Button btGenerar;
    EditText etNum, etNombre, etColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_monstruo);

        btGenerar = findViewById(R.id.u3a8btGenerar);
        etNum = findViewById(R.id.u3a8etNumMmbrs);
        etNombre = findViewById(R.id.u3a8etNombre);
        etColor = findViewById(R.id.u3a8etColor);

        btGenerar.setOnClickListener((v) -> {
            String nombre = etNombre.getText().toString();
            String color = etColor.getText().toString();
            String  etExtrem = etNum.getText().toString();
            int extremidades = Integer.parseInt(etExtrem);
            Monstruo miMonstruo = new Monstruo(nombre,extremidades, color);

            Intent i = new Intent(this, u3a8Dev.class);
            i.putExtra(Monstruo.CLAVE_MONSTRUO, miMonstruo);
            startActivity(i);
        });


    }
}