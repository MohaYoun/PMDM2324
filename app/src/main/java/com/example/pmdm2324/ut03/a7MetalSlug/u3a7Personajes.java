package com.example.pmdm2324.ut03.a7MetalSlug;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm2324.R;

public class u3a7Personajes extends AppCompatActivity {
    ImageButton imgTR, imgRJ, imgHyk, imgGDM;
    Button btLimpPers, btCancPers;
    public static final String IMG_PERSONAJE = "IMGPERSONAJE";
    public static final String NOMBRE_PERSONAJE = "NOMBREPERSONAJE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_personajes);

        imgGDM = findViewById(R.id.u3a7ivGDM);
        imgHyk = findViewById(R.id.u3a7ivHyakutaro);
        imgRJ = findViewById(R.id.u3a7ivRalfJones);
        imgTR = findViewById(R.id.u3a7ivTarmaRoving);
        btCancPers = findViewById(R.id.u3a7btCancSelecPers);
        btLimpPers = findViewById(R.id.u3a7btLimpSelecPers);

        String nombrePersonaje = getIntent().getStringExtra(u3a7MetalSlug.NOMB_PERSONAJE);
        if(nombrePersonaje.equals("RJ")){
            imgRJ.setEnabled(false);
            imgRJ.setBackgroundColor(Color.GRAY);
        }
        if(nombrePersonaje.equals("TR")){
            imgTR.setEnabled(false);
            imgTR.setBackgroundColor(Color.GRAY);
        }
        if(nombrePersonaje.equals("GDM")){
            imgGDM.setEnabled(false);
            imgGDM.setBackgroundColor(Color.GRAY);
        }
        if(nombrePersonaje.equals("HYK")){
            imgHyk.setEnabled(false);
            imgHyk.setBackgroundColor(Color.GRAY);
        }
        Intent i = new Intent(this, u3a7MetalSlug.class);
        imgRJ.setOnClickListener(v -> {
            i.putExtra(IMG_PERSONAJE, R.drawable.ralfjones);
            i.putExtra(NOMBRE_PERSONAJE, "RJ");
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        imgTR.setOnClickListener(v -> {
            i.putExtra(IMG_PERSONAJE, R.drawable.tarma_roving);
            i.putExtra(NOMBRE_PERSONAJE, "TR");
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        imgGDM.setOnClickListener(v -> {
            i.putExtra(IMG_PERSONAJE, R.drawable.donald_morden);
            i.putExtra(NOMBRE_PERSONAJE, "GDM");
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        imgHyk.setOnClickListener(v -> {
            i.putExtra(IMG_PERSONAJE, R.drawable.hyakutaro_ichimonji);
            i.putExtra(NOMBRE_PERSONAJE, "HYK");
            setResult(Activity.RESULT_OK, i);
            finish();
        });

        btLimpPers.setOnClickListener(v -> {
            i.putExtra(IMG_PERSONAJE, R.drawable.transparente);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        btCancPers.setOnClickListener(v -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}