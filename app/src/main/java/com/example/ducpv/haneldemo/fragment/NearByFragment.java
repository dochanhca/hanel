package com.example.ducpv.haneldemo.fragment;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.NearByAdapter;
import com.example.ducpv.haneldemo.model.NearByItem;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ducpv on 12/6/17.
 */

public class NearByFragment extends BaseFragment implements OnMapReadyCallback {

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 111;
    private static final float DEFAULT_ZOOM = 15;
    private static final LatLng DEFAULT_LATLNG = new LatLng(10.8010112,106.6813743);
    private static final int DEFAULT_RADIUS = 200;

    private SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private boolean mLocationPermissionGranted;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    private TextView txtDistance;
    private RecyclerView recyclerNearBy;
    private NearByAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_near_by;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        // Construct a FusedLocationProviderClient.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        txtDistance = rootView.findViewById(R.id.txt_distance);
        recyclerNearBy = rootView.findViewById(R.id.recycler_near_by);
        initRecyclerNearBy();
    }

    private void initRecyclerNearBy() {
        adapter = new NearByAdapter(getActivity().getApplicationContext(), getMockDatas());
        recyclerNearBy.setAdapter(adapter);
        recyclerNearBy.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerNearBy.addItemDecoration(dividerItemDecoration);
    }

    private List<NearByItem> getMockDatas() {
        List<NearByItem> nearByItems = new ArrayList<>();

        NearByItem nearByItem = new NearByItem("Coffee bean",
                "Số 20 Phan Xích Long, P2, Quận Phú Nhuận, TP HCM", "192.158.2", "2 Ưu đãi",
                R.drawable.img_promotion_1);

        NearByItem nearByItem1 = new NearByItem("House of Cha", "185 Kim Mã, Ba Đình, Hà Nội",
                "192.123.3", "5 ưu đãi", R.drawable.img_house_of_cha);

        nearByItems.add(nearByItem1);
        nearByItems.add(nearByItem);

        return nearByItems;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                DEFAULT_LATLNG, DEFAULT_ZOOM));
        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();

        LatLng firstMarker = getLocation(DEFAULT_LATLNG.longitude, DEFAULT_LATLNG.latitude, DEFAULT_RADIUS);
        LatLng secondMarker = getLocation(DEFAULT_LATLNG.longitude, DEFAULT_LATLNG.latitude, DEFAULT_RADIUS);

        addMarkerToMap("Coffee bean", "Số 20 Phan Xích Long, P2, quận Phú Nhuận",
                secondMarker);

        addMarkerToMap("House of Cha", "185 Kim Mã, Ba Đình, Hà Nội",
                firstMarker);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                    updateLocationUI();
                }
            }
        }

    }

    private void getLocationPermission() {
    /*
     * Request location permission, so that we can get the location of the
     * device. The result of the permission request is handled by a callback,
     * onRequestPermissionsResult.
     */
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this.getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                getLocationPermission();
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    private void getDeviceLocation() {
    /*
     * Get the best and most recent location of the device, which may be null in rare
     * cases when a location is not available.
     */
        try {
            if (mLocationPermissionGranted) {
                Task locationResult = mFusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(getActivity(), new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            // Set the map's camera position to the current location of the device.
                            Location mLastKnownLocation = (Location) task.getResult();
                            LatLng myLatlng = new LatLng(mLastKnownLocation.getLatitude(),
                                    mLastKnownLocation.getLongitude());

                            mMap.clear();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatlng
                                    , DEFAULT_ZOOM));

                            LatLng firstMarker = getLocation(myLatlng.longitude, myLatlng.latitude, DEFAULT_RADIUS);
                            LatLng secondMarker = getLocation(myLatlng.longitude, myLatlng.latitude, DEFAULT_RADIUS);

                            addMarkerToMap("Coffee bean", "Số 20 Phan Xích Long, P2, quận Phú Nhuận",
                                    secondMarker);

                            addMarkerToMap("House of Cha", "185 Kim Mã, Ba Đình, Hà Nội",
                                    firstMarker);
                        } else {
                            Log.e(TAG, "Current location is null. Using defaults.");
                            Log.e(TAG, "Exception: %s", task.getException());
                            mMap.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    private void addMarkerToMap(String title, String address, LatLng markerLatlng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(markerLatlng);
        markerOptions.anchor(0.5f, 0.5f); // center of the image
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_green));
        markerOptions.title(title)
                .snippet(address);

        mMap.addMarker(markerOptions);

    }

    /**
     *
     * @param lon
     * @param lat
     * @param radius number of meter
     * @return
     */
    private LatLng getLocation(double lon, double lat, int radius)
    {
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(lat);

        double foundLongitude = new_x + lon;
        double foundLatitude = y + lat;
        System.out.println("Longitude: " + foundLongitude + "  Latitude: "
                + foundLatitude);

        return new LatLng(foundLatitude, foundLongitude);
    }
}
