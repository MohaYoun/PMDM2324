package com.example.pmdm2324.ut03.a7MetalSlug;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pmdm2324.R;

public class u3a7Armas extends AppCompatActivity {
    public static final String IMG_ARMAS = "imagenarma";
    Button btLimpArm, btCancArm;
    ImageView imgAK, imgUMP, imgM4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_armas);

        imgAK = findViewById(R.id.u3a7ivAk47);
        imgUMP = findViewById(R.id.u3a7ivUmp);
        imgM4 = findViewById(R.id.u3a7ivM4);
        btLimpArm = findViewById(R.id.u3a7btLimpSelecArma);
        btCancArm = findViewById(R.id.u3a7btCancSelecArma);

        Intent i = new Intent(this, u3a7MetalSlug.class);
        imgAK.setOnClickListener(v ->{
            i.putExtra(u3a7Armas.IMG_ARMAS, R.drawable.ak47);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        imgM4.setOnClickListener(v ->{
            i.putExtra(u3a7Armas.IMG_ARMAS, R.drawable.m4_a1);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        imgUMP.setOnClickListener(v ->{
            i.putExtra(u3a7Armas.IMG_ARMAS, R.drawable.ump);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
        btLimpArm.setOnClickListener(v -> {
            i.putExtra(u3a7Armas.IMG_ARMAS, R.drawable.transparente);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
    }
}