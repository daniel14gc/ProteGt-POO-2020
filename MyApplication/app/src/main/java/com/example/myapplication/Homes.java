/*-----------------------------------------------------------------
    Homes.java
    Grupo 6, proyecto semestral.
    Última modificación: 2020-10-7

    Clase que maneja el layout de la página de inicio de la aplicación.
    Aquí se muestran todas las publicaciones de los usuarios y 
    las opciones de las funcionalidades de la app, es decir el mapa
    de coronavirus, los infectados por departamento, la opción de 
    marcarse como infectado y cerrar sesión.

-----------------------------------------------------------------*/

//Paquetes importados para poder utilizar las funcionalidades de XML junto con java.
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
import java.util.Collections;
import java.util.HashMap;

//----------------------------------------------------------------------------

public class Homes extends AppCompatActivity {

    //Atributos de la clase
    static ArrayList<Publicacion> ListaDatos;

    RecyclerView recycler;

    ImageView newpost;
    ImageView mini;
    ImageView mapa;
    TextView cerrar;
    Switch estado;
    TextView getuser;
    ImageView home;


    //Partes de la vida del activity.

    //OnResume para el momento en el cual la activity no ha muerto, sino que quedó en pausa.
    @Override
    protected void onResume() {
        super.onResume();

        //Se crea el contenedor que tendrá las publicaciones y las muestra.
        recycler = findViewById(R.id.ReciclerPub);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        AdapterDatos adapter = new AdapterDatos(ListaDatos);
        recycler.setAdapter(adapter);
    }

    //OnStart es el momento en el cual vuelve a cargar la activity.
    @Override
    protected void onStart() {
        super.onStart();

        //Se crea el contenedor que tendrá las publicaciones y las muestra.
        ListaDatos = Driver.getPosts();
        recycler = findViewById(R.id.ReciclerPub);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        AdapterDatos adapter = new AdapterDatos(ListaDatos);
        recycler.setAdapter(adapter);
    }


    //OnCreate es el momento en el cual se crea la activity por primera vez.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Conexión con el XML.
        setContentView(R.layout.activity_homes);

        //Conexión con la parte gráfica del botón que permite añadir una publicación.
        newpost = findViewById(R.id.newpost);

        //Creación del listener que espera a que el botón sea presionado.
        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homes.this, Publica.class);
                startActivity(intent);
            }
        });

        //Conexión con la parte gráfica del botón que permite añadir una publicación.
        estado = findViewById(R.id.estado);

        //Creación listener que espera a que el botón sea presionado.
        estado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Driver.verificar(!estado.isChecked())){
                    Driver.enfermo();
                }
            }
        });


        //Conexión con la parte gráfica del botón del menú donde se puede cerrar sesión o cambiar el estado de contagio.
        mini = findViewById(R.id.menu);

        //Se obtiene el label donde se pondrá el nombre de usuario de la persona que está usando la aplicación.
        getuser = findViewById(R.id.getusuario);

        //Se obtiene la referencia al layout donde saldrá la información para cambiar el estado de contagio, cerrar sesión y el usuario.
        final LinearLayout ly = findViewById(R.id.minimenu);

        //Se escribe en el label el nombre del usuario que está en la aplicación.
        getuser.setText(Driver.persona.getUser());

        //Se crear el listener que espera a que se presione el botón para acceder al menú.
        mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //El switch que define si el usuario está contagiado o no, se enciende o apaga dependiendo del estado de contagio real de
                //la persona.
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

        //Conexión con la parte gráfica del botón del menú donde se puede cerrar sesión o cambiar el estado de contagio.
        mapa = findViewById(R.id.departamentos);

        //Se crea el listener que espera a que el botón del mapa sea presionado.
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapaCovid();
            }
        });

        //Se obtiene conexión al botón para cerrar sesión.
        cerrar = findViewById(R.id.cerrarsesion);

        //Se crea el listener que espera para que el usuario cierre sesión y se sale de la aplicación.
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homes.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void porDepartamento(View view) {
        //Comunicación con el nuevo Layout donde se muestran los contagios por departamento.
        Intent siguiente = new Intent(this, PorDepartamentoActivity.class);
        startActivity(siguiente);

    }


    public void MapaCovid(){
        //Comunicación con el nuevo Layout donde se muestra el mapa con los contagiados.
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }
}