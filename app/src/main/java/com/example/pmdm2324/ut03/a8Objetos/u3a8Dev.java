package com.example.pmdm2324.ut03.a8Objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a8Dev extends AppCompatActivity {
    TextView tvMonstruo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_dev);

        tvMonstruo = findViewById(R.id.u3a8tvMonstruo);

        Intent intent = getIntent();
        Monstruo monstruito = (Monstruo) intent.getSerializableExtra(Monstruo.CLAVE_MONSTRUO);
        String color = monstruito.getColor();
        tvMonstruo.setText(monstruito.toString());
        tvMonstruo.setTextColor(Color.parseColor(color));
    }
}