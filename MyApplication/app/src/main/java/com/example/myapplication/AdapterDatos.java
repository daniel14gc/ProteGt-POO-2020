package com.example.myapplication;

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

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {


ArrayList<Publicacion> ListaDatos;

    public AdapterDatos(ArrayList<Publicacion> listaDatos) {
        ListaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publicacion,null,false);


        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {


        Publicacion prueba = ListaDatos.get(position);

        holder.asignarDatos(prueba);

    }

    @Override
    public int getItemCount() {
        return ListaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView usuariopub;
        TextView titulopub;
        TextView descpub;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            usuariopub = itemView.findViewById(R.id.usuariopub);
            titulopub = itemView.findViewById(R.id.titulopub);
            descpub = itemView.findViewById(R.id.descpub);

        }

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
