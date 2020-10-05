/*  #############################################################

        Esta clase controla lo que se realiza en el Layout
        activity_registar, contiene todos los metodos
        necesarios para verificar si el usuario podra
        registrarse o no.

    #############################################################   */

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity{

    Driver driver = new Driver();

    Button register;
    EditText user;
    EditText password;
    EditText confirmPassword;
    TextView error;
    ImageView backArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);
        register = findViewById(R.id.loginBtn2);
        user =  (EditText) findViewById(R.id.user2);
        password = (EditText) findViewById(R.id.contrasena);
        confirmPassword = (EditText) findViewById(R.id.conficontrasena);
        error = findViewById(R.id.error1);


        // Si el usuario desea retornar al Layout anterior cliquea la flecha.

        backArrow = findViewById(R.id.back2);
        backArrow.bringToFront();
        backArrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        // Si el usuario cliquea el boton de registro se

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                // Solicitud de informacion a los EditText

                String us = user.getText().toString();
                String pw = password.getText().toString();
                String cpw = confirmPassword.getText().toString();

                //Si no se ingreso informacion en algun EditText

                if(us.isEmpty()||pw.isEmpty()||cpw.isEmpty()){
                    error.setText("Llene todos los espacios");
                    error.setVisibility(View.VISIBLE);
                }

                // Si todos los EditText NO estan vacios

                else {

                    if(pw.equals(cpw)&& !pw.equals(us)){
                        error.setVisibility(View.INVISIBLE);

                        // Generar usuario y guardarlo
                        int res = Driver.addUser(us,pw);
                        if(res == 0){
                            Intent intent = new Intent(RegisterActivity.this, PrivacidadActivity.class);
                            startActivity(intent);
                        }
                        else{
                            error.setVisibility(View.VISIBLE);
                            error.setText("El nombre de usuario ya existe. Ingrese uno diferente.");
                        }
                    }
                    // Si las contrasenas no son iguales:

                    else if (!pw.equals(cpw)){
                        error.setText("Las contraseñas no coinciden");
                        error.setVisibility(View.VISIBLE);
                    }

                    //Si la contrasena es igual al usuario

                    else if (pw.equals(us)) {
                        error.setText("La contraseña es igual al usuario, por seguridad ingrese algo diferente");
                        error.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
        register.performClick();
    }
}