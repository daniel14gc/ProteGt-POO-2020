/*  ########################################################

        En esta clase almacena todas las publicaciones,
        y contiene los metodos necesarios para crear,
                buscar y eliminar las mismas.

    ########################################################   */


package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlmacenPublicaciones {

    private ArrayList<Publicacion> posts;


    public AlmacenPublicaciones(){

        posts = new ArrayList<Publicacion>();

    }

    public Publicacion getPublicacion(int index) {

        // Metodo para buscar una publicacion segun su indice.

        return posts.get(index);

    }

    public void addPublicacion(Publicacion p){

        //Metodo para anadir una publicacion.

        posts.add(p);

    }

    public void removePublicacion(Publicacion p){

        //Metodo para eliminar una publicacion

        posts.remove(p);

    }

    public ArrayList<Publicacion> getPublicaciones(int index) {

        // Metodo para retornar todas las publicaciones.

        return posts;

    }
}