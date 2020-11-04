package com.example.myapplication;

/*
    selectUbicacion.java
    Grupo 6, proyecto semestral.
    Última modificación: 2020-10-23

    Clase que permite seleccionar una locación específica
    para realizar una publicación.
*/


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class selectUbicacion extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    //Atributos de clase.
    private GoogleMap gMap;
    private LatLng latLng;
    private Button regreso;
    private Location currentLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Marker marker;
    private static final int REQUEST_CODE = 101;


    // Metodo que define las acciones que se realizaran cuando se cree el activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ubicacion);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();
        publica();

    }

    //Método que permite obtener la locación del usuario para realizar publicación.
    public void fetchLastLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return; //Se obtiene el permiso del usuario para el uso de localización.
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation(); //Se obtiene su localización.
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!= null){
                    currentLocation = location;
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    supportMapFragment.getMapAsync(selectUbicacion.this); //Se pone la ubicación en el mapa como marcador.
                }
            }
        });
    }


    //Metodo que define las acciones que se realizaran cuando el mapa se haya creado.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()); //Se obtiene la localización del usuario y se guarda.
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
        marker = gMap.addMarker(new MarkerOptions() //Se crea un nuevo marcador en el mapa, con la ubicación del usuario, el cual puede ser arrastrable.
                .position(latLng)
                .draggable(true)
                .title("Ubicación")
        );

        gMap.setOnMarkerDragListener(this);
    }

    //Override de método que permite obtener el permiso para usar la ubicación del usuario.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    //Método que permite arrastrar un marcador en el mapa.
    @Override
    public void onMarkerDragEnd(Marker marker) {
        this.marker = marker;
    }

    // Metodo que permite obtener la ubicación especificada por el usuario como latitud y longitud, para guardar la ubicación.
    public void publica(){
        regreso = findViewById(R.id.position);
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectUbicacion.this, Publica.class);
                intent.putExtra("latitude", Double.toString(marker.getPosition().latitude));
                intent.putExtra("longitude", Double.toString(marker.getPosition().longitude));
                startActivity(intent);
            }
        });
    }
}