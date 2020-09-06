/*  ##########################################################

        Este metodo se creo para solicitarle al usuario
         que permita que la aplicacion pueda utilizar
                         su ubicacion.

    ########################################################## */


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificacionActivity extends AppCompatActivity{

    Button activarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        activarButton = findViewById(R.id.Acept1);

        activarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificacionActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}