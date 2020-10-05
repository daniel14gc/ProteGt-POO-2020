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

    public void setUsers(ArrayList<Persona> p){
        users = p;
    }

    public Persona buscar(String user, String password){
        for(int i = 0; i<users.size(); i++){
            Persona temp = users.get(i);
            if(temp.getUser().equals(user) && temp.getPassword().equals(password)){
                return temp;
            }
        }

        return null;
    }
}