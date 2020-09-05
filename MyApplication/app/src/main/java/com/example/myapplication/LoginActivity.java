/*  ##############################################################

        Esta clase controla lo que ocurre en el layout de Login,
        contiene los metodos necesarios para verificar si el
                    usuario puede entrar o no.

    #############################################################  */


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Driver driver = new Driver();

    Button registerButton;
    Button loginButton;

    EditText user;
    EditText password;

    TextView error;

    Driver d = new Driver();

    //Metodo que indica las acciones que se realizan cuando se crea el Layout.

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user =  (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        error = findViewById(R.id.errordatos);

        //Cuando se cliquee el boton de registro, se procedera a mover al usuario al Layout de registro.

        registerButton = findViewById(R.id.buttonR);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //Si el usuario cliquea el boton de login, se procede a verificar los datos para entrar o no.

        loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String us = user.getText().toString();
                String pw = password.getText().toString();

                // Se verifica si el usuario ingreso la informacion necesaria.

                if(us.isEmpty()||pw.isEmpty()){

                    // si NO, se le notifica al usuario que la ingrese.

                    error.setText("Llene todos los espacios");
                    error.setVisibility(View.VISIBLE);
                }
                else {

                    // Si SI, se comparan los datos con la informacion del almacen.

                    if (d.comparardatos(us, pw)){

                        // Si se encuentran los datos se procede al siguiente layout.

                        //llamar a la que toca con inicio exitoso
                        /*Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);*/
                    }
                    else {

                        //Si NO se encuentran los datos, se le notifica al usuario.

                        error.setText("Contraseña o usuario incorrectos");
                        error.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

    }
}