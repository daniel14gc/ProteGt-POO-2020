/*  #############################################################

        Este metodo contiene toda la informacion necesaria
        que conforma una publicacion y los metodos necesarios
                para crearla y obtener sus datos.

    #############################################################*/


package com.example.myapplication;

public class Publicacion {

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



    // Metodo para obtener los datos de la publicacion.

    public String[] getDatos() {
        String [] temp = {user, location, type, description};
        return temp;
    }

}
