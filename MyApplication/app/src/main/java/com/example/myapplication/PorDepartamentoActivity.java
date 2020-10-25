package com.example.myapplication;

//#########################################################################

//Clase que tiene la función de mostrar los contagios por departamento en una nueva activity

// #########################################################################


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PorDepartamentoActivity extends AppCompatActivity {
    //muestra la activity donde están todos los departamentos   y cuantos contagios hay en cada uno
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_departamento);

        casosApp();
        casosGuate();
    }
    //método que sirve par poder volver al menú de inicio
    public void regresar(View view) {

        Intent i = new Intent(this, Homes.class);
        startActivity(i);
    }

    //actualiza el texto de una etiqueta para mostrar los casos activos de usuarios de la app
    private void casosApp(){
        TextView enApp = findViewById(R.id.casosenapp);
        enApp.setText(Driver.getCasosApp() + "");
    }

    //actualiza el texto de una etiqueta para mostrar los casos activos en guatemala
    private void casosGuate(){
        TextView enApp = findViewById(R.id.casosguate);
        enApp.setText(Driver.getCasosGuate() + "");
    }
}