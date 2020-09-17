package ru.dmitryvitutnev.multipleactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val user = intent.extras?.get("username")?.toString() ?: "Dimason"
        val gift = intent.extras?.get("gift")?.toString() ?: "банан"
        val sender = intent.extras?.get("sender")?.toString() ?: "горилла"

        messageText.text = "user ${user}, ${sender} передал Вам в подарок ${gift}"

    }
}