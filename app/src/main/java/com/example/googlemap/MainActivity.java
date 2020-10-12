package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;

=======
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
>>>>>>> Stashed changes
public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
=======

import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;


import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;



public class MainActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    GoogleMap googleMa;
    double latitude;

    double longitude;
    private Location mLastLocation = null;

    String mPermission = android.Manifest.permission.ACCESS_FINE_LOCATION;

    private static final int REQUEST_CODE = 101;

>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(MainActivity.this);
                }
            }
        });
    }
<<<<<<< Updated upstream
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("I am here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
<<<<<<< Updated upstream
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
=======
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
>>>>>>> Stashed changes
        googleMap.addMarker(markerOptions);
    }
    @Override
=======



    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("I am here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));


        googleMap.addMarker(markerOptions);
    }

    @Override
    public void onLocationChanged(Location location) {
        Location mLastLocation = null;
        // use latitude and longitude given by
        // location.getLatitude(), location.getLongitude()
        // for updated location marker
        Log.d("aaaaaaaa===>", "" + location.getLatitude() + "\n" + location.getLongitude());
        // displayLocation();

        // to remove old markers
        GoogleMap googleMa = null;
        googleMa.clear();
        final LatLng loc = new LatLng(location.getLongitude(), location.getLongitude());

        Marker ham = googleMa.addMarker(new MarkerOptions().position(loc).title("This is Me").icon(BitmapDescriptorFactory.fromResource(R.drawable.greenpointer)));
        googleMa.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));

        Toast.makeText(getApplicationContext(), loc.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
>>>>>>> Stashed changes
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }

    }
}