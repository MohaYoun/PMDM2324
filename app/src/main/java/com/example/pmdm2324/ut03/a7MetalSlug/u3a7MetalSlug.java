package com.example.pmdm2324.ut03.a7MetalSlug;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a7MetalSlug extends AppCompatActivity {
    public static final String NOMB_PERSONAJE = "nombrepersonaje";
    ImageView imgPersonaje1, imgArma1, imgPersonaje2, imgArma2;
    Button btPersonaje1, btArma1, btPersonaje2, btArma2;
    TextView tvPer1, tvPer2, tvArm1, tvArm2;
    ActivityResultLauncher<Intent> lanzP1, lanzP2, lanzAr1, lanzAr2;
    String nombPersonaje1 = "";
    String nombPersonaje2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_metal_slug);

        imgPersonaje1 = findViewById(R.id.u3a7ivPersonaje1);
        imgArma1 = findViewById(R.id.u3a7ivArma1);
        imgPersonaje2 = findViewById(R.id.u3a7ivPersonaje2);
        imgArma2 = findViewById(R.id.u3a7ivArma2);
        btPersonaje1 = findViewById(R.id.u3a7btSelPers1);
        btArma1 = findViewById(R.id.u3a7btSelArma1);
        btPersonaje2 = findViewById(R.id.u3a7btSelPers2);
        btArma2 = findViewById(R.id.u3a7btSelArma2);
        tvPer1 = findViewById(R.id.u3a7tvPers1);
        tvPer2 = findViewById(R.id.u3a7tvPers2);
        tvArm1 = findViewById(R.id.u3a7tvArma1);
        tvArm2 = findViewById(R.id.u3a7tvArma2);

        lanzP1= registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            nombPersonaje1 = dato.getExtras().getString(u3a7Personajes.NOMBRE_PERSONAJE);
                            imgPersonaje1.setImageResource(dato.getExtras().getInt(u3a7Personajes.IMG_PERSONAJE));
                        }
                    }
                });
        lanzP2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            nombPersonaje2 = dato.getExtras().getString(u3a7Personajes.NOMBRE_PERSONAJE);
                            imgPersonaje2.setImageResource(dato.getExtras().getInt(u3a7Personajes.IMG_PERSONAJE));
                           /* if (img.equals("tr")) {
                                imgPersonaje2.setImageResource(R.drawable.tarma_roving);
                                tvPer2.setText("Tarma Roving");
                            } else if (img.equals("rj")) {
                                imgPersonaje2.setImageResource(R.drawable.ralfjones);
                                tvPer1.setText("Ralf Jones");
                            }else if (img.equals("gdm")) {
                                imgPersonaje2.setImageResource(R.drawable.donald_morden);
                                tvPer1.setText("General D.Morden");
                            }else if (img.equals("hyk")) {
                                imgPersonaje2.setImageResource(R.drawable.hyakutaro_ichimonji);
                                tvPer1.setText("Hyakutaro ichimonji");
                            }else if(img.equals("clr")){
                                imgPersonaje2.setImageResource(R.drawable.transparente);
                                tvPer2.setText("Personaje2");
                            }*/
                        }
                    }
                });
        // Tienes que mandarle el nombPersonaje2 para que te bloquee la imagen
        // que ha elegido el jugador numero2
        btPersonaje1.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a7Personajes.class);
            i.putExtra(NOMB_PERSONAJE, nombPersonaje2);
            lanzP1.launch(i);
        });
        btPersonaje2.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a7Personajes.class);
            i.putExtra(NOMB_PERSONAJE, nombPersonaje1);
            lanzP2.launch(i);
        });

        btArma1.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a7Armas.class);
            lanzAr1.launch(i);
        });
        lanzAr1 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            imgArma1.setImageResource(dato.getExtras().getInt(u3a7Armas.IMG_ARMAS));
                        }
                    }
                });
        btArma2.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a7Armas.class);
            lanzAr2.launch(i);
        });
        lanzAr2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            imgArma2.setImageResource(dato.getExtras().getInt(u3a7Armas.IMG_ARMAS));
                            /*
                            String imgArma = dato.getStringExtra(u3a7Armas.IMG_ARMAS);
                            if(imgArma.equals("ak")){
                                imgArma2.setImageResource(R.drawable.ak47);
                                tvArm2.setText("AK");
                            }else if(imgArma.equals("m4")){
                                imgArma2.setImageResource(R.drawable.m4_a1);
                                tvArm2.setText("M4");
                            }else if(imgArma.equals("ump")){
                                imgArma2.setImageResource(R.drawable.ump);
                                tvArm1.setText("UMP");
                            }else if(imgArma.equals("clr")){
                                imgArma2.setImageResource(R.drawable.transparente);
                                tvArm1.setText("Arma2");
                            }*/
                        }
                    }
                });

    }
}