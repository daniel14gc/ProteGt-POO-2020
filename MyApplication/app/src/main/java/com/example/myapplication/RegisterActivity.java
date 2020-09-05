package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

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
        backArrow = findViewById(R.id.back2);
        backArrow.bringToFront();
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String us = user.getText().toString();
                String pw = password.getText().toString();
                String cpw = confirmPassword.getText().toString();
                if(us.isEmpty()||pw.isEmpty()||cpw.isEmpty()){
                    error.setText("Llene todos los espacios");
                    error.setVisibility(View.VISIBLE);
                }
                 else {
                    if(pw.equals(cpw)&& !pw.equals(us)){
                        error.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(RegisterActivity.this, PrivacidadActivity.class);
                        startActivity(intent);

                    }
                    else if (!pw.equals(cpw)){
                        error.setText("Las contraseñas no coinciden");
                        error.setVisibility(View.VISIBLE);
                    }
                    else if (pw.equals(us)) {
                        error.setText("La contraseña coincide con el usuario");
                        error.setVisibility(View.VISIBLE);
                    }
                 }

            }
        });
    }
}