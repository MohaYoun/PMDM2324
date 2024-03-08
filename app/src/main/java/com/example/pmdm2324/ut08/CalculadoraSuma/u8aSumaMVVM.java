package com.example.pmdm2324.ut08.CalculadoraSuma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut08.MVVM.u8aNumAleatorioViewModel;

public class u8aSumaMVVM extends AppCompatActivity {
    public static String n1 = "";
    public static String n2 = "";
    EditText num1, num2;
    TextView tvResultado;
    Button btSuma;
    ProgressBar pbCarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a_suma_mvvm);

        num1 = findViewById(R.id.u8aSumaMVVMetNum1);
        num2 = findViewById(R.id.u8aSumaMVVMetNum2);
        tvResultado = findViewById(R.id.u8aSumaMVVMtvResultado);
        btSuma = findViewById(R.id.u8aSumaMVVMbtSuma);
        pbCarga = findViewById(R.id.u8aSumaMVVMpb1);

        u8ViewModelSuma vm = new ViewModelProvider(this).get(u8ViewModelSuma.class);

        // Mover la obtención de valores dentro del OnClickListener
        pbCarga.setVisibility(View.INVISIBLE);
        btSuma.setOnClickListener((v) -> {
            n1 = num1.getText().toString();
            n2 = num2.getText().toString();

            pbCarga.setVisibility(View.VISIBLE);
            tvResultado.setVisibility(View.INVISIBLE);
            btSuma.setEnabled(false);
            vm.sumaNumero(n1, n2);
        });

        vm.getNumero().observe(this, integer -> {
            // Actualizar la interfaz
            if (integer == u8ViewModelSuma.FAIL) {
                tvResultado.setText("");
            } else {
                tvResultado.setText("" + integer);
            }
            pbCarga.setVisibility(View.INVISIBLE);
            tvResultado.setVisibility(View.VISIBLE);
            btSuma.setEnabled(true);
        });
    }
}