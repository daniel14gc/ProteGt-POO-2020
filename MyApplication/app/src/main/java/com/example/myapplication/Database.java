package com.example.myapplication;

/*-------------------------------------
Proyecto: ProteGt
Clase: Database

Clase que permite definir las caracteristicas
principales de la base de datos, para poder
realizar conexiones.

 -------------------------------------*/

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public abstract class Database extends AppCompatActivity implements DBOps {

    //Atributos de clase.
    protected FirebaseDatabase database;
    protected DatabaseReference reference;
    protected ArrayList<Object> elementos;
    protected String path;
    protected long Size;

    public Database(String p){
        path=p; //Definicion de tabla de base de datos.
        FirebaseApp.initializeApp(this);

        //Conexion a base de datos y tabla de usuarios.
        database = FirebaseDatabase.getInstance();
        reference = database.getReference(path);
        elementos = new ArrayList<Object>();
        Size=0;
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

    @Override
    public abstract void addElements(Object n);



    @Override
    public abstract ArrayList<Object> getElements();

    @Override
    public abstract void modificarElemento(Object n);
}


