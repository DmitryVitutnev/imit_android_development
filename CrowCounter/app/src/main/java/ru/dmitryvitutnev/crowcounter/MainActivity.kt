package ru.dmitryvitutnev.crowcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0
    private var counterCats: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_greetings.setOnClickListener {
            text_greetings.text = "Ну привет!"
        }
        button_counter.setOnClickListener {
            text_greetings.text = "Я насчитал ${++counter} ворон"
        }
        button_counter_cat.setOnClickListener {
            text_greetings.text = "Я насчитал ${++counterCats} котов"
        }
    }
}