package com.example.myapplication;

//#########################################################################

//Clase que tiene la función de mostrar los contagios por departamento en una nueva activity

// #########################################################################


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PorDepartamentoActivity extends AppCompatActivity {
    //muestra la activity donde están todos los departamentos   y cuantos contagios hay en cada uno
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_departamento);
    }
    //método que sirve par poder volver al menú de inicio
    public void regresar(View view) {

        Intent i = new Intent(this, Homes.class);
        startActivity(i);
    }
}