package com.example.pmdm2324.ut03.a3Heladeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3aHeladosLanza extends AppCompatActivity {
    TextView tvBolasFresa, tvBolasVainilla, tvBolasChoco, tvTarrina, tvCucu, tvChocoCucu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_helados_lanza);

        tvBolasFresa = findViewById(R.id.u3aHeladosLanzaTvFresa);
        tvBolasVainilla = findViewById(R.id.u3aHeladosLanzaTvVainilla);
        tvBolasChoco = findViewById(R.id.u3aHeladosLanzaTvChoco);
        tvTarrina = findViewById(R.id.u3aHeladosLanzaTvTarrina);
        tvCucu = findViewById(R.id.u3aHeladosLanzaTvCucurucho);
        tvChocoCucu = findViewById(R.id.u3aHeladosLanzaTvCucuChoco);

        Bundle info = getIntent().getExtras();
        if (info != null) {
            int fresa = info.getInt("fresa");
            int vainilla = info.getInt("vainilla");
            int choco = info.getInt("choco");
            String tipoHelado = info.getString("tipoHelado");

            tvBolasFresa.setText(generarLetras('O', fresa));
            tvBolasVainilla.setText(generarLetras('O', vainilla));
            tvBolasChoco.setText(generarLetras('O', choco));

            if (tipoHelado.equals("Tarrina")) {
                tvTarrina.setText("U");
            } else if (tipoHelado.equals("Cucurucho")) {
                tvCucu.setText("V");
            } else if (tipoHelado.equals("ChocoCucurucho")) {
                tvChocoCucu.setText("V");
            }
        }
    }
    private String generarLetras(char letra, int cantidad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad; i++) {
            sb.append(letra);
        }
        return sb.toString();
    }
}