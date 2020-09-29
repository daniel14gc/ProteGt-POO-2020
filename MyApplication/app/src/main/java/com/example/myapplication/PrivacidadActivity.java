/*  #################################################

        En esta clase el usuario debe aceptar las
        condiciones de privacidad para poder,
        registrarse en la aplicacion.

    ################################################# */



package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PrivacidadActivity extends Activity {

    ImageView cara;
    TextView titulo;
    Button siguiente;


    // Cuando se cree el layout de Privacidad se realizaran las siguientes acciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacidad);
        cara = findViewById(R.id.cara);
        cara.bringToFront();
        titulo = findViewById(R.id.Titulo);
        titulo.bringToFront();



        // Si el usuario acepta las condiciones de privacidad se procede a abrir el siguiente layout.

        siguiente = findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrivacidadActivity.this, NotificacionActivity.class);
                startActivity(intent);
            }
        });

    }


}