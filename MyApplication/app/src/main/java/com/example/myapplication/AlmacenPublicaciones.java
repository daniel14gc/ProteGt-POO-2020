package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlmacenPublicaciones {

    private ArrayList<Publicacion> posts;

    public AlmacenPublicaciones(){
        posts = new ArrayList<Publicacion>();
    }

    public Publicacion getPublicacion(int index) {
        return posts.get(index);
    }

    public void addPublicacion(Publicacion p){
        posts.add(p);
    }

    public void removePublicacion(Publicacion p){
        posts.remove(p);
    }
}