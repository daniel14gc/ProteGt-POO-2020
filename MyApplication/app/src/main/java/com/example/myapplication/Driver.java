//##################################################################

//  Esta clase se hizo con el objetivo de aplicar de forma visual
//  todos los conocimientos aprendidos en clase e incluir un driver
//          para administrar de forma efectiva los datos.

//###################################################################

package com.example.myapplication;

import android.content.Context;

import java.util.ArrayList;

public class Driver {

    static AlmacenPersonas AlPe = new AlmacenPersonas();
    static UserDatabase usuarios = new UserDatabase("Users");
    static PostsDatabase posts = new PostsDatabase("Publicaciones");
    static Persona persona;


    public static int addUser(String us, String pw){
        if(!buscar(us, pw)){
            persona = new Persona(us, pw, false);
            usuarios.add(persona);
            return 0;
        }
        return 1;
    }

    public static void nuevaPublicacion(Publicacion p){
        p.setId(posts.getSize()+1);
        posts.newPost(p);
    }

    public static ArrayList<Publicacion> getPosts(){
        return posts.getPosts();
    }

    public static boolean buscar(String us, String pw){
        ArrayList<Persona> algo = usuarios.getUsuarios();
        AlPe.setUsers(algo);
        Persona temp = AlPe.buscar(us,pw);
        if(temp != null){
            persona = temp;
            return true;
        }
        return false;
    }

    public static void enfermo(){
        persona.setStatus();
        usuarios.modificarestado(persona);
    }

    public static boolean obtenerestado(){
        return persona.getStatus();
    }

    public static boolean verificar(boolean b){
        return b == persona.getStatus();
    }
}