package com.naimyag.ornek.mineline;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Created by Naim on 9.02.2016.
 */
public class Harita extends FragmentActivity implements OnMapReadyCallback {


    private Bundle extras=null;
    private Double mLat,mLng;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.harita);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        extras=getIntent().getExtras();
        mLat= extras.getDouble("lat");
        mLng=extras.getDouble("lng");

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if(mLat!=null&&mLng!=null) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(mLat, mLng);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
           // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
           mMap.setContentDescription(null);

            final CircleOptions circOp=new CircleOptions().center(new LatLng(mLat, mLng))
                    .radius(100)
                    .strokeColor(Color.GRAY)
                    .strokeWidth(2)
                    .fillColor(Color.argb(100, 104, 220, 112));

            mMap.addCircle(circOp);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(sydney).zoom(16)
                    .bearing(90).tilt(20).build();

            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));





            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {


                    LatLng center = circOp.getCenter();
                    double radius = circOp.getRadius();
                    float[] distance = new float[1];
                    Location.distanceBetween(latLng.latitude, latLng.longitude, center.latitude, center.longitude, distance);
                    final boolean clicked = distance[0] < radius;

                    if(clicked){
                        mMap.addMarker(new MarkerOptions().position(latLng).title("Mayın Yerleştir!"));
                        Toast.makeText(Harita.this,"Nağber",Toast.LENGTH_LONG).show();
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                return false;
                            }
                        });
                    }
                }
            });


        }else {

            LatLng sydney = new LatLng(41, 29);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }
}
