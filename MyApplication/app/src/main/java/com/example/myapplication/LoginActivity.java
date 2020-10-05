/*  ##############################################################

        Esta clase controla lo que ocurre en el layout de Login,
        contiene los metodos necesarios para verificar si el
                    usuario puede entrar o no.

    #############################################################  */


package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        user =  (EditText) findViewById(R.id.userlogin1);
        password = (EditText) findViewById(R.id.Passwordlogin);

        error = findViewById(R.id.errordatos);
        Driver.buscar("","");

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
                    Driver.buscar(us,pw);
                    // si NO, se le notifica al usuario que la ingrese.

                    error.setText("Llene todos los espacios");
                    error.setVisibility(View.VISIBLE);
                }
                else {
                    if(Driver.buscar(us,pw)){
                        Intent intent = new Intent(LoginActivity.this, Homes.class);
                        startActivity(intent);
                    }
                    else{
                        error.setText("Usuario o contraseña incorrectos. Inténtelo nuevamente.");
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        loginButton.performClick();

    }
}