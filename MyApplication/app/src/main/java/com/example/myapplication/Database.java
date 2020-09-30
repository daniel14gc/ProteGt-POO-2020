package com.example.myapplication;

/*-------------------------------------
Proyecto: ProteGt
Fecha de modificacion: 09-30-2020
Clase: Database

Clase que permite definir las caracteristicas
principales de la base de datos, para poder
realizar conexiones.

 -------------------------------------*/

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database extends AppCompatActivity {

    //Atributos de clase
    FirebaseDatabase database;
    DatabaseReference reference;
    String path;

    public Database(String p){
        path=p; //Definicion de tabla de base de datos.
        FirebaseApp.initializeApp(this);

        //Conexion a base de datos y tabla de usuarios.
        database = FirebaseDatabase.getInstance();
        reference = database.getReference(path);
    }






}


