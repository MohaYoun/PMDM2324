package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm2324.R;

import java.util.Random;


public class u2aPidraPapelTijera extends AppCompatActivity {

    private static final String OPC_PIEDRA = "piedra";
    private static final String OPC_PAPEL = "papel";
    private static final String OPC_TIJERA = "tijera";
    TextView tvPuntPers, tvPuntMaq, tvResultado;
    ImageView imgPiedra, imgPapel, imgTijera, imgMaq;
    View.OnClickListener manejador;
    Vibrator vibrar;

    private int puntosPersona = 0;
    private int puntosMaquina = 0;
    private boolean finalizado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a_pidra_papel_tijera);

        imgPapel = findViewById(R.id.u2aPPTivPapel);
        imgPiedra = findViewById(R.id.u2aPPTivPiedra);
        imgTijera = findViewById(R.id.u2aPPTivTijera);
        imgMaq = findViewById(R.id.u2aPPTimgMaquina);
        tvPuntMaq = findViewById(R.id.u2aPPTtvPuntMaquina);
        tvPuntPers = findViewById(R.id.u2aPPTtvPuntPersona);
        tvResultado = findViewById(R.id.u2aPPTtvResultado);

        imgPapel.setOnClickListener(v -> jugar(OPC_PAPEL));
        imgPiedra.setOnClickListener(v -> jugar(OPC_PIEDRA));
        imgTijera.setOnClickListener(v -> jugar(OPC_TIJERA));

        vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Button botonReiniciar = findViewById(R.id.u2aPPTbtReiniciar);
        botonReiniciar.setOnClickListener(v -> reiniciarJuego());
    }

    private void jugar(String eleccionPersona) {
        String[] opciones = {OPC_PIEDRA, OPC_PAPEL, OPC_TIJERA};
        Random random = new Random();
        int index = random.nextInt(opciones.length);
        String eleccionMaquina = opciones[index];

        // Lógica de juego
        if (eleccionPersona.equals(OPC_PIEDRA) && eleccionMaquina.equals(OPC_TIJERA) ||
                eleccionPersona.equals(OPC_PAPEL) && eleccionMaquina.equals(OPC_PIEDRA) ||
                eleccionPersona.equals(OPC_TIJERA) && eleccionMaquina.equals(OPC_PAPEL)) {
            puntosPersona++;
            vibracionGanar();
        } else if (eleccionMaquina.equals(OPC_PIEDRA) && eleccionPersona.equals(OPC_TIJERA) ||
                eleccionMaquina.equals(OPC_PAPEL) && eleccionPersona.equals(OPC_PIEDRA) ||
                eleccionMaquina.equals(OPC_TIJERA) && eleccionPersona.equals(OPC_PAPEL)) {
            puntosMaquina++;
            vibracionPerder();
        }

        // Actualizar las vistas
        tvPuntPers.setText(String.valueOf(puntosPersona));
        tvPuntMaq.setText(String.valueOf(puntosMaquina));
        if (eleccionMaquina.equals(OPC_PAPEL)) {
            imgMaq.setImageResource(R.drawable.papel);
        } else if (eleccionMaquina.equals(OPC_PIEDRA)) {
            imgMaq.setImageResource(R.drawable.piedra);
        } else if (eleccionMaquina.equals(OPC_TIJERA)){
            imgMaq.setImageResource(R.drawable.tijera);
        }else{}

        // Lógica de finalización del juego
        if (puntosPersona == 3) {
            tvResultado.setText("¡Has GANADOO!");
            vibracionGanarPartida();
            finalizado=true;
            imgTijera.setVisibility(View.INVISIBLE);
            imgPiedra.setVisibility(View.INVISIBLE);
            imgPapel.setVisibility(View.INVISIBLE);
            imgMaq.setVisibility(View.INVISIBLE);
        } else if (puntosMaquina == 3) {
            tvResultado.setText("¡Has perdido!");
            vibracionPerderPartida();
            finalizado=true;
            imgTijera.setVisibility(View.INVISIBLE);
            imgPiedra.setVisibility(View.INVISIBLE);
            imgPapel.setVisibility(View.INVISIBLE);
            imgMaq.setVisibility(View.INVISIBLE);
        }
    }
    private void reiniciarJuego() {
        if (!finalizado) {
            // Aquí puedes mostrar un diálogo de confirmación antes de reiniciar el juego
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Estás seguro de que deseas reiniciar el juego?")
                    .setCancelable(false)
                    .setPositiveButton("Sí", (dialog, id) -> reiniciar());
            builder.setNegativeButton("No", (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            reiniciar();
        }
    }

    private void reiniciar() {
        puntosPersona = 0;
        puntosMaquina = 0;
        tvPuntPers.setText("0");
        tvPuntMaq.setText("0");
        tvResultado.setText("");
        imgTijera.setVisibility(View.VISIBLE);
        imgPiedra.setVisibility(View.VISIBLE);
        imgPapel.setVisibility(View.VISIBLE);
        imgMaq.setVisibility(View.VISIBLE);
        imgMaq.setImageResource(R.drawable.transparente);
        finalizado = false;
    }
    private void vibracionGanar(){
        if(vibrar.hasVibrator()){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                VibrationEffect efectoVibracion = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE);
                vibrar.vibrate(efectoVibracion);
            }
        }
    }
    private void vibracionPerder(){
        if(vibrar.hasVibrator()){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                VibrationEffect efectoVibracion = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
                vibrar.vibrate(efectoVibracion);
            }
        }
    }
    private void vibracionPerderPartida(){
        if(vibrar.hasVibrator()){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                long[] timings = {0, 500, 200, 0}; // Longitudes de tiempo en milisegundos
            // Crear el efecto de vibración
                VibrationEffect efectoVibracion = VibrationEffect.createWaveform(timings, 2);
                vibrar.vibrate(efectoVibracion);
            }
        }
    }
    private void vibracionGanarPartida(){
        if(vibrar.hasVibrator()){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                long[] timings = {1000, 500, 1000}; // Longitudes de tiempo en milisegundos
                // Crear el efecto de vibración
                VibrationEffect efectoVibracion = VibrationEffect.createWaveform(timings, 1);
                vibrar.vibrate(efectoVibracion);
            }
        }
    }
    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("puntosPersona", puntosPersona);
        outState.putInt("puntosMaquina", puntosMaquina);
        outState.putBoolean("finalizado", finalizado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        puntosPersona = savedInstanceState.getInt("puntosPersona");
        puntosMaquina = savedInstanceState.getInt("puntosMaquina");
        finalizado = savedInstanceState.getBoolean("finalizado");

        tvPuntPers.setText(String.valueOf(puntosPersona));
        tvPuntMaq.setText(String.valueOf(puntosMaquina));
        if (finalizado) {
            if (puntosPersona == 3) {
                tvResultado.setText("¡Has GANADOO!");
            } else if (puntosMaquina == 3) {
                tvResultado.setText("¡Has Perdido!");
            }

            // Aquí puedes realizar cualquier otra operación que necesites cuando el juego esté finalizado, como ocultar vistas, mostrar un mensaje, etc.
            imgTijera.setVisibility(View.INVISIBLE);
            imgTijera.setClickable(false);
            imgPiedra.setVisibility(View.INVISIBLE);
            imgPapel.setVisibility(View.INVISIBLE);
            imgMaq.setVisibility(View.INVISIBLE);
        } else {
            // Si el juego no está finalizado, asegúrate de mostrar las vistas necesarias y restablecer cualquier otro estado según sea necesario.
            imgTijera.setVisibility(View.VISIBLE);
            imgPiedra.setVisibility(View.VISIBLE);
            imgPapel.setVisibility(View.VISIBLE);
            imgMaq.setVisibility(View.VISIBLE);
            tvResultado.setText("");
        }
    }*/

}
