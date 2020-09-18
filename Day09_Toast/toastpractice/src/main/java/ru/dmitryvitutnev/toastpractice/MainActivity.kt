package ru.dmitryvitutnev.toastpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val text = R.string.catfood
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP, 0, 0)

            // Deprecated штука - больше не работает
            /*val toastContainer = toast.view as LinearLayout
            val catImage = ImageView(this)
            catImage.setImageResource(R.drawable.cat)
            toastContainer.addView(catImage, 0)*/

            // В этом уроке больше ничего и нету :( Всё устарело

            toast.show()
        }

    }
}
