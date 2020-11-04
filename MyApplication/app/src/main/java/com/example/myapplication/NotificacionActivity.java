package com.example.myapplication;

/*-------------------------------------
Proyecto: ProteGt
Clase: LoginActivity

Clase que permite mostrar el layout de Notificacion y tiene los metodos
para que funcione los botones

 -------------------------------------*/

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificacionActivity extends AppCompatActivity{

    private Button activarButton;
    private TextView msm2;

    //Metodo que indica las acciones que se realizan cuando se crea el Layout.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        activarButton = findViewById(R.id.Acept1);
        msm2 = findViewById(R.id.sms2);
        //Cuando se cliquee el boton de aceptar, se procedera a mover al usuario al Layout de Inicio.
        activarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificacionActivity.this, Homes.class);
                startActivity(intent);
            }
        });
        msm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificacionActivity.this, Homes.class);
                startActivity(intent);
            }
        });

    }
}