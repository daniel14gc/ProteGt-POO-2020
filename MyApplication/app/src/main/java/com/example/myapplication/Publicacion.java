package com.example.myapplication;

public class Publicacion {

    private String user;
    private String location;
    private String type;
    private String description;

    public Publicacion(String user, String location, String type, String description) {
        this.user = user;
        this.location = location;
        this.type = type;
        this.description = description;
    }

    public String[] getDatos() {
        String [] temp = {user, location, type, description};
        return temp;
    }

}
