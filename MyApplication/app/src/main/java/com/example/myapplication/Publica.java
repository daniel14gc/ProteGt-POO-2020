package com.example.myapplication;
/*-------------------------------------
Proyecto: ProteGt
Clase: Publica

Clase que tiene la funcion de recabar
la informacion necesaria, dada por el
usuario para que se pueda geenrar una
nueva publicacion..
 -------------------------------------*/

import androidx.annotation.Nullable;
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

import com.google.android.gms.maps.model.Marker;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class Publica extends AppCompatActivity {
    //Atributos de la clase
    private EditText donde;
    private CheckBox tipo1;
    private CheckBox tipo2;
    private TextView comentario;
    private TextView ubicar;
    private CheckBox anonimo;
    private Button publicar;
    private String dn ="";
    private String tp ="";
    private String cm ="";
    private String us ="";
    private double latitude;
    private double longitude;
    private Boolean anonim= false;


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

        Driver.size();

        obtenerIntent();

        donde.setFocusable(true);

        ubicacion();

        ubica();

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
                us = Driver.getUser();

                //Se envia al driver para que la pueda guardar.
                if(anonim==false){
                    Publicacion p = new Publicacion(us,dn,tp,cm, latitude, longitude);
                    Driver.nuevaPublicacion(p);
                    //en admin hay que poner al usuario
                }
                else if(anonim==true){
                    Publicacion p = new Publicacion("anonimo",dn,tp,cm, latitude, longitude);
                    Driver.nuevaPublicacion(p);
                }
                Intent intent = new Intent(Publica.this, Homes.class);
                startActivity(intent);
            }
        });

    }

    public void obtenerIntent(){
        Intent intent = getIntent();
        if(intent.getExtras()!= null){
            latitude = Double.parseDouble(intent.getStringExtra("latitude"));
            longitude = Double.parseDouble(intent.getStringExtra("longitude"));
            donde.setText(latitude + ", " + longitude);
            donde.setFocusable(false);
        }
    }

    public void ubica(){
        ubicar = findViewById(R.id.ubicacion);
        ubicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Publica.this, selectUbicacion.class);
                startActivity(intent);
            }
        });
    }

    public void ubicacion(){
        Places.initialize(getApplicationContext(), "AIzaSyAJ-cQGbCZxm_Uax6PGbFE6EyOJetOqz6M");
        donde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME);

                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fieldList).build(Publica.this);

                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){

            Place place = Autocomplete.getPlaceFromIntent(data);

            donde.setText(place.getAddress());
            latitude = place.getLatLng().latitude;
            longitude = place.getLatLng().longitude;

            donde.setFocusable(false);
        }
    }
}