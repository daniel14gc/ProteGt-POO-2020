package com.example.myapplication;

public class Driver {

    AlmacenPersonas AlPe = new AlmacenPersonas();

    public Driver(){

    }

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
