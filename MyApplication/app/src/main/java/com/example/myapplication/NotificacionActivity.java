package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
=======
import android.app.Activity;
>>>>>>> 72025d2d6ee27d2b0dc0be49ad8ceaf7851671e0
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificacionActivity extends AppCompatActivity{

    Button activarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        /*
        activarButton = findViewById(R.id.Acept1);

        activarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificacionActivity.this, PrivacidadActivity.class);
                startActivity(intent);
            }
        });*/

    }
}