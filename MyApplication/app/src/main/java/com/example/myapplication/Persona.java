package com.example.myapplication;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Persona {

    private String user;
    private String password;
    private boolean status;

    public Persona(String user, String password){
        this.user = user;
        this.password = password;
        status = false;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(){
        if (status == false){
            status = true;
        }
        else{
            status = false;
        }
    }

}
