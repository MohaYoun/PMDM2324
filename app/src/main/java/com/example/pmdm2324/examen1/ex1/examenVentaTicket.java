package com.example.pmdm2324.examen1.ex1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdm2324.R;

import java.util.Calendar;

public class examenVentaTicket extends AppCompatActivity {
    public static final String MADRID = "Madrid";
    public static final String BARCELONA = "Barcelona";
    public static final String VALENCIA = "Valencia";
    public static final String ZARAGOZA = "Zaragoza";
    public static final String SEVILLA = "Sevilla";
    public static final String MALAGA = "Málaga";
    public static final String MURCIA = "Murcia";
    public static final String PALMA_DE_MALLORCA = "Palma de Mallorca";
    public static final String LAS_PALMAS_DE_GRAN_CANARIA = "Las Palmas de Gran Canaria";
    public static final String ALICANTE = "Alicante";
    public static final String FECHA_IDA = "Fecha IDA";
    public static final String FECHA_VUELTA = "Fecha VUELTA";
    private static final CharSequence MSG_ERROR_ORIGEN_DESTINO = "No se puede salir y volver a la misma ciudad.";
    private static final CharSequence MSG_ERROR_FECHA = "No se puede volver antes de ir.";
    TextView tvFechaIda, tvFechaVuelta, tvError;
    Button btFechaIda, btFechaVuelta, btReservar;
    Spinner spOrigen, spDestino;
    CheckBox cbIda;
    ActivityResultLauncher<Intent> lanza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen_venta_ticket);

        tvFechaIda = findViewById(R.id.ex1tvFechaIda);
        tvFechaVuelta = findViewById(R.id.ex1tvFechaVuelta);
        tvError = findViewById(R.id.ex1tvError);
        btFechaIda= findViewById(R.id.ex1btFechaIda);
        btFechaVuelta = findViewById(R.id.ex1btFechaVuelta);
        btReservar = findViewById(R.id.ex1btReservar);
        spOrigen = findViewById(R.id.ex1spOrigen);
        spDestino = findViewById(R.id.ex1spDestino);
        cbIda = findViewById(R.id.ex1cbIda);

        tvFechaIda.setText(FECHA_IDA);
        tvFechaVuelta.setText(FECHA_VUELTA);

        int[] dia = new int[2];
        int[] mes = new int[2];
        int[] anio = new int[2];

        String [] ciudades = {MADRID, BARCELONA, VALENCIA, ZARAGOZA, SEVILLA, MALAGA, MURCIA, PALMA_DE_MALLORCA, LAS_PALMAS_DE_GRAN_CANARIA, ALICANTE};
        // Crear un ArrayAdapter utilizando una matriz de elementos y un diseño de spinner predeterminado
        /*ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.tipoHelado, android.R.layout.simple_spinner_item);*/
        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, ciudades);

        // Especificar el diseño para usar cuando la lista de opciones aparece
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar el adaptador al spinner
        spOrigen.setAdapter(adaptador);
        spDestino.setAdapter(adaptador);
        btFechaIda.setOnClickListener(new View.OnClickListener() {
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
                        examenVentaTicket.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                tvFechaIda.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                dia[0] = dayOfMonth;
                                mes[0] = monthOfYear;
                                anio[0] = year;
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
        if(cbIda.isPressed()){
            cbIda.setOnClickListener((v) -> {
                    btFechaVuelta.setEnabled(false);
            });
        }

        btFechaVuelta.setOnClickListener(new View.OnClickListener() {
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
                        examenVentaTicket.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                tvFechaVuelta.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                dia[1] = dayOfMonth;
                                mes[1] = monthOfYear;
                                anio[1] = year;
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


        btReservar.setOnClickListener((v) -> {
            if(spOrigen.getSelectedItem().equals(spDestino.getSelectedItem())){
                tvError.setText(MSG_ERROR_ORIGEN_DESTINO);
            }else if(dia[0] > dia[1] || mes[0] > mes[1] || anio[0] > anio[1]){
                tvError.setText(MSG_ERROR_FECHA);
            }else{
                if(cbIda.isChecked()==true){
                    String origen = spOrigen.getSelectedItem().toString();
                    String destino = spDestino.getSelectedItem().toString();
                    String fechaIda = tvFechaIda.getText().toString();
                    Viaje viaje = new Viaje(origen, destino, fechaIda);

                    Intent i = new Intent(this, examen1Dev.class);
                    i.putExtra(Viaje.CLAVE_VIAJE, viaje);
                    lanza.launch(i);
                }else{
                    String origen = spOrigen.getSelectedItem().toString();
                    String destino = spDestino.getSelectedItem().toString();
                    String fechaIda = tvFechaIda.getText().toString();
                    String fechaVuelta = tvFechaVuelta.getText().toString();
                    Viaje viaje = new Viaje(origen, destino, fechaIda, fechaVuelta);

                    Intent i = new Intent(this, examen1Dev.class);
                    i.putExtra(Viaje.CLAVE_VIAJE, viaje);
                    lanza.launch(i);
                }
            }
        });
        lanza= registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_FIRST_USER){
                            tvFechaIda.setText(dato.getExtras().getString(examen1Dev.MSG_FECHAIDA));
                            tvFechaVuelta.setText(dato.getExtras().getString(examen1Dev.MSG_FECHAVUELTA));
                            spOrigen.setPromptId(0);
                            spDestino.setPromptId(0);
                        }
                    }
                });
    }
}