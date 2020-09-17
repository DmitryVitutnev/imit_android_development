package ru.dmitryvitutnev.buttonsonscreen

import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            button1.text = getScreenOrientation() ?: "Первая кнопка"
        }

        button1.setOnClickListener {
            button1.text = getRotateOrientation() ?: "Вторая кнопка"
        }
    }

    private fun getScreenOrientation(): String? {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) "Портретная ориентация"
        else if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) "Альбомная ориентация"
        else ""
    }

    private fun getRotateOrientation(): String? =
        when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> "Не поворачивали"
            Surface.ROTATION_90 -> "Повернули на 90 градусов по часовой стрелке"
            Surface.ROTATION_180 -> "Повернули на 180 градусов"
            Surface.ROTATION_270 -> "Повернули на 90 градусов против часовой стрелки"
            else -> "Не понятно"

        }

}
