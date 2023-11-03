package com.example.pmdm2324.ut02;

import static android.text.TextUtils.isDigitsOnly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import com.example.pmdm2324.R;

public class u2aPideCita extends AppCompatActivity {
    TextView tvFecha, tvHora, tvError, tvMostrarNombre, tvMostrarDNI, tvMensajeFinal, tvHoraFin, tvFechaFin, tvFyHFin;
    EditText etDNI, etNombre;
    Button btValidar, btFecha, btHora;
    ImageView imgChek;
    private final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a_pide_cita);

        etDNI = findViewById(R.id.u2aPideCitaetDNI);
        etNombre = findViewById(R.id.u2aPideCitaetNombre);
        btValidar = findViewById(R.id.u2aPideCitabtValidaDNI);
        btFecha = findViewById(R.id.u2aPideCitabtFecha);
        btHora = findViewById(R.id.u2aPideCitabtHora);
        tvHora = findViewById(R.id.u2aPideCitatvHorabt);
        tvFecha = findViewById(R.id.u2aPideCitatvFechabt);
        tvMostrarNombre = findViewById(R.id.u2aPideCitatvNombreet);
        tvMostrarDNI = findViewById(R.id.u2aPideCitatvDNIet);
        tvError = findViewById(R.id.u2aPideCitatvError);
        tvFyHFin = findViewById(R.id.u2aPideCitatvFyH);
        tvHoraFin = findViewById(R.id.u2aPideCitatvHoraFin);
        tvFechaFin = findViewById(R.id.u2aPideCitatvFechaFin);
        tvMensajeFinal = findViewById(R.id.u2aPideCitatvMensajeFinal);
        imgChek = findViewById(R.id.u2aPideCitaimgImgCheck);

        tvMostrarNombre.setVisibility(View.INVISIBLE);
        tvMostrarDNI.setVisibility(View.INVISIBLE);
        tvMensajeFinal.setVisibility(View.INVISIBLE);
        tvFyHFin.setVisibility(View.INVISIBLE);
        tvFechaFin.setVisibility(View.INVISIBLE);
        tvHoraFin.setVisibility(View.INVISIBLE);
        imgChek.setVisibility(View.INVISIBLE);

        btFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        u2aPideCita.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                tvFecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });
        btHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on below line we are getting the
                // instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        u2aPideCita.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // on below line we are setting selected time
                                // in our text view.
                                tvHora.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                // at last we are calling show to
                // display our time picker dialog.
                timePickerDialog.show();
            }
        });

        btValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMensajeFinal.setText("¡Cita confirmada con EXITO!");
                String dniVal = etDNI.getText().toString();
                validarDNI(dniVal);
                if(validarDNI(dniVal)==false||etNombre.getText().toString().isEmpty()||etDNI.getText().toString().isEmpty()||tvHora.getText().toString().isEmpty()||tvFecha.getText().toString().isEmpty()){
                    tvError.setText("Error al meter el Nombre o el DNI introducido no es valido o no has seleccionado Fecha y Hora.");
                }else{
                    tvFechaFin.setText(tvFecha.getText().toString());
                    tvHoraFin.setText(tvHora.getText());
                    tvMostrarNombre.setText(etNombre.getText().toString());
                    tvMostrarDNI.setText(etDNI.getText().toString());
                    tvError.setVisibility(View.INVISIBLE);
                    btFecha.setVisibility(View.INVISIBLE);
                    btHora.setVisibility(View.INVISIBLE);
                    etNombre.setVisibility(View.INVISIBLE);
                    etDNI.setVisibility(View.INVISIBLE);
                    btValidar.setVisibility(View.INVISIBLE);

                    tvMostrarNombre.setVisibility(View.VISIBLE);
                    tvMostrarDNI.setVisibility(View.VISIBLE);
                    tvMensajeFinal.setVisibility(View.VISIBLE);
                    tvFyHFin.setVisibility(View.VISIBLE);
                    tvFechaFin.setVisibility(View.VISIBLE);
                    tvHoraFin.setVisibility(View.VISIBLE);
                    imgChek.setVisibility(View.VISIBLE);

                }
            }
        });


    }
    private boolean validarDNI(String itDNI) {
        String elDNI = etDNI.getText().toString();
        int numDNI = Integer.parseInt(elDNI.substring(0, 8));
        char letraCalculada = dniChars.charAt(numDNI % 23);
        char letraDNI = elDNI.charAt(8);
        if(letraCalculada==letraDNI){
            return true;
        }else {
            return  false;
        }

    }
}