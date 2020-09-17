package ru.dmitryvitutnev.crowcounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val KEY_COUNT = "COUNT"
    private val KEY_COUNT_CATS = "COUNT_CATS"
    private val KEY_TEXT = "TEXT"

    private var counter: Int = 0
    private var counterCats: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            counterCats = savedInstanceState.getInt(KEY_COUNT_CATS, 0)
            text_greetings.text = savedInstanceState.getString(KEY_TEXT, "")
        }


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


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
        outState.putInt(KEY_COUNT_CATS, counterCats)
        outState.putString(KEY_TEXT, text_greetings.text.toString())

    }


}