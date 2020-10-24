package com.example.myapplication;

/*    ################################################
*
*           Esta clase controla las publicaciones
*           que se muestran en el homes activity.
*
*      ###############################################*/


import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Esta clase se extiende de la clase Recycler View

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    // Las publicaciones se almacenan en la variable ListaDatos para que se apliquen al homes

    ArrayList<Publicacion> ListaDatos;

    // Este metodo recibe una lista para actualizar la información de ListaDatos

    public AdapterDatos(ArrayList<Publicacion> listaDatos) {
        ListaDatos = listaDatos;
    }

    // Este metodo define las acciones que se realizarán al crear el view holder

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publicacion,null,true);


        return new ViewHolderDatos(view);
    }

    // Este metodo itera dentro de lista datos para agregar una publicacion a homes.

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {


        Publicacion prueba = ListaDatos.get(position);

        holder.asignarDatos(prueba);

    }

    // Este metodo devuelve el tamaño de la ListDatos

    @Override
    public int getItemCount() {
        return ListaDatos.size();
    }


    // Esta es una subclase toma los componentes de las tarjetas que se encuentran en el recyclerview de homes

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView usuariopub;
        TextView titulopub;
        TextView descpub;


        // Este metodo define las variables creadas anteriormente para proseguir con actualizar la información que los conforma.

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            usuariopub = itemView.findViewById(R.id.usuariopub);
            titulopub = itemView.findViewById(R.id.titulopub);
            descpub = itemView.findViewById(R.id.descpub);

        }


        // Este metodo define la información que conforma las tarjetas.

        public void asignarDatos(Publicacion s) {

            String usuario = s.getUser();
            String titulo = s.getType();
            String descripcion = s.getDescription();

            usuariopub.setText(usuario);
            titulopub.setText(titulo);
            descpub.setText(descripcion);

        }
    }
}
