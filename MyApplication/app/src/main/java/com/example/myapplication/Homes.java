/*  ##########################################################

        Esta clase se creo para mostrar el inicio de
        la aplicacion al usuario.

    ########################################################## */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Homes extends AppCompatActivity {
    ImageView newpost;
    ImageView mini;
    ImageView mapa;
    TextView cerrar;
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



        mini = findViewById(R.id.menu);
        final LinearLayout ly = findViewById(R.id.minimenu);

        mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ly.isShown() == true){
                    ly.setVisibility(View.INVISIBLE);
                }
                else{
                    ly.setVisibility(View.VISIBLE);
                }

            }
        });



        cerrar = findViewById(R.id.cerrarsesion);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homes.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void porDepartamento(View view) {

        Intent siguiente = new Intent(this, PorDepartamentoActivity.class);
        startActivity(siguiente);

    }


}