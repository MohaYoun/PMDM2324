package com.example.pmdm2324.ut01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u1aAdivinaNumero extends AppCompatActivity {
    final int MAX_VIDAS=6;
    final int MIN_VIDAS=0;
    boolean fin = false;
    Button btReset, btInsert;
    TextView tvLives,tvStatus;
    EditText etEntrada;
    int num_random = (int) (Math.random() * 101);
    int vidas = MAX_VIDAS;
    private String VIDAS_RESTANTES = "Numero de vidas restantes: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u1a_adivina_numero);
         btInsert = findViewById(R.id.u1aAdivinabtInserta);
         btReset = findViewById(R.id.u1aAdivinabtReset);
         tvLives = findViewById(R.id.u1aAdivinatvVidas);
         tvStatus = findViewById(R.id.u1aAdivinatvPista);
         etEntrada = findViewById(R.id.u1aAdivinaetInserta);



         tvLives.setText(VIDAS_RESTANTES + vidas);  // Aqui era necesario hacer un getString

         btInsert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(vidas > 0){
                     vidas -= 1;
                 }
                 tvLives.setText(VIDAS_RESTANTES + vidas);
                 if(vidas <= MIN_VIDAS ){
                     tvStatus.setText("Se te acabron las oportunidades.");
                 } else if (num_random > Integer.parseInt(etEntrada.getText().toString())&& !fin) {
                     tvStatus.setText("El numero es elevado al resultado.");
                 }else if (num_random < Integer.parseInt(etEntrada.getText().toString())&& !fin) {
                     tvStatus.setText("El numero es menor al resultado.");
                 }else if (num_random == Integer.parseInt(etEntrada.getText().toString())&& !fin) {
                     tvStatus.setText("¡¡ENHORABUENA HAS ACERTADO EL NUMEROO!!");
                 }
             }
         });

         btReset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 num_random = (int) (Math.random() * 101);
                 vidas = MAX_VIDAS;
                 tvStatus.setText("");
                 tvLives.setText(VIDAS_RESTANTES + vidas);
                 etEntrada.setText("");
                 fin=false;
             }
         });

    }
}