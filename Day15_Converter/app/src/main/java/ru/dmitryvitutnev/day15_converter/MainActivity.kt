package ru.dmitryvitutnev.day15_converter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (editText.text.length == 0) {
                Toast.makeText(
                    applicationContext, "Введите длину кота",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val inputValue = editText.text.toString().toFloat()
                if (radioButtonMeter.isChecked) {
                    editText.setText(convertParrotToMeter(inputValue).toString())
                } else {
                    editText.setText(convertMeterToParrot(inputValue).toString())
                }
            }
        }

    }

    // Конвертируем в метры
    fun convertParrotToMeter(parrot: Float): Float {
        return (parrot / 7.6).toFloat()
    }

    // Конвертируем в попугаи
    fun convertMeterToParrot(meter: Float): Float {
        return (meter * 7.6).toFloat()
    }

}