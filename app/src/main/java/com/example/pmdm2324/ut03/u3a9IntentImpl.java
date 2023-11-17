package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a9IntentImpl extends AppCompatActivity {
    Button btCancion, btLlamada, btMensaje, btCamara;
    TextView tvSalError;
    public  static  final String ERROR_SOLICITUD = "Error, no resuelse la solicitud";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a9_intent_impl);

        btCancion = findViewById(R.id.u3a9btCancion);
        btCamara = findViewById(R.id.u3a9btCamara);
        btLlamada = findViewById(R.id.u3a9btLlamar);
        btMensaje = findViewById(R.id.u3a9btMensaje);
        tvSalError = findViewById(R.id.u3a9tvError);

        tvSalError.setText(ERROR_SOLICITUD);

        btLlamada.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + "666"));
            if(i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }else {tvSalError.getText().toString();}
        });
        btMensaje.setOnClickListener(v ->{
            //Uri uri = Uri.parse("mailto:preuba@gmail.com"); // Para abrir Gmail
            //i.putExtra("mail_body", "Te veo hoy a las 6pm.");
            Uri uri = Uri.parse("smsto:666111222");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            i.putExtra("sms_body", "Te veo hoy a las 6pm.");
            if(getIntent().resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }else {tvSalError.getText().toString();}
        });
        btCancion.setOnClickListener(v -> {
            String url = "https://www.youtube.com/watch?v=T8nbNQpRwNo";
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY, url);
            if(i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }else {tvSalError.getText().toString();}
        });
        btCamara.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }else{tvSalError.getText().toString();}
        });
    }
}