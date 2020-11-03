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
    static Database usuarios = new UserDatabase("Users");
    static Database posts = new PostsDatabase("Publicaciones");
    static AlmacenPublicaciones Almpost =  new AlmacenPublicaciones();
    static Persona persona;


    //Método que permite añadir un usuario nuevo, cuando se registra, a la base de datos.
    public static int addUser(String us, String pw){
        //Se debe buscar si el usuario ya existe. 
        if(!buscar(us, pw)){
            //Si no existe, se añade a la base de datos.
            persona = new Persona(us, pw, false);
            usuarios.addElements(persona);
            return 0;
        }
        return 1;
    }

    //Método que permite realizar una nueva publicación.
    public static void nuevaPublicacion(Publicacion p){
        p.setId(posts.getSize()+1);
        posts.addElements(p);
    }

    //Se obtienen todos los posts que hay en la base de datos para mostrarlos al usuario.
    public static ArrayList<Publicacion> getPosts(){
        ArrayList<Publicacion> temp = new ArrayList<Publicacion>();
        ArrayList<Object> publicaciones = posts.getElements();
        for(int i = 0; i< publicaciones.size(); i++){
            Publicacion p = (Publicacion) publicaciones.get(i);
            temp.add(p);
        }
        Almpost.setPosts(temp);
        return temp;
    }
    public static ArrayList<Publicacion> getPosts(int filtro){
        ArrayList<Publicacion> temp = new ArrayList<Publicacion>();
       if(filtro==-1)
       {
        temp=Almpost.filtro1();
       }
       else {
           temp=Almpost.filtro2();
       }
        return temp;
    }

    //Método que permite definir si un usuario existe o no en la base de datos.
    public static boolean buscar(String us, String pw){
        //Se obtienen todos los usuarios de la base de datos y se busca
        //por nombre de usuario y contraseña.
        ArrayList<Object> users = usuarios.getElements();
        ArrayList<Persona> temp = new ArrayList<Persona>();
        for(int i = 0; i<users.size(); i++){
            Persona p = (Persona) users.get(i);
            temp.add(p);
        }
        AlPe.setUsers(temp);
        Persona pTemp = AlPe.buscar(us,pw);
        if(pTemp != null){
            persona = pTemp;
            return true;
        }
        return false;
    }

    public static Double[] localizacion(Long id){
        Publicacion temp = Almpost.obtener(id);
        Double[] res = new Double[2];
        res[0] = temp.getLatitude();
        res[1] = temp.getLongitude();
        return res;
    }

    public static void size(){
        posts.getSize();
    }

    //Permite modificar el estado de contagio de un usuario.
    public static void enfermo(){
        persona.setStatus();
        usuarios.modificarElemento(persona);
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