package ru.dmitryvitutnev.day25_preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private val APP_PREFERENCES_COUNTER = "counter"
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)

        crowButton.setOnClickListener {
            counter++
            infoTextView.text = "Я насчитал $counter ворон"
        }

    }

    override fun onPause() {
        super.onPause()

        val editor = prefs.edit()
        editor.putInt(APP_PREFERENCES_COUNTER, counter).apply()
    }

    override fun onResume() {
        super.onResume()

        if(prefs.contains(APP_PREFERENCES_COUNTER)){
            counter = prefs.getInt(APP_PREFERENCES_COUNTER, 0)
            infoTextView.text = "Я насчитал $counter ворон"
        }
    }

}