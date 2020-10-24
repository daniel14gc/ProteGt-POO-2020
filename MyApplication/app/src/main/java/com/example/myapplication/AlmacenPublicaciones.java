package com.example.myapplication;


/*  ########################################################

        En esta clase almacena todas las publicaciones,
        y contiene los metodos necesarios para crear,
                buscar y eliminar las mismas.

    ########################################################   */



import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlmacenPublicaciones {
    //Almacena las publicaciones realizadas por los usuarios.
    private ArrayList<Publicacion> posts;

    //Inicializa posts y permite crear la instancia de la clase.
    public AlmacenPublicaciones(){

        posts = new ArrayList<Publicacion>();

    }
    //Permite añadir las publicaciones de la base de datos al almacén, para poder mostrarlas a los usuarios.
    public void setPosts(ArrayList<Publicacion> posts) {
        this.posts = posts;
    }
    //Obtiene todas las publicaciones hechas hasta el momento.
    public ArrayList<Publicacion> getPublicaciones() {
        return posts;

    }
}