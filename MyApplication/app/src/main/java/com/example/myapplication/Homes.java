/*  ##########################################################

        Esta clase se creo para mostrar el inicio de
        la aplicacion al usuario.

    ########################################################## */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

<<<<<<< HEAD
=======
public class Homes extends Activity {
>>>>>>> 2bd7301fffafbee0915bbf4f1de8cc6017704dca

public class Homes extends AppCompatActivity {
    ImageView newpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        newpost = findViewById(R.id.newpost);

        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homes.this, Publica.class);
                startActivity(intent);
            }
        });
    }
}