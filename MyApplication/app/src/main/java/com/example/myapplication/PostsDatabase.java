package com.example.myapplication;

/*-----------------------------------------------------------------
    PostsDatabase.java
    Grupo 6, proyecto semestral.
    Última modificación: 2020-10-7

    Clase que permite hacer la conexión con la base de datos 
    en la rama de posts, para obtenerlos todos o agregarlos.

-----------------------------------------------------------------*/


import androidx.annotation.NonNull;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class PostsDatabase extends Database {

    //Atributos de clase.
    private long Size;
    private ArrayList<Publicacion> posts;


    //Constructor que permite definir la rama de la base de datos que se consultará y se inicializan los atributos.
    public PostsDatabase(String p){
        super(p);
        Size = 0;
        posts = new ArrayList<Publicacion>();
    }

    //Método que permite crear un nuevo post conectando a la base de datos.
    public void newPost(Publicacion p){
        reference.child(Long.toString(p.getId())).setValue(p);
    }

    //Método que permite obtener todos los posts de la base de datos.
    public ArrayList<Publicacion> getPosts(){
        //Se crea un listener que espera a que los datos cambien en la base.
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Cuando cambian, se obtienen todos los posts realizados.
                long count = snapshot.getChildrenCount();
                ArrayList<Publicacion> temp = new ArrayList<Publicacion>();
                for(long i = 0; i<count; i++){
                    String index = Long.toString(i+1);
                    String description = snapshot.child(index).child("description").getValue().toString();
                    String location = snapshot.child(index).child("location").getValue().toString();
                    String type = snapshot.child(index).child("type").getValue().toString();
                    String user = snapshot.child(index).child("user").getValue().toString();
                    Publicacion p = new Publicacion(user,location,type,description);
                    temp.add(p);
                }
                posts = temp;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Se devuelven los posts en un arraylist.
        return posts;

    }

    //Método que permite obtener el tamaño de la base de datos, lo que servirá como ID para un nuevo post.
    public long getSize(){
        reference.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        Size = dataSnapshot.getChildrenCount();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        return Size;
    }

}
