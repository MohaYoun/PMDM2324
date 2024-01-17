package com.example.pmdm2324.ut05.pruebaPermiso;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pmdm2324.R;

public class u5aPruebaPermisos extends AppCompatActivity {
    ActivityResultLauncher<String> requestPermissionLauncher;
    Button btLlamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u5a_prueba_permisos);
        btLlamar = findViewById(R.id.u5aPermisosbtLlamar);

        // Register the permissions callback, which handles the user's response to the
        // system permissions dialog. Save the return value, an instance of
        // ActivityResultLauncher, as an instance variable.
        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                llamar();
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
                Toast.makeText(this, "Necesitamos permiso para llamar", Toast.LENGTH_SHORT).show();
            }
        });

        btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamadaClick();
            }
        });
    }

    private void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:0034 666 66 66 66"));
        startActivity(phoneIntent);
    }

    public void llamadaClick(){
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            llamar();
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
    }
}