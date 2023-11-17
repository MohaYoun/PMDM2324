package com.example.pmdm2324.ut03.a6ContLetras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.a6ContLetras.u3a6ContLetras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class u3a6DevContLetras extends AppCompatActivity {

    public static final String CLAVE_ANALISIS = "letrascontadas";
    private static  final int LETRAS_A_PASAR = 3;
    TextView tvLista;
    Button btFinalizar;

    // Declaración de un LinkedHashMap para almacenar las letras y sus conteos
    LinkedHashMap<Character, Integer> mapa = new LinkedHashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_dev_cont_letras);

        tvLista = findViewById(R.id.u3a6tvAnalisisCompl);
        btFinalizar = findViewById(R.id.u3a6btFinAnalisis);

        Bundle info = getIntent().getExtras();
        String texto = info.getString(u3a6ContLetras.FRASE);

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                if (mapa.containsKey(c)) {
                    mapa.put(c, mapa.get(c) + 1);
                } else {
                    mapa.put(c, 1);
                }
            }
        }
        // Ordena la lista de acuerdo a la frecuencia de las letras
        List<Map.Entry<Character, Integer>> lista = new ArrayList<>(mapa.entrySet());
        Collections
                .sort(lista, (o1, o2) -> o2.getValue()
                .compareTo(o1.getValue()));
        /*Collections.sort(lista, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });*/
        // Mostrar todas las letras y sus recuentos en el TextView
        StringBuilder sb = new StringBuilder();
        /*Utilizando un bucle for-each tradicional:
        for (Map.Entry<Character, Integer> entry : lista) {
            sb.append("Letra "+ entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }*/
        //utilizando el método forEach de la interfaz Map:
        lista.forEach(entry -> sb.append("Letra ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));

        tvLista.setText(sb.toString());

        // Lógica para devolver los datos a la actividad principal
        btFinalizar.setOnClickListener(view -> {
            // Obtener las tres letras más repetidas
            List<Map.Entry<Character, Integer>> tresMasListadas = lista.subList(0, Math.min(lista.size(), LETRAS_A_PASAR));
            StringBuilder sb2 = new StringBuilder();
            // Construir una cadena de texto con las tres letras más repetidas
            for (Map.Entry<Character, Integer> entry : tresMasListadas) {
                sb2.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            // Crear un Intent y pasar los datos a la actividad principal
            Intent dato = new Intent();
            dato.putExtra(CLAVE_ANALISIS, sb2.toString());
            setResult(Activity.RESULT_OK, dato);
            finish();
        });
    }
}