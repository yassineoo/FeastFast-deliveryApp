package com.example.feastfast.ui.address

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.*
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.edit
import com.example.feastfast.databinding.ActivityAddressBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class AddressActivity : AppCompatActivity() {
    val PERMISSION_ID = 100
    lateinit var binding: ActivityAddressBinding
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    var myAddress = ""
    var country = ""
    var city = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddressBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        binding.btnLocation.setOnClickListener {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_ID
                )
        }
        binding.btnConfirm.setOnClickListener {
            var userInput = binding.editTextAddress.text.toString()
            if (userInput.isNotEmpty()){
                myAddress=userInput
                saveAddress()
            }else{
                Toast.makeText(this,"empty!!" , Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun getLocation(){
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationProviderClient.lastLocation.addOnSuccessListener {location : Location? ->
            if (location!=null){
                getCityName(location.latitude,location.longitude)
                saveAddress()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==PERMISSION_ID){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLocation()
            }
        }
    }

    fun getCityName(lat:Double,long:Double){
        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val address = geocoder.getFromLocation(lat,long,3)
            if (address!=null){
                myAddress=address[0].getAddressLine(0)
                country=address[0].countryName
                city=address[0].locality
            }
        }catch (e:Exception){
            Toast.makeText(this,"getting city!!" , Toast.LENGTH_SHORT).show()
        }
    }

    fun saveAddress(){
        val pref = getSharedPreferences("myPreferences",Context.MODE_PRIVATE)
        pref.edit {
            putString("address",myAddress)
        }
        finish()
    }
}