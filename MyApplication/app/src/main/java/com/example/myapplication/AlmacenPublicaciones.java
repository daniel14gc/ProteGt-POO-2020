package com.example.myapplication;


/*  ########################################################

        En esta clase almacena todas las publicaciones,
        y contiene los metodos necesarios para crear,
                buscar y eliminar las mismas.

    ########################################################   */



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class AlmacenPublicaciones implements filtro {
    //Almacena las publicaciones realizadas por los usuarios.
    private ArrayList<Publicacion> posts;

    //Inicializa posts y permite crear la instancia de la clase.
    public AlmacenPublicaciones(){

        posts = new ArrayList<Publicacion>();

    }
    //Permite añadir las publicaciones de la base de datos al almacén, para poder mostrarlas a los usuarios.
    public void setPosts(ArrayList<Publicacion> posts) {
        this.posts = posts;
        Collections.reverse(this.posts);
    }
    //Obtiene todas las publicaciones hechas hasta el momento.
    public ArrayList<Publicacion> getPublicaciones() {
        return posts;

    }

    public ArrayList<Publicacion> filtro1()
    {
        ArrayList<Publicacion> temp= new ArrayList<>();
        for (int i =0;i< posts.size();i++)
        {
            if(posts.get(i).getType().equals("Infectado"))
            {
                temp.add(posts.get(i));
            }

        }
        return temp;
    }
    public ArrayList<Publicacion> filtro2()
    {
        ArrayList<Publicacion> temp= new ArrayList<>();
        for (int i =0;i< posts.size();i++)
        {
            if(!posts.get(i).getType().equals("Infectado"))
            {
                temp.add(posts.get(i));
            }
        }
        return temp;
    }

    public Publicacion obtener(Long id){
        for(int i = 0; i<posts.size(); i++){
            Publicacion temp = posts.get(i);
            if(temp.getId() == id){
                return temp;
            }
        }
        return null;
    }

}