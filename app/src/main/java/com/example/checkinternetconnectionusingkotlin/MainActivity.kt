package com.example.checkinternetconnectionusingkotlin

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CheckConnectionType()
    }

    fun CheckConnectionType()
    {
        val connectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifi_Connection = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobile_data_connection = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

        if (wifi_Connection.isConnectedOrConnecting)
        {
            toast("WIFI Connection is on")
        }
        else
        {
            if (mobile_data_connection.isConnectedOrConnecting)
            {
                toast("Mobile Data Connection is on")
            }
            else
            {
                toast("No Network Connection")
            }
        }
    }

    fun toast(msg: String)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
