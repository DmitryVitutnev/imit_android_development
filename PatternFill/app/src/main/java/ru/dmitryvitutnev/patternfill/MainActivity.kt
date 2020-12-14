package ru.dmitryvitutnev.patternfill

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun paintClicked(view: View?) {
        // устанавливаем узор
        val pattern = view!!.tag.toString()
        drawing.setPattern(pattern);
    }
}