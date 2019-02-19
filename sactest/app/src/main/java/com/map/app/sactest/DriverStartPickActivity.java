package com.map.app.sactest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import java. util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class DriverStartPickActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng newLatLng;
    String displayText;
    ArrayList<LatLng> markerPoints = new ArrayList<LatLng>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_start_pick);
        // AsyncCallWS task = new AsyncCallWS();
        //task.execute();

        //FragmentManager fmanager = getSupportFragmentManager();
      //  Fragment fragment = fmanager.findFragmentById(R.id.map);
      //  SupportMapFragment supportmapfragment = (SupportMapFragment)fragment;
      //  GoogleMap supportMap = supportmapfragment.getMap();

        newLatLng = new LatLng(Double.parseDouble("37.4116332"), Double.parseDouble("-122.08547180000001"));
        markerPoints.add(newLatLng);
/*
        try{
        JSONArray jsonarr = new JSONArray("[{\"stupikisdriveract\":0,\"stupikid\":15,\"stupiklat\":\"37.4186317\",\"stupikplace\":\"Google Building 1055, 1055 Joaquin Rd, Mountain View, CA 94043, USA\",\"stupikusn\":\"1272\",\"stupiklang\":\"-122.0797499\",\"stupikisadminact\":1,\"stupickupdate\":\"2018-04-22\"}]\n");

        // System.out.println("Array length :  " + jsonarr.length());
        //  Toast.makeText(getApplicationContext(), "array length is : "+jsonarr.length(), Toast.LENGTH_LONG).show();


        for (int i = 0; i < jsonarr.length(); i++) {

            JSONObject jsonobj = jsonarr.getJSONObject(i);

            newLatLng = new LatLng(Double.parseDouble(jsonobj.getString("stupiklat")), Double.parseDouble(jsonobj.getString("stupiklang")));
            markerPoints.add(newLatLng);
        }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error Occured!", Toast.LENGTH_LONG).show();

        }*/

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        Iterator<LatLng> iterator = markerPoints.iterator();
        while (iterator.hasNext()) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(iterator.next());
            mMap.addMarker(markerOptions);
        }

    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokegetstupicklist("stuacceptedlist");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            try{



                JSONArray jsonarr = new JSONArray("[{\"stupikisdriveract\":0,\"stupikid\":15,\"stupiklat\":\"37.4186317\",\"stupikplace\":\"Google Building 1055, 1055 Joaquin Rd, Mountain View, CA 94043, USA\",\"stupikusn\":\"1272\",\"stupiklang\":\"-122.0797499\",\"stupikisadminact\":1,\"stupickupdate\":\"2018-04-22\"}]\n");

                // System.out.println("Array length :  " + jsonarr.length());
                //  Toast.makeText(getApplicationContext(), "array length is : "+jsonarr.length(), Toast.LENGTH_LONG).show();


                for (int i = 0; i < jsonarr.length(); i++) {

                    JSONObject jsonobj = jsonarr.getJSONObject(i);

                    newLatLng = new LatLng(Double.parseDouble(jsonobj.getString("stupiklat")), Double.parseDouble(jsonobj.getString("stupiklang")));
                    markerPoints.add(newLatLng);
                }
                //   Toast.makeText(getApplicationContext(), "the value is : "+catlist.size(), Toast.LENGTH_LONG).show();







            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Error Occured!", Toast.LENGTH_LONG).show();

            }


        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }

    }
}
