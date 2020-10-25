package com.example.myapplication;

/*-----------------------------------------------------------------
    Driver.java
    Grupo 6, proyecto semestral.
    Última modificación: 2020-10-7

    Clase que permite seguir el patrón MVC, conectando la múltiples clases
    de la vista con la base de datos, para mostrar información al usuario
    y hacer funcional la aplicación.

-----------------------------------------------------------------*/

import android.content.Context;

import java.util.ArrayList;

public class Driver {

    //Atributos de clase.
    static AlmacenPersonas AlPe = new AlmacenPersonas();
    static UserDatabase usuarios = new UserDatabase("Users");
    static PostsDatabase posts = new PostsDatabase("Publicaciones");
    static Persona persona;


    //Método que permite añadir un usuario nuevo, cuando se registra, a la base de datos.
    public static int addUser(String us, String pw){
        //Se debe buscar si el usuario ya existe. 
        if(!buscar(us, pw)){
            //Si no existe, se añade a la base de datos.
            persona = new Persona(us, pw, false);
            usuarios.add(persona);
            return 0;
        }
        return 1;
    }

    //Método que permite realizar una nueva publicación.
    public static void nuevaPublicacion(Publicacion p){
        p.setId(posts.getSize()+1);
        posts.newPost(p);
    }

    //Se obtienen todos los posts que hay en la base de datos para mostrarlos al usuario.
    public static ArrayList<Publicacion> getPosts(){
        return posts.getPosts();
    }

    //Método que permite definir si un usuario existe o no en la base de datos.
    public static boolean buscar(String us, String pw){
        //Se obtienen todos los usuarios de la base de datos y se busca
        //por nombre de usuario y contraseña.
        ArrayList<Persona> algo = usuarios.getUsuarios();
        AlPe.setUsers(algo);
        Persona temp = AlPe.buscar(us,pw);
        if(temp != null){
            persona = temp;
            return true;
        }
        return false;
    }

    //Permite modificar el estado de contagio de un usuario.
    public static void enfermo(){
        persona.setStatus();
        usuarios.modificarestado(persona);
    }

    public static String getUser(){
        return persona.getUser();
    }

    //Permite obtener el estado de contagio de un usuario.
    public static boolean obtenerestado(){
        return persona.getStatus();
    }

    //Permite verificar el status de contagio de una persona para mostarlo.
    public static boolean verificar(boolean b){
        return b == persona.getStatus();
    }

    //Permite obtener la cantidad de casos activos en la app.
    public static int getCasosApp (){
        return AlPe.getCasosApp();
    }

    //Permite obtener la cantidad de casos activos en Guatemala.
    public static int getCasosGuate (){
        return AlPe.getCasosGuate();
    }

}