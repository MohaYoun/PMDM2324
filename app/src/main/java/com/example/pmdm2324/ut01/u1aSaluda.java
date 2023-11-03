package com.example.pmdm2324.ut01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u1aSaluda extends AppCompatActivity {
    Button btSaluda;
    TextView tvSalida;
    EditText etEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u1a_saluda);
        btSaluda = findViewById(R.id.u1aSaludabtSaluda);
        tvSalida = findViewById(R.id.u1aSaludatvSalida);
        etEntrada = findViewById(R.id.u1aSaludaetEntrada);

        btSaluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEntrada.getText().toString().isEmpty()){
                    tvSalida.setText("Hola Mundo");
                } else {
                    tvSalida.setText("Hola "+etEntrada.getText());
                }
            }
        });
    }
}