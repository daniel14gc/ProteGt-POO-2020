//#########################################################################

// Clase que permite realizar la conexión a la parte de los usuarios de la base de datos.
// Aquí se puede agregar un nuevo usuario a la base de datos, obtener todos los usuarios
// de la base de datos y modificar el estado de infección de Covid. Hereda de Database,
// para poder definir  que se utilizará la rama de usuarios.

// #########################################################################


package com.example.myapplication;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;

public class UserDatabase extends Database {
    //Atributo de subclase que permite guardar los datos de usuarios.
    private ArrayList<Persona> respuestas;
    private String aber;
    private long Size;

    //Define la ruta de la base de datos de donde se obtendrán los datos, es decir de los usuarios. Inicializa la lista de personas.
    public UserDatabase(String path) {
        super(path);
        respuestas = new ArrayList<Persona>();
        Size = 0;
        aber = "";
    }

    public void getUsuario() {

    }

    public void getStatus() {

    }
    //Permite añadir una persona previamente creada a la base de datos, cuando un nuevo usuario se registra.
    public void add(Persona p) { //Metodo que permite añadir un usuario a la base de datos.
        reference.child(p.getUser()).setValue(p);
    }


    public ArrayList<Persona> getUsuarios(){
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Persona> temp = new ArrayList<Persona>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String user = snapshot.child("user").getValue(String.class);
                    boolean status = snapshot.child("status").getValue(Boolean.class);
                    String password = snapshot.child("password").getValue(String.class);
                    Persona p = new Persona(user, password, status);
                    temp.add(p);
                }
                respuestas = temp;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return respuestas;
    }

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
    //Cambia el estado de infección de coronavirus de una persona cuando es marcado por el usuario dentro de la aplicación.
    public void modificarestado(Persona p){
        reference.child(p.getUser()).child("status").setValue(p.getStatus());
    }

}