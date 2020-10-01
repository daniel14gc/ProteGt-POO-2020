/*  #############################################################

        Este metodo contiene toda la informacion necesaria
        que conforma una publicacion y los metodos necesarios
                para crearla y obtener sus datos.

    #############################################################*/


package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Publicacion {

    private long id;
    private String user;
    private String location;
    private String type;
    private String description;


    //Metodo para crear una publicacion y definir sus datos.

    public Publicacion(String user, String location, String type, String description) {
        this.user = user;
        this.location = location;
        this.type = type;
        this.description = description;
    }


    public String getUser() {
        return user;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
}
