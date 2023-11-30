package com.example.pmdm2324.ut03.a3Heladeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pmdm2324.R;

public class u3aHelados extends AppCompatActivity {
    EditText numVainilla, numFresa, numChoco;
    Spinner eleccionSpinner;
    Button btGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a_helados);
        numVainilla = findViewById(R.id.u3aHeladosEtVainilla);
        numChoco = findViewById(R.id.u3aHeladosEtChoco);
        numFresa = findViewById(R.id.u3aHeladosEtFresa);
        btGenerar = findViewById(R.id.u3aHeladosBtGenerar);
        eleccionSpinner = findViewById(R.id.u3aHeladosSpnTipo);

        String [] tipoHelado = {"Cucurucho", "ChocoCucurucho", "Tarrina"};
        // Crear un ArrayAdapter utilizando una matriz de elementos y un diseño de spinner predeterminado
        /*ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.tipoHelado, android.R.layout.simple_spinner_item);*/
        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tipoHelado);

        // Especificar el diseño para usar cuando la lista de opciones aparece
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar el adaptador al spinner
        eleccionSpinner.setAdapter(adaptador);

        btGenerar.setOnClickListener((View v) ->{
            if(numFresa.getText().toString().isEmpty()&&numChoco.getText().toString().isEmpty()&&numVainilla.getText().toString().isEmpty()){
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setMessage("Tienes que elegir un por lo menos un sabor.")
                        .setCancelable(true);
                AlertDialog alert = alerta.create();
                alert.show();
            }else {
                Intent i = new Intent(this, u3aHeladosLanza.class);
                Bundle bundle = new Bundle();
                bundle.putInt("fresa", Integer.parseInt(numFresa.getText().toString()));
                bundle.putInt("vainilla", Integer.parseInt(numVainilla.getText().toString()));
                bundle.putInt("choco", Integer.parseInt(numChoco.getText().toString()));
                bundle.putString("tipoHelado", eleccionSpinner.getSelectedItem().toString());
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}