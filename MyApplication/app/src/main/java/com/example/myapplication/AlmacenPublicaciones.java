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

    public void setPosts(ArrayList<Publicacion> posts) {
        this.posts = posts;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return posts;

    }
}