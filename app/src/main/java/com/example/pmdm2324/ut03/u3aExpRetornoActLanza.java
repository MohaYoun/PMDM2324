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

public class u3aExpRetornoActLanza extends AppCompatActivity {
    Button btObtenerNumero;
    TextView tvNumero;
    TextView tvSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_exp_retorno);

        btObtenerNumero = findViewById(R.id.u3aERAbtNumero);
        tvNumero = findViewById(R.id.u3aERAtvNumero);
        tvSMS = findViewById(R.id.u3aERAtvSMS);

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            tvNumero.setText(data.getStringExtra(u3aExpRetornoActLanzada.CLAVE_NUMERO));
                            tvSMS.setText("");
                            tvSMS.setTextColor(Color.GREEN);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            tvSMS.setText("El usuario ha cancelado la operación");
                            tvSMS.setTextColor(Color.RED);
                        } else {
                            tvSMS.setText("No obtenemos código");
                            tvSMS.setTextColor(Color.RED);
                        }
                    }
                }
        );
        btObtenerNumero.setOnClickListener(view->{
            // Ojo con ese this
            Intent i = new Intent(this, u3aExpRetornoActLanzada.class);
            lanzador.launch(i);
        });
    }
}