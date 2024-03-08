package com.example.pmdm2324.ut08.CalculadoraSuma;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class u8ViewModelSuma extends ViewModel {
    private static final double DELAY = 2000;
    public static final Integer FAIL = -1;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero(){
        if(misDatos == null){
            misDatos = new MutableLiveData<Integer>();
            sumaNumero(u8aSumaMVVM.n1, u8aSumaMVVM.n2);
        }
        return misDatos;
    }

    public void sumaNumero(String num1, String num2) {
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        // He recibido los datos (simulando petición remota)

                        // Verificar que las cadenas no estén vacías antes de convertirlas a enteros para que no de error NumberFormatException
                        if (!num1.isEmpty() && !num2.isEmpty()) {
                            int n1 = Integer.parseInt(num1);
                            int n2 = Integer.parseInt(num2);
                            int suma = n1 + n2;
                            misDatos.postValue(suma);
                        } else {
                            misDatos.postValue(FAIL);
                        }

                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                    }
                }
        ).start();
    }
}
