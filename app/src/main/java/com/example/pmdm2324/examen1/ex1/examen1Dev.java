package com.example.pmdm2324.examen1.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class examen1Dev extends AppCompatActivity {

    public static final String MSG_FECHAIDA = "Fecha IDA";
    public static final String MSG_FECHAVUELTA = "Fecha VUELTA";
    TextView tvFinal;
    Button btVolver, btReiniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen1_dev);

        tvFinal = findViewById(R.id.ex1tvMsgFinal);
        btVolver = findViewById(R.id.ex1btVolver);
        btReiniciar = findViewById(R.id.ex1btReiniciar);

        Intent dato = getIntent();
        Viaje elVieje = (Viaje) dato.getSerializableExtra(Viaje.CLAVE_VIAJE);
        tvFinal.setText(elVieje.toString());

        btVolver.setOnClickListener((v) -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
        Intent i = new Intent(this, examenVentaTicket.class);
        btReiniciar.setOnClickListener((v) -> {
            i.putExtra(examenVentaTicket.FECHA_IDA, MSG_FECHAIDA);
            i.putExtra(examenVentaTicket.FECHA_VUELTA, MSG_FECHAVUELTA);
            setResult(Activity.RESULT_FIRST_USER, i);
            finish();
        });
    }
}