package com.example.googlemap

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Color
import android.location.Geocoder
import android.location.Location

import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemap.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.Marker
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
   private lateinit var binding:ActivityMapsBinding
    var latitude=0.00
    var longitude=0.00
    lateinit var location: Location


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        if (ActivityCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION)!=PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                ACCESS_COARSE_LOCATION)!=PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION,ACCESS_COARSE_LOCATION),1)
        }
        var manager:LocationManager=getSystemService(LOCATION_SERVICE) as LocationManager

        if (!manager.isProviderEnabled(GPS_PROVIDER))
        {
            Toast.makeText(applicationContext,"GPS is not working",Toast.LENGTH_LONG).show()
        }

        if(!manager.isProviderEnabled(NETWORK_PROVIDER))
        {
            Toast.makeText(applicationContext,"Network is not working",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Fetching Location",Toast.LENGTH_LONG).show()
        }

      var locationListener:LocationListener = object : LocationListener
      {
          override fun onLocationChanged(p0: Location)
          {
              latitude=p0.latitude
              longitude=p0.longitude
          }
      }
        if (manager.isProviderEnabled(NETWORK_PROVIDER))
        {
            manager.requestLocationUpdates(NETWORK_PROVIDER,0,0.0F,locationListener)
        }
        location = manager.getLastKnownLocation(NETWORK_PROVIDER)!!
        if (location!=null)
        {
            latitude=location.latitude
            longitude=location.longitude
            Toast.makeText(applicationContext,""+location.latitude,Toast.LENGTH_LONG).show()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        binding.mapsIcon.setOnClickListener {
            binding.mapsIcon.setBackgroundColor(Color.GRAY)
            mapTypePopup()
        }

        val marker = LatLng(latitude ,longitude)
        mMap.addMarker(MarkerOptions().position(marker).title("I am here").snippet(getAddress(latitude, longitude)).draggable(true))
        mMap.animateCamera(CameraUpdateFactory.newLatLng(marker))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker,15f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker))
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getAddress(latitude: Double, longitude: Double): String?
    {
      var geocoder=  Geocoder(this, Locale.getDefault())
      var address=  geocoder.getFromLocation(latitude,longitude,1)
        return address!![0].getAddressLine(0).toString()
    }


    private fun mapTypePopup() {
        var inflater=layoutInflater
        var alertdialog=inflater.inflate(R.layout.map_type_dialog,null)
        var alert=AlertDialog.Builder(this)
        alert.setTitle("Change Map Type")
        alert.setView(alertdialog)
        alert.setCancelable(false)
        alert.setPositiveButton("Done",{ dialogInterface: DialogInterface, i: Int ->
            binding.mapsIcon.setBackgroundColor(Color.WHITE)
        })
        var dialog=alert.create()
        if (mMap.mapType == GoogleMap.MAP_TYPE_HYBRID)
        {
            var hybridmaptypeRB : RadioButton = alertdialog.findViewById(R.id.maptype_hybrid)
            hybridmaptypeRB.isChecked = true
        }
        else  if (mMap.mapType == GoogleMap.MAP_TYPE_NONE)
        {
            var nonemaptypeRB : RadioButton = alertdialog.findViewById(R.id.maptype_none)
            nonemaptypeRB.isChecked =true
        }
        else  if (mMap.mapType == GoogleMap.MAP_TYPE_NORMAL)
        {
            var normalmaptypeRB : RadioButton = alertdialog.findViewById(R.id.maptype_normal)
            normalmaptypeRB.isChecked =true
        }
        else  if (mMap.mapType == GoogleMap.MAP_TYPE_SATELLITE)
        {
            var satellitemaptypeRB : RadioButton = alertdialog.findViewById(R.id.maptype_satellite)
            satellitemaptypeRB.isChecked = true
        }
        else  if (mMap.mapType == GoogleMap.MAP_TYPE_TERRAIN)
        {
            var terrainmaptypeRB : RadioButton = alertdialog.findViewById(R.id.maptype_terrain)
            terrainmaptypeRB.isChecked =true
        }
        dialog.show()
    }
    fun chooseMaptype(view:View){
        when (view.id)
        {
            R.id.maptype_hybrid -> mMap.mapType =GoogleMap.MAP_TYPE_HYBRID
            R.id.maptype_terrain ->mMap.mapType =GoogleMap.MAP_TYPE_TERRAIN
            R.id.maptype_none-> mMap.mapType =GoogleMap.MAP_TYPE_NONE
            R.id.maptype_satellite-> mMap.mapType =GoogleMap.MAP_TYPE_SATELLITE
            R.id.maptype_normal -> mMap.mapType =GoogleMap.MAP_TYPE_NORMAL
        }
    }
}