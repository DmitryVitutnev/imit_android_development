package ru.dmitryvitutnev.day31_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            imageView.setImageResource(R.drawable.cat3)
            textView.text = "Маленький рыжий котик"
        }
        button2.setOnClickListener {
            imageView.setImageResource(R.drawable.cat1)
            textView.text = "Большой чёрный кот"
        }
        button3.setOnClickListener {
            imageView.setImageResource(R.drawable.cat2)
            textView.text = "Просто красивый котейка"
        }
    }
}