package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    String path;

    public Database(String p){
        path=p;
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference(path);
    }

    public int write(Persona p){
        reference.child(p.getUser()).setValue(p);
        return -1;
    }

    public boolean buscar(String username){
        return false;
    }



}


