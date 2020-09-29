/*  ##########################################################

        Esta clase se creo para mostrar el inicio de
        la aplicacion al usuario.

    ########################################################## */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class Homes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
    }
}