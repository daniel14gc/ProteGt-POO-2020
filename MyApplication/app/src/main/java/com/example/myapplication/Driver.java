//##################################################################

//  Esta clase se hizo con el objetivo de aplicar de forma visual
//  todos los conocimientos aprendidos en clase e incluir un driver
//          para administrar de forma efectiva los datos.

//###################################################################

package com.example.myapplication;

public class Driver {

    static AlmacenPersonas AlPe = new AlmacenPersonas();
    static UserDatabase usuarios = new UserDatabase("Users");
    static PostsDatabase posts = new PostsDatabase("Publicaciones");
    static Persona persona;


    // Este metodo genera un usuario con la informacion que se le brinde

    public static int crearPersona(String n, String p) {

        persona = new Persona(n,p);
        return addUser(persona);
        //AlPe.addUser(persona);

    }

    private static int addUser(Persona p){
        return usuarios.add(p);
    }

    public static void nuevaPublicacion(Publicacion p){
        p.setId(posts.getSize()+1);
        posts.newPost(p);

    }

    public static void enfermo(){

    }

    public static boolean comparardatos(String u, String p){
        return usuarios.buscar(p,u);
    }


}
