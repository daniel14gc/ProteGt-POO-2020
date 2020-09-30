package com.example.myapplication;

/*-------------------------------------
Proyecto: ProteGt
Fecha de modificacion: 09-30-2020
Clase: UserDatabase

Subclase que hereda de database, la cual
permite conectarse a la tabla que contiene
los usuarios de la aplicación.
 -------------------------------------*/

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDatabase extends Database {
    //Atributo de subclase que permite guardar los datos de usuarios.
    ArrayList <String> respuestas;

    public UserDatabase(String path){
        super(path);
        respuestas = new ArrayList<String>();
    }

    public void getUsuario(){

    }

    public void getStatus(){

    }

    public int add(Persona p){ //Metodo que permite añadir un usuario a la base de datos.
        if(buscar(p.getUser()) == false){
            reference.child(p.getUser()).setValue(p);
            return 0;
        }
        return -1;
    }



    //Metodo que permite comparar un usuario ingresado al hacer el login y definir si existe y la contraseña es correcta.
    public boolean buscar(final String pw, final String usuario){

        //Se hace la llamada a la base de datos en la tabla especificada.
        Query checkUser = reference.orderByChild("user").equalTo(pw);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener(){
           @Override

           public void onDataChange(@NonNull DataSnapshot dataSnapshot)
           {
                if(dataSnapshot.exists())
                {
                    //Se obtiene la contraseña y usuario del nombre de usuario ingresado.
                    String userDB = dataSnapshot.child(usuario).child("user").getValue(String.class);
                    String passwordDB = dataSnapshot.child(usuario).child("password").getValue(String.class);
                    if(userDB.equals(usuario) && passwordDB.equals(pw)){
                        respuestas.add(userDB);
                    }
                }
           }
           @Override
           public  void  onCancelled(@NonNull DatabaseError databaseError)
           {

           }

        });
        if(respuestas != null){
            return true;
        }
        else{
            return false;
        }

    }

    //Metodo que permite buscar un usuario existente para valida el registro.
    private boolean buscar(final String usuario){

        //Se hace la llamada a la base de datos en la tabla especificada.
        Query checkUser = reference.orderByChild("user").equalTo(usuario);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.exists())
                {
                    //Se obtiene la contraseña y usuario del nombre de usuario ingresado.
                    String userDB = dataSnapshot.child(usuario).child("user").getValue(String.class);
                    if(userDB.equals(usuario)){
                        respuestas.add(userDB);
                    }
                }
            }
            @Override
            public  void  onCancelled(@NonNull DatabaseError databaseError)
            {

            }

        });
        if(respuestas != null){
            return true;
        }
        else{
            return false;
        }

    }
}
