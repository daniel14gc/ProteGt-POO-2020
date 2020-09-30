package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Publica extends AppCompatActivity {
    TextView donde;
    CheckBox tipo1;
    CheckBox tipo2;
    TextView comentario;
    CheckBox anonimo;
    Button publicar;
    String dn ="";
    String tp ="";
    String cm ="";
    Boolean anonim= false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publica);

        publicar = findViewById(R.id.publicar);
        donde = findViewById(R.id.new_donde);
        tipo1 = findViewById(R.id.new_infe);
        tipo2 = findViewById(R.id.new_ano);
        comentario = findViewById(R.id.com);
        anonimo = findViewById(R.id.anonimo);
        dn = donde.getText().toString();
        tp = "";
        cm = comentario.getText().toString();

        tipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo2.setChecked(false);
                tp = "Infectado";
            }
        });

        tipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo1.setChecked(false);
                tp = "Anomalia";

            }
        });

        anonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anonim = true;
            }
        });

        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(anonim==false){
                    Publicacion p = new Publicacion("admin",dn,tp,cm);
                    //en admin hay que poner al usuario
                }
                else if(anonim==true){
                    Publicacion p = new Publicacion("anonimo",dn,tp,cm);
                }
                Intent intent = new Intent(Publica.this, Homes.class);
                startActivity(intent);
            }
        });

    }
}