/*  ##########################################################

        Esta clase se creo para mostrar el inicio de
        la aplicacion al usuario.

    ########################################################## */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



public class Homes extends AppCompatActivity {
    ImageView newpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        newpost = findViewById(R.id.newpost);

        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homes.this, Publica.class);
                startActivity(intent);
            }
        });
    }

    public void porDepartamento(View view) {

        Intent siguiente = new Intent(this, PorDepartamentoActivity.class);
        startActivity(siguiente);

    }

}