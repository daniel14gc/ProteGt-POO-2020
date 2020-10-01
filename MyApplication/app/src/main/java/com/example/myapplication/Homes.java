/*  ##########################################################

        Esta clase se creo para mostrar el inicio de
        la aplicacion al usuario.

    ########################################################## */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Homes extends AppCompatActivity {

    ArrayList<HashMap<String,String>> ListaDatos;

    RecyclerView recycler;

    ImageView newpost;
    ImageView mini;
    ImageView mapa;
    TextView cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        recycler = findViewById(R.id.ReciclerPub);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));



        ListaDatos = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < 5; i++) {

            HashMap<String,String> l = new HashMap<String, String>();

            l.put("usuario", "ejemplo");
            l.put("titulo", "Este es un titulo de ejemplo");
            l.put("descripcion", "Esta es una descripcion de ejemplo que necesita tener más caracteres y quiero decirte comeme beibi");

            ListaDatos.add(l);

        }

        AdapterDatos adapter = new AdapterDatos(ListaDatos);

        recycler.setAdapter(adapter);











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