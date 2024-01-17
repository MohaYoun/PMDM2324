package com.example.pmdm2324.ut03.a6ContLetras;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a6ContLetras extends AppCompatActivity {
    TextView tvListaFinal;
    EditText etEntrada;
    Button btLanza;
    ActivityResultLauncher<Intent> lanzador;
    public static final String FRASE = "fraseaenviar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_cont_letras);

        tvListaFinal = findViewById(R.id.u3a6tvLista);
        etEntrada = findViewById(R.id.u3a6etEntrada);
        btLanza = findViewById(R.id.u3a6btLanzar);

        btLanza.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a6DevContLetras.class);
            i.putExtra(FRASE, etEntrada.getText().toString());
            lanzador.launch(i);
        });

        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            tvListaFinal.setText(dato.getStringExtra(u3a6DevContLetras.CLAVE_ANALISIS));
                        }
                    }
                });


    }
}