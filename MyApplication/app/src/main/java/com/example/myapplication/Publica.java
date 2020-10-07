package com.example.myapplication;
/*-------------------------------------
Proyecto: ProteGt
Clase: Publica

Clase que tiene la funcion de recabar
la informacion necesaria, dada por el
usuario para que se pueda geenrar una
nueva publicacion..
 -------------------------------------*/

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
    //Atributos de la clase
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


//Metodo que se inicializa a la hora de mostrar por primera vez el activity
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
        tp = "";

        //Funcion que se realiza al precionar el boton para indicar que
        // el reporte es de un infectado.
        tipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo2.setChecked(false);
                tp = "Infectado";
            }
        });

        //Funcion que se realiza al precionar el boton para indicar que
        // el reporte es de una anomalia.
        tipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo1.setChecked(false);
                tp = "Anomalia";

            }
        });

        //indicar si la publicacion sera anonima o no.
        anonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anonim = true;
            }
        });

        //metodo que se realiza al precionar el boton de publicar.
        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se toman los valores de los comentarios e informacion del usuario
                dn = donde.getText().toString();
                cm = comentario.getText().toString();

                //Se envia al driver para que la pueda guardar.
                if(anonim==false){
                    Publicacion p = new Publicacion("admin",dn,tp,cm);
                    Driver.nuevaPublicacion(p);
                    //en admin hay que poner al usuario
                }
                else if(anonim==true){
                    Publicacion p = new Publicacion("anonimo",dn,tp,cm);
                    Driver.nuevaPublicacion(p);
                }
                Intent intent = new Intent(Publica.this, Homes.class);
                startActivity(intent);
            }
        });

    }
}