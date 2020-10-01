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


    ArrayList<HashMap<String,String>> ListaDatos;

    public AdapterDatos(ArrayList<HashMap<String,String>> listaDatos) {
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


        HashMap<String,String> prueba = ListaDatos.get(position);

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

        public void asignarDatos(HashMap<String,String> s) {

            String usuario = s.get("usuario");
            String titulo = s.get("titulo");
            String descripcion = s.get("descripcion");

            usuariopub.setText(usuario);
            titulopub.setText(titulo);
            descpub.setText(descripcion);

        }
    }
}
