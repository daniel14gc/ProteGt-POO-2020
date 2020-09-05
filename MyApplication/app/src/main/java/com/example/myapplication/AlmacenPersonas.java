//#########################################################################

//  Esta clase almacena todos los usuarios que maneja la aplicacion
//  y contiene todos los metodos para editar, agregar y eliminar
//                              usuarios.

// #########################################################################


package com.example.myapplication;

import java.security.Permission;
import java.util.ArrayList;

public class AlmacenPersonas {

    private ArrayList<Persona> users;

    public AlmacenPersonas() {
        users = new ArrayList<Persona>();
    }


    //Metodo que retorna el usuario segun el indice que se indique.

    public Persona getUser(int index) {
        return users.get(index);
    }


    //Metodo para agregar un usuario al almacen.
    public void addUser(Persona p){
        users.add(p);
    }


    //Metodo que retorna el tamano del arreglo users.
    public int getsize(){
        return users.size();
    }

    public int removeUser(int index){

        //Metodo para eliminar un usuario de la "base de datos".


        //Se comprueba si el indice del usuario que se indico existe.
        if(users.get(index) != null){
            users.remove(index);
            return 0;
        }

        else{
            return -1;
        }
    }

    //Metodo para modificar el arreglo users.
    public void setUser(ArrayList<Persona> users) {
        this.users = users;
    }
}