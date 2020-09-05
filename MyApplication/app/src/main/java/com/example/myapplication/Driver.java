//##################################################################

//  Esta clase se hizo con el objetivo de aplicar de forma visual
//  todos los conocimientos aprendidos en clase e incluir un driver
//          para administrar de forma efectiva los datos.

//###################################################################

package com.example.myapplication;

public class Driver {

    AlmacenPersonas AlPe = new AlmacenPersonas();


    public Driver(){

    }



    // Este metodo genera un usuario con la informacion que se le brinde

    public void crearPersona(String n, String p) {

        Persona persona = new Persona(n,p);

        AlPe.addUser(persona);

    }



    /* Metodo para comparar los datos brindados por el usuario y el almacen para definir si
       puede loguearse o no.  */

    public boolean comparardatos(String u, String p){

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