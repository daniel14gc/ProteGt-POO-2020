package com.example.myapplication;

//####################################################################

//  Esta clase almacena la informacion de cada persona, cada persona
//  se almacena en la clase AlmacenPersonas. Ademas contiene todos
//      los metodos para crearlo y obtener su informacion.

//####################################################################


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Persona {

    private String user;
    private String password;
    private boolean status;

    //constructor de la clase, el cual asignará las propiedades iniciales del objeto persona
    public Persona(String user, String password, boolean status){
        this.user = user;
        this.password = password;
        this.status = status;
    }

    // Metodo para obtener el nombre del usuario.

    public String getUser(){
        return user;
    }



    // Metodo para obtener la contrasena del usuario.

    public String getPassword(){
        return password;
    }



    // Metodo para obtener el status del usuario.

    public boolean getStatus(){
        return status;
    }



    // Metodo para editar el status del usuario.

    public void setStatus(){
        if (status == false){
            status = true;
        }
        else{
            status = false;
        }
    }

}