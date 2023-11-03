package com.example.pmdm2324.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a4Lanza extends AppCompatActivity {

    Button btObtenerNombre;
    TextView tvNombre;
    ActivityResultLauncher<Intent> lanzador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_lanza);

        btObtenerNombre = findViewById(R.id.u3a4btNombre);
        tvNombre = findViewById(R.id.u3a4tvNombre);

        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent dato = result.getData();
                            tvNombre.setText(dato.getStringExtra(u3a4DevResultado.CLAVE_NOMBRE));
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                            Intent dato = result.getData();
                            tvNombre.setText(dato.getStringExtra(u3a4DevResultado.CLAVE_NOMBRE));
                        }
                    }
                }
        );
        btObtenerNombre.setOnClickListener(view ->{
            Intent i = new Intent(this,u3a4DevResultado.class);
            lanzador.launch(i);
        });
    }
}