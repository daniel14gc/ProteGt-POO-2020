package com.example.myapplication;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDatabase extends Database {
    ArrayList <String>  respuestas;

    public UserDatabase(String path){
        super(path);
        respuestas = new ArrayList<String>();
    }

    public void getUsuario(){

    }

    public void getStatus(){

    }



    public boolean buscar(final String pw, final String usuario){
        //------------------------------------

        Query checkUser = reference.orderByChild("password").equalTo(pw);
        // minuto 1:45 posible error
        //boolean [] bandera ={};
        checkUser.addListenerForSingleValueEvent(new ValueEventListener(){
           @Override

           public void onDataChange(@NonNull DataSnapshot dataSnapshot)
           {
                if(dataSnapshot.exists())
                {

                    respuestas.add(dataSnapshot.child(pw).child("password").getValue(String.class));
                    respuestas.add(dataSnapshot.child(pw).child("status").getValue(String.class));
                    respuestas.add(dataSnapshot.child(pw).child("nombre").getValue(String.class));



                }
           }
           @Override
           public  void  onCancelled(@NonNull DatabaseError databaseError)
           {

           }

        });
        if(pw.equals(respuestas.get(0))&& usuario.equals(respuestas.get(2)))
            return true;
        return false;
        //------------------------------------

    }
}
