package com.example.pmdm2324.ut03.a1Lanza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.a1Lanza.u3aLanza;

public class u3aLaLanzada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_la_lanzada);

        Bundle info = getIntent().getExtras();
        String sInfo = info.getString(u3aLanza.INFO_NOMBRE);
        TextView tv = findViewById(R.id.u3aLaLanzatvSaludo);
        tv.setText(tv.getText() + sInfo);
    }
}