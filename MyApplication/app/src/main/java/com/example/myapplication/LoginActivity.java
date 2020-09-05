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

    Button registerButton;
    Button loginButton;

    EditText user;
    EditText password;

    TextView error;

    Driver d = new Driver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user =  (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        error = findViewById(R.id.errordatos);

        registerButton = findViewById(R.id.buttonR);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD

        loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String us = user.getText().toString();
                String pw = password.getText().toString();
                if(us.isEmpty()||pw.isEmpty()){
                    error.setText("Llene todos los espacios");
                    error.setVisibility(View.VISIBLE);
                }
                else {

                    if (d.comparardatos(us, pw)){

                    }
                    else
                    {

                    }

                }

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

=======
>>>>>>> 47b36dd3539aabf367d8882b3693a26aaef69107
    }
}