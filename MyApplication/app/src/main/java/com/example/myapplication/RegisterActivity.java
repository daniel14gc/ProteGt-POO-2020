package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity{

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
        user =  (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
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
                    if(pw.equals(cpw)){
                        error.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(RegisterActivity.this, NotificacionActivity.class);
                        startActivity(intent);

                    }
                    else{
                        error.setText("Las contraseñas no coinciden");
                        error.setVisibility(View.VISIBLE);
                    }
                 }

            }
        });
    }
}