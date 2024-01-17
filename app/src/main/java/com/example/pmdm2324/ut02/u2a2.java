package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u2a2 extends AppCompatActivity {

    private static final int RANGO_MAX_COLOR = 255;
    TextView tvSalida;
    EditText etEntrada;
    Switch swConst;
    SeekBar skR, skG, skB;
    Button btGenera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2);

        etEntrada=findViewById(R.id.u2a2etEntrada);
        tvSalida = findViewById(R.id.u2a2tvSalida);
        swConst = findViewById(R.id.u2a2swContraste);
        skR = findViewById(R.id.u2a2sbR);
        skG = findViewById(R.id.u2a2sbG);
        skB = findViewById(R.id.u2a2sbB);
        btGenera = findViewById(R.id.u2a2btGenerar);
        skR.setMax(RANGO_MAX_COLOR);
        skG.setMax(RANGO_MAX_COLOR);
        skB.setMax(RANGO_MAX_COLOR);



        skR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                skR.getProgress();
                //actColorFondo();// Para que me lo muestre en tiempo real la funcion esta abajo
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        skB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                skB.getProgress();
                //actColorFondo();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        skG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //actColorFondo();
                skG.getProgress();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        swConst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(swConst.isChecked()){
                    tvSalida.setTextColor(Color.WHITE);
                }else{
                    tvSalida.setTextColor(Color.BLACK);
                }
            }
        });
        btGenera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = skR.getProgress();
                int green = skG.getProgress();
                int blue = skB.getProgress();

                int color = Color.rgb(red, green, blue);
                tvSalida.setText(etEntrada.getText().toString());
                tvSalida.setBackgroundColor(color);
            }
        });

    }

    private void actColorFondo() {
        int red = skR.getProgress();
        int green = skG.getProgress();
        int blue = skB.getProgress();

        int color = Color.rgb(red, green, blue);
        tvSalida.setText(etEntrada.getText().toString());
        tvSalida.setBackgroundColor(color);
    }
}