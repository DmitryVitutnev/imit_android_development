package ru.dmitryvitutnev.trafficlight

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red_button.setOnClickListener {
            textView.text = resources.getText(R.string.red_button_text)
            rootLayout.setBackgroundColor(resources.getColor(R.color.colorRed, null))
        }
        yellow_button.setOnClickListener {
            textView.text = resources.getText(R.string.yellow_button_text)
            rootLayout.setBackgroundColor(resources.getColor(R.color.colorYellow, null))
        }
        green_button.setOnClickListener {
            textView.text = resources.getText(R.string.green_button_text)
            rootLayout.setBackgroundColor(resources.getColor(R.color.colorGreen, null))
        }
    }
}