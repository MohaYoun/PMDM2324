package com.example.pmdm2324.ut03.a5Fibonacci;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a5Fibonacci extends AppCompatActivity {
    TextView tvNum1, tvNum2;
    Button btSiguiente;
    ActivityResultLauncher<Intent> lanzador;
    public static final String CLAVE_NUMERO1 = "n1";
    public static final String CLAVE_NUMERO2 = "n2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_fibonacci);

        tvNum1 = findViewById(R.id.u3a5tvNumero1);
        tvNum2 = findViewById(R.id.u3a5tvNumero2);
        btSiguiente = findViewById(R.id.u3a5btSiguiente);

        btSiguiente.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a5Dev.class);
            String n1 = tvNum1.getText().toString();
            String n2 = tvNum2.getText().toString();
            i.putExtra(u3a5Fibonacci.CLAVE_NUMERO1, n1);
            i.putExtra(u3a5Fibonacci.CLAVE_NUMERO2, n2);
            lanzador.launch(i);
        });

        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent dato = result.getData();
                if(result.getResultCode() == Activity.RESULT_OK){
                    String suma = dato.getStringExtra(u3a5Dev.CLAVE_NUMERO);
                    tvNum1.setText(tvNum2.getText().toString());
                    tvNum2.setText(suma);
                }
            }
        });
    }
}