package com.example.pmdm2324.ut09.ConsumoAPIjorje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm2324.MainActivity;
import com.example.pmdm2324.R;
import com.example.pmdm2324.ut09.ConsumoAPIjorje.data.Personaje;
import com.example.pmdm2324.ut09.ConsumoAPIjorje.data.ServiceRickAndMorty;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class u9aPersonaje1 extends AppCompatActivity {

    EditText etId;
    Button btGet;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9a_personaje1);

        etId = findViewById(R.id.ut09a1_id);
        btGet = findViewById(R.id.ut09a1_get);
        tvInfo = findViewById(R.id.ut09a1_info);

        btGet.setOnClickListener((v)->{
            ServiceRickAndMorty ser = ServiceRickAndMorty.getInstancia();
            Call<Personaje> llamada = ser.getRepo().getCharacter(Integer.parseInt(etId.getText().toString().trim()));

            llamada.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    try {
                        Personaje p = response.body();
                        tvInfo.setText(p.name+"\n"+p.status+"\n"+p.species+"\n"+p.type+"\n"+p.gender);
                    }catch (Exception ex){
                        Toast.makeText(u9aPersonaje1.this, "Fallo en la peticion", Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {
                    Toast.makeText(u9aPersonaje1.this, "Fallo en la conexion", Toast.LENGTH_LONG);
                }
            });
        });
    }
}