package com.example.myapplication;

/*  #############################################################

        Este metodo contiene toda la informacion necesaria
        que conforma una publicacion y los metodos necesarios
                para crearla y obtener sus datos.

    #############################################################*/


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Publicacion {

    private long id;
    private String user;
    private String location;
    private String type;
    private String description;
    private double latitude;
    private double longitude;


    //Metodo para crear una publicacion y definir sus datos.

    public Publicacion(String user, String location, String type, String description, double latitude, double longitude) {
        this.user = user;
        this.location = location;
        this.type = type;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Metodo que obtiene al usuario de la publicación
    public String getUser() {
        return user;
    }

    //getter que obtiene la ubicacion donde se realizo la publicación
    public String getLocation() {
        return location;
    }

    //Metodo que obtendrá el tipo de la publicacion
    public String getType() {
        return type;
    }

    //Getter que devuelve la descripcion caracteristica de la publicacion
    public String getDescription() {
        return description;
    }

    //Getter que obtendra el id que corresponde a la publicación respectiva
    public long getId() {
        return id;
    }

    //Setter que modifica el id de la publicación
    public void setId(long id){
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
