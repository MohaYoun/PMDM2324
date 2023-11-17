package com.example.pmdm2324.ut03.a2Calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.pmdm2324.R;

public class u3aCalculadoraLanza extends AppCompatActivity {
    public static final String SOLUCION = "La solucion";
    EditText etnum1,etnum2;
    Button btSalida;
    RadioButton rbSuma,rbResta,rbMult,rbDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a_calculadora_lanza);

        etnum1=findViewById(R.id.u3aCalculadoraLanzaetPrimero);
        etnum2=findViewById(R.id.u3aCalculadoraLanzaetSegundo);
        rbSuma=findViewById(R.id.u3aCalculadoraLanzarbSuma);
        rbResta=findViewById(R.id.u3aCalculadoraLanzarbResta);
        rbMult=findViewById(R.id.u3aCalculadoraLanzarbMult);
        rbDivision=findViewById(R.id.u3aCalculadoraLanzarbDiv);
        btSalida = findViewById(R.id.u3aCalculadoraLanzabtLanza);

        btSalida.setOnClickListener(view ->{
            if((!etnum1.getText().toString().isEmpty()&&!etnum2.getText().toString().isEmpty())&&
                    (rbDivision.isChecked()||rbMult.isChecked()||rbResta.isChecked()||rbSuma.isChecked())) {
                int num1 = Integer.parseInt(etnum1.getText().toString());
                int num2 = Integer.parseInt(etnum2.getText().toString());
                int sol = 0;
                if (rbSuma.isChecked()) {
                    sol = num1 + num2;
                } else if (rbResta.isChecked()) {
                    sol = num1 - num2;
                } else if (rbMult.isChecked()) {
                    sol = num1 * num2;
                } else if (rbDivision.isChecked()) {
                    if (num2 == 0) {
                        btSalida.setVisibility(View.INVISIBLE);
                    } else {
                        btSalida.setVisibility(View.VISIBLE);
                        sol = num1 / num2;
                    }
                }
                Intent i = new Intent(this, u3aCalculadoraLanzada.class);
                i.putExtra(SOLUCION, String.valueOf(sol));
                startActivity(i);
            }else{
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setMessage("No puede haber campos vacios, ni puede haber opciones sin seleccionar.")
                        .setCancelable(false)
                        .setPositiveButton("Vale", (dialog, id) -> dialog.dismiss());
                alerta.setNegativeButton("No", (dialog, id) -> dialog.cancel());
                AlertDialog alert = alerta.create();
                alert.show();
            }
        });


    }
}
