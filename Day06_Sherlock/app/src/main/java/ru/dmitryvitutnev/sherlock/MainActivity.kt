package ru.dmitryvitutnev.sherlock

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CHOOSE_THIEF: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonChoose.setOnClickListener {
            val questionIntent = Intent(this, SecondActivity::class.java)
            startActivityForResult(questionIntent, CHOOSE_THIEF)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == Activity.RESULT_OK) {
                val thiefName = data?.extras?.get("THIEF")?.toString() ?: "ОШИБКА"
                textViewInfo.text = thiefName
            } else {
                textViewInfo.text = ""
            }
        }

    }


}