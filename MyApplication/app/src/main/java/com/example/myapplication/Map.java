package com.example.myapplication;

/*  #######################################################

        Esta clase contiene todos los metodos y atributos
        necesarios para mostrar el mapa al usuario.

    ###################################################### */



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    LatLng latLng;
    ImageView flecha;
    ImageView regreso;



    // Metodo que define las acciones que se realizaran cuando se cree el activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        flecha = findViewById(R.id.flecha);
        regreso = findViewById(R.id.back);


        // Al cliquear el boton de regreso, la aplicacion retorna al usuario a homes.

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(this);
    }

    // Metodo que define las acciones que se realizaran cuando el mapa este listo

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        latLng = new LatLng(14.618988, -90.471653);

        gMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {

            // Este metodo define que acciones se realizaran cuando el mapa se cargue

            @Override
            public void onMapLoaded() {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);

                markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                gMap.clear();

                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

                gMap.addMarker(markerOptions);
            }
        });

    }

    // Metodo para retornar a homes

    public void home(){
        Intent intent = new Intent(Map.this, Homes.class);
        startActivity(intent);
    }
}