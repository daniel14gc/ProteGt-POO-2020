package com.example.myapplication;

import java.security.Permission;
import java.util.ArrayList;

public class AlmacenPersonas {

    private ArrayList<Persona> users;

    public AlmacenPersonas() {
        users = new ArrayList<Persona>();
    }

    public Persona getUser(int index) {
        return users.get(index);
    }

    public void addUser(Persona p){
        users.add(p);
    }

    public int getsize(){
        return users.size();
    }

    public int removeUser(int index){
        if(users.get(index) != null){
            users.remove(index);
            return 0;
        }
        else{
            return -1;
        }
    }

    public void setUser(ArrayList<Persona> users) {
        this.users = users;
    }
}