package com.example.myapplication;

/*  #######################################################

        Esta clase contiene todos los metodos y atributos
        necesarios para mostrar el mapa al usuario.

    ###################################################### */



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    private LatLng latLng;
    private ImageView flecha;
    private ImageView regreso;
    private Location currentLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Marker marker;
    private static final int REQUEST_CODE = 101;

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

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();

    }

    //obtiene la ultima locacion del usuario
    public void fetchLastLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!= null){
                    currentLocation = location;
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    supportMapFragment.getMapAsync(Map.this);
                }
            }
        });
    }

    // Metodo que define las acciones que se realizaran cuando el mapa este listo

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        marker = gMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true)
                .title("Tu ubicación")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        );
        setMarkers();
        obtenerIntent();
    }

    //solicita permisos para poder acceder a la ubicacion del usuario
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

    // Metodo para retornar a homes
    public void home(){
        Intent intent = new Intent(Map.this, Homes.class);
        startActivity(intent);
    }

    //pone los marcadores que se muestran en el mapa
    public void setMarkers(){
        ArrayList<Publicacion> publicaciones = Driver.getPosts();
        for(int i = 0; i<publicaciones.size(); i++){
            Publicacion temp = publicaciones.get(i);
            String tipo = temp.getType();
            double latitude = temp.getLatitude();
            double longitude = temp.getLongitude();
            latLng = new LatLng(latitude, longitude);
            if(tipo.equals("Infectado")){
                marker = gMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .draggable(true)
                        .title("Infectados:")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                );
            }
            else {
                marker = gMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .draggable(true)
                        .title("Anomalía")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                );
            }
        }
    }

    //obtiene la ubicacion de una publicacion
    public void obtenerIntent(){
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            Long id = Long.parseLong(intent.getStringExtra("id"));
            Double[] localizacion = Driver.localizacion(id);
            latLng = new LatLng(localizacion[0], localizacion[1]);
            gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        }
    }
}