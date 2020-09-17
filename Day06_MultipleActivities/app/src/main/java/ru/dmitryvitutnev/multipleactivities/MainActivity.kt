package ru.dmitryvitutnev.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
        sendButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", editTextWho.text.toString())
            intent.putExtra("gift", editTextWhere.text.toString())
            intent.putExtra("sender", editTextSender.text.toString())
            startActivity(intent)
        }
    }
}