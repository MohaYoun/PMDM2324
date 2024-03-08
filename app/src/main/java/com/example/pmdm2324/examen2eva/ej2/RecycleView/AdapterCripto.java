package com.example.pmdm2324.examen2eva.ej2.RecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.examen2eva.ej2.data.Cripto;
import com.example.pmdm2324.examen2eva.ej2.data.Estafados;

import java.util.ArrayList;

public class AdapterCripto extends RecyclerView.Adapter<AdapterCripto.ViewHolder>{
    private ArrayList<Cripto> datos;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView valor;
        private final TextView estafa;

        public ViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.moneda);
            valor = (TextView) view.findViewById(R.id.valor);
            estafa = (TextView) view.findViewById(R.id.estafados);
        }

        public void setInfo(Cripto cripto) {
            nombre.setText(cripto.getNombre());
            valor.setText(String.valueOf(cripto.getEuros()));
            if (cripto.getEstafado() != null && cripto.getEstafado().length > 0) {
                StringBuilder estafadosText = new StringBuilder();
                for (Estafados estafado : cripto.getEstafado()) {
                    estafadosText.append(estafado.getNombre()).append(", ");
                }
                estafa.setText(estafadosText.toString());
            } else {
                estafa.setText("Estafados no disponibles");
            }
        }
    }

    public AdapterCripto(Cripto dataSet) {
        datos = new ArrayList<>();
        datos.clear();
        add(dataSet);
    }
    public void add(Cripto dataSet){
        datos.add(dataSet);
        notifyDataSetChanged();
    }
    @Override
    public AdapterCripto.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_cripto, viewGroup, false);

        return new AdapterCripto.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cripto crp = datos.get(position);
        holder.setInfo(crp);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }
}
