package com.example.pmdm2324.ut02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm2324.R;

import java.util.Arrays;

import kotlin.jvm.internal.Lambda;

public class u2Propinator2000 extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btCorregir, bt0, btBorrar, btSalida;
    TextView tvSalida, tvSalidaTotal;
    RadioButton rbBueno, rbMalo, rbExcelente;
    View.OnClickListener manejador;

    String pulsado, pulsadoConcatenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2_propinator2000);

        bt0=findViewById(R.id.u2aPropinatorbtZero);
        bt1=findViewById(R.id.u2aPropinatorbtUno);
        bt2=findViewById(R.id.u2aPropinatorbtDos);
        bt3=findViewById(R.id.u2aPropinatorbtTres);
        bt4=findViewById(R.id.u2aPropinatorbtCuatro);
        bt5=findViewById(R.id.u2aPropinatorbtCinco);
        bt6=findViewById(R.id.u2aPropinatorbtSeis);
        bt7=findViewById(R.id.u2aPropinatorbtSiete);
        bt8=findViewById(R.id.u2aPropinatorbtOcho);
        bt9=findViewById(R.id.u2aPropinatorbtNueve);
        btCorregir=findViewById(R.id.u2aPropinatorbtCorregir);
        btBorrar=findViewById(R.id.u2aPropinatorbtBorrar);
        btSalida=findViewById(R.id.u2aPropinatorbtPropina);
        tvSalida=findViewById(R.id.u2aPropinatortvSalida);
        tvSalidaTotal=findViewById(R.id.u2aPropinatortvTotal);
        rbBueno=findViewById(R.id.u2aPropinatorRbBueno);
        rbMalo=findViewById(R.id.u2aPropinatorRbMalo);
        rbExcelente=findViewById(R.id.u2aPropinatorRbExcelente);

        manejador = (View elPulsado) -> { // Manejador Lambda
            Button btnelPulsado = (Button) elPulsado;
            /*
            pulsado = btnelPulsado.getText().toString();
            pulsadoConcatenado = tvSalida.getText().toString() + pulsado;
            tvSalida.setText(pulsadoConcatenado);*/
            tvSalida.append(btnelPulsado.getText().toString());
        };
        /* Normal, no landa;
        manejador = new View.OnClickListener() {
            @Override
            public void onClick(View elPulsado) {
                Button botonPulsado = (Button) elPulsado;
                String numero = botonPulsado.getText().toString();
                String precioStr = tvSalida.getText().toString() + numero;
                tvSalida.setText(precioStr);
            }
        };*/

        bt0.setOnClickListener(manejador);
        bt1.setOnClickListener(manejador);
        bt2.setOnClickListener(manejador);
        bt3.setOnClickListener(manejador);
        bt4.setOnClickListener(manejador);
        bt5.setOnClickListener(manejador);
        bt6.setOnClickListener(manejador);
        bt7.setOnClickListener(manejador);
        bt8.setOnClickListener(manejador);
        bt9.setOnClickListener(manejador);


        btCorregir.setOnClickListener(new View.OnClickListener() {// Manejar el botón "Borrar" para eliminar un dígito
            @Override
            public void onClick(View v) {
                pulsadoConcatenado = tvSalida.getText().toString();
                if (!pulsadoConcatenado.isEmpty()) {
                    // Eliminar el último dígito del precio
                    pulsadoConcatenado = pulsadoConcatenado.substring(0, pulsadoConcatenado.length() - 1);
                    tvSalida.setText(pulsadoConcatenado);
                }
            }
        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSalida.setText(""); // Borrar todo el contenido
            }
        });

        btSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsadoConcatenado = tvSalida.getText().toString();
                if (!pulsadoConcatenado.isEmpty()) {
                    double precio = Double.parseDouble(pulsadoConcatenado);
                    double propinaPorcentaje = 0.0;

                    if (rbMalo.isChecked()) {
                        propinaPorcentaje = 0.10; // 10% para malo
                    } else if (rbBueno.isChecked()) {
                        propinaPorcentaje = 0.15; // 15% para bueno
                    } else if (rbExcelente.isChecked()) {
                        propinaPorcentaje = 0.20; // 20% para excelente
                    }

                    // Calcular la propina
                    double propina = precio * propinaPorcentaje;
                    double precioTotal = precio + propina;
                    tvSalidaTotal.setText(String.format("Total con Propina: %.2f€", precioTotal));
                }
            }
        });
        /*
            btSalida.setOnClickListener(new View.OnClickListener() {// Manejar el botón "Calcular Propina"
            @Override
            public void onClick(View v) {
                String precioStr = tvSalida.getText().toString();
                if (!precioStr.isEmpty()) {
                    double precio = Double.parseDouble(precioStr);
                    double propina = calcularPropina(precio);
                    double precioTotal = precio + propina;
                    tvSalidaTotal.setText(String.format("Total: %.2f€", precioTotal));
                }
            }
        });*/

    };
    private double calcularPropina(double precio) {
        double propinaPorcentaje = 0.0;

        if (rbMalo.isChecked()) {
            propinaPorcentaje = 0.10; // 10% para malo
        } else if (rbBueno.isChecked()) {
            propinaPorcentaje = 0.15; // 15% para bueno
        } else if (rbExcelente.isChecked()) {
            propinaPorcentaje = 0.20; // 20% para excelente
        }

        // Calcular la propina
        return precio * propinaPorcentaje;
    }
}
