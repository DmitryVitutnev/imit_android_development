package ru.dmitryvitutnev.day_28map_and_streetview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val zoom : Int = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val geoUri = String.format("geo:0,0?q=%s&z=%s", editText.text, zoom.toString())
            val geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))

            startActivity(geoIntent)
        }
        button2.setOnClickListener {
            val geoUriString = "google.streetview:cbll=59.939448,30.328264&cbp=1,99.56,,1,2.0&mz=19"
            val geoUri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(mapIntent)
        }
    }


}