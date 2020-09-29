//##################################################################

//  Esta clase se hizo con el objetivo de aplicar de forma visual
//  todos los conocimientos aprendidos en clase e incluir un driver
//          para administrar de forma efectiva los datos.

//###################################################################

package com.example.myapplication;

public class Driver {

    static AlmacenPersonas AlPe = new AlmacenPersonas();
    static Database usuarios = new UserDatabase("Users");
    static Persona persona;


    // Este metodo genera un usuario con la informacion que se le brinde

    public static int crearPersona(String n, String p) {

        persona = new Persona(n,p);
        return addDatabase(persona);
        //AlPe.addUser(persona);

    }

    public static int addDatabase(Persona p){
        return usuarios.write(p);
    }

    public static void usuario(){

    }

    public static void enfermo(){

    }

        /* Metodo para comparar los datos brindados por el usuario y el almacen para definir si
       puede loguearse o no.  */


    public static boolean comparardatos(String u, String p){

        for (int i = 0; i < AlPe.getsize(); i++){
            Persona per = AlPe.getUser(i);
            if (per.getUser().equals(u)){
                if (per.getPassword().equals(p)){
                    return true;
                }
            }
        }

        return false;

    }


}
