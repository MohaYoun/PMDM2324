package com.example.pmdm2324.ut09.practicaAPIPeliActor.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut09.practicaAPIPeliActor.data.Actores;
import com.example.pmdm2324.ut09.practicaAPIPeliActor.data.Peliculas;

import java.util.ArrayList;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolder> {

    private ArrayList<Peliculas> datos;

    public AdapterPeliculas(Peliculas listaPeliculas) {
        datos = new ArrayList<>();
        add(listaPeliculas);
    }

    public void add(Peliculas listaPeliculas) {
        datos.add(listaPeliculas);
        notifyDataSetChanged();
    }

    // Interface para manejar los clics en los elementos del RecyclerView
    private interface OnItemClickListener {
        void onItemClickListener(Peliculas pelicula);
    }

    private OnItemClickListener listener;

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public AdapterPeliculas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_peliculas_apijavi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterPeliculas.ViewHolder holder, int position) {
        Peliculas p = datos.get(position);
        holder.setInfo(p);

        // Configuración del clic en el elemento del RecyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    // Llamada al método onItemClick del listener
                    listener.onItemClickListener(p);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    // el row
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombrePeliculas;
        private final TextView descripcionPeliculas;
        private final TextView nombreActores;
        private final TextView urlActores;
        private final TextView urlPeliculas;
        private final TextView estrellasPeliculas;
        public ViewHolder(View itemView) {
            super(itemView);

            nombrePeliculas = itemView.findViewById(R.id.nombrePeliculas);
            descripcionPeliculas = itemView.findViewById(R.id.descripcionPeliculas);
            nombreActores =itemView.findViewById(R.id.nombreActores);
            estrellasPeliculas = itemView.findViewById(R.id.estrellasPeliculas);
            urlActores = itemView.findViewById(R.id.urlActoresAPI);
            urlPeliculas = itemView.findViewById(R.id.urlPeliculasAPI);
        }


        // Método para configurar los datos en el ViewHolder
        public void setInfo(Peliculas pelicula) {
            nombrePeliculas.setText(pelicula.getNombre().toString());
            descripcionPeliculas.setText(pelicula.getDescripcion().toString());
            estrellasPeliculas.setText(pelicula.getEstrellas().toString());

            // Configurar la información de los actores
            StringBuilder nombresActores = new StringBuilder();
            StringBuilder urlsActores = new StringBuilder();
            StringBuilder urlsPeliculas = new StringBuilder();

            for (Actores actor : pelicula.getActores()) {
                nombresActores.append(actor.getNombre()).append("\n");
                urlsActores.append(actor.getUrl()).append("\n");
                urlsPeliculas.append(actor.getPelicula()).append("\n");
            }

            nombreActores.setText(nombresActores.toString());
            urlPeliculas.setText(urlsPeliculas.toString());
            urlActores.setText(urlsActores.toString());
        }
    }
}
