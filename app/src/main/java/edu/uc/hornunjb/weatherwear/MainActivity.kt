package edu.uc.hornunjb.weatherwear

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PermissionInfo
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*
import edu.uc.hornunjb.weatherwear.repo.Repository
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModel
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModelFactory
import kotlinx.android.synthetic.main.weather_data_fragment.*
import java.util.*
import java.util.jar.Manifest
import kotlin.math.round

//TODO: https://youtu.be/vard0CUTLbA?t=1272
class MainActivity : AppCompatActivity() {

    private var PERMISSION_ID = 76;
    private lateinit var viewModel: MainViewModel
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var  locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_data_fragment)



        Toast.makeText(this, "How's the Weather?", Toast.LENGTH_SHORT).show()

        //Location
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        btnSetLocation.setOnClickListener{
            getLastLocation()
        }

        defaultLocationBoot()

    }
    //This gets a default city and displays the information from weather API. In this case I set it to indianapolis.
    private fun defaultLocationBoot(CityName:String = "Indianapolis")
    {
        //Creating TextView Objects to bind to our fragment
        var temperatureText: TextView
        var cityText: TextView
        var conditionsText: TextView

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost(CityName)

        viewModel.myResponse.observe(this, Observer { response ->

            //Building Individual Objects for binding and Parsing
            //val country = response.sys.country
            val city = response.name
            val humidity = response.main.humidity.toString() + "%"
            val pressure = response.main.pressure
            val tempRange = round((response.main.temp_min -273)*9/5 + 32).toString() + " to " + round((response.main.temp_max -273)*9/5 + 32).toString() + " Degrees"
            val wind = response.wind.speed.toString() + " mph"
            val otherConditions = response.weather[0].main.toString() + " - " +  response.weather[0].description.toString() + "\n" + "Humidity: " + humidity + "       " + "Pressure: " + pressure + " units" + "\n" + "Wind: " + wind

            //Finding Fragment Labels by Id and setting them to our response
            cityText = findViewById(R.id.lblLocationPlaceholder)
            cityText.text = city
            conditionsText = findViewById(R.id.lblConditionsPlaceholder)
            conditionsText.text = otherConditions
            temperatureText=findViewById(R.id.lblTempPlaceholder)
            temperatureText.text = tempRange

        })
    }

    //Get City Name
    private fun getCityName(lat:Double, long:Double) : String
    {
        var CityName = ""
        var geoCoder = Geocoder(this, Locale.getDefault())
        var Address = geoCoder.getFromLocation(lat, long, 1)

        CityName = Address[0].locality
        return CityName
    }

    private fun getLastLocation(){
        if(checkPermissions())
        {
            if(isLocationEnabled())
            {
                fusedLocationProviderClient.lastLocation.addOnCompleteListener {task ->
                var location = task.result
                if(location == null){
                    getNewLocation()
                }else{
                    //Put fragment object here to display location
                    Toast.makeText(this, "Your Current Coordinates are :\nLat:" + location.latitude + " ; Long:" + location.longitude, Toast.LENGTH_SHORT).show()
                    defaultLocationBoot(getCityName(location.latitude, location.longitude))
                }}
            }else{
                Toast.makeText(this, "Please Enable your Location services", Toast.LENGTH_SHORT).show()
            }
        }else{
            RequestPermissions()
        }
    }

    private fun getNewLocation(){
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 2
        fusedLocationProviderClient!!.requestLocationUpdates(
            locationRequest,locationCallback, Looper.myLooper()
        )
    }

    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(p0: LocationResult) {
            var lastLocation = p0.lastLocation
            //Below you should set the api to the new location.
            //Insert Here

        }
    }
    //Checks uses permissions
    private fun checkPermissions():Boolean {
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            return true
        }
        return false
    }

    //Fetches user permissions
    private fun RequestPermissions(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_ID)
    }

    //Checks to see if Location is enabled on device
    private fun isLocationEnabled():Boolean{
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == PERMISSION_ID)
        if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "Location Permission has been Granted.", Toast.LENGTH_SHORT).show()
        }
    }
}