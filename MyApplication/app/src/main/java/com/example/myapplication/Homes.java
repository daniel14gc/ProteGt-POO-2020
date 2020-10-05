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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Homes extends AppCompatActivity {

    static PostsDatabase posts = new PostsDatabase("Publicaciones");
    static ArrayList<Publicacion> ListaDatos;

    RecyclerView recycler;

    ImageView newpost;
    ImageView mini;
    ImageView mapa;
    TextView cerrar;
    Switch estado;
    TextView getuser;


    @Override
    protected void onResume() {
        super.onResume();

        recycler = findViewById(R.id.ReciclerPub);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));

        AdapterDatos adapter = new AdapterDatos(ListaDatos);

        recycler.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListaDatos = posts.getPosts();


        recycler = findViewById(R.id.ReciclerPub);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));

        AdapterDatos adapter = new AdapterDatos(ListaDatos);

        recycler.setAdapter(adapter);

    }


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

        estado = findViewById(R.id.estado);
        estado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Driver.verificar(!estado.isChecked())){
                    Driver.enfermo();
                }
            }
        });



        mini = findViewById(R.id.menu);
        getuser = findViewById(R.id.getusuario);
        final LinearLayout ly = findViewById(R.id.minimenu);

        getuser.setText(Driver.persona.getUser());
        mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                estado.setChecked(Driver.obtenerestado());
                ly.bringToFront();
                if (ly.isShown() == true){
                    ly.setVisibility(View.INVISIBLE);
                }
                else{
                    ly.setVisibility(View.VISIBLE);
                }

            }
        });

        mapa = findViewById(R.id.departamentos);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapaCovid();
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


    public void MapaCovid(){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }


}