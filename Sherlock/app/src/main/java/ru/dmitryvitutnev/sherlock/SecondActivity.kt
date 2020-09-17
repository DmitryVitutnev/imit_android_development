package ru.dmitryvitutnev.sherlock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        radioDog.setOnClickListener {
            radioClick("Сраный пёсик")
        }
        radioCrow.setOnClickListener {
            radioClick("Ворона")
        }
        radioCat.setOnClickListener {
            radioClick("Лошадь Пржевальского")
        }
    }

    fun radioClick(value: String) {
        val answerIntent = Intent()
        answerIntent.putExtra("THIEF", value)
        setResult(Activity.RESULT_OK, answerIntent)
        finish()
    }




}